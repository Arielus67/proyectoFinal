package controllers;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.Archivo;
import view.VentanaReportes;

public class ControllerReportes {

	private VentanaReportes vr;
	private ControllerPrincipal controllerPrincipal;
	public DefaultTableModel modelReportes;
	private Archivo archivoCitas;
	private Archivo archivoMedicos;
	private Archivo archivoPacientes;
	private final char DELIMITER = ',';

	public ControllerReportes(ControllerPrincipal controllerPrincipal) {

		this.vr = new VentanaReportes();
		this.controllerPrincipal = controllerPrincipal;
		this.archivoCitas = new Archivo("citas.txt", DELIMITER);
		this.archivoMedicos = new Archivo("medicos.txt", DELIMITER);
		this.archivoPacientes = new Archivo("pacientes.txt", DELIMITER);

		funtions();
		loadCbxMeses();
	}

	public void start() {
		vr.init();
	}

	public void funtions() {
		vr.btnPaciente.addActionListener(e -> {
			initTablePacientes();
			loadTablePacientes();
		});

		vr.btnHistorial.addActionListener(e -> {
			initTableCitas();
			loadTableHistoral();
		});

		vr.btnVolver.addActionListener(e -> {
			vr.close();
			controllerPrincipal.mostrarVentana();
		});

		vr.btnEspecialidad.addActionListener(e -> {
			initTableMedico();
			loadTableMedicosOrdenados();
		});
		vr.btnFecha.addActionListener(e -> {
			initTableCitas();
			loadPacientsForDate();
		});
		vr.btnMedico.addActionListener(e -> {
			initTableCitas();
			loadPacientsForMedics();
		});
		vr.btnCanceladas.addActionListener(e->{
			initTableCitas();
			loadCancelDates();
		});
		vr.btnAtendidas.addActionListener(e->{
			initTableCitas();
			loadAtendDates();
		});
	}

	private void initTablePacientes() {
		modelReportes = new DefaultTableModel();
		modelReportes.addColumn("identificaion");
		modelReportes.addColumn("Nombre");
		modelReportes.addColumn("Edad");
		modelReportes.addColumn("Genero");
		modelReportes.addColumn("Contacto");
		modelReportes.addColumn("Enfermedad");
		modelReportes.addColumn("Gravedad");

		vr.tableReportes.setModel(modelReportes);
	}

	private void initTableCitas() {
		modelReportes = new DefaultTableModel();
		modelReportes.addColumn("Id");
		modelReportes.addColumn("Codigo");
		modelReportes.addColumn("Medico");
		modelReportes.addColumn("Especialidad");
		modelReportes.addColumn("Identificacion");
		modelReportes.addColumn("Nombre");
		modelReportes.addColumn("Enfermedad");
		modelReportes.addColumn("Hora");
		modelReportes.addColumn("Mes");
		modelReportes.addColumn("Activo");
		modelReportes.addColumn("Estado");
		vr.tableReportes.setModel(modelReportes);

	}

	private void initTableMedico() {
		modelReportes = new DefaultTableModel();
		modelReportes.addColumn("Codigo");
		modelReportes.addColumn("Nombre");
		modelReportes.addColumn("Edad");
		modelReportes.addColumn("Sexo");
		modelReportes.addColumn("Especialidad");

		vr.tableReportes.setModel(modelReportes);
	}

