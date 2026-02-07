package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class VentanaMedicos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConsultar;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtSexo;
	private JTextField txtEdad;
	private JTextArea textArea;
	private JButton btnEliminar;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMedicos frame = new VentanaMedicos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
		btnConsultar.setBounds(25, 25, 158, 44);
		panel.add(btnConsultar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(new Color(0, 102, 153));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setBounds(25, 109, 158, 44);
		panel.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(0, 102, 153));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBorder(null);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(25, 195, 158, 44);
		panel.add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(0, 102, 153));
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVolver.setBorder(null);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(25, 279, 158, 44);
		panel.add(btnVolver);
		
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
		txtCodigo.setBounds(66, 81, 408, 20);
		panel_1.add(txtCodigo);
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(66, 121, 92, 20);
		panel_1.add(txtSexo);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(348, 36, 126, 20);
		panel_1.add(txtEdad);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(235, 201, 504, 297);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea.setBounds(10, 32, 484, 254);
		panel_1_1.add(textArea);
		
		JLabel lblAquiApareceraLa = new JLabel("Aqui aparecera la informacion del medico");
		lblAquiApareceraLa.setForeground(new Color(0, 102, 153));
		lblAquiApareceraLa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAquiApareceraLa.setBounds(10, 0, 286, 28);
		panel_1_1.add(lblAquiApareceraLa);

	}
}
