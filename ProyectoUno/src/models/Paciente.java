package models;

/**
 * La clase Paciente representa a una persona que recibe atención médica.
 * Hereda de la clase Persona, por lo que incluye atributos básicos como
 * nombre, edad, sexo y delimitador.
 * 
 * Además, incorpora información adicional como:
 * identificación, contacto, enfermedad asociada y estado del paciente.
 * 
 * @author Luis
 * @author Ariel
 */
public class Paciente extends Persona {

	/**
	 * Identificación única del paciente.
	 */
	private String identificacion;

	/**
	 * Información de contacto del paciente.
	 */
	private String contacto;

	/**
	 * Enfermedad asociada al paciente.
	 */
	private Enfermedad enfermedad;

	/**
	 * Estado del paciente (activo o inactivo).
	 */
	private boolean activo;

	/**
	 * Constructor vacío de la clase Paciente.
	 */
	public Paciente() {
	}

	/**
	 * Constructor que inicializa los datos del paciente sin enfermedad.
	 * 
	 * @param identificacion Identificación del paciente
	 * @param nombre Nombre del paciente
	 * @param edad Edad del paciente
	 * @param sexo Sexo del paciente
	 * @param contacto Información de contacto
	 * @param activo Estado del paciente
	 * @param delimiter Delimitador heredado de Persona
	 */
	public Paciente(String identificacion, String nombre, int edad,char sexo, String contacto, boolean activo,char delimiter) {
		super(nombre, edad, sexo, delimiter);
		this.identificacion = identificacion;
		this.contacto = contacto;
		this.activo=activo;
	}

	/**
	 * Constructor que inicializa todos los atributos del paciente,
	 * incluyendo su enfermedad.
	 * 
	 * @param identificacion Identificación del paciente
	 * @param nombre Nombre del paciente
	 * @param edad Edad del paciente
	 * @param sexo Sexo del paciente
	 * @param contacto Información de contacto
	 * @param enfermedad Enfermedad asociada
	 * @param activo Estado del paciente
	 * @param delimiter Delimitador heredado de Persona
	 */
	public Paciente(String identificacion, String nombre, int edad,char sexo, String contacto, Enfermedad enfermedad, boolean activo,char delimiter) {
		super(nombre, edad, sexo, delimiter);
		this.identificacion = identificacion;
		this.contacto = contacto;
		this.enfermedad = enfermedad;
		this.activo=activo;
	}

	/**
	 * Obtiene la identificación del paciente.
	 * 
	 * @return identificación
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Establece la identificación del paciente.
	 * 
	 * @param identificacion nueva identificación
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * Obtiene el contacto del paciente.
	 * 
	 * @return contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * Establece el contacto del paciente.
	 * 
	 * @param contacto nuevo contacto
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	/**
	 * Obtiene la enfermedad asociada al paciente.
	 * 
	 * @return enfermedad
	 */
	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	/**
	 * Establece la enfermedad asociada al paciente.
	 * 
	 * @param enfermedad nueva enfermedad
	 */
	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	/**
	 * Indica si el paciente está activo.
	 * 
	 * @return true si está activo, false en caso contrario
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Establece el estado del paciente.
	 * 
	 * @param activo nuevo estado
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * Convierte el estado booleano en una representación textual.
	 * 
	 * @param activo estado del paciente
	 * @return "activo" si es true, "inactivo" si es false
	 */
	public String activo(boolean activo) {
		String salida ="";
		if(activo) {
			salida = "activo";
		}else {
			salida = "inactivo";
		}
		return salida;
	}

	/**
	 * Retorna una representación en cadena del paciente,
	 * incluyendo sus datos personales y estado.
	 * 
	 * @return datos del paciente en formato String
	 */
	@Override
	public String toString() {
		return identificacion +super.getDelimiter()+super.toString()+ contacto + super.getDelimiter()+ enfermedad+super.getDelimiter()+activo(activo);
	}

}