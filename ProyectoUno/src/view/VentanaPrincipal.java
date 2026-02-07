package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class VentanaPrincipal extends JFrame {

    
    public JButton btnPacientes;
    public JButton btnMedicos;
    public JButton btnCitas;
    public JButton btnExpedientes;
    public JButton btnReportes;

    public VentanaPrincipal() {
        setTitle("Sistema de Gestión Clínica");
        setSize(1150, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inicializarUI();
    }

    private void inicializarUI() {

        // ===== HEADER =====
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(18, 72, 107));
        header.setPreferredSize(new Dimension(1150, 70));
        header.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        JLabel lblTitulo = new JLabel("Sistema de Gestión Clínica");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel lblFecha = new JLabel("Fecha: " + LocalDate.now());
        lblFecha.setForeground(Color.WHITE);
        lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        header.add(lblTitulo, BorderLayout.WEST);
        header.add(lblFecha, BorderLayout.EAST);

        // ===== PANEL USUARIO =====
        JPanel panelUsuario = new JPanel();
        panelUsuario.setPreferredSize(new Dimension(320, 0));
        panelUsuario.setBackground(Color.WHITE);
        panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
        panelUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 1,
                        new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(30, 25, 30, 25)
        ));

        JLabel lblPerfil = new JLabel("Perfil de Usuario");
        lblPerfil.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblPerfil.setForeground(new Color(18, 72, 107));

        JLabel lblNombre = new JLabel("Nombre: Administrador");
        JLabel lblRol = new JLabel("Rol: Personal Administrativo");
        JLabel lblEstado = new JLabel("Estado: Activo");
        JLabel lblSesion = new JLabel("Sesión iniciada correctamente");

        configurarLabelInfo(lblNombre);
        configurarLabelInfo(lblRol);
        configurarLabelInfo(lblEstado);
        configurarLabelInfo(lblSesion);

        JTextArea txtInfoUsuario = new JTextArea(
                "Desde este panel usted puede acceder a los módulos del sistema "
                        + "utilizando el menú de navegación ubicado a la derecha.\n\n"
                        + "El sistema garantiza la correcta gestión de la información clínica."
        );
        txtInfoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtInfoUsuario.setLineWrap(true);
        txtInfoUsuario.setWrapStyleWord(true);
        txtInfoUsuario.setEditable(false);
        txtInfoUsuario.setOpaque(false);
        txtInfoUsuario.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        panelUsuario.add(lblPerfil);
        panelUsuario.add(lblNombre);
        panelUsuario.add(lblRol);
        panelUsuario.add(lblEstado);
        panelUsuario.add(lblSesion);
        panelUsuario.add(txtInfoUsuario);

        // ===== PANEL NAVEGACIÓN =====
        JPanel panelNavegacion = new JPanel(new GridBagLayout());
        panelNavegacion.setBackground(new Color(245, 247, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        btnPacientes = crearBotonCard("Pacientes", "Gestión de pacientes");
        btnMedicos = crearBotonCard("Médicos", "Personal médico");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelNavegacion.add(btnPacientes, gbc);

        gbc.gridx = 1;
        panelNavegacion.add(btnMedicos, gbc);

        btnCitas = crearBotonCard("Citas Médicas", "Programación de citas");
        btnExpedientes = crearBotonCard("Expedientes", "Historial clínico");

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelNavegacion.add(btnCitas, gbc);

        gbc.gridx = 1;
        panelNavegacion.add(btnExpedientes, gbc);

        btnReportes = crearBotonCard("Reportes", "Reportes del sistema");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panelNavegacion.add(btnReportes, gbc);

        // ===== FOOTER =====
        JPanel footer = new JPanel();
        footer.setBackground(Color.WHITE);
        footer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,
                new Color(220, 220, 220)));

        JLabel lblFooter = new JLabel("VERSION 1.0");
        lblFooter.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        footer.add(lblFooter);

        // ===== ENSAMBLAR =====
        add(header, BorderLayout.NORTH);
        add(panelUsuario, BorderLayout.WEST);
        add(panelNavegacion, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    // ===== MÉTODOS AUXILIARES =====

    private void configurarLabelInfo(JLabel lbl) {
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lbl.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    }

    private JButton crearBotonCard(String titulo, String descripcion) {
        JButton boton = new JButton(
                "<html><b>" + titulo + "</b><br>" + descripcion + "</html>"
        );
        boton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        boton.setBackground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        return boton;
    }

    public void init() {
        this.setVisible(true);
    }

    public void close() {
        this.setVisible(false);
    }
}
