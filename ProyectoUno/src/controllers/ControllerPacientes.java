package controllers;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Archivo;
import models.Enfermedad;
import models.Paciente;
import view.VentanaPacientes;

public class ControllerPacientes {

	private VentanaPacientes vp;
	private ControllerPrincipal controllerPrincipal;
	private Archivo archivo;
	private DefaultTableModel model;
	private final char DELIMITER = ',';

	public ControllerPacientes(ControllerPrincipal controllerPrincipal) {
		this.controllerPrincipal = controllerPrincipal;
		this.vp = new VentanaPacientes();
		this.archivo = new Archivo("pacientes.txt", DELIMITER);

		funciones();
		initTable();
		loadTable();
	}

	public void start() {
		vp.init();

	}

	private void initTable() {
		model = new DefaultTableModel();
		model.addColumn("identificaion");
		model.addColumn("Nombre");
		model.addColumn("Edad");
		model.addColumn("Genero");
		model.addColumn("Contacto");
		model.addColumn("Enfermedad");
		model.addColumn("Gravedad");

		vp.table.setModel(model);
	}

	private void funciones() {

		vp.btnGuardar.addActionListener(e -> create());

		vp.btnLimpiar.addActionListener(e -> clear());

		vp.btnModificar.addActionListener(e -> edit());

		vp.btnVolver.addActionListener(e -> {
			vp.close();
			controllerPrincipal.mostrarVentana();
		});
		vp.btnEliminar.addActionListener(e -> delete());

		vp.btnConsultar.addActionListener(e -> search());
	}

	private void create() {

		try {

			String nombre = vp.txtNombre.getText();
			String edadTxt = vp.txtEdad.getText();
			String genero = vp.rdbtnMasculino.isSelected() ? "Masculino" : "Femenino";
			String identificacion = vp.txtIdentificacion.getText();
			String contacto = vp.txtContacto.getText();
			String enfermedad = vp.txtAreaEnfermedad.getText();
			int gravedad = (int) vp.comboBox.getSelectedItem();

			if (!nombre.isEmpty() && !edadTxt.isEmpty() && !genero.isEmpty() && !identificacion.isEmpty()
					&& !contacto.isEmpty() && !enfermedad.isEmpty()) {
				
				if(archivo.dontRepeat(identificacion)) {
					JOptionPane.showMessageDialog(null, "El paciente con esa identificacion ya existe");
					return;
				}
				int edad = Integer.parseInt(edadTxt);
				char sexo = genero.charAt(0);

				Enfermedad en = new Enfermedad(enfermedad, gravedad);
				Paciente p = new Paciente(identificacion, nombre, edad, sexo, contacto, en, DELIMITER);
				archivo.add(p.toString());

				clear();
				loadTable();


			} else {
				JOptionPane.showMessageDialog(null, "Debes rellenar todos los espacios");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al agregar al Paciente");
		}

	}

	private void delete() {
		try {

			int row = vp.table.getSelectedRow();

			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione un paciente");
				return;
			}

			String identificacion = model.getValueAt(row, 0).toString();

			archivo.delete(identificacion);

			JOptionPane.showMessageDialog(null, "Paciente eliminado");

			loadTable();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar al paciente " + e);
		}
	}

	private void search() {
		try {

			String identificacion = vp.txtBuscar.getText();

			String line = archivo.getById(identificacion);

			if (line == null) {
				JOptionPane.showMessageDialog(null, "No encontrado");
				return;
			}

			model.setRowCount(0);
			model.addRow(line.split(String.valueOf(DELIMITER)));

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar al paciente " + e);
		}
	}

	private void edit() {
		try {

			
			String identificacion = vp.txtIdentificacion.getText();		
			String nombre = vp.txtNombre.getText();
			int edad = Integer.parseInt(vp.txtEdad.getText());
			String contacto = vp.txtContacto.getText();
			char genero = vp.rdbtnMasculino.isSelected() ? "Masculino".charAt(0) : "Femenino".charAt(0);
			String enfermedad = vp.txtAreaEnfermedad.getText();
			int gravedad = (int)(vp.comboBox.getSelectedItem());
			
			Enfermedad en = new Enfermedad(enfermedad, gravedad);
			Paciente paciente = new Paciente(identificacion, nombre, edad, genero, contacto, en, DELIMITER);

			archivo.update(identificacion, paciente.toString());

			JOptionPane.showMessageDialog(null, "Paciente actualizado");

			loadTable();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al editar al paciente " + e);
		}
	}

	private void clear() {
		vp.txtNombre.setText("");
		vp.txtEdad.setText("");
		vp.rdbtnMasculino.setSelected(false);
		vp.rdbtnFemenino.setSelected(false);
		vp.txtIdentificacion.setText("");
		vp.txtContacto.setText("");
		vp.txtAreaEnfermedad.setText("");
		vp.comboBox.setSelectedIndex(0);
	}

	private void loadTable() {
		try {

			model.setRowCount(0);

			String data = archivo.getData();
			if (data == null || data.isEmpty())
				return;

			String[] lines = data.split("\n");

			for (String line : lines) {
				String[] values = line.split(String.valueOf(DELIMITER));
				model.addRow(values);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
