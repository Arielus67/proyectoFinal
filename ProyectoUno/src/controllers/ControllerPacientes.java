package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Archivo;
import models.Enfermedad;
import models.Paciente;
import view.VentanaPacientes;

/**
 * Controlador para la gestión de pacientes.
 * Permite crear, modificar, eliminar, consultar y visualizar
 * información de pacientes almacenada en archivo de texto.
 *
 * @author Luis
 * @author Ariel
 * @version 1.0
 */
public class ControllerPacientes {

    private VentanaPacientes vp;
    private ControllerPrincipal controllerPrincipal;
    private Archivo archivo;
    private DefaultTableModel model;
    private final char DELIMITER = ',';

    /**
     * Constructor del controlador de pacientes.
     * Inicializa ventana, archivo de datos, tabla y listeners.
     *
     * @param controllerPrincipal referencia al controlador principal
     */
    public ControllerPacientes(ControllerPrincipal controllerPrincipal) {
        this.controllerPrincipal = controllerPrincipal;
        this.vp = new VentanaPacientes();
        this.archivo = new Archivo("pacientes.txt", DELIMITER);

        funciones();
        initTable();
        loadTable();
    }

    /**
     * Muestra la ventana de gestión de pacientes.
     */
    public void start() {
        vp.init();
    }

    /**
     * Define la estructura de columnas de la tabla de pacientes.
     */
    private void initTable() {
        model = new DefaultTableModel();
        model.addColumn("identificaion");
        model.addColumn("Nombre");
        model.addColumn("Edad");
        model.addColumn("Genero");
        model.addColumn("Contacto");
        model.addColumn("Enfermedad");
        model.addColumn("Gravedad");
        model.addColumn("Activo");

        vp.table.setModel(model);
    }

    /**
     * Asigna listeners a botones y tabla:
     * guardar, limpiar, modificar, volver, eliminar, consultar y selección de fila.
     */
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

        vp.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDatosSeleccionados();
            }
        });
    }

    /**
     * Crea y guarda un nuevo paciente en el archivo.
     * Valida campos obligatorios y unicidad de identificación.
     */
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

                if (archivo.dontRepeat(identificacion)) {
                    JOptionPane.showMessageDialog(null, "El paciente con esa identificacion ya existe");
                    return;
                }

                int edad = Integer.parseInt(edadTxt);
                char sexo = genero.charAt(0);

                Enfermedad en = new Enfermedad(enfermedad, gravedad, DELIMITER);
                Paciente p = new Paciente(identificacion, nombre, edad, sexo, contacto, en, false, DELIMITER);

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

    /**
     * Elimina el paciente seleccionado en la tabla.
     */
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

    /**
     * Busca un paciente por identificación y muestra solo esa fila en la tabla.
     */
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

    /**
     * Carga los datos del paciente seleccionado en los campos del formulario.
     */
    private void cargarDatosSeleccionados() {
        int fila = vp.table.getSelectedRow();
        if (fila == -1) {
            return;
        }
        vp.txtIdentificacion.setText(vp.table.getValueAt(fila, 0).toString());
        vp.txtNombre.setText(vp.table.getValueAt(fila, 1).toString());
        vp.txtEdad.setText(vp.table.getValueAt(fila, 2).toString());
        vp.txtContacto.setText(vp.table.getValueAt(fila, 4).toString());

        String genero = vp.table.getValueAt(fila, 3).toString();
        if (genero.equals("M")) {
            vp.rdbtnMasculino.setSelected(true);
        } else {
            vp.rdbtnFemenino.setSelected(true);
        }

        vp.txtAreaEnfermedad.setText(vp.table.getValueAt(fila, 5).toString());
        vp.comboBox.setSelectedItem(Integer.parseInt(vp.table.getValueAt(fila, 6).toString()));
    }

    /**
     * Actualiza los datos del paciente seleccionado con la información del formulario.
     */
    private void edit() {
        try {
            int fila = vp.table.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un paciente de la tabla");
                return;
            }

            String identificacion = vp.txtIdentificacion.getText();
            String nombre = vp.txtNombre.getText();
            int edad = Integer.parseInt(vp.txtEdad.getText());
            String contacto = vp.txtContacto.getText();
            char genero = vp.rdbtnMasculino.isSelected() ? 'M' : 'F';
            String enfermedad = vp.txtAreaEnfermedad.getText();
            int gravedad = Integer.parseInt(vp.comboBox.getSelectedItem().toString());

            Enfermedad en = new Enfermedad(enfermedad, gravedad, DELIMITER);
            Paciente paciente = new Paciente(identificacion, nombre, edad, genero, contacto, en, false, DELIMITER);

            archivo.update(identificacion, paciente.toString());

            JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente");
            loadTable();
            clear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar: " + e.getMessage());
        }
    }

    /**
     * Limpia todos los campos del formulario y restablece selecciones.
     */
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

    /**
     * Carga todos los pacientes del archivo en la tabla.
     */
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