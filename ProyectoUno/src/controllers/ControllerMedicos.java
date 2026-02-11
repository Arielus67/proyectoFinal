package controllers;

import javax.swing.JOptionPane;

import models.ListaMedicos;
import models.Medico;
import view.VentanaMedicos;

public class ControllerMedicos {

	private ListaMedicos lm;
	private VentanaMedicos vm;
	private ControllerPrincipal controllerPrincipal;
	private boolean modoEdicion = false;
	
	public ControllerMedicos(ControllerPrincipal controllerPrincipal) {
		this.controllerPrincipal = controllerPrincipal;
		this.lm = new ListaMedicos();
		this.vm = new VentanaMedicos();
	}
	
	public void start() {
		vm.init();
		funciones();
		cargarTabla();
	}
	
	private void funciones() {

        vm.btnAgregar.addActionListener(e -> {
        	create();
        	cargarTabla();
        });

        vm.btnLimpiar.addActionListener(e -> {
        	limpiarCampos();
        	cargarTabla();
        });
        
        vm.btnModificar.addActionListener(e -> {
        	editar();
        	cargarTabla();
        });
        
        vm.btnVolver.addActionListener(e -> {
            vm.close();
            controllerPrincipal.mostrarVentana();
        });
        vm.btnEliminar.addActionListener(e-> {
        	int seleccionado = vm.table.getSelectedRow();
			if (seleccionado == -1) {
				JOptionPane.showMessageDialog(null, "No has seleccionado a ninguno");
				return;
			}
			String codigo = vm.table.getValueAt(seleccionado, 0).toString();

			lm.eliminarMedico(codigo);
        	cargarTabla();
        });
        
        vm.btnConsultar.addActionListener(e-> {
        	consultar();
        	cargarTabla();
        });
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

		String codigo = vm.txtCodigo.getText();

		if (codigo.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debes ingresar el código");
			return;
		}

		// PRIMER CLIC → buscar y cargar datos
		if (!modoEdicion) {

			Medico m = lm.buscarMedico(codigo);

			if (m != null) {

				vm.txtNombre.setText(m.getNombre());
				vm.txtEdad.setText(String.valueOf(m.getEdad()));
				vm.txtSexo.setText(String.valueOf(m.getSexo()));
				vm.txtEspecialidad.setText(m.getEspecialidad());

				modoEdicion = true;
				JOptionPane.showMessageDialog(null, "Ahora puedes modificar los datos");

			} else {
				JOptionPane.showMessageDialog(null, "Médico no encontrado");
			}

		}
		// SEGUNDO CLIC → guardar cambios
		else {

			String nombre = vm.txtNombre.getText();
			String edadTxt = vm.txtEdad.getText();
			String sexoTxt = vm.txtSexo.getText();
			String especialidad = vm.txtEspecialidad.getText();

			if (nombre.isEmpty() || edadTxt.isEmpty() || sexoTxt.isEmpty() || especialidad.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
				return;
			}

			int edad = Integer.parseInt(edadTxt);
			char sexo = sexoTxt.charAt(0);

			Medico m = new Medico(nombre, edad, sexo, codigo, especialidad);
			lm.editarMedico(m);

			JOptionPane.showMessageDialog(null, "Médico actualizado correctamente");

			limpiarCampos();
			modoEdicion = false;
		}
	}

	
//	private void editar() {
//    	String nombre = vm.txtNombre.getText();
//    	String edadTxt = vm.txtEdad.getText();
//    	String sexoTxt = vm.txtSexo.getText();
//    	String codigo = vm.txtCodigo.getText();
//    	String especialidad = vm.txtEspecialidad.getText();
//
//    	if (!nombre.isEmpty() &&
//    	    !edadTxt.isEmpty() &&
//    	    !sexoTxt.isEmpty() &&
//    	    !codigo.isEmpty() &&
//    	    !especialidad.isEmpty()) {
//
//    	    int edad = Integer.parseInt(edadTxt);
//    	    char sexo = sexoTxt.charAt(0);
//
//    	    Medico m = new Medico(nombre, edad, sexo, codigo, especialidad);
//
//    	    lm.editarMedico(m);;
//    	    limpiarCampos();
//
//    	} else {
//    	    JOptionPane.showMessageDialog(null, "Debes rellenar todos los espacios");
//    	}
//	}
	
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
	
	private void consultar() {

		String codigo = vm.txtCodigo.getText();

		if (!codigo.isEmpty()) {

			Medico m = lm.buscarMedico(codigo);

			if (m != null) {

				vm.txtNombre.setText(m.getNombre());
				vm.txtEdad.setText(String.valueOf(m.getEdad()));
				vm.txtSexo.setText(String.valueOf(m.getSexo()));
				vm.txtEspecialidad.setText(m.getEspecialidad());

			} else {
				JOptionPane.showMessageDialog(null, "Médico no encontrado");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Debes ingresar el código");
		}
	}
	
	private void cargarTabla() {
		vm.modelo.setDataVector(lm.getDatosMedicos(), lm.getColumnsMedicos());
	}


	
	private void limpiarCampos() {
		vm.txtNombre.setText("");
		vm.txtEdad.setText("");
		vm.txtSexo.setText("");
		vm.txtCodigo.setText("");
		vm.txtEspecialidad.setText("");
		modoEdicion = false;
	}
}
