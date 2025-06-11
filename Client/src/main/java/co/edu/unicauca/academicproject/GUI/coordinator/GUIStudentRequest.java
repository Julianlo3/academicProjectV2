/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.coordinator;

import co.edu.unicauca.academicproject.GUI.company.*;
import co.edu.unicauca.academicproject.GUI.controller.Project.ControllerNewProject;
import co.edu.unicauca.academicproject.GUI.controller.coordinator.controllerStudentRequest;
import co.edu.unicauca.academicproject.entities.Company;
import co.edu.unicauca.academicproject.entities.Project;
import co.edu.unicauca.academicproject.entities.observer.Observer;
import co.edu.unicauca.academicproject.entities.observer.Sujeto;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JSpinField;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author lopez
 */
public class GUIStudentRequest extends javax.swing.JFrame implements Observer {

    private String token;

    public GUIStudentRequest(String token, Sujeto sujeto) {
        initComponents();
        sujeto.agregarObservador(this);
        this.token = token;
        controllerStudentRequest controllerStudentRequest = new controllerStudentRequest(this,sujeto);
    }

    public JPanel getjPChat() {
        return jPChat;
    }

    public JLabel getjLIDPubli() {
        return jLIDPubli;
    }
    
    

    public JLabel getjLEstudianteSolicitante() {
        return jLEstudianteSolicitante;
    }

    public JLabel getjLEstadoSolicitud() {
        return jLEstadoSolicitud;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JButton getjBtnLoginU() {
        return jBtnLoginU;
    }

    public void setjBtnLoginU(JButton jBtnLoginU) {
        this.jBtnLoginU = jBtnLoginU;
    }

    public JButton getjBtnNewPubli() {
        return jBtnNewPubli;
    }

    public void setjBtnNewPubli(JButton jBtnNewPubli) {
        this.jBtnNewPubli = jBtnNewPubli;
    }

    public JButton getjBtnProcesarSoli() {
        return jBtnProcesarSoli;
    }

    public void setjBtnProcesarSoli(JButton jBtnProcesarSoli) {
        this.jBtnProcesarSoli = jBtnProcesarSoli;
    }

    public JDateChooser getjDateChFechaInicio() {
        return jDateChFechaInicio;
    }

    public void setjDateChFechaInicio(String jDateChFechaInicio) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.jDateChFechaInicio.setDate(format.parse(jDateChFechaInicio));;
    }


    public JTextField getjFieldPresupuesto() {
        return jFieldPresupuesto;
    }

    public void setjFieldPresupuesto(JTextField jFieldPresupuesto) {
        this.jFieldPresupuesto = jFieldPresupuesto;
    }

    public JTextField getjFieldTitleProject() {
        return jFieldTitleProject;
    }

    public void setjFieldTitleProject(JTextField jFieldTitleProject) {
        this.jFieldTitleProject = jFieldTitleProject;
    }

    public JPanel getjPDetalleSolicitud() {
        return jPDetalleSolicitud;
    }

    public void setjPDetalleSolicitud(JPanel jPDetalleSolicitud) {
        this.jPDetalleSolicitud = jPDetalleSolicitud;
    }

    public JPanel getjPSolicitudes() {
        return jPSolicitudes;
    }

    public void setjPSolicitudes(JPanel jPSolicitudes) {
        this.jPSolicitudes = jPSolicitudes;
    }

    public JRadioButton getjRBtnAceptarSoli() {
        return jRBtnAceptarSoli;
    }

    public void setjRBtnAceptarSoli(JRadioButton jRBtnAceptarSoli) {
        this.jRBtnAceptarSoli = jRBtnAceptarSoli;
    }

    public JRadioButton getjRBtnRechazarSoli() {
        return jRBtnRechazarSoli;
    }

    public void setjRBtnRechazarSoli(JRadioButton jRBtnRechazarSoli) {
        this.jRBtnRechazarSoli = jRBtnRechazarSoli;
    }

    public JSpinField getjSpinDuracionMes() {
        return jSpinDuracionMes;
    }

    public void setjSpinDuracionMes(JSpinField jSpinDuracionMes) {
        this.jSpinDuracionMes = jSpinDuracionMes;
    }

    public JSpinField getjSpinTerm() {
        return jSpinTerm;
    }

    public void setjSpinTerm(JSpinField jSpinTerm) {
        this.jSpinTerm = jSpinTerm;
    }

    public JTextArea getjTextAreaDescripProject() {
        return jTextAreaDescripProject;
    }

    public void setjTextAreaDescripProject(JTextArea jTextAreaDescripProject) {
        this.jTextAreaDescripProject = jTextAreaDescripProject;
    }

