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

public class VentanaReportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public DefaultTableModel modelReportes;
	public JTable tableReportes;
	public JButton btnPaciente;
	public JButton btnHistoral;
	public JButton btnEspecialidad;
	public JButton btnAtendidas;
	public JButton btnFecha;
	public JButton btnMedico;
	public JButton btnVolver;
	public JTextField txtIdentificacion;
	public JButton btnCanceladas;

	public VentanaReportes() {
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(0, 0, 923, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnPaciente = new JButton("Paciente");
		btnPaciente.setForeground(new Color(0, 102, 153));
		btnPaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPaciente.setBorder(null);
		btnPaciente.setBackground(Color.WHITE);
		btnPaciente.setBounds(10, 75, 101, 24);
		panel.add(btnPaciente);
		
		JLabel iblGreportes = new JLabel("Generación de reportes");
		iblGreportes.setForeground(Color.WHITE);
		iblGreportes.setFont(new Font("Tahoma", Font.BOLD, 13));
		iblGreportes.setBounds(10, 0, 365, 33);
		panel.add(iblGreportes);
		
		JLabel iblPaciente = new JLabel("Reporte de pacintes");
		iblPaciente.setForeground(Color.WHITE);
		iblPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		iblPaciente.setBounds(10, 30, 225, 44);
		panel.add(iblPaciente);
		
		JLabel iblMedicos = new JLabel("Reporte de medicos por especialidad");
		iblMedicos.setForeground(Color.WHITE);
		iblMedicos.setFont(new Font("Tahoma", Font.BOLD, 11));
		iblMedicos.setBounds(245, 30, 225, 44);
		panel.add(iblMedicos);
		
		JLabel lblCitas = new JLabel("Citas programadas por fecha o por médico");
		lblCitas.setForeground(Color.WHITE);
		lblCitas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCitas.setBounds(560, 30, 251, 44);
		panel.add(lblCitas);
		
		JLabel lblHistorial = new JLabel("Historial clínico de un paciente");
		lblHistorial.setForeground(Color.WHITE);
		lblHistorial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHistorial.setBounds(10, 104, 180, 44);
		panel.add(lblHistorial);
		
		JLabel lblReporteDeCitas = new JLabel("Reporte de citas atendidas y canceladas");
		lblReporteDeCitas.setForeground(Color.WHITE);
		lblReporteDeCitas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReporteDeCitas.setBounds(245, 104, 273, 44);
		panel.add(lblReporteDeCitas);
		
		btnEspecialidad = new JButton("Especialidad");
		btnEspecialidad.setForeground(new Color(0, 102, 153));
		btnEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEspecialidad.setBorder(null);
		btnEspecialidad.setBackground(Color.WHITE);
		btnEspecialidad.setBounds(255, 75, 101, 24);
		panel.add(btnEspecialidad);
		
		btnFecha = new JButton("Fecha");
		btnFecha.setForeground(new Color(0, 102, 153));
		btnFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFecha.setBorder(null);
		btnFecha.setBackground(Color.WHITE);
		btnFecha.setBounds(560, 75, 88, 24);
		panel.add(btnFecha);
		
		btnMedico = new JButton("Medico");
		btnMedico.setForeground(new Color(0, 102, 153));
		btnMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMedico.setBorder(null);
		btnMedico.setBackground(Color.WHITE);
		btnMedico.setBounds(711, 75, 88, 24);
		panel.add(btnMedico);
		
		btnHistoral = new JButton("Historal");
		btnHistoral.setForeground(new Color(0, 102, 153));
		btnHistoral.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHistoral.setBorder(null);
		btnHistoral.setBackground(Color.WHITE);
		btnHistoral.setBounds(10, 164, 77, 24);
		panel.add(btnHistoral);
		
		btnAtendidas = new JButton("Atendidas");
		btnAtendidas.setForeground(new Color(0, 102, 153));
		btnAtendidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAtendidas.setBorder(null);
		btnAtendidas.setBackground(Color.WHITE);
		btnAtendidas.setBounds(245, 159, 88, 24);
		panel.add(btnAtendidas);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(97, 167, 110, 20);
		panel.add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		btnCanceladas = new JButton("Canceladas");
		btnCanceladas.setForeground(new Color(0, 102, 153));
		btnCanceladas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCanceladas.setBorder(null);
		btnCanceladas.setBackground(Color.WHITE);
		btnCanceladas.setBounds(382, 159, 88, 24);
		panel.add(btnCanceladas);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 242, 893, 386);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		modelReportes = new DefaultTableModel();
		
		JLabel lblReporte = new JLabel("Reportes");
		lblReporte.setBounds(10, 10, 135, 14);
		panel_2.add(lblReporte);
		lblReporte.setForeground(new Color(0, 102, 153));
		lblReporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 272, 873, 356);
		contentPane.add(scrollPane);
		tableReportes = new JTable(modelReportes);
		scrollPane.setViewportView(tableReportes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 102, 152));
		panel_1.setBounds(0, 626, 893, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 153));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(773, 10, 110, 29);
		panel_1.add(btnVolver);

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
