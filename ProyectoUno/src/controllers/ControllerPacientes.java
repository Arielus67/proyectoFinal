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

	public ControllerPacientes(ControllerPrincipal controllerPrincipal) {
		this.controllerPrincipal = controllerPrincipal;
		this.lp = new ListaPacientes();
		this.vp = new VentanaPacientes();
	}

	public void start() {
		vp.init();
		funciones();
	}

	private void funciones() {

        vp.btnGuardar.addActionListener(e -> create());

        vp.btnLimpiar.addActionListener(e -> limpiarCampos());
        
        vp.btnModificar.addActionListener(e -> editar());
        
        vp.btnVolver.addActionListener(e -> {
            vp.close();
            controllerPrincipal.mostrarVentana();
        });
        vp.btnEliminar.addActionListener(e-> eliminar());
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

    	    lp.editarPaciente(p);
    	    limpiarCampos();

    	} else {
    	    JOptionPane.showMessageDialog(null, "Debes rellenar todos los espacios");
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

	private void limpiarCampos() {
		vp.txtNombre.setText("");
		vp.txtEdad.setText("");
		vp.txtSexo.setText("");
		vp.txtIdentificacion.setText("");
		vp.txtContacto.setText("");
		vp.txtAreaEnfermedad.setText("");
	}
}
