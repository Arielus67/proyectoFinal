package controllers;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.Archivo;
import view.VentanaCitas;
import view.VentanaExpediente;

public class ControllerExpedientes {

	private VentanaExpediente ve;
	private ControllerPrincipal controllerPrincipal;
	private Archivo archivoCitas;
	private Archivo archivoPacientes;
	private DefaultTableModel modelPacientes;
	private DefaultTableModel modelExpediente;
	private final char DELIMITER = ',';

	public ControllerExpedientes(ControllerPrincipal controllerPrincipal) {

		this.ve = new VentanaExpediente();
		this.controllerPrincipal = controllerPrincipal;
		this.archivoCitas = new Archivo("citas.txt", DELIMITER);
		this.archivoPacientes = new Archivo("pacientes.txt", DELIMITER);

		funtions();
		initTablePacientes();
		loadTablePacientes();
		
		initTableExpediente();
		loadTableExpediente();
	}

	public void start() {
		ve.init();
	}

	public void funtions() {

		ve.btnConsultar.addActionListener(e-> loadTableExpediente());
		
		ve.btnVolver.addActionListener(e -> {
			ve.close();
			controllerPrincipal.mostrarVentana();
		});
	}

	private void initTableExpediente() {
		modelExpediente = new DefaultTableModel();
		modelExpediente.addColumn("Id");
		modelExpediente.addColumn("Codigo");
		modelExpediente.addColumn("Medico");
		modelExpediente.addColumn("Especialidad");
		modelExpediente.addColumn("Identificacion");
		modelExpediente.addColumn("Nombre");
		modelExpediente.addColumn("Enfermedad");
		modelExpediente.addColumn("Activo");
		modelExpediente.addColumn("Estado");
		
		ve.tableExpediente.setModel(modelExpediente);
		
	}
	
	private void loadTableExpediente() {
	    try {

	        modelExpediente.setRowCount(0);

	        String identificacionBuscada = ve.txtConsultar.getText().trim();

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
	                    modelExpediente.addRow(values);
	                }
	            }
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
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

		ve.tablePacientes.setModel(modelPacientes);
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
