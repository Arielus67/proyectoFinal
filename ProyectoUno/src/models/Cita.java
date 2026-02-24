package models;

/**
 * La clase Cita representa una consulta médica programada
 * entre un paciente y un médico.
 * 
 * Contiene información relacionada con:
 * el paciente, el médico, el estado de la cita,
 * la fecha (día y mes), la hora y un identificador único.
 * 
 * También utiliza un delimitador para estructurar
 * la información en formato de texto.
 * 
 * @author Luis
 * @author Ariel
 */
public class Cita {
	
	/**
	 * Paciente asociado a la cita.
	 */
	private Paciente paciente;

	/**
	 * Médico asignado a la cita.
	 */
	private Medico medico;

	/**
	 * Estado actual de la cita.
	 */
	private EstadoCita estado;

	/**
	 * Delimitador utilizado para separar los datos.
	 */
	private char delimiter;

	/**
	 * Identificador único de la cita.
	 */
	private int id;

	/**
	 * Hora programada de la cita.
	 */
	private int hora;

	/**
	 * Mes en el que se realiza la cita.
	 */
	private String mes;

	/**
	 * Día en el que se realiza la cita.
	 */
	private String dia;

	/**
	 * Constructor que inicializa una cita sin fecha específica.
	 * 
	 * @param paciente Paciente de la cita
	 * @param medico Médico asignado
	 * @param estado Estado de la cita
	 * @param delimiter Carácter delimitador
	 */
	public Cita(Paciente paciente, Medico medico, EstadoCita estado,char delimiter) {
		super();
		this.id=generarId();
		this.paciente = paciente;
		this.medico = medico;
		this.estado = estado;
		this.delimiter=delimiter;
	}

	/**
	 * Constructor que inicializa una cita con fecha y hora.
	 * 
	 * @param paciente Paciente de la cita
	 * @param medico Médico asignado
	 * @param estado Estado de la cita
	 * @param delimiter Carácter delimitador
	 * @param hora Hora de la cita
	 * @param mes Mes de la cita
	 * @param dia Día de la cita
	 */
	public Cita(Paciente paciente, Medico medico, EstadoCita estado,char delimiter,int hora, String mes, String dia ) {
		super();
		this.id=generarId();
		this.paciente = paciente;
		this.medico = medico;
		this.estado = estado;
		this.delimiter=delimiter;
		this.hora=hora;
		this.mes=mes;
		this.dia=dia;
	}

	/**
	 * Obtiene el paciente de la cita.
	 * @return paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * Establece el paciente de la cita.
	 * @param paciente nuevo paciente
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * Obtiene el médico de la cita.
	 * @return médico
	 */
	public Medico getMedico() {
		return medico;
	}

	/**
	 * Establece el médico de la cita.
	 * @param medico nuevo médico
	 */
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	/**
	 * Obtiene el estado de la cita.
	 * @return estado
	 */
	public EstadoCita getEstado() {
		return estado;
	}

	/**
	 * Establece el estado de la cita.
	 * @param estado nuevo estado
	 */
	public void setEstado(EstadoCita estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene el delimitador.
	 * @return delimitador
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
	 * Obtiene la hora de la cita.
	 * @return hora
	 */
	public int getHora() {
		return hora;
	}

	/**
	 * Establece la hora de la cita.
	 * @param hora nueva hora
	 */
	public void setHora(int hora) {
		this.hora = hora;
	}

	/**
	 * Obtiene el mes de la cita.
	 * @return mes
	 */
	public String getMes() {
		return mes;
	}

	/**
	 * Establece el mes de la cita.
	 * @param mes nuevo mes
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}

	/**
	 * Obtiene el identificador de la cita.
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador de la cita.
	 * @param id nuevo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el día de la cita.
	 * @return día
	 */
    public String getDia() {
		return dia;
	}

	/**
	 * Establece el día de la cita.
	 * @param dia nuevo día
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}

	/**
	 * Genera un identificador aleatorio de 6 dígitos.
	 * 
	 * @return id generado
	 */
	private int generarId() {
        return (int)(Math.random() * 900000) + 100000; 
    }

	/**
	 * Retorna una representación en cadena de la cita,
	 * incluyendo datos del médico, paciente,
	 * fecha, hora y estado.
	 * 
	 * @return datos de la cita en formato String
	 */
	@Override
	public String toString() {
		return  id + ""+delimiter + medico.getCodigo() + delimiter + medico.getNombre()+ delimiter +medico.getEspecialidad()+ delimiter +paciente.getIdentificacion()+ delimiter +paciente.getNombre()+ delimiter +paciente.getEnfermedad().getNombreEnfermedad()+delimiter+""+hora+""+delimiter+""+dia+""+delimiter+""+mes+""+delimiter+paciente.activo(paciente.isActivo())+delimiter+estado;
	}
}