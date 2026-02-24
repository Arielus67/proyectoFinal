package controllers;

import view.VentanaPrincipal;

/**
 * Controlador principal de la aplicación.
 * Gestiona la ventana inicial y la navegación hacia los módulos:
 * pacientes, médicos, citas, expedientes y reportes.
 *
 * @author Luis
 * @author Ariel
 * @version 1.0
 */
public class ControllerPrincipal {

    private VentanaPrincipal vp;

    /**
     * Constructor.
     * Crea la instancia de la ventana principal.
     */
    public ControllerPrincipal() {
        this.vp = new VentanaPrincipal();
    }

    /**
     * Inicia la aplicación.
     * Muestra la ventana principal y asigna los listeners a los botones.
     */
    public void start() {
        vp.init();
        funciones();
    }

    /**
     * Asigna listeners a cada botón de la ventana principal.
     * Al hacer clic en un botón:
     * - Cierra la ventana principal
     * - Crea el controlador correspondiente
     * - Inicia su ventana
     */
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

        vp.btnCitas.addActionListener(e -> {
            vp.close();
            ControllerCita cc = new ControllerCita(this);
            cc.start();
        });

        vp.btnExpedientes.addActionListener(e -> {
            vp.close();
            ControllerExpedientes ce = new ControllerExpedientes(this);
            ce.start();
        });

        vp.btnReportes.addActionListener(e -> {
            vp.close();
            ControllerReportes cr = new ControllerReportes(this);
            cr.start();
        });
    }

    /**
     * Muestra nuevamente la ventana principal.
     * Usado para regresar desde otros módulos.
     */
    public void mostrarVentana() {
        vp.init();
    }
}