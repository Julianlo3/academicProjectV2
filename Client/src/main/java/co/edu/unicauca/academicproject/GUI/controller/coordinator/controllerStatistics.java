/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.coordinator;

import co.edu.unicauca.academicproject.GUI.coordinator.GUIStatistics;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.provider.appContextProvider;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.util.List;


/**
 *
 * @author lopez
 */
public class controllerStatistics {
    private final GUIStatistics vista;
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));

    public controllerStatistics(GUIStatistics vista) {
        this.vista = vista;
        this.vista.getJBtnFiltrar().addActionListener(e-> obtenerProyectos());
    }

    public void obtenerProyectos() {
        System.out.println("Obteniendo proyectos");

        int aprobados = projectController.getProjectsFilter("Approved",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();
        int asignados = projectController.getProjectsFilter("Assigned",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();
        int compledados = projectController.getProjectsFilter("Completed",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();
        int recebidos = projectController.getProjectsFilter("Received",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();
        int rechazados = projectController.getProjectsFilter("Reject",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();

        System.out.println("# aprobados: "+aprobados+"  #asignados "+asignados+" #completados "+compledados+" #rechazados "+rechazados+" #recibidos"+recebidos);

        generarGraficoBarra(aprobados,asignados,compledados,rechazados,recebidos);
        generarGraficoPastel(aprobados,asignados,compledados,rechazados,recebidos);

    }

    public void generarGraficoBarra(int aprobados, int asignados, int completados, int rechazados, int recebidos) {
        System.out.println("Generando Grafico Barra");
        DefaultCategoryDataset graficoBarra = new DefaultCategoryDataset();
        graficoBarra.addValue(aprobados, "Proyectos", "Aprobados");
        graficoBarra.addValue(asignados, "Proyectos", "Asignados");
        graficoBarra.addValue(completados, "Proyectos", "Compleados");
        graficoBarra.addValue(recebidos, "Proyectos", "Recibidos");
        graficoBarra.addValue(rechazados, "Proyectos", "Rechazados");

        JFreeChart chart = ChartFactory.createBarChart(
                "Estado de Proyectos de",
                "Estado",
                "Cantidad",
                graficoBarra
        );

        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        renderer.setSeriesPaint(0, Color.GRAY);

        plot.setRenderer(new BarRenderer() {
            @Override
            public Paint getItemPaint(int row, int column) {
                String category = (String) graficoBarra.getColumnKey(column);
                switch (category) {
                    case "Aprobados": return new Color(0, 153, 76);      // Verde
                    case "Asignados": return new Color(0, 102, 204);     // Azul
                    case "Compleados": return new Color(255, 204, 0);    // Amarillo
                    case "Recebidos": return new Color(102, 0, 204);     // Morado
                    case "Rechazados": return new Color(204, 0, 0);      // Rojo
                    default: return Color.GRAY;
                }
            }
        });

        // 3. Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(vista.getjPGraficoBarra().getSize()); // para ocupar todo el JPanel


        // 4. Mostrarlo en tu JPanel
        vista.getjPGraficoBarra().removeAll(); // limpia el panel si ya había algo
        vista.getjPGraficoBarra().setLayout(new java.awt.BorderLayout()); // usa BorderLayout para que se ajuste bien
        vista.getjPGraficoBarra().add(chartPanel, BorderLayout.CENTER);
        vista.getjPGraficoBarra().validate(); // actualiza el contenido
    }

    public void generarGraficoPastel(int aprobados, int asignados, int compleados, int rechazados, int recebidos) {
        System.out.println("Generando Grafico Pastel");
        DefaultPieDataset graficoPastel = new DefaultPieDataset();
        graficoPastel.setValue("Aprobados", aprobados);
        graficoPastel.setValue("Asignados", asignados);
        graficoPastel.setValue("Completados", compleados);
        graficoPastel.setValue("Rechazados", rechazados);
        graficoPastel.setValue("Recibidos", recebidos);

        JFreeChart chart = ChartFactory.createPieChart(
                "Estado de Proyectos",  // Título del gráfico
                graficoPastel,                // Dataset
                true,                   // Include legend
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();

        // Establecer color para cada categoría
        plot.setSectionPaint("Aprobados", Color.GREEN);
        plot.setSectionPaint("Rechazados", Color.RED);
        plot.setSectionPaint("Asignados", Color.BLUE);
        plot.setSectionPaint("Completados", Color.ORANGE);
        plot.setSectionPaint("Recibidos", Color.pink);


        // 3. Crear el ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(vista.getjPGraficoPastel().getSize());

        // 4. Mostrarlo en tu JPanel
        vista.getjPGraficoPastel().removeAll();
        vista.getjPGraficoPastel().setLayout(new java.awt.BorderLayout());
        vista.getjPGraficoPastel().add(chartPanel, BorderLayout.CENTER);
        vista.getjPGraficoPastel().validate();

    }
    
}
