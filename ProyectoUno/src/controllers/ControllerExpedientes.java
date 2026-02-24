package controllers;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Archivo;
import models.Diagnostico;
import view.VentanaCitas;
import view.VentanaExpediente;

/**
 * Controlador para la gestión de expedientes médicos de pacientes.
 * Muestra citas asociadas a un paciente y lista de pacientes registrados.
 *
 * @author Luis
 * @author Ariel
 */
public class ControllerExpedientes {

    private VentanaExpediente ve;
    private ControllerPrincipal controllerPrincipal;
    private Archivo archivoCitas;
    private Archivo archivoPacientes;
    private Archivo archivoDiagnostico;
    private DefaultTableModel modelPacientes;
    private DefaultTableModel modelExpediente;
    private DefaultTableModel modelDiagnostico;
    private final char DELIMITER = ',';

    /**
     * Constructor del controlador de expedientes.
     * Inicializa ventana, archivos y componentes iniciales.
     *
     * @param controllerPrincipal referencia al controlador principal
     */
    public ControllerExpedientes(ControllerPrincipal controllerPrincipal) {
        this.ve = new VentanaExpediente();
        this.controllerPrincipal = controllerPrincipal;
        this.archivoCitas = new Archivo("citas.txt", DELIMITER);
        this.archivoPacientes = new Archivo("pacientes.txt", DELIMITER);
        this.archivoDiagnostico= new Archivo("diagnostico.txt", DELIMITER);
        
        funtions();
        initTablePacientes();
        loadTablePacientes();
        initTableExpediente();
        loadTableExpediente();
    }

    /**
     * Muestra la ventana de expedientes.
     */
    public void start() {
        ve.init();
    }

    /**
     * Asigna listeners a los botones de la ventana.
     */
    public void funtions() {
        ve.btnConsultar.addActionListener(e -> {
        	initTableExpediente();
            loadTableExpediente();
        });

        ve.btnVolver.addActionListener(e -> {
            ve.close();
            controllerPrincipal.mostrarVentana();
        });
        ve.btnGuardar.addActionListener(e->createDiagnostico());
        ve.btnDiagnosticos.addActionListener(e->{
        	initTableDiagnostico();
        	loadTableDiagnostics();
        });
    }

    /**
     * Inicializa el modelo de la tabla de expedientes con sus columnas.
     */
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
    
    /**
     * Crea un nuevo diagnóstico para el paciente seleccionado.
     * 
     * Obtiene la identificación del paciente desde la tabla,
     * toma el texto ingresado en el campo de diagnóstico
     * y lo guarda en el archivo correspondiente.
     * 
     * Si no se selecciona un paciente, muestra un mensaje de advertencia.
     */
    private void createDiagnostico() {
    	
    	try {
			
    		int getPaciente = ve.tablePacientes.getSelectedRow();
    		
    		if (getPaciente == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente");
                return;
            }
    		
    		 String identificacion = modelPacientes.getValueAt(getPaciente, 0).toString();
    		 String diagnostico = ve.txtDiagnostico.getText();
    		 
    		 Diagnostico d = new Diagnostico(identificacion, diagnostico, DELIMITER);
    		 archivoDiagnostico.add(d.toString());
    		 
    		 ve.txtDiagnostico.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    /**
     * Carga en la tabla de expedientes las citas del paciente
     * cuya identificación se ingresó en el campo de consulta.
     */
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

            boolean encontrado = false;

            for (String line : lines) {

                String[] values = line.split(",");

                if (values.length > 4) {

                    if (values[4].trim().equals(identificacionBuscada)) {
                        modelExpediente.addRow(values);
                        encontrado = true; 
                    }
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, 
                    "El expediente no está disponible o no existe",
                    "Resultado de búsqueda",
                    JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicializa el modelo de la tabla de pacientes con sus columnas.
     */
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
    
    /**
     * Inicializa el modelo de la tabla de diagnósticos
     * con las columnas correspondientes.
     * 
     * Muestra la identificación del paciente
     * y el diagnóstico asociado.
     */
    private void initTableDiagnostico() {
        modelDiagnostico = new DefaultTableModel();
        modelDiagnostico.addColumn("identificaion");
        modelDiagnostico.addColumn("Diagnostico");
        
        ve.tableExpediente.setModel(modelDiagnostico);
    }

    /**
     * Carga todos los pacientes desde el archivo al modelo de la tabla.
     */
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
    
    /**
     * Carga todos los diagnósticos almacenados en el archivo
     * y los muestra en la tabla correspondiente.
     * 
     * Cada línea del archivo es separada utilizando
     * el delimitador definido.
     */
    private void loadTableDiagnostics() {
        try {
            modelDiagnostico.setRowCount(0);
            String data = archivoDiagnostico.getData();
            if (data == null || data.isEmpty())
                return;
            String[] lines = data.split("\n");
            for (String line : lines) {
                String[] values = line.split(String.valueOf(DELIMITER));
                modelDiagnostico.addRow(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}