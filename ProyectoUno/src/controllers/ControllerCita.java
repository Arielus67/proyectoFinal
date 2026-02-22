package controllers;

import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Archivo;
import models.Cita;
import models.Enfermedad;
import models.EstadoCita;
import models.Medico;
import models.Paciente;
import view.VentanaCitas;

public class ControllerCita {

	private VentanaCitas vc;
	private ControllerPrincipal controllerPrincipal;
	private Archivo archivoCitas;
	private Archivo archivoMedicos;
	private Archivo archivoPacientes;
	private DefaultTableModel modelCitas;
	private DefaultTableModel modelMedicos;
	private DefaultTableModel modelPacientes;
	private final char DELIMITER = ',';

	public ControllerCita(ControllerPrincipal controllerPrincipal) {

		this.vc = new VentanaCitas();
		this.controllerPrincipal = controllerPrincipal;
		this.archivoCitas = new Archivo("citas.txt", DELIMITER);
		this.archivoMedicos = new Archivo("medicos.txt", DELIMITER);
		this.archivoPacientes = new Archivo("pacientes.txt", DELIMITER);

		funtions();
		initTableCitas();
		initTableMedico();
		initTablePacientes();
		loadTableCitas();
		updateAvailableDoctors();
		loadTablePacientes();
		loadCbxCitas();

	}

	public void start() {
		vc.init();
	}

	public void funtions() {

		vc.btnCrearCita.addActionListener(e -> create());

		vc.btnEliminar.addActionListener(e -> delete());

		vc.btnBuscar.addActionListener(e -> consultar());

		vc.btnModificar.addActionListener(e -> modificar());

		vc.btnVolver.addActionListener(e -> {
			vc.close();
			controllerPrincipal.mostrarVentana();
		});
	}

