package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
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
	public JTextField txtSexo;

	public VentanaPacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(10, 11, 225, 467);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBorder(null);
		btnGuardar.setForeground(new Color(0, 102, 153));
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setBounds(30, 30, 136, 38);
		panel.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 102, 153));
		btnModificar.setBorder(null);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(30, 92, 136, 38);
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(0, 102, 153));
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(30, 167, 136, 38);
		panel.add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(0, 102, 153));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(Color.WHITE);
		btnLimpiar.setBounds(30, 239, 136, 38);
		panel.add(btnLimpiar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 153));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(30, 314, 136, 38);
		panel.add(btnVolver);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(245, 11, 560, 152);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informacion Personal");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 175, 28);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 50, 63, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Identificacion:");
		lblNewLabel_1_1.setBounds(10, 85, 85, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Edad:");
		lblNewLabel_1_2.setBounds(342, 50, 63, 14);
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
		txtEdad.setBounds(375, 47, 126, 20);
		panel_1.add(txtEdad);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(93, 113, 92, 20);
		panel_1.add(txtSexo);
		txtSexo.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(245, 167, 560, 152);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblInformacionDeContacto = new JLabel("Informacion de Contacto");
		lblInformacionDeContacto.setForeground(new Color(0, 102, 153));
		lblInformacionDeContacto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformacionDeContacto.setBounds(10, 0, 175, 28);
		panel_1_1.add(lblInformacionDeContacto);
		
		JLabel lblNewLabel_2 = new JLabel("Contacto:");
		lblNewLabel_2.setBounds(10, 69, 68, 19);
		panel_1_1.add(lblNewLabel_2);
		
		txtContacto = new JTextField();
		txtContacto.setBounds(72, 68, 428, 20);
		panel_1_1.add(txtContacto);
		txtContacto.setColumns(10);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(245, 326, 560, 152);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JLabel lblCuasaDeVisita = new JLabel("Cuasa de Visita");
		lblCuasaDeVisita.setForeground(new Color(0, 102, 153));
		lblCuasaDeVisita.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCuasaDeVisita.setBounds(10, 0, 175, 28);
		panel_1_2.add(lblCuasaDeVisita);
		
		JLabel lblNewLabel_3 = new JLabel("Enfermedad:");
		lblNewLabel_3.setBounds(10, 39, 78, 14);
		panel_1_2.add(lblNewLabel_3);
		
		txtAreaEnfermedad = new JTextArea();
		txtAreaEnfermedad.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtAreaEnfermedad.setBounds(101, 39, 211, 107);
		panel_1_2.add(txtAreaEnfermedad);
		
		JLabel lblNewLabel_4 = new JLabel("Gravedad:");
		lblNewLabel_4.setBounds(348, 39, 63, 14);
		panel_1_2.add(lblNewLabel_4);
		
		comboBox = new JComboBox();
		comboBox.setBounds(438, 37, 78, 18);

		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);

		panel_1_2.add(comboBox);


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