    public JTextArea getjTextAreaObjetivos() {
        return jTextAreaObjetivos;
    }

    public void setjTextAreaObjetivos(JTextArea jTextAreaObjetivos) {
        this.jTextAreaObjetivos = jTextAreaObjetivos;
    }

    public JTextArea getjTextAreaResumen() {
        return jTextAreaResumen;
    }

    public void setjTextAreaResumen(JTextArea jTextAreaResumen) {
        this.jTextAreaResumen = jTextAreaResumen;
    }

    public JYearChooser getjYearProyecto() {
        return jYearProyecto;
    }

    public void setjYearProyecto(JYearChooser jYearProyecto) {
        this.jYearProyecto = jYearProyecto;
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

        buttonGroupSolis = new javax.swing.ButtonGroup();
        jPContent = new javax.swing.JPanel();
        jPSolicitudes = new javax.swing.JPanel();
        jScrollPaneChat = new javax.swing.JScrollPane();
        jPChat = new javax.swing.JPanel();
        jPDetalleSolicitud = new javax.swing.JPanel();
        jLTitleProject = new javax.swing.JLabel();
        jFieldTitleProject = new javax.swing.JTextField();
        jLDescriptionProject = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripProject = new javax.swing.JTextArea();
        jLResumen = new javax.swing.JLabel();
        jLObjetivos = new javax.swing.JLabel();
        jLDuracionMeses = new javax.swing.JLabel();
        jSpinDuracionMes = new com.toedter.components.JSpinField();
        jLPeriodoAca = new javax.swing.JLabel();
        jYearProyecto = new com.toedter.calendar.JYearChooser();
        jSpinTerm = new com.toedter.components.JSpinField();
        jLFechaInicioProyecto = new javax.swing.JLabel();
        jDateChFechaInicio = new com.toedter.calendar.JDateChooser();
        jFieldPresupuesto = new javax.swing.JTextField();
        jLPresupuesto = new javax.swing.JLabel();
        jLTEstado = new javax.swing.JLabel();
        jLEstadoSolicitud = new javax.swing.JLabel();
        jLTEstudiante = new javax.swing.JLabel();
        jLEstudianteSolicitante = new javax.swing.JLabel();
        jRBtnAceptarSoli = new javax.swing.JRadioButton();
        jRBtnRechazarSoli = new javax.swing.JRadioButton();
        jBtnProcesarSoli = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaResumen = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaObjetivos = new javax.swing.JTextArea();
        jLIDPubli = new javax.swing.JLabel();
        jPTitleNewProject = new javax.swing.JPanel();
        jBtnNewPubli = new javax.swing.JButton();
        jPHead = new javax.swing.JPanel();
        lbTitleProyect = new java.awt.Label();
        jPOpcLogin = new javax.swing.JPanel();
        jBtnLoginU = new javax.swing.JButton();
        jPButtom = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitudes");
        setBackground(new java.awt.Color(15, 32, 65));
        setMinimumSize(new java.awt.Dimension(700, 550));

        jPContent.setBackground(new java.awt.Color(15, 32, 65));
        jPContent.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPaneChat.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPChat.setLayout(new javax.swing.BoxLayout(jPChat, javax.swing.BoxLayout.Y_AXIS));
        jScrollPaneChat.setViewportView(jPChat);

        javax.swing.GroupLayout jPSolicitudesLayout = new javax.swing.GroupLayout(jPSolicitudes);
        jPSolicitudes.setLayout(jPSolicitudesLayout);
        jPSolicitudesLayout.setHorizontalGroup(
            jPSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneChat, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPSolicitudesLayout.setVerticalGroup(
            jPSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneChat, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPDetalleSolicitud.setBackground(new java.awt.Color(15, 32, 65));
        jPDetalleSolicitud.setEnabled(false);
        jPDetalleSolicitud.setLayout(new java.awt.GridBagLayout());

        jLTitleProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLTitleProject.setForeground(new java.awt.Color(255, 255, 255));
        jLTitleProject.setText("Titulo del proyecto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPDetalleSolicitud.add(jLTitleProject, gridBagConstraints);

        jFieldTitleProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jFieldTitleProject.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFieldTitleProject.setText("Mi proyecto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPDetalleSolicitud.add(jFieldTitleProject, gridBagConstraints);

        jLDescriptionProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLDescriptionProject.setForeground(new java.awt.Color(255, 255, 255));
        jLDescriptionProject.setText("Descripción del proyecto: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPDetalleSolicitud.add(jLDescriptionProject, gridBagConstraints);

        jTextAreaDescripProject.setColumns(20);
        jTextAreaDescripProject.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextAreaDescripProject.setLineWrap(true);
        jTextAreaDescripProject.setRows(5);
        jTextAreaDescripProject.setText("Proyecto enfocado en los sitemas gestores academicos\n");
        jScrollPane1.setViewportView(jTextAreaDescripProject);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPDetalleSolicitud.add(jScrollPane1, gridBagConstraints);

        jLResumen.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLResumen.setForeground(new java.awt.Color(255, 255, 255));
        jLResumen.setText("Resumen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPDetalleSolicitud.add(jLResumen, gridBagConstraints);

        jLObjetivos.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLObjetivos.setForeground(new java.awt.Color(255, 255, 255));
        jLObjetivos.setText("Objetivos:");
        jLObjetivos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        jPDetalleSolicitud.add(jLObjetivos, gridBagConstraints);

        jLDuracionMeses.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLDuracionMeses.setForeground(new java.awt.Color(255, 255, 255));
        jLDuracionMeses.setText("Duracion del proyecto(meses):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        jPDetalleSolicitud.add(jLDuracionMeses, gridBagConstraints);

        jSpinDuracionMes.setMaximum(12);
        jSpinDuracionMes.setMinimum(1);
        jSpinDuracionMes.setValue(1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPDetalleSolicitud.add(jSpinDuracionMes, gridBagConstraints);

        jLPeriodoAca.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLPeriodoAca.setForeground(new java.awt.Color(255, 255, 255));
        jLPeriodoAca.setText("Periodo academico:");
        jLPeriodoAca.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPDetalleSolicitud.add(jLPeriodoAca, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPDetalleSolicitud.add(jYearProyecto, gridBagConstraints);

        jSpinTerm.setMaximum(2);
        jSpinTerm.setMinimum(1);
        jSpinTerm.setValue(1);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, -50, 0, 0);
        jPDetalleSolicitud.add(jSpinTerm, gridBagConstraints);

        jLFechaInicioProyecto.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLFechaInicioProyecto.setForeground(new java.awt.Color(255, 255, 255));
        jLFechaInicioProyecto.setText("Fecha inicio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPDetalleSolicitud.add(jLFechaInicioProyecto, gridBagConstraints);

        jDateChFechaInicio.setDateFormatString("y-MM-d");
        jDateChFechaInicio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        jPDetalleSolicitud.add(jDateChFechaInicio, gridBagConstraints);

        jFieldPresupuesto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jFieldPresupuesto.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPDetalleSolicitud.add(jFieldPresupuesto, gridBagConstraints);

        jLPresupuesto.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLPresupuesto.setForeground(new java.awt.Color(255, 255, 255));
        jLPresupuesto.setText("Presupuesto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        jPDetalleSolicitud.add(jLPresupuesto, gridBagConstraints);

        jLTEstado.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLTEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLTEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTEstado.setText("Estado:");
        jLTEstado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPDetalleSolicitud.add(jLTEstado, gridBagConstraints);

        jLEstadoSolicitud.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLEstadoSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        jLEstadoSolicitud.setText("Received");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPDetalleSolicitud.add(jLEstadoSolicitud, gridBagConstraints);

        jLTEstudiante.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLTEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        jLTEstudiante.setText("Estudiante solicitante:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPDetalleSolicitud.add(jLTEstudiante, gridBagConstraints);

        jLEstudianteSolicitante.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLEstudianteSolicitante.setForeground(new java.awt.Color(255, 255, 255));
        jLEstudianteSolicitante.setText("Pepito perez");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPDetalleSolicitud.add(jLEstudianteSolicitante, gridBagConstraints);

        jRBtnAceptarSoli.setBackground(new java.awt.Color(15, 32, 65));
        buttonGroupSolis.add(jRBtnAceptarSoli);
        jRBtnAceptarSoli.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jRBtnAceptarSoli.setForeground(new java.awt.Color(255, 255, 255));
        jRBtnAceptarSoli.setText("ACETPAR SOLICITUD");
        jRBtnAceptarSoli.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPDetalleSolicitud.add(jRBtnAceptarSoli, gridBagConstraints);

        jRBtnRechazarSoli.setBackground(new java.awt.Color(15, 32, 65));
        buttonGroupSolis.add(jRBtnRechazarSoli);
        jRBtnRechazarSoli.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jRBtnRechazarSoli.setForeground(new java.awt.Color(255, 255, 255));
        jRBtnRechazarSoli.setText("RECHAZAR SOLICITUD");
        jRBtnRechazarSoli.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 0, 0);
        jPDetalleSolicitud.add(jRBtnRechazarSoli, gridBagConstraints);

        jBtnProcesarSoli.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jBtnProcesarSoli.setText("CONFIRMAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPDetalleSolicitud.add(jBtnProcesarSoli, gridBagConstraints);

        jTextAreaResumen.setColumns(20);
        jTextAreaResumen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextAreaResumen.setLineWrap(true);
        jTextAreaResumen.setRows(5);
        jScrollPane3.setViewportView(jTextAreaResumen);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPDetalleSolicitud.add(jScrollPane3, gridBagConstraints);

        jTextAreaObjetivos.setColumns(20);
        jTextAreaObjetivos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextAreaObjetivos.setLineWrap(true);
        jTextAreaObjetivos.setRows(5);
        jScrollPane4.setViewportView(jTextAreaObjetivos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPDetalleSolicitud.add(jScrollPane4, gridBagConstraints);

        jLIDPubli.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLIDPubli.setForeground(new java.awt.Color(255, 255, 255));
        jLIDPubli.setText("IDPUBLI");
        jPDetalleSolicitud.add(jLIDPubli, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPContentLayout = new javax.swing.GroupLayout(jPContent);
        jPContent.setLayout(jPContentLayout);
        jPContentLayout.setHorizontalGroup(
            jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPDetalleSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPContentLayout.setVerticalGroup(
            jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPDetalleSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 59, Short.MAX_VALUE))
        );

        jPTitleNewProject.setBackground(new java.awt.Color(15, 32, 65));
        jPTitleNewProject.setForeground(new java.awt.Color(255, 255, 255));

        jBtnNewPubli.setBackground(new java.awt.Color(172, 0, 0));
        jBtnNewPubli.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jBtnNewPubli.setForeground(new java.awt.Color(255, 255, 255));
        jBtnNewPubli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.0/notificacion.png"))); // NOI18N
        jBtnNewPubli.setText("Solicitudes");
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

        javax.swing.GroupLayout jPButtomLayout = new javax.swing.GroupLayout(jPButtom);
        jPButtom.setLayout(jPButtomLayout);
        jPButtomLayout.setHorizontalGroup(
            jPButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1739, Short.MAX_VALUE)
        );
        jPButtomLayout.setVerticalGroup(
            jPButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(806, Short.MAX_VALUE)
                    .addComponent(jPButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSolis;
    private javax.swing.JButton jBtnLoginU;
    private javax.swing.JButton jBtnNewPubli;
    private javax.swing.JButton jBtnProcesarSoli;
    private com.toedter.calendar.JDateChooser jDateChFechaInicio;
    private javax.swing.JTextField jFieldPresupuesto;
    private javax.swing.JTextField jFieldTitleProject;
    private javax.swing.JLabel jLDescriptionProject;
    private javax.swing.JLabel jLDuracionMeses;
    private javax.swing.JLabel jLEstadoSolicitud;
    private javax.swing.JLabel jLEstudianteSolicitante;
    private javax.swing.JLabel jLFechaInicioProyecto;
    private javax.swing.JLabel jLIDPubli;
    private javax.swing.JLabel jLObjetivos;
    private javax.swing.JLabel jLPeriodoAca;
    private javax.swing.JLabel jLPresupuesto;
    private javax.swing.JLabel jLResumen;
    private javax.swing.JLabel jLTEstado;
    private javax.swing.JLabel jLTEstudiante;
    private javax.swing.JLabel jLTitleProject;
    private javax.swing.JPanel jPButtom;
    private javax.swing.JPanel jPChat;
    private javax.swing.JPanel jPContent;
    private javax.swing.JPanel jPDetalleSolicitud;
    private javax.swing.JPanel jPHead;
    private javax.swing.JPanel jPOpcLogin;
    private javax.swing.JPanel jPSolicitudes;
    private javax.swing.JPanel jPTitleNewProject;
    private javax.swing.JRadioButton jRBtnAceptarSoli;
    private javax.swing.JRadioButton jRBtnRechazarSoli;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPaneChat;
    private com.toedter.components.JSpinField jSpinDuracionMes;
    private com.toedter.components.JSpinField jSpinTerm;
    private javax.swing.JTextArea jTextAreaDescripProject;
    private javax.swing.JTextArea jTextAreaObjetivos;
    private javax.swing.JTextArea jTextAreaResumen;
    private com.toedter.calendar.JYearChooser jYearProyecto;
    private java.awt.Label lbTitleProyect;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