	private void create() {
		try {

			int getMedico = vc.tableMedicos.getSelectedRow();
			int getPaciente = vc.tablePacientes.getSelectedRow();

			if (getMedico == -1 || getPaciente == -1) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un médico y un paciente");
				return;
			}

			String codigoMedico = modelMedicos.getValueAt(getMedico, 0).toString();
			String nombreMedico = modelMedicos.getValueAt(getMedico, 1).toString();
			int edadMedico = Integer.parseInt(modelMedicos.getValueAt(getMedico, 2).toString());
			char sexoMedico = modelMedicos.getValueAt(getMedico, 3).toString().charAt(0);
			String especialidad = modelMedicos.getValueAt(getMedico, 4).toString();

			String identificacion = modelPacientes.getValueAt(getPaciente, 0).toString();
			String nombrePaciente = modelPacientes.getValueAt(getPaciente, 1).toString();
			int edadPaciente = Integer.parseInt(modelPacientes.getValueAt(getPaciente, 2).toString());
			char sexoPaciente = modelPacientes.getValueAt(getPaciente, 3).toString().charAt(0);
			String telefonoPaciente = modelPacientes.getValueAt(getPaciente, 4).toString();
			String enfermedad = modelPacientes.getValueAt(getPaciente, 5).toString();
			int gravedad = Integer.parseInt(modelPacientes.getValueAt(getPaciente, 6).toString());

			String estadoTexto = vc.cbxEstado.getSelectedItem().toString();
			EstadoCita estado = EstadoCita.valueOf(estadoTexto.toUpperCase());
			
			int horas = Integer.parseInt(vc.cbxHorasDisponibles.getSelectedItem().toString());

			
			
			if(archivoCitas.dontRepeatCita(codigoMedico, horas)) {
				JOptionPane.showMessageDialog(null, "Ya este medico tiene esa hora asignada");
				return;
			}
			
			Enfermedad en = new Enfermedad(enfermedad, gravedad, DELIMITER);

			Paciente p = new Paciente(identificacion, nombrePaciente, edadPaciente, sexoPaciente, telefonoPaciente, en,
					true, DELIMITER);
			Medico m = new Medico(codigoMedico, nombreMedico, edadMedico, sexoMedico, especialidad, DELIMITER);
			

			Cita cita = new Cita(p, m, estado, DELIMITER);
			cita.setHora(horas);
			
			archivoCitas.add(cita.toString());

			JOptionPane.showMessageDialog(null, "Cita creada correctamente");

			loadTableCitas();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al crear la cita: " + e);
		}
	}

	private void delete() {
		try {

			int row = vc.tableCitas.getSelectedRow();

			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione una cita ");
				return;
			}

			String codigo = modelCitas.getValueAt(row, 0).toString();

			archivoCitas.delete(codigo);

			JOptionPane.showMessageDialog(null, "Cita eliminado");

			loadTableCitas();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al eliminar la cita " + e);
		}
	}

	private void consultar() {
		try {

			String idBuscar = vc.txtBuscar.getText();

			if (idBuscar == null || idBuscar.isEmpty()) {
				loadTableCitas();
				return;
			}

			String data = archivoCitas.getData();

			if (data == null || data.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay citas registradas");
				return;
			}

			String[] lines = data.split("\n");

			boolean encontrado = false;

			modelCitas.setRowCount(0);

			for (String line : lines) {

				String[] values = line.split(String.valueOf(DELIMITER));

				if (values[0].equals(idBuscar)) {

					modelCitas.addRow(values);
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				JOptionPane.showMessageDialog(null, "Cita no encontrada");
				loadTableCitas();
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar la cita: " + e);
		}
	}

	private void modificar() {
		try {

			int rowCita = vc.tableCitas.getSelectedRow();
			int rowMedico = vc.tableMedicos.getSelectedRow();
			int rowPaciente = vc.tablePacientes.getSelectedRow();

			if (rowCita == -1 || rowMedico == -1 || rowPaciente == -1) {
				JOptionPane.showMessageDialog(null, "Seleccione una cita, un médico y un paciente");
				return;
			}

			String id = modelCitas.getValueAt(rowCita, 0).toString();

			String codigoMedico = modelMedicos.getValueAt(rowMedico, 0).toString();
			String nombreMedico = modelMedicos.getValueAt(rowMedico, 1).toString();
			int edadMedico = Integer.parseInt(modelMedicos.getValueAt(rowMedico, 2).toString());
			char sexoMedico = modelMedicos.getValueAt(rowMedico, 3).toString().charAt(0);
			String especialidad = modelMedicos.getValueAt(rowMedico, 4).toString();
			
			String identificacion = modelPacientes.getValueAt(rowPaciente, 0).toString();
			String nombrePaciente = modelPacientes.getValueAt(rowPaciente, 1).toString();
			int edadPaciente = Integer.parseInt(modelPacientes.getValueAt(rowPaciente, 2).toString());
			char sexoPaciente = modelPacientes.getValueAt(rowPaciente, 3).toString().charAt(0);
			String telefonoPaciente = modelPacientes.getValueAt(rowPaciente, 4).toString();
			String enfermedad = modelPacientes.getValueAt(rowPaciente, 5).toString();
			int gravedad = Integer.parseInt(modelPacientes.getValueAt(rowPaciente, 6).toString());

			String estadoTexto = vc.cbxEstado.getSelectedItem().toString();
			EstadoCita estado = EstadoCita.valueOf(estadoTexto.toUpperCase());
			
			int horas = Integer.parseInt(vc.cbxHorasDisponibles.getSelectedItem().toString());

			
			
			if(archivoCitas.dontRepeatCita(codigoMedico, horas)) {
				JOptionPane.showMessageDialog(null, "Ya este medico tiene esa hora asignada");
				return;
			}
			
			Enfermedad en = new Enfermedad(enfermedad, gravedad, DELIMITER);
			Paciente p = new Paciente(identificacion, nombrePaciente, edadPaciente, sexoPaciente, telefonoPaciente, en,
					true, DELIMITER);

			Medico m = new Medico(codigoMedico, nombreMedico, edadMedico, sexoMedico, especialidad, DELIMITER);

			Cita nuevaCita = new Cita(p, m, estado, DELIMITER);
			nuevaCita.setHora(horas);
			
			archivoCitas.update(id, nuevaCita.toString());

			JOptionPane.showMessageDialog(null, "Cita modificada correctamente");

			loadTableCitas();

			vc.tableCitas.clearSelection();
			vc.tableMedicos.clearSelection();
			vc.tablePacientes.clearSelection();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al modificar la cita: " + e);
		}
	}

	private void initTableCitas() {
		modelCitas = new DefaultTableModel();
		modelCitas.addColumn("Id");
		modelCitas.addColumn("Codigo");
		modelCitas.addColumn("Medico");
		modelCitas.addColumn("Especialidad");
		modelCitas.addColumn("Identificacion");
		modelCitas.addColumn("Nombre");
		modelCitas.addColumn("Enfermedad");
		modelCitas.addColumn("Hora");
		modelCitas.addColumn("Activo");
		modelCitas.addColumn("Estado");

		vc.tableCitas.setModel(modelCitas);

	}

	private void initTableMedico() {
		modelMedicos = new DefaultTableModel();
		modelMedicos.addColumn("Codigo");
		modelMedicos.addColumn("Nombre");
		modelMedicos.addColumn("Edad");
		modelMedicos.addColumn("Sexo");
		modelMedicos.addColumn("Especialidad");
		modelMedicos.addColumn("Dias");
		modelMedicos.addColumn("Desde");
		modelMedicos.addColumn("Hasta");

		vc.tableMedicos.setModel(modelMedicos);
	}

	private void initTablePacientes() {
		modelPacientes = new DefaultTableModel();
		modelPacientes.addColumn("identificaion");
		modelPacientes.addColumn("Nombre");
		modelPacientes.addColumn("Edad");
		modelPacientes.addColumn("Genero");
		modelPacientes.addColumn("Contacto");
		modelPacientes.addColumn("Enfermedad");
		modelPacientes.addColumn("Gravedad");

		vc.tablePacientes.setModel(modelPacientes);
	}

	private void loadTableCitas() {
		try {

			modelCitas.setRowCount(0);

			String data = archivoCitas.getData();
			if (data == null || data.isEmpty())
				return;

			String[] lines = data.split("\n");

			for (String line : lines) {
				String[] values = line.split(String.valueOf(DELIMITER));
				modelCitas.addRow(values);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadTableMedicos() {
		try {

			modelMedicos.setRowCount(0);

			String data = archivoMedicos.getData();
			if (data == null || data.isEmpty())
				return;

			String[] lines = data.split("\n");

			for (String line : lines) {
				String[] values = line.split(String.valueOf(DELIMITER));
				modelMedicos.addRow(values);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadTablePacientes() {
		try {

			modelPacientes.setRowCount(0);

			String data = archivoPacientes.getData();
			if (data == null || data.isEmpty())
				return;

			String[] lines = data.split("\n");

			for (String line : lines) {
				String[] values = line.split(String.valueOf(DELIMITER));
				modelPacientes.addRow(values);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateAvailableDoctors() {
		try {

			int horas = 1;
			modelMedicos.setRowCount(0);

			String dataMedicos = archivoMedicos.getData();
			String dataCitas = archivoCitas.getData();
			boolean mostrar = false;

			if (dataMedicos == null || dataMedicos.isEmpty())
				return;

			String[] linesMedicos = dataMedicos.split("\n");

			if (!(vc.cbxHorasDisponibles.getSelectedItem() == null)) {
				horas = Integer.parseInt(vc.cbxHorasDisponibles.getSelectedItem().toString());
				
			}
			for (String line : linesMedicos) {
				String[] values = line.split(String.valueOf(DELIMITER));
				String idDoctor = values[0];
				if (dataCitas == null || dataCitas.isEmpty()) {
					if ((horas >= Integer.parseInt(values[6]) && horas <= Integer.parseInt(values[7]))) {

						modelMedicos.addRow(values);
					} else if (Integer.parseInt(values[6]) > Integer.parseInt(values[7])) {
						if (horas >= Integer.parseInt(values[6])
								|| (horas >= Integer.parseInt(values[6]) && horas >= 24) || horas == 1) {
							modelMedicos.addRow(values);
						}
					}

				} else {
					String[] linesCitas = dataCitas.split("\n");
					for (String citas : linesCitas) {
						String[] valuesCitas = citas.split(String.valueOf(DELIMITER));

						if ((horas >= Integer.parseInt(values[6]) && horas <= Integer.parseInt(values[7]))) {
							if (!idDoctor.equals(valuesCitas[2])) {
								mostrar = true;
								break;
							}

						} else if (Integer.parseInt(values[6]) > Integer.parseInt(values[7])) {
							if (horas >= Integer.parseInt(values[6])
									|| (horas >= Integer.parseInt(values[6]) && horas >= 24) || horas == 1) {
								if (!idDoctor.equals(valuesCitas[2])) {
									mostrar = true;
									break;
								}
							}
						}

					}
					if (mostrar) {
						modelMedicos.addRow(values);
					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadCbxCitas() {
		for (int i = 1; i < 25; i++) {
			vc.cbxHorasDisponibles.addItem(i + "");
		}
		vc.cbxHorasDisponibles.addActionListener(e -> {
			updateAvailableDoctors();
		});
	}

}
