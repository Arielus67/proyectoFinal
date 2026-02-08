package controllers;

import javax.swing.JOptionPane;

import models.Cita;
import models.ListaCitas;
import models.ListaMedicos;
import models.ListaPacientes;
import models.Medico;
import models.Paciente;
import view.VentanaCitas;

public class ControllerCitas {

    private VentanaCitas vc;
    private ListaCitas lc;
    private ListaPacientes lp;
    private ListaMedicos lm;
    private ControllerPrincipal controllerPrincipal;

    public ControllerCitas() {
        this.controllerPrincipal = controllerPrincipal;
        this.vc = new VentanaCitas();
        this.lc = new ListaCitas();
        this.lp = new ListaPacientes();
        this.lm = new ListaMedicos();
    }
	public void start() {
		loadPaciente();
		loadMedicos();
		vc.init();
		funtions();
		
	}
	public void funtions() {
		
		vc.btnAsignar.addActionListener(e->{
			crearCita();
			loadPaciente();
			loadMedicos();
			loadCitas();
			
		});

	}
	private void crearCita() {

        int indexPaciente = vc.comboBoxPacientes.getSelectedIndex();
        int indexMedico = vc.comboBoxMedicos.getSelectedIndex();

        if (indexPaciente == -1 || indexMedico == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un paciente y un médico");
            return;
        }

        Paciente paciente = lc.obtenerPacientes().get(indexPaciente);
        Medico medico = lc.obtenerMedicos().get(indexMedico);

        Cita cita = new Cita(paciente, medico);

        lc.agregarCita(cita);

        JOptionPane.showMessageDialog(null, "Cita asignada correctamente");
    }
	public void loadPaciente() {
		
		 for (Paciente p : lc.obtenerPacientes()) {
		        vc.comboBoxPacientes.addItem(p.getIdentificacion()+" - "+p.getNombre() + " - " + p.getEnfermedad().getNombreEnfermedad());
		    }
	}
	public void loadMedicos() {
		
		for(Medico m : lc.obtenerMedicos()) {
			vc.comboBoxMedicos.addItem(m.getCodigo()+"-"+m.getNombre()+"-"+m.getEspecialidad());
		}
	}
	public void loadCitas() {
		
		for(Cita c : lc.obtenerCitas()) {
			vc.comboBoxCitas.addItem(c.getPaciente()+"-"+c.getPaciente());
		}
	}
	public static void main(String[] args) {
		ControllerCitas p = new ControllerCitas();
		p.start();
	}
}
