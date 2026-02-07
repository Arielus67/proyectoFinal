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
    }

    public void mostrarVentana() {
        vp.init();
    }
}
