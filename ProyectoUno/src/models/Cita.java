package models;

public class Cita {
	
	private Paciente paciente;
	private Medico medico;
	private char delimiter;
	public Cita(Paciente paciente, Medico medico,char delimiter) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.delimiter=delimiter;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public char getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	@Override
	public String toString() {
		return medico.getCodigo() + delimiter + medico.getNombre()+ delimiter +medico.getEspecialidad()+ delimiter +paciente.getIdentificacion()+ delimiter +paciente.getNombre()+ delimiter +paciente.getEnfermedad() ;
	}
	
	
}
