/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.coordinator;

import co.edu.unicauca.academicproject.GUI.coordinator.GUIStatistics;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.entities.observer.Observer;
import co.edu.unicauca.academicproject.entities.observer.Sujeto;
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
public class controllerStatistics implements Observer {
    private final GUIStatistics vista;
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));

    public controllerStatistics(GUIStatistics vista, Sujeto sujeto) {
        this.vista = vista;
        sujeto.agregarObservador(this);
        this.vista.getJBtnFiltrar().addActionListener(e-> obtenerProyectos());
        this.vista.getjRbtnGraficoPastel().setSelected(true);
    }

    public void obtenerProyectos() {
        System.out.println("Obteniendo proyectos");
        int aprobados = projectController.getProjectsFilter("Approved",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();
        int asignados = projectController.getProjectsFilter("Assigned",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();
        int completados = projectController.getProjectsFilter("Completed",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();
        int recibidos = projectController.getProjectsFilter("Received",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();
        int rechazados = projectController.getProjectsFilter("Rejected",vista.getjYear().getValue(),vista.getjSpinPeriodo().getValue(),"Bearer "+vista.getToken()).size();

        System.out.println("# aprobados: "+aprobados+"  #asignados "+asignados+" #completados "+completados+" #rechazados "+rechazados+" #recibidos"+recibidos);

        if(vista.getjRbtnGraficoPastel().isSelected()){
            generarGraficoPastel(aprobados,asignados,completados,rechazados,recibidos);
        }

        if(vista.getjRbtnGraficoBarra().isSelected()){
            generarGraficoBarra(aprobados,asignados,completados,rechazados,recibidos);
        }


    }

    public void generarGraficoBarra(int aprobados, int asignados, int completados, int rechazados, int recibidos) {
        System.out.println("Generando Grafico Barra");
        DefaultCategoryDataset graficoBarra = new DefaultCategoryDataset();
        graficoBarra.addValue(aprobados, "Proyectos", "Aprobados");
        graficoBarra.addValue(asignados, "Proyectos", "Asignados");
        graficoBarra.addValue(completados, "Proyectos", "Completados");
        graficoBarra.addValue(recibidos, "Proyectos", "Recibidos");
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
                    case "Aprobados": return new Color(60,179,113);
                    case "Asignados": return new Color(255,140,0);
                    case "Completados": return new Color(255,215,0);
                    case "Recibidos": return new Color(100,149,237);
                    case "Rechazados": return new Color(220,20,60);
                    default: return Color.GRAY;
                }
            }
        });

        // 3. Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(vista.getjPGraficos().getSize());


        // 4. Mostrarlo en tu JPanel
        vista.getjPGraficos().removeAll(); // limpia el panel si ya había algo
        vista.getjPGraficos().setLayout(new java.awt.BorderLayout()); // usa BorderLayout para que se ajuste bien
        vista.getjPGraficos().add(chartPanel, BorderLayout.CENTER);
        vista.getjPGraficos().validate(); // actualiza el contenido
    }

    public void generarGraficoPastel(int aprobados, int asignados, int completados, int rechazados, int recibidos) {
        System.out.println("Generando Grafico Pastel");
        DefaultPieDataset graficoPastel = new DefaultPieDataset();
        graficoPastel.setValue("Aprobados", aprobados);
        graficoPastel.setValue("Asignados", asignados);
        graficoPastel.setValue("Completados", completados);
        graficoPastel.setValue("Rechazados", rechazados);
        graficoPastel.setValue("Recibidos", recibidos);

        JFreeChart chart = ChartFactory.createPieChart(
                "Estado de Proyectos",  // Título del gráfico
                graficoPastel,                // Dataset
                true,                   // Include legend
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();

        // Establecer color para cada categoría
        plot.setSectionPaint("Aprobados", new Color(60,179,113));
        plot.setSectionPaint("Rechazados", new Color(220,20,60));
        plot.setSectionPaint("Asignados", new Color(255,140,0));
        plot.setSectionPaint("Completados", new Color(255,215,0));
        plot.setSectionPaint("Recibidos", new Color(100,149,237));


        // 3. Crear el ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(vista.getjPGraficos().getSize());

        // 4. Mostrarlo en tu JPanel
        vista.getjPGraficos().removeAll();
        vista.getjPGraficos().setLayout(new java.awt.BorderLayout());
        vista.getjPGraficos().add(chartPanel, BorderLayout.CENTER);
        vista.getjPGraficos().validate();

    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Actualizando estadisticas");
        obtenerProyectos();
    }
}
