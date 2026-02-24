package controllers;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Archivo;
import view.VentanaReportes;

/**
 * Controlador para generación y visualización de reportes.
 * Permite consultar listas ordenadas de pacientes, médicos,
 * citas por médico, por mes, historial por paciente, citas atendidas/canceladas.
 *
 * @author Luis
 * @author Ariel
 * @version 1.0
 */
public class ControllerReportes {

    private VentanaReportes vr;
    private ControllerPrincipal controllerPrincipal;
    public DefaultTableModel modelReportes;
    private Archivo archivoCitas;
    private Archivo archivoMedicos;
    private Archivo archivoPacientes;
    private final char DELIMITER = ',';

    /**
     * Constructor.
     * Inicializa ventana, archivos y carga combo de meses.
     *
     * @param controllerPrincipal referencia al controlador principal
     */
    public ControllerReportes(ControllerPrincipal controllerPrincipal) {
        this.vr = new VentanaReportes();
        this.controllerPrincipal = controllerPrincipal;
        this.archivoCitas = new Archivo("citas.txt", DELIMITER);
        this.archivoMedicos = new Archivo("medicos.txt", DELIMITER);
        this.archivoPacientes = new Archivo("pacientes.txt", DELIMITER);

        funtions();
        loadCbxMeses();
    }

    /**
     * Muestra la ventana de reportes.
     */
    public void start() {
        vr.init();
    }

    /**
     * Asigna listeners a todos los botones de reportes.
     */
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
        vr.btnCanceladas.addActionListener(e -> {
            initTableCitas();
            loadCancelDates();
        });
        vr.btnAtendidas.addActionListener(e -> {
            initTableCitas();
            loadAtendDates();
        });
    }

    /**
     * Inicializa tabla para lista de pacientes.
     */
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

    /**
     * Inicializa tabla para mostrar citas.
     */
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

    /**
     * Inicializa tabla para lista de médicos.
     */
    private void initTableMedico() {
        modelReportes = new DefaultTableModel();
        modelReportes.addColumn("Codigo");
        modelReportes.addColumn("Nombre");
        modelReportes.addColumn("Edad");
        modelReportes.addColumn("Sexo");
        modelReportes.addColumn("Especialidad");
        vr.tableReportes.setModel(modelReportes);
    }

    /**
     * Carga citas de un médico por nombre ingresado.
     */
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
                if (values[1].equals(nombre)) {
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

    /**
     * Carga citas del mes seleccionado en el combo.
     */
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
                if (values[9].equals(mes)) {
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

    /**
     * Carga citas con estado CANCELADA.
     */
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
                if (values[11].equalsIgnoreCase("CANCELADA")) {
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

    /**
     * Carga citas con estado ATENDIDA.
     */
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
                if (values[11].equalsIgnoreCase("ATENDIDA")) {
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

    /**
     * Carga y ordena alfabéticamente por nombre todos los pacientes.
     */
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
            // Bubble sort por nombre (columna 1)
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
            for (String[] paciente : pacientes) {
                modelReportes.addRow(paciente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga historial de citas de un paciente por identificación.
     */
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

    /**
     * Carga y ordena médicos por especialidad (alfabéticamente).
     */
    private void loadTableMedicosOrdenados() {
        try {
            modelReportes.setRowCount(0);
            String data = archivoMedicos.getData();
            if (data == null || data.isEmpty())
                return;
            String[] lines = data.split("\\r?\\n");
            String[][] medicos = new String[lines.length][];
            for (int i = 0; i < lines.length; i++) {
                medicos[i] = lines[i].split(String.valueOf(DELIMITER));
            }
            // Bubble sort por especialidad (columna 4)
            for (int i = 0; i < medicos.length - 1; i++) {
                for (int j = 0; j < medicos.length - 1 - i; j++) {
                    String espActual = medicos[j][4].trim();
                    String espSiguiente = medicos[j + 1][4].trim();
                    if (espActual.compareToIgnoreCase(espSiguiente) > 0) {
                        String[] temp = medicos[j];
                        medicos[j] = medicos[j + 1];
                        medicos[j + 1] = temp;
                    }
                }
            }
            for (String[] medico : medicos) {
                modelReportes.addRow(medico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los meses en el combo box.
     */
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