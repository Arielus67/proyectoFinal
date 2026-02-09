package controllers;

import view.VentanaPrincipal;

public class ControllerPrincipal {

    private VentanaPrincipal vp;

    public ControllerPrincipal() {
        this.vp = new VentanaPrincipal();
    }

    public void start() {
        vp.init();
        funciones();
    }

    private void funciones() {

        vp.btnPacientes.addActionListener(e -> {
            vp.close();
            ControllerPacientes cp = new ControllerPacientes(this);
            cp.start();
        });
        
        vp.btnMedicos.addActionListener(e -> {
            vp.close();
            ControllerMedicos cm = new ControllerMedicos(this);
            cm.start();
        });
        vp.btnCitas.addActionListener(e->{
        	vp.close();
        	ControllerCitas cc = new ControllerCitas(this);
        	cc.start();
        });
    }

    public void mostrarVentana() {
        vp.init();
    }
}
