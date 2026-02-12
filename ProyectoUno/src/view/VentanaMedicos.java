package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;

public class VentanaMedicos extends JFrame {

	private JPanel contentPane;
	public JButton btnConsultar;
	public JTextField txtNombre;
	public JTextField txtCodigo;
	public JTextField txtEdad;
	public JButton btnEliminar;
	public JButton btnAgregar;
	public JTextField txtEspecialidad;
	public JButton btnLimpiar;
	public JButton btnVolver;
	public JButton btnModificar;
	public JTable table;
	public DefaultTableModel modelo;
	public JRadioButton rdbtnMasculino;
	public JRadioButton rdbtnFemenino;
	private JPanel panel_2;
	private JLabel lblBuscarMedico;
	private JLabel lblNewLabel_1_4;
	public JTextField txtBuscar;

	public VentanaMedicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 548);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(6, 175, 734, 75);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(27, 30, 95, 25);
		panel.add(btnAgregar);
		btnAgregar.setForeground(new Color(0, 102, 153));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(new Color(255, 255, 255));

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(608, 30, 95, 25);
		panel.add(btnVolver);
		btnVolver.setForeground(new Color(0, 102, 153));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(459, 34, 96, 25);
		panel.add(btnEliminar);
		btnEliminar.setForeground(new Color(0, 102, 153));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.WHITE);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(319, 32, 95, 25);
		panel.add(btnLimpiar);
		btnLimpiar.setForeground(new Color(0, 102, 153));
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(Color.WHITE);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(176, 31, 95, 25);
		panel.add(btnModificar);
		btnModificar.setForeground(new Color(0, 102, 153));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBorder(null);
		btnModificar.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(6, 11, 733, 156);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Informacion Personal");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 0, 175, 28);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 39, 63, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Edad:");
		lblNewLabel_1_2.setBounds(309, 39, 38, 14);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1 = new JLabel("Codigo:");
		lblNewLabel_1_1.setBounds(10, 84, 46, 14);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Sexo:");
		lblNewLabel_1_3.setBounds(10, 124, 63, 14);
		panel_1.add(lblNewLabel_1_3);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(66, 36, 233, 20);
		panel_1.add(txtNombre);

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(66, 81, 162, 20);
		panel_1.add(txtCodigo);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(395, 36, 126, 20);
		panel_1.add(txtEdad);

		JLabel lblNewLabel_1_3_1 = new JLabel("Especialidad:");
		lblNewLabel_1_3_1.setBounds(309, 84, 76, 14);
		panel_1.add(lblNewLabel_1_3_1);

		txtEspecialidad = new JTextField();
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(395, 81, 126, 20);
		panel_1.add(txtEspecialidad);

		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBackground(new Color(255, 255, 255));
		rdbtnMasculino.setBounds(51, 120, 83, 23);
		panel_1.add(rdbtnMasculino);

		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBackground(Color.WHITE);
		rdbtnFemenino.setBounds(145, 120, 83, 23);
		panel_1.add(rdbtnFemenino);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(253, 252, 486, 254);
		contentPane.add(panel_1_1);

		modelo = new DefaultTableModel();
		panel_1_1.setLayout(null);
		table = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(4, 5, 480, 246);

		panel_1_1.add(scroll);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(7, 255, 239, 241);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblBuscarMedico = new JLabel("Buscar Medico");
		lblBuscarMedico.setForeground(new Color(0, 102, 153));
		lblBuscarMedico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscarMedico.setBounds(4, 6, 175, 28);
		panel_2.add(lblBuscarMedico);

		lblNewLabel_1_4 = new JLabel("Buscar: ");
		lblNewLabel_1_4.setBounds(5, 65, 53, 14);
		panel_2.add(lblNewLabel_1_4);

		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(67, 62, 162, 20);
		panel_2.add(txtBuscar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(50, 136, 120, 35);
		panel_2.add(btnConsultar);
		btnConsultar.setBorder(null);
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(new Color(0, 102, 153));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
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
