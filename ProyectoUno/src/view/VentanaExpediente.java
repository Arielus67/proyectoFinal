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

public class VentanaExpediente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnVolver;
	public DefaultTableModel modeloExpediente;
	public DefaultTableModel modeloPacientes;
	public DefaultTableModel modeloMedicos;
	public JTable tableExpediente;
	public JTable tablePacientes;
	public JButton btnConsultar;
	public JTextField txtConsultar;
	public JButton btnGuardar;

	public VentanaExpediente() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(516, 10, 375, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 153));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(255, 602, 110, 29);
		panel.add(btnVolver);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(0, 102, 153));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(20, 59, 110, 29);
		panel.add(btnConsultar);
		
		txtConsultar = new JTextField();
		txtConsultar.setBounds(140, 61, 196, 28);
		panel.add(txtConsultar);
		txtConsultar.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(0, 102, 153));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(Color.WHITE);
		btnGuardar.setBounds(20, 472, 110, 29);
		panel.add(btnGuardar);
		
		JLabel lblDiagnsticosYObservaciones = new JLabel("Diagnósticos y observaciones médicas");
		lblDiagnsticosYObservaciones.setForeground(new Color(255, 255, 255));
		lblDiagnsticosYObservaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDiagnsticosYObservaciones.setBounds(10, 123, 297, 44);
		panel.add(lblDiagnsticosYObservaciones);
		
		JTextArea txtDiagnostico = new JTextArea();
		txtDiagnostico.setBounds(20, 166, 331, 296);
		panel.add(txtDiagnostico);
		
		JLabel iblInformacion = new JLabel("Ingrese la idenficicacion del paciente para ver el expediente");
		iblInformacion.setForeground(Color.WHITE);
		iblInformacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		iblInformacion.setBounds(10, 10, 365, 44);
		panel.add(iblInformacion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(11, 10, 495, 320);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPacientes = new JLabel("Pacientes ");
		lblPacientes.setBounds(10, 11, 135, 14);
		panel_1.add(lblPacientes);
		lblPacientes.setForeground(new Color(0, 102, 153));
		lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 36, 486, 273);
		panel_1.add(scrollPane_1);
		
		modeloPacientes = new DefaultTableModel();
		tablePacientes = new JTable(modeloPacientes);
		scrollPane_1.setViewportView(tablePacientes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(11, 354, 495, 297);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 25, 486, 251);
		panel_2.add(scrollPane);
		
		modeloExpediente = new DefaultTableModel();
		tableExpediente = new JTable(modeloExpediente);
		scrollPane.setViewportView(tableExpediente);
		
		JLabel lblExpediente = new JLabel("Expediente");
		lblExpediente.setBounds(10, 10, 135, 14);
		panel_2.add(lblExpediente);
		lblExpediente.setForeground(new Color(0, 102, 153));
		lblExpediente.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		modeloMedicos = new DefaultTableModel();

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
