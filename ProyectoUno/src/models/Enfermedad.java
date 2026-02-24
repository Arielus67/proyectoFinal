package models;

/**
 * La clase Enfermedad representa una condición médica asociada a un paciente.
 * Contiene información sobre el nombre de la enfermedad, su nivel de gravedad
 * y un delimitador que permite estructurar los datos en formato de texto.
 * 
 * @author Luis
 * @author Ariel
 */
public class Enfermedad {

	/**
	 * Nombre de la enfermedad.
	 */
	private String nombreEnfermedad;

	/**
	 * Nivel de gravedad de la enfermedad.
	 */
	private int gravedad;

	/**
	 * Delimitador utilizado para separar los datos en formato String.
	 */
	private char delimiter;

	/**
	 * Constructor que inicializa los atributos de la enfermedad.
	 * 
	 * @param nombreEnfermedad Nombre de la enfermedad
	 * @param gravedad Nivel de gravedad
	 * @param delimiter Carácter delimitador
	 */
	public Enfermedad(String nombreEnfermedad, int gravedad, char delimiter) {
		super();
		this.nombreEnfermedad = nombreEnfermedad;
		this.gravedad = gravedad;
		this.delimiter=delimiter;
	}

	/**
	 * Obtiene el nombre de la enfermedad.
	 * 
	 * @return nombre de la enfermedad
	 */
	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	/**
	 * Establece el nombre de la enfermedad.
	 * 
	 * @param nombreEnfermedad nuevo nombre
	 */
	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}

	/**
	 * Obtiene el nivel de gravedad de la enfermedad.
	 * 
	 * @return gravedad
	 */
	public int getGravedad() {
		return gravedad;
	}

	/**
	 * Establece el nivel de gravedad de la enfermedad.
	 * 
	 * @param gravedad nueva gravedad
	 */
	public void setGravedad(int gravedad) {
		this.gravedad = gravedad;
	}

	/**
	 * Obtiene el delimitador.
	 * 
	 * @return delimitador
	 */
	public char getDelimiter() {
		return delimiter;
	}

	/**
	 * Establece el delimitador.
	 * 
	 * @param delimiter nuevo delimitador
	 */
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Retorna una representación en cadena de la enfermedad.
	 * 
	 * @return datos de la enfermedad en formato String
	 */
	@Override
	public String toString() {
		return nombreEnfermedad + delimiter + gravedad;
	}

}