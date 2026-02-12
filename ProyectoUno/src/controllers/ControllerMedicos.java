package controllers;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Archivo;
import models.Medico;
import view.VentanaMedicos;

public class ControllerMedicos {

	private VentanaMedicos vm;
	private ControllerPrincipal controllerPrincipal;
	private Archivo archivo;
	private DefaultTableModel model;
	private final char DELIMITER = ',';

	public ControllerMedicos(ControllerPrincipal controllerPrincipal) {
		this.controllerPrincipal = controllerPrincipal;
		this.vm = new VentanaMedicos();
		this.archivo = new Archivo("medicos.txt", DELIMITER);
		
		funciones();
		initTable();
		loadTable();
	}

	public void start() {
		vm.init();
	}

	private void initTable() {
		model = new DefaultTableModel();
		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Edad");
		model.addColumn("Sexo");
		model.addColumn("Especialidad");

		vm.table.setModel(model);
	}

	private void funciones() {

		vm.btnAgregar.addActionListener(e -> create());

		vm.btnLimpiar.addActionListener(e -> clear());

		vm.btnModificar.addActionListener(e -> edit());

		vm.btnVolver.addActionListener(e -> {
			vm.close();
			controllerPrincipal.mostrarVentana();
		});
		vm.btnEliminar.addActionListener(e -> delete());

		vm.btnConsultar.addActionListener(e -> search());
	}

	private void create() {

		try {

			String nombre = vm.txtNombre.getText();
			String edadTxt = vm.txtEdad.getText();
			String sexoTxt = vm.rdbtnMasculino.isSelected() ? "Masculino" : "Femenino";
			String codigo = vm.txtCodigo.getText();
			String especialidad = vm.txtEspecialidad.getText();

			if (!nombre.isEmpty() && !edadTxt.isEmpty() && !sexoTxt.isEmpty() && !codigo.isEmpty()
					&& !especialidad.isEmpty()) {
				
				if (archivo.dontRepeat(codigo)) {
					JOptionPane.showMessageDialog(null, "El medico con ese codigo ya existe");
					return;
				}
				int edad = Integer.parseInt(edadTxt);
				char sexo = sexoTxt.charAt(0);

				Medico m = new Medico(codigo, nombre, edad, sexo, especialidad, DELIMITER);

				archivo.add(m.toString());
				clear();
				loadTable();
				

			} else {
				JOptionPane.showMessageDialog(null, "Debes rellenar todos los espacios");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al agregar al Medico");
		}

	}
	private void delete() {
		try {

			int row = vm.table.getSelectedRow();

			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione un medico");
				return;
			}

			String codigo = model.getValueAt(row, 0).toString();

			archivo.delete(codigo);

			JOptionPane.showMessageDialog(null, "Medico eliminado");

			loadTable();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar al medico " + e);
		}
	}
	private void search() {
		try {

			String codigo = vm.txtBuscar.getText();

			String line = archivo.getById(codigo);

			if (line == null) {
				JOptionPane.showMessageDialog(null, "No encontrado");
				return;
			}

			model.setRowCount(0);
			model.addRow(line.split(String.valueOf(DELIMITER)));

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar al medico " + e);
		}
	}
	private void edit() {
		try {

			
			String codigo = vm.txtCodigo.getText();		
			String nombre = vm.txtNombre.getText();
			int edad = Integer.parseInt(vm.txtEdad.getText());
			char genero = vm.rdbtnMasculino.isSelected() ? "Masculino".charAt(0) : "Femenino".charAt(0);
			String especialidad = vm.txtEspecialidad.getText();
			
			Medico m = new Medico(codigo, nombre, edad, genero, especialidad, DELIMITER);

			archivo.update(codigo, m.toString());

			JOptionPane.showMessageDialog(null, "Medico actualizado");

			loadTable();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al editar al Medico " + e);
		}
	}
	private void clear() {
		vm.txtNombre.setText("");
		vm.txtEdad.setText("");
		vm.rdbtnMasculino.setSelected(false);
		vm.rdbtnFemenino.setSelected(false);
		vm.txtCodigo.setText("");
		vm.txtEspecialidad.setText("");

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
