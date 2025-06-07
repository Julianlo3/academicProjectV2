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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JSpinField;

import javax.swing.*;

/**
 *
 * @author lopez
 */
public class GUIStudentRequest extends javax.swing.JFrame {

    private String token;
    public GUIStudentRequest(String token) {
        initComponents();
        this.token = token;
        controllerStudentRequest controllerStudentRequest = new controllerStudentRequest(this);
    }

    public JPanel getjPChat() {
        return jPChat;
    }

    

    public String getToken(){
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JButton getjBtnFiltrar() {
        return jBtnFiltrar;
    }

    public void setjBtnFiltrar(JButton jBtnFiltrar) {
        this.jBtnFiltrar = jBtnFiltrar;
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

    public JButton getjBtnQuitarFiltro() {
        return jBtnQuitarFiltro;
    }

    public void setjBtnQuitarFiltro(JButton jBtnQuitarFiltro) {
        this.jBtnQuitarFiltro = jBtnQuitarFiltro;
    }

    public JComboBox<String> getjCBEstadoProyecto() {
        return jCBEstadoProyecto;
    }

    public void setjCBEstadoProyecto(JComboBox<String> jCBEstadoProyecto) {
        this.jCBEstadoProyecto = jCBEstadoProyecto;
    }

    public JDateChooser getjDateChFechaInicio() {
        return jDateChFechaInicio;
    }

    public void setjDateChFechaInicio(JDateChooser jDateChFechaInicio) {
        this.jDateChFechaInicio = jDateChFechaInicio;
    }

    public JTextArea getjFieldMotivoRechazo() {
        return jFieldMotivoRechazo;
    }

    public void setjFieldMotivoRechazo(JTextArea jFieldMotivoRechazo) {
        this.jFieldMotivoRechazo = jFieldMotivoRechazo;
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

    public JSpinField getjSpinPeriodo() {
        return jSpinPeriodo;
    }

    public void setjSpinPeriodo(JSpinField jSpinPeriodo) {
        this.jSpinPeriodo = jSpinPeriodo;
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

    public JTextField getjTextAreaObjetivos() {
        return jTextAreaObjetivos;
    }

    public void setjTextAreaObjetivos(JTextField jTextAreaObjetivos) {
        this.jTextAreaObjetivos = jTextAreaObjetivos;
    }

    public JTextField getjTextAreaResumen() {
        return jTextAreaResumen;
    }

    public void setjTextAreaResumen(JTextField jTextAreaResumen) {
        this.jTextAreaResumen = jTextAreaResumen;
    }

    public JYearChooser getjYear() {
        return jYear;
    }

    public void setjYear(JYearChooser jYear) {
        this.jYear = jYear;
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

        buttonGroupSolis = new javax.swing.ButtonGroup();
        jPContent = new javax.swing.JPanel();
        jPSolicitudes = new javax.swing.JPanel();
        jPFiltrar = new javax.swing.JPanel();
        jPDatosGraficos = new javax.swing.JPanel();
        jYear = new com.toedter.calendar.JYearChooser();
        jSpinPeriodo = new com.toedter.components.JSpinField();
        jCBEstadoProyecto = new javax.swing.JComboBox<>();
        jBtnFiltrar = new javax.swing.JButton();
        jBtnQuitarFiltro = new javax.swing.JButton();
        jScrollPaneChat = new javax.swing.JScrollPane();
        jPChat = new javax.swing.JPanel();
        jPDetalleSolicitud = new javax.swing.JPanel();
        jLTitleProject = new javax.swing.JLabel();
        jFieldTitleProject = new javax.swing.JTextField();
        jLDescriptionProject = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripProject = new javax.swing.JTextArea();
        jLResumen = new javax.swing.JLabel();
        jTextAreaResumen = new javax.swing.JTextField();
        jLObjetivos = new javax.swing.JLabel();
        jTextAreaObjetivos = new javax.swing.JTextField();
        jLDuracionMeses = new javax.swing.JLabel();
        jSpinDuracionMes = new com.toedter.components.JSpinField();
        jLabel1 = new javax.swing.JLabel();
        jYearProyecto = new com.toedter.calendar.JYearChooser();
        jSpinTerm = new com.toedter.components.JSpinField();
        jLFechaInicioProyecto = new javax.swing.JLabel();
        jDateChFechaInicio = new com.toedter.calendar.JDateChooser();
        jFieldPresupuesto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLTEstado = new javax.swing.JLabel();
        jLEstadoSolicitud = new javax.swing.JLabel();
        jLTEstudiante = new javax.swing.JLabel();
        jLEstudianteSolicitante = new javax.swing.JLabel();
        jRBtnAceptarSoli = new javax.swing.JRadioButton();
        jRBtnRechazarSoli = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jFieldMotivoRechazo = new javax.swing.JTextArea();
        jBtnProcesarSoli = new javax.swing.JButton();
        jPTitleNewProject = new javax.swing.JPanel();
        jBtnNewPubli = new javax.swing.JButton();
        jPHead = new javax.swing.JPanel();
        lbTitleProyect = new java.awt.Label();
        jPOpcLogin = new javax.swing.JPanel();
        jBtnLoginU = new javax.swing.JButton();
        jPButtom = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitudes");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(15, 32, 65));
        setMinimumSize(new java.awt.Dimension(700, 550));

        jPContent.setBackground(new java.awt.Color(15, 32, 65));
        jPContent.setForeground(new java.awt.Color(255, 255, 255));

        jPFiltrar.setBackground(new java.awt.Color(204, 204, 204));
        jPFiltrar.setLayout(new javax.swing.BoxLayout(jPFiltrar, javax.swing.BoxLayout.LINE_AXIS));

        jPDatosGraficos.setLayout(new java.awt.GridLayout(1, 0, 10, 40));
        jPDatosGraficos.add(jYear);

        jSpinPeriodo.setMaximum(2);
        jSpinPeriodo.setMinimum(1);
        jSpinPeriodo.setValue(1);
        jPDatosGraficos.add(jSpinPeriodo);

        jPFiltrar.add(jPDatosGraficos);

        jCBEstadoProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approved", "Assigned", "Completed", "Received", "Reject" }));
        jPFiltrar.add(jCBEstadoProyecto);

        jBtnFiltrar.setText("Filtrar");
        jPFiltrar.add(jBtnFiltrar);

        jBtnQuitarFiltro.setText("Quitar filtro");
        jPFiltrar.add(jBtnQuitarFiltro);

        jScrollPaneChat.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPChat.setLayout(new javax.swing.BoxLayout(jPChat, javax.swing.BoxLayout.Y_AXIS));
        jScrollPaneChat.setViewportView(jPChat);

        javax.swing.GroupLayout jPSolicitudesLayout = new javax.swing.GroupLayout(jPSolicitudes);
        jPSolicitudes.setLayout(jPSolicitudesLayout);
        jPSolicitudesLayout.setHorizontalGroup(
            jPSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneChat))
                .addContainerGap())
        );
        jPSolicitudesLayout.setVerticalGroup(
            jPSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneChat, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPDetalleSolicitud.setBackground(new java.awt.Color(15, 32, 65));

        jLTitleProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLTitleProject.setForeground(new java.awt.Color(255, 255, 255));
        jLTitleProject.setText("Titulo del proyecto:");

        jFieldTitleProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jFieldTitleProject.setText("Mi proyecto");
        jFieldTitleProject.setEnabled(false);

        jLDescriptionProject.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLDescriptionProject.setForeground(new java.awt.Color(255, 255, 255));
        jLDescriptionProject.setText("Descripción del proyecto: ");

        jTextAreaDescripProject.setColumns(20);
        jTextAreaDescripProject.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextAreaDescripProject.setLineWrap(true);
        jTextAreaDescripProject.setRows(5);
        jTextAreaDescripProject.setText("Proyecto enfocado en los sitemas gestores academicos\n");
        jTextAreaDescripProject.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaDescripProject);

        jLResumen.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLResumen.setForeground(new java.awt.Color(255, 255, 255));
        jLResumen.setText("Resumen:");

        jTextAreaResumen.setText("jTextField1");
        jTextAreaResumen.setEnabled(false);
        jTextAreaResumen.setMaximumSize(new java.awt.Dimension(250, 30));
        jTextAreaResumen.setMinimumSize(new java.awt.Dimension(200, 30));
        jTextAreaResumen.setPreferredSize(new java.awt.Dimension(200, 30));

        jLObjetivos.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLObjetivos.setForeground(new java.awt.Color(255, 255, 255));
        jLObjetivos.setText("Objetivos:");

        jTextAreaObjetivos.setText("jTextField2");
        jTextAreaObjetivos.setEnabled(false);
        jTextAreaObjetivos.setMaximumSize(new java.awt.Dimension(250, 30));
        jTextAreaObjetivos.setMinimumSize(new java.awt.Dimension(200, 30));
        jTextAreaObjetivos.setPreferredSize(new java.awt.Dimension(200, 30));

        jLDuracionMeses.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLDuracionMeses.setForeground(new java.awt.Color(255, 255, 255));
        jLDuracionMeses.setText("Duracion del proyecto(meses):");

        jSpinDuracionMes.setEnabled(false);
        jSpinDuracionMes.setMaximum(12);
        jSpinDuracionMes.setMinimum(1);
        jSpinDuracionMes.setValue(1);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Periodo academico:");

        jYearProyecto.setEnabled(false);

        jSpinTerm.setEnabled(false);
        jSpinTerm.setMaximum(2);
        jSpinTerm.setMinimum(1);
        jSpinTerm.setValue(1);

        jLFechaInicioProyecto.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLFechaInicioProyecto.setForeground(new java.awt.Color(255, 255, 255));
        jLFechaInicioProyecto.setText("Fecha inicio:");

        jDateChFechaInicio.setDateFormatString("y-MM-d");
        jDateChFechaInicio.setEnabled(false);

        jFieldPresupuesto.setText("1");
        jFieldPresupuesto.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Presupuesto:");

        jLTEstado.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLTEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLTEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTEstado.setText("Estado:");

        jLEstadoSolicitud.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLEstadoSolicitud.setForeground(new java.awt.Color(255, 255, 255));
        jLEstadoSolicitud.setText("Received");

        jLTEstudiante.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLTEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        jLTEstudiante.setText("Estudiante solicitante:");

        jLEstudianteSolicitante.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLEstudianteSolicitante.setForeground(new java.awt.Color(255, 255, 255));
        jLEstudianteSolicitante.setText("Pepito perez");

        buttonGroupSolis.add(jRBtnAceptarSoli);
        jRBtnAceptarSoli.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jRBtnAceptarSoli.setForeground(new java.awt.Color(255, 255, 255));
        jRBtnAceptarSoli.setText("ACETPAR SOLICITUD");

        buttonGroupSolis.add(jRBtnRechazarSoli);
        jRBtnRechazarSoli.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jRBtnRechazarSoli.setForeground(new java.awt.Color(255, 255, 255));
        jRBtnRechazarSoli.setText("RECHAZAR SOLICITUD");

        jFieldMotivoRechazo.setColumns(20);
        jFieldMotivoRechazo.setRows(5);
        jFieldMotivoRechazo.setEnabled(false);
        jScrollPane2.setViewportView(jFieldMotivoRechazo);

        jBtnProcesarSoli.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jBtnProcesarSoli.setText("CONFIRMAR");

        javax.swing.GroupLayout jPDetalleSolicitudLayout = new javax.swing.GroupLayout(jPDetalleSolicitud);
        jPDetalleSolicitud.setLayout(jPDetalleSolicitudLayout);
        jPDetalleSolicitudLayout.setHorizontalGroup(
            jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFieldPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jYearProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addComponent(jLDuracionMeses)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinDuracionMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addComponent(jLFechaInicioProyecto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(142, 142, 142))
            .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                                .addComponent(jLDescriptionProject)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLObjetivos))
                            .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                                .addComponent(jLTitleProject)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFieldTitleProject, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jLResumen)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextAreaResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextAreaObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLTEstado)
                        .addGap(18, 18, 18)
                        .addComponent(jLEstadoSolicitud)
                        .addGap(138, 138, 138)
                        .addComponent(jLTEstudiante)
                        .addGap(18, 18, 18)
                        .addComponent(jLEstudianteSolicitante)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jRBtnAceptarSoli)
                        .addGap(18, 18, 18)
                        .addComponent(jRBtnRechazarSoli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDetalleSolicitudLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnProcesarSoli)
                        .addGap(220, 220, 220)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPDetalleSolicitudLayout.setVerticalGroup(
            jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitleProject)
                    .addComponent(jFieldTitleProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLResumen)
                    .addComponent(jTextAreaResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLDescriptionProject))
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLObjetivos)
                            .addComponent(jTextAreaObjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jYearProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jFieldPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinDuracionMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDuracionMeses))
                        .addGap(18, 18, 18)
                        .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLFechaInicioProyecto)
                            .addComponent(jDateChFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTEstado)
                    .addComponent(jLEstadoSolicitud)
                    .addComponent(jLTEstudiante)
                    .addComponent(jLEstudianteSolicitante))
                .addGap(34, 34, 34)
                .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPDetalleSolicitudLayout.createSequentialGroup()
                        .addGroup(jPDetalleSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRBtnAceptarSoli)
                            .addComponent(jRBtnRechazarSoli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnProcesarSoli))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPContentLayout = new javax.swing.GroupLayout(jPContent);
        jPContent.setLayout(jPContentLayout);
        jPContentLayout.setHorizontalGroup(
            jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPDetalleSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPContentLayout.setVerticalGroup(
            jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPDetalleSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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
            .addGap(0, 1328, Short.MAX_VALUE)
        );
        jPButtomLayout.setVerticalGroup(
            jPButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(670, Short.MAX_VALUE)
                    .addComponent(jPButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSolis;
    private javax.swing.JButton jBtnFiltrar;
    private javax.swing.JButton jBtnLoginU;
    private javax.swing.JButton jBtnNewPubli;
    private javax.swing.JButton jBtnProcesarSoli;
    private javax.swing.JButton jBtnQuitarFiltro;
    private javax.swing.JComboBox<String> jCBEstadoProyecto;
    private com.toedter.calendar.JDateChooser jDateChFechaInicio;
    private javax.swing.JTextArea jFieldMotivoRechazo;
    private javax.swing.JTextField jFieldPresupuesto;
    private javax.swing.JTextField jFieldTitleProject;
    private javax.swing.JLabel jLDescriptionProject;
    private javax.swing.JLabel jLDuracionMeses;
    private javax.swing.JLabel jLEstadoSolicitud;
    private javax.swing.JLabel jLEstudianteSolicitante;
    private javax.swing.JLabel jLFechaInicioProyecto;
    private javax.swing.JLabel jLObjetivos;
    private javax.swing.JLabel jLResumen;
    private javax.swing.JLabel jLTEstado;
    private javax.swing.JLabel jLTEstudiante;
    private javax.swing.JLabel jLTitleProject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPButtom;
    private javax.swing.JPanel jPChat;
    private javax.swing.JPanel jPContent;
    private javax.swing.JPanel jPDatosGraficos;
    private javax.swing.JPanel jPDetalleSolicitud;
    private javax.swing.JPanel jPFiltrar;
    private javax.swing.JPanel jPHead;
    private javax.swing.JPanel jPOpcLogin;
    private javax.swing.JPanel jPSolicitudes;
    private javax.swing.JPanel jPTitleNewProject;
    private javax.swing.JRadioButton jRBtnAceptarSoli;
    private javax.swing.JRadioButton jRBtnRechazarSoli;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneChat;
    private com.toedter.components.JSpinField jSpinDuracionMes;
    private com.toedter.components.JSpinField jSpinPeriodo;
    private com.toedter.components.JSpinField jSpinTerm;
    private javax.swing.JTextArea jTextAreaDescripProject;
    private javax.swing.JTextField jTextAreaObjetivos;
    private javax.swing.JTextField jTextAreaResumen;
    private com.toedter.calendar.JYearChooser jYear;
    private com.toedter.calendar.JYearChooser jYearProyecto;
    private java.awt.Label lbTitleProyect;
    // End of variables declaration//GEN-END:variables
}
