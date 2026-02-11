package controllers;

import javax.swing.JOptionPane;

import models.Enfermedad;
import models.ListaPacientes;
import models.Paciente;
import view.VentanaPacientes;

public class ControllerPacientes {

	private ListaPacientes lp;
	private VentanaPacientes vp;
	private ControllerPrincipal controllerPrincipal;
	private boolean modoEdicion = false;

	public ControllerPacientes(ControllerPrincipal controllerPrincipal) {
		this.controllerPrincipal = controllerPrincipal;
		this.lp = new ListaPacientes();
		this.vp = new VentanaPacientes();
	}

	public void start() {
		vp.init();
		funciones();
		cargarTabla();
	}

	private void funciones() {

        vp.btnGuardar.addActionListener(e -> {
        	create();
        	cargarTabla();
        });

        vp.btnLimpiar.addActionListener(e -> {
        	limpiarCampos();
        	cargarTabla();
        });
        
        vp.btnModificar.addActionListener(e -> {
        	editar();
        	cargarTabla();
        });
        
        vp.btnVolver.addActionListener(e -> {
            vp.close();
            controllerPrincipal.mostrarVentana();
        });
        vp.btnEliminar.addActionListener(e->{
        	int seleccionado = vp.table.getSelectedRow();
			if (seleccionado == -1) {
				JOptionPane.showMessageDialog(null, "No has seleccionado a ninguno");
				return;
			}
			String identificacion = vp.table.getValueAt(seleccionado, 0).toString();

			lp.eliminarPaciente(identificacion);
        	cargarTabla();
        });
        
        vp.btnConsultar.addActionListener(e-> {
        	consultar();
        	cargarTabla();
        });
    }

	private void create() {
    	String nombre = vp.txtNombre.getText();
    	String edadTxt = vp.txtEdad.getText();
    	String sexoTxt = vp.txtSexo.getText();
    	String identificacion = vp.txtIdentificacion.getText();
    	String contacto = vp.txtContacto.getText();
    	String enfermedad = vp.txtAreaEnfermedad.getText();
    	int gravedad = (int) vp.comboBox.getSelectedItem();

    	if (!nombre.isEmpty() &&
    	    !edadTxt.isEmpty() &&
    	    !sexoTxt.isEmpty() &&
    	    !identificacion.isEmpty() &&
    	    !contacto.isEmpty() &&
    	    !enfermedad.isEmpty()) {

    	    int edad = Integer.parseInt(edadTxt);
    	    char sexo = sexoTxt.charAt(0);

    	    Enfermedad en = new Enfermedad(enfermedad, gravedad);
    	    Paciente p = new Paciente(nombre, edad, sexo, identificacion, contacto, en);
    	   
    	    lp.agregarPaciente(p);
    	    limpiarCampos();

    	} else {
    	    JOptionPane.showMessageDialog(null, "Debes rellenar todos los espacios");
    	}
	}
	private void editar() {
		
		String identificacion = vp.txtIdentificacion.getText();
		
		if (identificacion.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes ingresar el código");
			return;
		}
		if(!modoEdicion) {
			
			Paciente p = lp.buscarPaciente(identificacion);
			
			if(p != null) {
				
				vp.txtNombre.setText(p.getNombre());
				vp.txtEdad.setText(String.valueOf(p.getEdad()));
				vp.txtSexo.setText(String.valueOf(p.getSexo()));
				vp.txtContacto.setText(p.getContacto());
				vp.txtAreaEnfermedad.setText(p.getEnfermedad().getNombreEnfermedad());
				vp.comboBox.setSelectedIndex(p.getEnfermedad().getGravedad());
				
				modoEdicion = true;
				JOptionPane.showMessageDialog(null, "Ahora puedes modificar los datos");
			}
			else {
				JOptionPane.showMessageDialog(null, "Médico no encontrado");
			}
		} else {
			
		 	String nombre = vp.txtNombre.getText();
	    	String edadTxt = vp.txtEdad.getText();
	    	String sexoTxt = vp.txtSexo.getText();
	    	String contacto = vp.txtContacto.getText();
	    	String enfermedad = vp.txtAreaEnfermedad.getText();
	    	int gravedad = (int) vp.comboBox.getSelectedItem();
	    	
	    	if (!nombre.isEmpty() &&
	        	    !edadTxt.isEmpty() &&
	        	    !sexoTxt.isEmpty() &&
	        	    !identificacion.isEmpty() &&
	        	    !contacto.isEmpty() &&
	        	    !enfermedad.isEmpty()) {

	        	    int edad = Integer.parseInt(edadTxt);
	        	    char sexo = sexoTxt.charAt(0);

	        	    Enfermedad en = new Enfermedad(enfermedad, gravedad);
	        	    Paciente p = new Paciente(nombre, edad, sexo, identificacion, contacto, en);

	        	    lp.editarPaciente(p);
	        	    limpiarCampos();

		}else {
			JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
		}
		
    	} 
	}
	
	private void eliminar() {

		String identificacion = vp.txtIdentificacion.getText();
		
		if (!identificacion.isEmpty()) {
			lp.eliminarPaciente(identificacion);
			limpiarCampos();
			JOptionPane.showMessageDialog(null, "Se Elimino con exito");
		}else {
			JOptionPane.showMessageDialog(null, "Debes rellenar el espacio");
		}
	}
	
	private void consultar() {

		String identificacion = vp.txtIdentificacion.getText();

		if (!identificacion.isEmpty()) {

			Paciente p = lp.buscarPaciente(identificacion);

			if (p != null) {

				vp.txtNombre.setText(p.getNombre());
				vp.txtEdad.setText(String.valueOf(p.getEdad()));
				vp.txtSexo.setText(String.valueOf(p.getSexo()));
				vp.txtContacto.setText(p.getContacto());
				vp.txtAreaEnfermedad.setText(p.getEnfermedad().getNombreEnfermedad());
				vp.comboBox.setSelectedItem(p.getEnfermedad().getGravedad());

			} else {
				JOptionPane.showMessageDialog(null, "Paciente no encontrado");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Debes ingresar la identificación");
		}
	}

	public void cargarTabla() {
		vp.modelo.setDataVector(lp.getDatosPacientes(), lp.getColumnsPacinetes());
	}

	private void limpiarCampos() {
		vp.txtNombre.setText("");
		vp.txtEdad.setText("");
		vp.txtSexo.setText("");
		vp.txtIdentificacion.setText("");
		vp.txtContacto.setText("");
		vp.txtAreaEnfermedad.setText("");
	}
}
