package models;

/**
 * La clase Persona representa una entidad básica con información personal.
 * Contiene atributos como nombre, edad, sexo y un delimitador que permite
 * estructurar la información en formato de texto.
 * 
 * Esta clase incluye métodos de acceso (getters y setters), constructores
 * y una representación en forma de cadena del objeto.
 * 
 * @author Luis
 * @author Ariel
 */
public class Persona {

	/**
	 * Nombre de la persona.
	 */
	private String nombre;

	/**
	 * Edad de la persona.
	 */
	private int edad;

	/**
	 * Sexo de la persona.
	 */
	private char sexo;

	/**
	 * Delimitador utilizado para separar los datos en formato String.
	 */
	private char delimiter;

	/**
	 * Constructor vacío de la clase Persona.
	 */
	public Persona() {}

	/**
	 * Constructor con parámetros que permite inicializar todos los atributos.
	 * 
	 * @param nombre Nombre de la persona
	 * @param edad Edad de la persona
	 * @param sexo Sexo de la persona
	 * @param delimiter Carácter utilizado como delimitador
	 */
	public Persona(String nombre, int edad, char sexo, char delimiter) {

		this.nombre = nombre;
		this.edad = edad;
		this.sexo=sexo;
		this.delimiter=delimiter;
	}

	/**
	 * Obtiene el nombre de la persona.
	 * 
	 * @return nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la persona.
	 * 
	 * @param nombre nuevo nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la edad de la persona.
	 * 
	 * @return edad de la persona
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece la edad de la persona.
	 * 
	 * @param edad nueva edad de la persona
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene el sexo de la persona.
	 * 
	 * @return sexo de la persona
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Establece el sexo de la persona.
	 * 
	 * @param sexo nuevo sexo de la persona
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Obtiene el delimitador utilizado.
	 * 
	 * @return delimitador
	 */
	public char getDelimiter() {
		return delimiter;
	}

	/**
	 * Establece el delimitador utilizado.
	 * 
	 * @param delimiter nuevo delimitador
	 */
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Retorna una representación en forma de cadena del objeto Persona,
	 * utilizando el delimitador para separar los atributos.
	 * 
	 * @return datos de la persona en formato String
	 */
	@Override
	public String toString() {
		return nombre +delimiter+ edad +delimiter + sexo +delimiter ;
	}
}


