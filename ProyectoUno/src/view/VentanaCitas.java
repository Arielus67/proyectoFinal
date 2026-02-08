package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class VentanaCitas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // ===== BOTONES PUBLICOS =====
    public JButton btnGuardar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnLimpiar;
    public JButton btnVolver;

    // ===== CAMPOS PUBLICOS =====
    public JTextField txtPaciente;
    public JTextField txtIdentificacion;
    public JTextField txtFecha;
    public JTextField txtHora;
    public JTextField txtMedico;
    public JTextArea txtMotivo;

    public VentanaCitas() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 540);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ================= PANEL BOTONES =================
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(0, 102, 153));
        panelBotones.setBounds(10, 11, 225, 480);
        panelBotones.setLayout(null);
        contentPane.add(panelBotones);

        btnGuardar = crearBoton("Guardar", 30);
        panelBotones.add(btnGuardar);

        btnModificar = crearBoton("Modificar", 95);
        panelBotones.add(btnModificar);

        btnEliminar = crearBoton("Eliminar", 160);
        panelBotones.add(btnEliminar);

        btnLimpiar = crearBoton("Limpiar", 225);
        panelBotones.add(btnLimpiar);

        btnVolver = crearBoton("Volver", 300);
        panelBotones.add(btnVolver);

        // ================= PANEL DATOS CITA =================
        JPanel panelCita = new JPanel();
        panelCita.setBorder(new LineBorder(Color.LIGHT_GRAY));
        panelCita.setBackground(Color.WHITE);
        panelCita.setBounds(245, 11, 570, 480);
        panelCita.setLayout(null);
        contentPane.add(panelCita);

        JLabel lblTitulo = new JLabel("Programar Cita Médica");
        lblTitulo.setForeground(new Color(0, 102, 153));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBounds(10, 10, 250, 25);
        panelCita.add(lblTitulo);

        JLabel lblPaciente = new JLabel("Nombre Paciente:");
        lblPaciente.setBounds(10, 55, 120, 14);
        panelCita.add(lblPaciente);

        txtPaciente = new JTextField();
        txtPaciente.setBounds(130, 52, 250, 20);
        panelCita.add(txtPaciente);

        JLabel lblId = new JLabel("Identificación:");
        lblId.setBounds(10, 90, 120, 14);
        panelCita.add(lblId);

        txtIdentificacion = new JTextField();
        txtIdentificacion.setBounds(130, 87, 250, 20);
        panelCita.add(txtIdentificacion);

        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setBounds(10, 125, 120, 14);
        panelCita.add(lblMedico);

        txtMedico = new JTextField();
        txtMedico.setBounds(130, 122, 250, 20);
        panelCita.add(txtMedico);

        JLabel lblFecha = new JLabel("Fecha (dd/mm/aaaa):");
        lblFecha.setBounds(10, 160, 150, 14);
        panelCita.add(lblFecha);

        txtFecha = new JTextField();
        txtFecha.setBounds(160, 157, 120, 20);
        panelCita.add(txtFecha);

        JLabel lblHora = new JLabel("Hora:");
        lblHora.setBounds(300, 160, 50, 14);
        panelCita.add(lblHora);

        txtHora = new JTextField();
        txtHora.setBounds(350, 157, 80, 20);
        panelCita.add(txtHora);

        JLabel lblMotivo = new JLabel("Motivo de la cita:");
        lblMotivo.setBounds(10, 200, 120, 14);
        panelCita.add(lblMotivo);

        txtMotivo = new JTextArea();
        txtMotivo.setBorder(new LineBorder(Color.LIGHT_GRAY));
        txtMotivo.setBounds(130, 200, 300, 180);
        panelCita.add(txtMotivo);
    }

    // ================= ESTILO BOTON =================
    private JButton crearBoton(String texto, int y) {
        JButton btn = new JButton(texto);
        btn.setBounds(30, y, 160, 40);
        btn.setBackground(Color.WHITE);
        btn.setForeground(new Color(0, 102, 153));
        btn.setBorder(null);
        return btn;
    }

    public void init() {
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void close() {
        this.setVisible(false);
    }
}
