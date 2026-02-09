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

public class VentanaCitas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnAsignar;
	public JComboBox comboBoxMedicos;
	public JComboBox comboBoxPacientes;
	public JComboBox comboBoxCitas;
	public JButton btnConsultar;
	public JButton btnEliminar;
	public JTextArea textAreaConsulta;
	public JButton btnVolver;

	public VentanaCitas() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(10, 11, 266, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		comboBoxPacientes = new JComboBox();
		comboBoxPacientes.setBounds(10, 39, 234, 22);
		panel.add(comboBoxPacientes);
		
		JLabel lblMedicos = new JLabel("Medicos Disponibles");
		lblMedicos.setForeground(Color.WHITE);
		lblMedicos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMedicos.setBounds(10, 21, 135, 14);
		panel.add(lblMedicos);
		
		JLabel lblPacientes = new JLabel("Pacientes ");
		lblPacientes.setForeground(Color.WHITE);
		lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPacientes.setBounds(10, 72, 135, 14);
		panel.add(lblPacientes);
		
		comboBoxMedicos = new JComboBox();
		comboBoxMedicos.setBounds(10, 97, 234, 22);
		panel.add(comboBoxMedicos);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setBorder(null);
		btnAsignar.setBackground(Color.WHITE);
		btnAsignar.setForeground(new Color(0, 102, 153));
		btnAsignar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAsignar.setBounds(52, 150, 135, 37);
		panel.add(btnAsignar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 153));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(70, 418, 135, 37);
		panel.add(btnVolver);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(286, 11, 476, 147);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		comboBoxCitas = new JComboBox();
		comboBoxCitas.setBounds(10, 31, 376, 22);
		panel_1.add(comboBoxCitas);
		
		JLabel lblCitas = new JLabel("Citas");
		lblCitas.setForeground(new Color(0, 102, 153));
		lblCitas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCitas.setBounds(10, 11, 135, 14);
		panel_1.add(lblCitas);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(new Color(0, 102, 153));
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBounds(10, 91, 135, 29);
		panel_1.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(new Color(0, 102, 153));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBounds(251, 91, 135, 29);
		panel_1.add(btnEliminar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(286, 169, 476, 336);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textAreaConsulta = new JTextArea();
		textAreaConsulta.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textAreaConsulta.setBounds(10, 11, 456, 314);
		panel_2.add(textAreaConsulta);

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
