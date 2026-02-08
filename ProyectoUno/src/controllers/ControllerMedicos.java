package controllers;

import javax.swing.JOptionPane;

import models.ListaMedicos;
import models.Medico;
import view.VentanaMedicos;

public class ControllerMedicos {

	private ListaMedicos lm;
	private VentanaMedicos vm;
	private ControllerPrincipal controllerPrincipal;
	
	public ControllerMedicos(ControllerPrincipal controllerPrincipal) {
		this.controllerPrincipal = controllerPrincipal;
		this.lm = new ListaMedicos();
		this.vm = new VentanaMedicos();
	}
	
	public void start() {
		vm.init();
		funciones();
	}
	
	private void funciones() {

        vm.btnAgregar.addActionListener(e -> create());

        vm.btnLimpiar.addActionListener(e -> limpiarCampos());
        
        vm.btnModificar.addActionListener(e -> editar());
        
        vm.btnVolver.addActionListener(e -> {
            vm.close();
            controllerPrincipal.mostrarVentana();
        });
        vm.btnEliminar.addActionListener(e-> eliminar());
    }
	
	private void create() {
    	String nombre = vm.txtNombre.getText();
    	String edadTxt = vm.txtEdad.getText();
    	String sexoTxt = vm.txtSexo.getText();
    	String codigo = vm.txtCodigo.getText();
    	String especialidad = vm.txtEspecialidad.getText();

    	if (!nombre.isEmpty() &&
    	    !edadTxt.isEmpty() &&
    	    !sexoTxt.isEmpty() &&
    	    !codigo.isEmpty() &&
    	    !especialidad.isEmpty()) {

    	    int edad = Integer.parseInt(edadTxt);
    	    char sexo = sexoTxt.charAt(0);

    	    Medico m = new Medico(nombre, edad, sexo, codigo, especialidad);

    	    lm.agregarMedico(m);
    	    limpiarCampos();

    	} else {
    	    JOptionPane.showMessageDialog(null, "Debes rellenar todos los espacios");
    	}
	}
	
	private void editar() {
    	String nombre = vm.txtNombre.getText();
    	String edadTxt = vm.txtEdad.getText();
    	String sexoTxt = vm.txtSexo.getText();
    	String codigo = vm.txtCodigo.getText();
    	String especialidad = vm.txtEspecialidad.getText();

    	if (!nombre.isEmpty() &&
    	    !edadTxt.isEmpty() &&
    	    !sexoTxt.isEmpty() &&
    	    !codigo.isEmpty() &&
    	    !especialidad.isEmpty()) {

    	    int edad = Integer.parseInt(edadTxt);
    	    char sexo = sexoTxt.charAt(0);

    	    Medico m = new Medico(nombre, edad, sexo, codigo, especialidad);

    	    lm.editarMedico(m);;
    	    limpiarCampos();

    	} else {
    	    JOptionPane.showMessageDialog(null, "Debes rellenar todos los espacios");
    	}
	}
	
	private void eliminar() {

		String codigo = vm.txtCodigo.getText();
		
		if (!codigo.isEmpty()) {
			lm.eliminarMedico(codigo);;
			limpiarCampos();
			JOptionPane.showMessageDialog(null, "Se Elimino con exito");
		}else {
			JOptionPane.showMessageDialog(null, "Debes rellenar el espacio");
		}
	}
	
	private void limpiarCampos() {
		vm.txtNombre.setText("");
		vm.txtEdad.setText("");
		vm.txtSexo.setText("");
		vm.txtCodigo.setText("");
		vm.txtEspecialidad.setText("");
	}
}
