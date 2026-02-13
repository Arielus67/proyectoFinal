package controllers;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Archivo;
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
		loadTableMedicos();
		loadTablePacientes();

	}

	public void start() {
		vc.init();
	}
	public void funtions() {
		
		vc.btnCrearCita.addActionListener(e->create());
		vc.btnVolver.addActionListener(e->{
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
			String especialidad = modelMedicos.getValueAt(getMedico, 4).toString();

			String idPaciente = modelPacientes.getValueAt(getPaciente, 0).toString();
			String nombrePaciente = modelPacientes.getValueAt(getPaciente, 1).toString();
			String enfermedad = modelPacientes.getValueAt(getPaciente, 5).toString();

			if (archivoCitas.dontRepeat(codigoMedico)) {
				JOptionPane.showMessageDialog(null, "Este médico ya tiene una cita registrada");
				return;
			}
			
			String cita = codigoMedico + DELIMITER +
						  nombreMedico + DELIMITER +
						  especialidad + DELIMITER +
						  idPaciente + DELIMITER +
						  nombrePaciente + DELIMITER +
						  enfermedad;
			
			archivoCitas.add(cita);
			
			JOptionPane.showMessageDialog(null, "Cita creada correctamente");

			loadTableCitas();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al crear la cita: " + e);
		}
	}

	private void initTableCitas() {
		modelCitas = new DefaultTableModel();
		modelCitas.addColumn("Codigo");
		modelCitas.addColumn("Medico");
		modelCitas.addColumn("Especialidad");
		modelCitas.addColumn("Identificacion");
		modelCitas.addColumn("Nombre");
		modelCitas.addColumn("Enfermedad");
		
		vc.tableCitas.setModel(modelCitas);
		
	}
	private void initTableMedico() {
		modelMedicos = new DefaultTableModel();
		modelMedicos.addColumn("Codigo");
		modelMedicos.addColumn("Nombre");
		modelMedicos.addColumn("Edad");
		modelMedicos.addColumn("Sexo");
		modelMedicos.addColumn("Especialidad");

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
}
