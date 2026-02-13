package models;

public class Cita {
	
	private Paciente paciente;
	private Medico medico;
	private char delimiter;
	private int id;
	
	public Cita(Paciente paciente, Medico medico,char delimiter) {
		super();
		this.id=generarId();
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    private int generarId() {
        return (int)(Math.random() * 900000) + 100000; // 6 digitos
    }
	@Override
	public String toString() {
		return  id + ""+delimiter + medico.getCodigo() + delimiter + medico.getNombre()+ delimiter +medico.getEspecialidad()+ delimiter +paciente.getIdentificacion()+ delimiter +paciente.getNombre()+ delimiter +paciente.getEnfermedad().getNombreEnfermedad()+delimiter+paciente.activo(paciente.isActivo());
	}
	
	
}
