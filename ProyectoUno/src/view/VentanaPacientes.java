package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class VentanaPacientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnGuardar;
	public JButton btnModificar;
	public JButton btnEliminar;
	public JButton btnLimpiar;
	public JButton btnVolver;
	public JTextField txtNombre;
	public JTextField txtIdentificacion;
	public JTextField txtEdad;
	public JTextField txtContacto;
	public JTextArea txtAreaEnfermedad;
	public JComboBox comboBox;
	public JButton btnConsultar;
	public JTable table;
	public DefaultTableModel modelo;
	public JTextField txtBuscar;
	public JRadioButton rdbtnMasculino;
	public JRadioButton rdbtnFemenino;

	public VentanaPacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 523);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 11, 795, 152);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Informacion del Paciente");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 186, 28);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 50, 63, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Identificacion:");
		lblNewLabel_1_1.setBounds(10, 85, 85, 14);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Edad:");
		lblNewLabel_1_2.setBounds(333, 50, 63, 14);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Sexo:");
		lblNewLabel_1_3.setBounds(10, 116, 63, 14);
		panel_1.add(lblNewLabel_1_3);

		txtNombre = new JTextField();
		txtNombre.setBounds(93, 50, 230, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);

		txtIdentificacion = new JTextField();
		txtIdentificacion.setColumns(10);
		txtIdentificacion.setBounds(93, 82, 408, 20);
		panel_1.add(txtIdentificacion);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(375, 48, 126, 20);
		panel_1.add(txtEdad);

		JLabel lblNewLabel_2 = new JLabel("Contacto:");
		lblNewLabel_2.setBounds(248, 114, 68, 19);
		panel_1.add(lblNewLabel_2);

		txtContacto = new JTextField();
		txtContacto.setBounds(315, 114, 186, 20);
		panel_1.add(txtContacto);
		txtContacto.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Gravedad:");
		lblNewLabel_4.setBounds(511, 50, 63, 14);
		panel_1.add(lblNewLabel_4);

		comboBox = new JComboBox();
		comboBox.setBounds(584, 48, 78, 18);
		panel_1.add(comboBox);

		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);

		JLabel lblNewLabel_3 = new JLabel("Enfermedad:");
		lblNewLabel_3.setBounds(511, 85, 78, 14);
		panel_1.add(lblNewLabel_3);

		txtAreaEnfermedad = new JTextArea();
		txtAreaEnfermedad.setBounds(584, 81, 186, 60);
		panel_1.add(txtAreaEnfermedad);
		txtAreaEnfermedad.setBorder(new LineBorder(Color.LIGHT_GRAY));

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBackground(new Color(255, 255, 255));
		rdbtnMasculino.setBounds(43, 112, 85, 23);
		panel_1.add(rdbtnMasculino);

		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBackground(Color.WHITE);
		rdbtnFemenino.setBounds(130, 112, 85, 23);
		panel_1.add(rdbtnFemenino);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(10, 166, 795, 81);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBounds(26, 21, 104, 30);
		panel_1_1.add(btnGuardar);
		btnGuardar.setBorder(null);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(0, 102, 153));

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBounds(175, 21, 104, 30);
		panel_1_1.add(btnModificar);
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setBorder(null);
		btnModificar.setBackground(new Color(0, 102, 153));

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(337, 21, 104, 30);
		panel_1_1.add(btnEliminar);
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(0, 102, 153));

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setBounds(500, 21, 104, 30);
		panel_1_1.add(btnLimpiar);
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(new Color(0, 102, 153));

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBounds(657, 21, 104, 30);
		panel_1_1.add(btnVolver);
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.setBorder(null);
		btnVolver.setBackground(new Color(0, 102, 153));

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.LIGHT_GRAY);
		panel_1_2.setBounds(276, 246, 529, 238);
		contentPane.add(panel_1_2);

		modelo = new DefaultTableModel();
		panel_1_2.setLayout(null);
		table = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 11, 519, 216);

		panel_1_2.add(scroll);

		JPanel panel = new JPanel();
		panel.setBounds(10, 258, 256, 215);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblBuscarPaciente = new JLabel("Buscar Paciente");
		lblBuscarPaciente.setForeground(new Color(0, 102, 153));
		lblBuscarPaciente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscarPaciente.setBounds(10, 11, 186, 28);
		panel.add(lblBuscarPaciente);

		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(66, 50, 169, 20);
		panel.add(txtBuscar);

		JLabel lblNewLabel_1_3_1 = new JLabel("Buscar:");
		lblNewLabel_1_3_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3_1.setBounds(10, 53, 57, 14);
		panel.add(lblNewLabel_1_3_1);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(66, 132, 104, 30);
		panel.add(btnConsultar);
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(new Color(0, 102, 153));
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
