package models;

/**
 * Enumeración que representa los posibles estados de una cita médica.
 * 
 * Define las diferentes condiciones en las que puede encontrarse una cita
 * dentro del sistema.
 * 
 * Estados disponibles:
 * <ul>
 *   <li>ATENDIDA: La cita fue realizada exitosamente.</li>
 *   <li>PENDIENTE: La cita está programada pero aún no ha sido atendida.</li>
 *   <li>CANCELADA: La cita fue cancelada.</li>
 * </ul>
 * 
 * @author Luis
 * @author Ariel
 */
public enum EstadoCita {

	/**
	 * Indica que la cita ya fue atendida.
	 */
	ATENDIDA,

	/**
	 * Indica que la cita está pendiente.
	 */
	PENDIENTE,

	/**
	 * Indica que la cita fue cancelada.
	 */
	CANCELADA
}