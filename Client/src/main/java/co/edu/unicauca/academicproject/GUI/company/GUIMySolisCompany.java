/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.academicproject.GUI.company;

import co.edu.unicauca.academicproject.GUI.student.*;
import co.edu.unicauca.academicproject.GUI.controller.student.ControllerMySolisStudent;
import co.edu.unicauca.academicproject.GUI.coordinator.*;
import co.edu.unicauca.academicproject.GUI.company.*;
import co.edu.unicauca.academicproject.GUI.controller.Project.ControllerNewProject;
import co.edu.unicauca.academicproject.GUI.controller.company.controllerMySoliCompany;
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
public class GUIMySolisCompany extends javax.swing.JFrame implements Observer {

    private String token;
    private String nitCompany;
    private String rol;
    public GUIMySolisCompany(String nitCompany, String token, String rol, Sujeto sujeto) {
        initComponents();
        this.rol = rol;
        this.token = token;
        this.nitCompany = nitCompany;
        sujeto.agregarObservador(this);
        controllerMySoliCompany controller = new controllerMySoliCompany(this,rol,sujeto);
    }

    public JLabel getjLIDProyecto() {
        return jLIDProyecto;
    }

    public JScrollPane getjScrollPanelComen() {
        return jScrollPanelComen;
    }

    
    
    public JPanel getjPEstadoPubli() {
        return jPEstadoPubli;
    }

    public JPanel getjPFiltrar() {
        return jPFiltrar;
    }
    
    

    public JButton getjBtnCerrarPubli() {
        return jBtnCerrarPubli;
    }

    public JButton getjBtnCambiarEstado() {
        return jBtnCambiarEstado;
    }

    public JButton getjBtnFiltrar() {
        return jBtnFiltrar;
    }

    public JButton getjBtnQuitarFiltro() {
        return jBtnQuitarFiltro;
    }

    public JComboBox<String> getjCBEstadoProyecto() {
        return jCBEstadoProyecto;
    }

    public JRadioButton getjRbtnAceptarPro() {
        return jRbtnAceptarPro;
    }

    public JRadioButton getjRbtnCompletarProye() {
        return jRbtnCompletarProye;
    }

    public JRadioButton getjRbtnRechazarProye() {
        return jRbtnRechazarProye;
    }

    public JSpinField getjSpinPeriodo() {
        return jSpinPeriodo;
    }

    public JTextArea getjTextAreaComentarioProye() {
        return jTextAreaComentarioProye;
    }

    public JYearChooser getjYear() {
        return jYear;
    }
    
    

    public String getnitCompany() {
        return nitCompany;
    }

    public JPanel getjPChat() {
        return jPChat;
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
        return jBtnMyPubli;
    }

