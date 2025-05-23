/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.student;

import co.edu.unicauca.academicproject.GUI.*;
import co.edu.unicauca.academicproject.GUI.controller.Project.ControllerNewProject;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.Project;

import javax.swing.*;

/**
 *
 * @author lopez
 */
public class GUINominationProject extends javax.swing.JFrame {

    /**
     * Creates new form GUINewProject
     */

    private final Company company;
    public GUINominationProject(Company company) {
        initComponents();
       
        this.company = company;
    }

    public String getTitleProject() {
        return jFieldTitleProject.getText();
    }

    public String getDescriptionProject() {
        return jTextAreaDescripProject.getText();
    }

   public JButton getjBtnPubliProject() {
        return jBtnPubliProject;
    }

    public Company getCompany() {
        return company;
    }
    
    public JComboBox getAcademicTerm(){
        return jCBAcademicTerm;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPContent = new javax.swing.JPanel();
        jLTitleProject = new javax.swing.JLabel();
        jFieldTitleProject = new javax.swing.JTextField();
        jLDescriptionProject = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripProject = new javax.swing.JTextArea();
        jBtnPubliProject = new javax.swing.JButton();
        jCBAcademicTerm = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPTitleNewProject = new javax.swing.JPanel();
        jBtnNewPubli = new javax.swing.JButton();
        jPHead = new javax.swing.JPanel();
        lbTitleProyect = new java.awt.Label();
        jPOpcLogin = new javax.swing.JPanel();
        jBtnLoginU = new javax.swing.JButton();
        jPButtom = new javax.swing.JPanel();
        jBtnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Publicación");
        setBackground(new java.awt.Color(15, 32, 65));
        setMinimumSize(new java.awt.Dimension(700, 650));

        jPContent.setBackground(new java.awt.Color(15, 32, 65));
        jPContent.setForeground(new java.awt.Color(255, 255, 255));
        jPContent.setLayout(new java.awt.GridBagLayout());

        jLTitleProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLTitleProject.setForeground(new java.awt.Color(255, 255, 255));
        jLTitleProject.setText("Titulo del proyecto:");
        jPContent.add(jLTitleProject, new java.awt.GridBagConstraints());

        jFieldTitleProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jFieldTitleProject.setText("Mi proyecto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPContent.add(jFieldTitleProject, gridBagConstraints);

        jLDescriptionProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLDescriptionProject.setForeground(new java.awt.Color(255, 255, 255));
        jLDescriptionProject.setText("Descripción del proyecto: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        jPContent.add(jLDescriptionProject, gridBagConstraints);

        jTextAreaDescripProject.setColumns(20);
        jTextAreaDescripProject.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextAreaDescripProject.setLineWrap(true);
        jTextAreaDescripProject.setRows(5);
        jTextAreaDescripProject.setText("Proyecto enfocado en los sitemas gestores academicos\n");
        jScrollPane1.setViewportView(jTextAreaDescripProject);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPContent.add(jScrollPane1, gridBagConstraints);

        jBtnPubliProject.setBackground(new java.awt.Color(172, 0, 0));
        jBtnPubliProject.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jBtnPubliProject.setForeground(new java.awt.Color(255, 255, 255));
        jBtnPubliProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.0/solicitar.png"))); // NOI18N
        jBtnPubliProject.setText("Solicitar");
        jBtnPubliProject.setBorderPainted(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPContent.add(jBtnPubliProject, gridBagConstraints);

        jCBAcademicTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPContent.add(jCBAcademicTerm, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Periodo academico:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 0, 0);
        jPContent.add(jLabel1, gridBagConstraints);

        jPTitleNewProject.setBackground(new java.awt.Color(15, 32, 65));
        jPTitleNewProject.setForeground(new java.awt.Color(255, 255, 255));

        jBtnNewPubli.setBackground(new java.awt.Color(172, 0, 0));
        jBtnNewPubli.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jBtnNewPubli.setForeground(new java.awt.Color(255, 255, 255));
        jBtnNewPubli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.0/publi.png"))); // NOI18N
        jBtnNewPubli.setText("Publicación");
        jBtnNewPubli.setBorderPainted(false);
        jBtnNewPubli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnNewPubli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPTitleNewProject.add(jBtnNewPubli);

        jPHead.setBackground(new java.awt.Color(15, 32, 65));
        jPHead.setLayout(new javax.swing.BoxLayout(jPHead, javax.swing.BoxLayout.LINE_AXIS));

        lbTitleProyect.setBackground(new java.awt.Color(15, 32, 65));
        lbTitleProyect.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lbTitleProyect.setForeground(new java.awt.Color(255, 255, 255));
        lbTitleProyect.setText("Sistema gestor de proyectos academicos");
        jPHead.add(lbTitleProyect);

        jPOpcLogin.setBackground(new java.awt.Color(236, 230, 240));
        jPOpcLogin.setLayout(new java.awt.GridLayout(1, 1, 1, 0));

        jBtnLoginU.setBackground(new java.awt.Color(172, 0, 0));
        jBtnLoginU.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jBtnLoginU.setForeground(new java.awt.Color(255, 255, 255));
        jBtnLoginU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.0/usuario.png"))); // NOI18N
        jBtnLoginU.setText("My User");
        jBtnLoginU.setBorder(null);
        jBtnLoginU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBtnLoginU.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnLoginU.setIconTextGap(5);
        jBtnLoginU.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtnLoginU.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPOpcLogin.add(jBtnLoginU);

        jPHead.add(jPOpcLogin);

        jPButtom.setBackground(new java.awt.Color(15, 32, 65));

        jBtnSalir.setBackground(new java.awt.Color(15, 32, 65));
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.0/anterior (1).png"))); // NOI18N
        jBtnSalir.setBorderPainted(false);

        javax.swing.GroupLayout jPButtomLayout = new javax.swing.GroupLayout(jPButtom);
        jPButtom.setLayout(jPButtomLayout);
        jPButtomLayout.setHorizontalGroup(
            jPButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPButtomLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jBtnSalir)
                .addContainerGap(594, Short.MAX_VALUE))
        );
        jPButtomLayout.setVerticalGroup(
            jPButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPButtomLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jBtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPHead, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
            .addComponent(jPContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPTitleNewProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPHead, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPTitleNewProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPContent, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(509, 509, 509)
                    .addComponent(jPButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnLoginU;
    private javax.swing.JButton jBtnNewPubli;
    private javax.swing.JButton jBtnPubliProject;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JComboBox<String> jCBAcademicTerm;
    private javax.swing.JTextField jFieldTitleProject;
    private javax.swing.JLabel jLDescriptionProject;
    private javax.swing.JLabel jLTitleProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPButtom;
    private javax.swing.JPanel jPContent;
    private javax.swing.JPanel jPHead;
    private javax.swing.JPanel jPOpcLogin;
    private javax.swing.JPanel jPTitleNewProject;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescripProject;
    private java.awt.Label lbTitleProyect;
    // End of variables declaration//GEN-END:variables
}