	private void loadPacientsForMedics() {

		try {

			String nombre = vr.txtNombreMedico.getText();

			if (nombre == null || nombre.isEmpty()) {
				return;
			}

			String data = archivoCitas.getData();

			if (data == null || data.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay citas registradas");
				return;
			}

			String[] lines = data.split("\n");

			boolean encontrado = false;

			modelReportes.setRowCount(0);

			for (String line : lines) {

				String[] values = line.split(String.valueOf(DELIMITER));

				if (values[2].equals(nombre)) {

					modelReportes.addRow(values);
					encontrado = true;
				}
			}

			if (!encontrado) {
				JOptionPane.showMessageDialog(null, "Cita no encontrada");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la cita: " + e);
		}
	}

	private void loadPacientsForDate() {

		try {

			String mes = vr.cbxMes.getSelectedItem().toString();

			if (mes == null || mes.isEmpty()) {

				return;
			}

			String data = archivoCitas.getData();

			if (data == null || data.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay citas registradas");
				return;
			}

			String[] lines = data.split("\n");

			boolean encontrado = false;

			modelReportes.setRowCount(0);

			for (String line : lines) {

				String[] values = line.split(String.valueOf(DELIMITER));

				if (values[8].equals(mes)) {

					modelReportes.addRow(values);
					encontrado = true;
					
				}
			}

			if (!encontrado) {
				JOptionPane.showMessageDialog(null, "Cita no encontrada");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la cita: " + e);
		}
	}

	private void loadCancelDates() {

		try {

			String data = archivoCitas.getData();

			if (data == null || data.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay citas registradas");
				return;
			}

			String[] lines = data.split("\n");

			boolean encontrado = false;

			modelReportes.setRowCount(0);

			for (String line : lines) {

				String[] values = line.split(String.valueOf(DELIMITER));

				if (values[10].equalsIgnoreCase("CANCELADA")) {

					modelReportes.addRow(values);
					encontrado = true;
				}
			}

			if (!encontrado) {
				JOptionPane.showMessageDialog(null, "No hay citas canceladas");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar las citas: " + e);
		}
	}

	private void loadAtendDates() {

		try {

			String data = archivoCitas.getData();

			if (data == null || data.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay citas registradas");
				return;
			}

			String[] lines = data.split("\n");

			boolean encontrado = false;

			modelReportes.setRowCount(0);

			for (String line : lines) {

				String[] values = line.split(String.valueOf(DELIMITER));

				if (values[10].equalsIgnoreCase("ATENDIDA")) {

					modelReportes.addRow(values);
					encontrado = true;
				}
			}

			if (!encontrado) {
				JOptionPane.showMessageDialog(null, "No hay citas canceladas");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar las citas: " + e);
		}
	}


	private void loadTablePacientes() {
		try {

			modelReportes.setRowCount(0);

			String data = archivoPacientes.getData();
			if (data == null || data.isEmpty())
				return;

			String[] lines = data.split("\\r?\\n");

			String[][] pacientes = new String[lines.length][];

			for (int i = 0; i < lines.length; i++) {
				pacientes[i] = lines[i].split(String.valueOf(DELIMITER));
			}

			for (int i = 0; i < pacientes.length - 1; i++) {
				for (int j = 0; j < pacientes.length - 1 - i; j++) {

					String nombreActual = pacientes[j][1];
					String nombreSiguiente = pacientes[j + 1][1];

					if (nombreActual.compareToIgnoreCase(nombreSiguiente) > 0) {

						String[] temp = pacientes[j];
						pacientes[j] = pacientes[j + 1];
						pacientes[j + 1] = temp;
					}
				}
			}

			for (int i = 0; i < pacientes.length; i++) {
				modelReportes.addRow(pacientes[i]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadTableHistoral() {
		try {

			modelReportes.setRowCount(0);

			String identificacionBuscada = vr.txtIdentificacion.getText().trim();

			if (identificacionBuscada.isEmpty()) {
				return;
			}

			String data = archivoCitas.getData();
			if (data == null || data.isEmpty())
				return;

			String[] lines = data.split("\n");

			for (String line : lines) {

				String[] values = line.split(",");

				if (values.length > 4) {

					if (values[4].trim().equals(identificacionBuscada)) {
						modelReportes.addRow(values);
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadCitasPorMedicos() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void loadTableMedicosOrdenados() {
		try {

			modelReportes.setRowCount(0);

			String data = archivoMedicos.getData();
			if (data == null || data.isEmpty())
				return;

			String[] lines = data.split("\\r?\\n");

			// 🔥 Crear matriz
			String[][] medicos = new String[lines.length][];

			for (int i = 0; i < lines.length; i++) {
				medicos[i] = lines[i].split(String.valueOf(DELIMITER));
			}

			// 🔥 Ordenar por especialidad (posición 4)
			for (int i = 0; i < medicos.length - 1; i++) {
				for (int j = 0; j < medicos.length - 1 - i; j++) {

					String espActual = medicos[j][4].trim();
					String espSiguiente = medicos[j + 1][4].trim();

					if (espActual.compareToIgnoreCase(espSiguiente) > 0) {

						// Intercambiar filas completas
						String[] temp = medicos[j];
						medicos[j] = medicos[j + 1];
						medicos[j + 1] = temp;
					}
				}
			}

			// 🔥 Cargar en la tabla ya ordenados
			for (int i = 0; i < medicos.length; i++) {
				modelReportes.addRow(medicos[i]);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadCbxMeses() {
		vr.cbxMes.addItem("Enero");
		vr.cbxMes.addItem("Febrero");
		vr.cbxMes.addItem("Marzo");
		vr.cbxMes.addItem("Abril");
		vr.cbxMes.addItem("Mayo");
		vr.cbxMes.addItem("Junio");
		vr.cbxMes.addItem("Julio");
		vr.cbxMes.addItem("Septiembre");
		vr.cbxMes.addItem("Octubre");
		vr.cbxMes.addItem("Noviembre");
		vr.cbxMes.addItem("Diciembre");
	}
}
