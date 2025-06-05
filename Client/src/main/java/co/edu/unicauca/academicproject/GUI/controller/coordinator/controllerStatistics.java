/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.controller.coordinator;

import co.edu.unicauca.academicproject.GUI.coordinator.GUIStatistics;
import co.edu.unicauca.academicproject.Service.project.ProjectServiceClient;
import co.edu.unicauca.academicproject.controller.ProjectController;
import co.edu.unicauca.academicproject.provider.appContextProvider;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;


/**
 *
 * @author lopez
 */
public class controllerStatistics {
    private final GUIStatistics vista;
    ProjectController projectController = new ProjectController(appContextProvider.getBean(ProjectServiceClient.class));

    public controllerStatistics(GUIStatistics vista) {
        this.vista = vista;
        this.vista.getJBtnFiltrar().addActionListener(e-> generarGraficos());
    }

    public void generarGraficos() {
        System.out.println("Generando Graficos de barras");
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Agrega los datos (ejemplo)
        dataset.addValue(10, "Proyectos", "Postulados");
        dataset.addValue(7, "Proyectos", "Aprobados");
        dataset.addValue(3, "Proyectos", "Rechazados");
        dataset.addValue(5, "Proyectos", "Terminados");

        // 2. Crear el gráfico
        JFreeChart chart = ChartFactory.createBarChart(
                "Estado de Proyectos",
                "Estado",
                "Cantidad",
                dataset
        );

        // 3. Crear el panel del gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(vista.getjPGraficoBarra().getSize()); // para ocupar todo el JPanel

        // 4. Mostrarlo en tu JPanel
        vista.getjPGraficoBarra().removeAll(); // limpia el panel si ya había algo
        vista.getjPGraficoBarra().setLayout(new java.awt.BorderLayout()); // usa BorderLayout para que se ajuste bien
        vista.getjPGraficoBarra().add(chartPanel, BorderLayout.CENTER);
        vista.getjPGraficoBarra().validate(); // actualiza el contenido
    }
    
}