    public void setjBtnNewPubli(JButton jBtnNewPubli) {
        this.jBtnMyPubli = jBtnNewPubli;
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

        buttonGroupEstadoPro = new javax.swing.ButtonGroup();
        jPContent = new javax.swing.JPanel();
        jPSolicitudes = new javax.swing.JPanel();
        jPFiltrar = new javax.swing.JPanel();
        jPDatosGraficos1 = new javax.swing.JPanel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaResumen = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaObjetivos = new javax.swing.JTextArea();
        jPEstadoPubli = new javax.swing.JPanel();
        jLEstado = new javax.swing.JLabel();
        jRbtnAceptarPro = new javax.swing.JRadioButton();
        jRbtnRechazarProye = new javax.swing.JRadioButton();
        jRbtnCompletarProye = new javax.swing.JRadioButton();
        jScrollPanelComen = new javax.swing.JScrollPane();
        jTextAreaComentarioProye = new javax.swing.JTextArea();
        jBtnCambiarEstado = new javax.swing.JButton();
        jLIDProyecto = new javax.swing.JLabel();
        jPTitleNewProject = new javax.swing.JPanel();
        jBtnMyPubli = new javax.swing.JButton();
        jPHead = new javax.swing.JPanel();
        lbTitleProyect = new java.awt.Label();
        jPOpcLogin = new javax.swing.JPanel();
        jBtnLoginU = new javax.swing.JButton();
        jPButtom = new javax.swing.JPanel();
        jBtnCerrarPubli = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitudes");
        setBackground(new java.awt.Color(15, 32, 65));
        setMinimumSize(new java.awt.Dimension(1400, 1050));

        jPContent.setBackground(new java.awt.Color(15, 32, 65));
        jPContent.setForeground(new java.awt.Color(255, 255, 255));

        jPFiltrar.setBackground(new java.awt.Color(204, 204, 204));
        jPFiltrar.setLayout(new javax.swing.BoxLayout(jPFiltrar, javax.swing.BoxLayout.LINE_AXIS));

        jPDatosGraficos1.setLayout(new java.awt.GridLayout(1, 0, 10, 40));
        jPDatosGraficos1.add(jYear);

        jSpinPeriodo.setMaximum(2);
        jSpinPeriodo.setMinimum(1);
        jSpinPeriodo.setValue(1);
        jPDatosGraficos1.add(jSpinPeriodo);

        jPFiltrar.add(jPDatosGraficos1);

        jCBEstadoProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approved", "Assigned", "Completed", "Received", "Rejected" }));
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
                    .addComponent(jScrollPaneChat, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addComponent(jPFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPSolicitudesLayout.setVerticalGroup(
            jPSolicitudesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSolicitudesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPaneChat, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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
        jLTEstado.setText("Estado de la publicación:");
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

        jLEstado.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLEstado.setText("Cambie el estado del proyecto:");

        buttonGroupEstadoPro.add(jRbtnAceptarPro);
        jRbtnAceptarPro.setText("Aceptar proyecto");

        buttonGroupEstadoPro.add(jRbtnRechazarProye);
        jRbtnRechazarProye.setText("Rechazar proyecto");

        buttonGroupEstadoPro.add(jRbtnCompletarProye);
        jRbtnCompletarProye.setText("Completar proyecto");

        jTextAreaComentarioProye.setColumns(20);
        jTextAreaComentarioProye.setLineWrap(true);
        jTextAreaComentarioProye.setRows(5);
        jScrollPanelComen.setViewportView(jTextAreaComentarioProye);

        jBtnCambiarEstado.setBackground(new java.awt.Color(172, 0, 0));
        jBtnCambiarEstado.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jBtnCambiarEstado.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCambiarEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.0/solicitar.png"))); // NOI18N
        jBtnCambiarEstado.setText("CAMBIAR ESTADO");

        javax.swing.GroupLayout jPEstadoPubliLayout = new javax.swing.GroupLayout(jPEstadoPubli);
        jPEstadoPubli.setLayout(jPEstadoPubliLayout);
        jPEstadoPubliLayout.setHorizontalGroup(
            jPEstadoPubliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEstadoPubliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLEstado)
                .addGap(30, 30, 30)
                .addGroup(jPEstadoPubliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRbtnCompletarProye)
                    .addComponent(jRbtnRechazarProye)
                    .addComponent(jRbtnAceptarPro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPanelComen, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jBtnCambiarEstado)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPEstadoPubliLayout.setVerticalGroup(
            jPEstadoPubliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEstadoPubliLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPEstadoPubliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnCambiarEstado)
                    .addComponent(jScrollPanelComen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPEstadoPubliLayout.createSequentialGroup()
                        .addComponent(jRbtnAceptarPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPEstadoPubliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLEstado)
                            .addComponent(jRbtnRechazarProye))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRbtnCompletarProye)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPDetalleSolicitud.add(jPEstadoPubli, gridBagConstraints);

        jLIDProyecto.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLIDProyecto.setForeground(new java.awt.Color(255, 255, 255));
        jLIDProyecto.setText("IDPubli");
        jPDetalleSolicitud.add(jLIDProyecto, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPContentLayout = new javax.swing.GroupLayout(jPContent);
        jPContent.setLayout(jPContentLayout);
        jPContentLayout.setHorizontalGroup(
            jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPDetalleSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPContentLayout.setVerticalGroup(
            jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPContentLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPDetalleSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPTitleNewProject.setBackground(new java.awt.Color(15, 32, 65));
        jPTitleNewProject.setForeground(new java.awt.Color(255, 255, 255));
        jPTitleNewProject.setLayout(new java.awt.GridBagLayout());

        jBtnMyPubli.setBackground(new java.awt.Color(172, 0, 0));
        jBtnMyPubli.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jBtnMyPubli.setForeground(new java.awt.Color(255, 255, 255));
        jBtnMyPubli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/MyPubli.png"))); // NOI18N
        jBtnMyPubli.setText("Mis publicaciones");
        jBtnMyPubli.setBorderPainted(false);
        jBtnMyPubli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnMyPubli.setMinimumSize(new java.awt.Dimension(300, 62));
        jBtnMyPubli.setPreferredSize(new java.awt.Dimension(300, 62));
        jBtnMyPubli.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPTitleNewProject.add(jBtnMyPubli, new java.awt.GridBagConstraints());

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

        jBtnCerrarPubli.setBackground(new java.awt.Color(12, 32, 65));
        jBtnCerrarPubli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.0/anterior (1).png"))); // NOI18N
        jBtnCerrarPubli.setBorderPainted(false);

        javax.swing.GroupLayout jPButtomLayout = new javax.swing.GroupLayout(jPButtom);
        jPButtom.setLayout(jPButtomLayout);
        jPButtomLayout.setHorizontalGroup(
            jPButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPButtomLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jBtnCerrarPubli)
                .addContainerGap(1580, Short.MAX_VALUE))
        );
        jPButtomLayout.setVerticalGroup(
            jPButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPButtomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnCerrarPubli)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPTitleNewProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(915, 915, 915)
                    .addComponent(jPButtom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupEstadoPro;
    private javax.swing.JButton jBtnCambiarEstado;
    private javax.swing.JButton jBtnCerrarPubli;
    private javax.swing.JButton jBtnFiltrar;
    private javax.swing.JButton jBtnLoginU;
    private javax.swing.JButton jBtnMyPubli;
    private javax.swing.JButton jBtnQuitarFiltro;
    private javax.swing.JComboBox<String> jCBEstadoProyecto;
    private com.toedter.calendar.JDateChooser jDateChFechaInicio;
    private javax.swing.JTextField jFieldPresupuesto;
    private javax.swing.JTextField jFieldTitleProject;
    private javax.swing.JLabel jLDescriptionProject;
    private javax.swing.JLabel jLDuracionMeses;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLEstadoSolicitud;
    private javax.swing.JLabel jLFechaInicioProyecto;
    private javax.swing.JLabel jLIDProyecto;
    private javax.swing.JLabel jLObjetivos;
    private javax.swing.JLabel jLPeriodoAca;
    private javax.swing.JLabel jLPresupuesto;
    private javax.swing.JLabel jLResumen;
    private javax.swing.JLabel jLTEstado;
    private javax.swing.JLabel jLTitleProject;
    private javax.swing.JPanel jPButtom;
    private javax.swing.JPanel jPChat;
    private javax.swing.JPanel jPContent;
    private javax.swing.JPanel jPDatosGraficos1;
    private javax.swing.JPanel jPDetalleSolicitud;
    private javax.swing.JPanel jPEstadoPubli;
    private javax.swing.JPanel jPFiltrar;
    private javax.swing.JPanel jPHead;
    private javax.swing.JPanel jPOpcLogin;
    private javax.swing.JPanel jPSolicitudes;
    private javax.swing.JPanel jPTitleNewProject;
    private javax.swing.JRadioButton jRbtnAceptarPro;
    private javax.swing.JRadioButton jRbtnCompletarProye;
    private javax.swing.JRadioButton jRbtnRechazarProye;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPaneChat;
    private javax.swing.JScrollPane jScrollPanelComen;
    private com.toedter.components.JSpinField jSpinDuracionMes;
    private com.toedter.components.JSpinField jSpinPeriodo;
    private com.toedter.components.JSpinField jSpinTerm;
    private javax.swing.JTextArea jTextAreaComentarioProye;
    private javax.swing.JTextArea jTextAreaDescripProject;
    private javax.swing.JTextArea jTextAreaObjetivos;
    private javax.swing.JTextArea jTextAreaResumen;
    private com.toedter.calendar.JYearChooser jYear;
    private com.toedter.calendar.JYearChooser jYearProyecto;
    private java.awt.Label lbTitleProyect;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Actualizando desde GUI MYSOLI "+mensaje);
    }
}
