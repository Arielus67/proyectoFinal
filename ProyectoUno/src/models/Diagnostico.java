package models;

/**
 * La clase Diagnostico representa la información médica
 * asociada a un paciente específico.
 * 
 * Contiene datos relacionados con:
 * la cédula del paciente y la descripción
 * del diagnóstico asignado.
 * 
 * También utiliza un delimitador para estructurar
 * la información en formato de texto.
 * 
 * @author Luis
 * @author Ariel
 */
public class Diagnostico {

	/**
	 * Cédula del paciente al que pertenece el diagnóstico.
	 */
	private String cedula;
	
	/**
	 * Descripción del diagnóstico médico.
	 */
	private String diagnostico;
	
	/**
	 * Delimitador utilizado para separar los datos.
	 */
	private char delimiter;

	/**
	 * Constructor que inicializa un diagnóstico.
	 * 
	 * @param cedula Cédula del paciente
	 * @param diagnostico Descripción del diagnóstico
	 * @param delimiter Carácter delimitador
	 */
	public Diagnostico(String cedula, String diagnostico, char delimiter) {
		super();
		this.cedula = cedula;
		this.diagnostico = diagnostico;
		this.delimiter = delimiter;
	}

	/**
	 * Obtiene la cédula del paciente.
	 * @return cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Establece la cédula del paciente.
	 * @param cedula nueva cédula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Obtiene la descripción del diagnóstico.
	 * @return diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * Establece la descripción del diagnóstico.
	 * @param diagnostico nuevo diagnóstico
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * Obtiene el delimitador.
	 * @return delimiter
	 */
	public char getDelimiter() {
		return delimiter;
	}

	/**
	 * Establece el delimitador.
	 * @param delimiter nuevo delimitador
	 */
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Retorna una representación en cadena del diagnóstico,
	 * separando los datos mediante el delimitador.
	 * 
	 * Formato:
	 * cedula + delimiter + diagnostico
	 * 
	 * @return datos del diagnóstico en formato String
	 */
	@Override
	public String toString() {
		return cedula + "" + delimiter + "" + diagnostico;
	}
}