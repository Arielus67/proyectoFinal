package models;

/**
 * La clase Medico representa a un profesional de la salud.
 * Hereda de la clase Persona, por lo que contiene información
 * básica como nombre, edad, sexo y delimitador.
 * 
 * Además, incorpora información específica como:
 * código del médico, especialidad y horario de atención.
 * 
 * @author Luis
 * @author Ariel
 */
public class Medico extends Persona{

	/**
	 * Código único del médico.
	 */
	private String codigo;

	/**
	 * Especialidad médica.
	 */
	private String especialidad;

	/**
	 * Horario de atención del médico.
	 */
	private Horario horario;

	/**
	 * Constructor que inicializa los datos del médico sin horario.
	 * 
	 * @param codigo Código del médico
	 * @param nombre Nombre del médico
	 * @param edad Edad del médico
	 * @param sexo Sexo del médico
	 * @param especialidad Especialidad del médico
	 * @param delimiter Delimitador heredado de Persona
	 */
	public Medico(String codigo,  String nombre, int edad, char sexo,String especialidad,char delimiter) {
		super(nombre, edad,sexo, delimiter);
		this.codigo = codigo;
		this.especialidad = especialidad;
	}

	/**
	 * Constructor que inicializa todos los atributos del médico,
	 * incluyendo su horario.
	 * 
	 * @param codigo Código del médico
	 * @param nombre Nombre del médico
	 * @param edad Edad del médico
	 * @param sexo Sexo del médico
	 * @param especialidad Especialidad del médico
	 * @param horario Horario de atención
	 * @param delimiter Delimitador heredado de Persona
	 */
	public Medico(String codigo, String nombre, int edad, char sexo, String especialidad, Horario horario ,char delimiter) {
		super(nombre, edad,sexo, delimiter);
		this.codigo = codigo;
		this.horario=horario;
		this.especialidad = especialidad;
	}

	/**
	 * Obtiene el código del médico.
	 * 
	 * @return código
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece el código del médico.
	 * 
	 * @param codigo nuevo código
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene la especialidad del médico.
	 * 
	 * @return especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}

	/**
	 * Establece la especialidad del médico.
	 * 
	 * @param especialidad nueva especialidad
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	/**
	 * Obtiene el horario del médico.
	 * 
	 * @return horario
	 */
	public Horario getHorario() {
		return horario;
	}

	/**
	 * Establece el horario del médico.
	 * 
	 * @param horario nuevo horario
	 */
	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	/**
	 * Retorna una representación en cadena del médico,
	 * incluyendo sus datos personales, especialidad y horario.
	 * 
	 * @return datos del médico en formato String
	 */
	@Override
	public String toString() {
		return codigo + super.getDelimiter() +super.toString()+ especialidad+ super.getDelimiter() + horario;
	}
}