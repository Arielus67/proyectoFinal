package models;

public class Cita {
	
	private Paciente paciente;
	private Medico medico;
	public Cita(Paciente paciente, Medico medico) {
		super();
		this.paciente = paciente;
		this.medico = medico;
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
	@Override
	public String toString() {
		return "Cita [paciente=" + paciente + ", medico=" + medico + "]";
	}
	
	
}
