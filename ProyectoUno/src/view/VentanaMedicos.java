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

public class VentanaMedicos extends JFrame {

	private JPanel contentPane;
	public JButton btnConsultar;
	public JTextField txtNombre;
	public JTextField txtCodigo;
	public JTextField txtSexo;
	public JTextField txtEdad;
	public JButton btnEliminar;
	public JButton btnAgregar;
	public JTextField txtEspecialidad;
	public JButton btnLimpiar;
	public JButton btnVolver;
	public JButton btnModificar;
	public JTable table;
	public DefaultTableModel modelo;



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
		panel.setBounds(10, 11, 215, 487);
		contentPane.add(panel);
		panel.setLayout(null);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setBorder(null);
		btnConsultar.setForeground(new Color(0, 102, 153));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(25, 10, 158, 44);
		panel.add(btnConsultar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(new Color(0, 102, 153));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(25, 92, 158, 44);
		panel.add(btnAgregar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(0, 102, 153));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(25, 182, 158, 44);
		panel.add(btnEliminar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(0, 102, 153));
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(25, 269, 158, 44);
		panel.add(btnLimpiar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 153));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(25, 419, 158, 44);
		panel.add(btnVolver);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 102, 153));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnModificar.setBorder(null);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(25, 348, 158, 44);
		panel.add(btnModificar);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(235, 11, 504, 179);
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

		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(66, 121, 92, 20);
		panel_1.add(txtSexo);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(348, 36, 126, 20);
		panel_1.add(txtEdad);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Especialidad:");
		lblNewLabel_1_3_1.setBounds(236, 84, 102, 14);
		panel_1.add(lblNewLabel_1_3_1);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(348, 82, 126, 20);
		panel_1.add(txtEspecialidad);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(235, 201, 504, 297); 
		contentPane.add(panel_1_1);              

		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		JScrollPane scroll = new JScrollPane(table);

		panel_1_1.add(scroll, BorderLayout.CENTER);
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
