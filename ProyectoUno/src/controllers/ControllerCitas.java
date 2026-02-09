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


    public ControllerCitas(ControllerPrincipal controllerPrincipal) {
        this.controllerPrincipal = controllerPrincipal;
        this.vc = new VentanaCitas();
        this.lc = new ListaCitas();
        this.lp = new ListaPacientes();
        this.lm = new ListaMedicos();
    }


    public void start() {
        cargarPacientes();
        cargarMedicos();
        cargarCitas();
        vc.init();
        functions();
    }

    private void functions() {

        vc.btnAsignar.addActionListener(e -> crearCita());

        vc.btnVolver.addActionListener(e -> {
            vc.close();
            controllerPrincipal.mostrarVentana();
        });
    }

    private void crearCita() {

        int indexPaciente = vc.comboBoxPacientes.getSelectedIndex();
        int indexMedico = vc.comboBoxMedicos.getSelectedIndex();

        if (indexPaciente == -1 || indexMedico == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un paciente y un médico");
            return;
        }

        Paciente paciente = lp.obtenerPacientes().get(indexPaciente);
        Medico medico = lm.obtenerMedicos().get(indexMedico);

        Cita cita = new Cita(paciente, medico);
        lc.agregarCita(cita);

        JOptionPane.showMessageDialog(null, "Cita asignada correctamente");

        cargarCitas();
    }

    private void cargarPacientes() {

        vc.comboBoxPacientes.removeAllItems();

        for (Paciente p : lp.obtenerPacientes()) {
            vc.comboBoxPacientes.addItem(
                p.getIdentificacion() + " - " +
                p.getNombre() + " - " +
                p.getEnfermedad().getNombreEnfermedad()
            );
        }
    }

    private void cargarMedicos() {

        vc.comboBoxMedicos.removeAllItems();

        for (Medico m : lm.obtenerMedicos()) {
            vc.comboBoxMedicos.addItem(
                m.getCodigo() + " - " +
                m.getNombre() + " - " +
                m.getEspecialidad()
            );
        }
    }

    private void cargarCitas() {

        vc.comboBoxCitas.removeAllItems();

        for (Cita c : lc.obtenerCitas()) {
            vc.comboBoxCitas.addItem(
                c.getPaciente().getNombre() + " - " +
                c.getMedico().getNombre()
            );
        }
    }
}
