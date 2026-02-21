package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VentanaCitas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnVolver;
	public DefaultTableModel modeloCitas;
	public DefaultTableModel modeloPacientes;
	public DefaultTableModel modeloMedicos;
	public JTable tableCitas;
	public JTable tablePacientes;
	public JTable tableMedicos;
	public JButton btnCrearCita;
	public JButton btnEliminar;
	public JButton btnBuscar;
	public JTextField txtBuscar;
	public JButton btnModificar;
	public JComboBox cbxEstado;
	public JComboBox cbxHorasDisponibles;

	public VentanaCitas() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(11, 343, 375, 325);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 153));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(10, 268, 110, 29);
		panel.add(btnVolver);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(0, 102, 153));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(10, 67, 110, 29);
		panel.add(btnBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(145, 69, 178, 28);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 102, 153));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBorder(null);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(135, 268, 110, 29);
		panel.add(btnModificar);
		
		JLabel lblInformacion = new JLabel("Ingrese el codigo de la cita a buscar");
		lblInformacion.setForeground(new Color(255, 255, 255));
		lblInformacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformacion.setBounds(10, 28, 268, 14);
		panel.add(lblInformacion);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(255, 268, 110, 29);
		panel.add(btnEliminar);
		btnEliminar.setForeground(new Color(0, 102, 153));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(543, 11, 531, 320);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPacientes = new JLabel("Pacientes ");
		lblPacientes.setBounds(10, 11, 135, 14);
		panel_1.add(lblPacientes);
		lblPacientes.setForeground(new Color(0, 102, 153));
		lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 36, 589, 273);
		panel_1.add(scrollPane_1);
		
		modeloPacientes = new DefaultTableModel();
		tablePacientes = new JTable(modeloPacientes);
		scrollPane_1.setViewportView(tablePacientes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(395, 342, 679, 328);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 25, 669, 292);
		panel_2.add(scrollPane);
		
		modeloCitas = new DefaultTableModel();
		tableCitas = new JTable(modeloCitas);
		scrollPane.setViewportView(tableCitas);
		
		JLabel lblCitas = new JLabel("Citas");
		lblCitas.setBounds(10, 10, 135, 14);
		panel_2.add(lblCitas);
		lblCitas.setForeground(new Color(0, 102, 153));
		lblCitas.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 11, 523, 262);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblMedicos = new JLabel("Medicos Disponibles");
		lblMedicos.setBounds(10, 11, 135, 14);
		panel_3.add(lblMedicos);
		lblMedicos.setForeground(new Color(0, 102, 153));
		lblMedicos.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 36, 513, 225);
		panel_3.add(scrollPane_2);
		
		modeloMedicos = new DefaultTableModel();
		tableMedicos = new JTable(modeloMedicos);
		scrollPane_2.setViewportView(tableMedicos);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(11, 277, 522, 62);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		btnCrearCita = new JButton("Crear Cita");
		btnCrearCita.setForeground(new Color(255, 255, 255));
		btnCrearCita.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCrearCita.setBorder(null);
		btnCrearCita.setBackground(new Color(0, 102, 153));
		btnCrearCita.setBounds(24, 23, 110, 29);
		panel_4.add(btnCrearCita);
		
		cbxEstado = new JComboBox();
		cbxEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbxEstado.setForeground(new Color(255, 255, 255));
		cbxEstado.setBackground(new Color(0, 102, 152));
		cbxEstado.setBounds(157, 23, 110, 29);
		panel_4.add(cbxEstado);
		
		cbxEstado.addItem("Atendida");
		cbxEstado.addItem("Pendiente");
		cbxEstado.addItem("Cancelada");
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setForeground(new Color(0, 102, 153));
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(317, 30, 46, 14);
		panel_4.add(lblHora);
		
		cbxHorasDisponibles = new JComboBox();
		cbxHorasDisponibles.setBounds(373, 27, 110, 22);
		panel_4.add(cbxHorasDisponibles);

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
