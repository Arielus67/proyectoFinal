package models;

public class Cita {
	
	private Paciente paciente;
	private Medico medico;
	private EstadoCita estado;
	private char delimiter;
	private int id;
	private int hora;
	
	public Cita(Paciente paciente, Medico medico, EstadoCita estado,char delimiter) {
		super();
		this.id=generarId();
		this.paciente = paciente;
		this.medico = medico;
		this.estado = estado;
		this.delimiter=delimiter;
	}
	public Cita(Paciente paciente, Medico medico, EstadoCita estado,char delimiter,int hora) {
		super();
		this.id=generarId();
		this.paciente = paciente;
		this.medico = medico;
		this.estado = estado;
		this.delimiter=delimiter;
		this.hora=hora;
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
	public EstadoCita getEstado() {
		return estado;
	}
	public void setEstado(EstadoCita estado) {
		this.estado = estado;
	}
	public char getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter; 
	}
	
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    private int generarId() {
        return (int)(Math.random() * 900000) + 100000; 
    }
	@Override
	public String toString() {
		return  id + ""+delimiter + medico.getCodigo() + delimiter + medico.getNombre()+ delimiter +medico.getEspecialidad()+ delimiter +paciente.getIdentificacion()+ delimiter +paciente.getNombre()+ delimiter +paciente.getEnfermedad().getNombreEnfermedad()+delimiter+""+hora+""+delimiter+paciente.activo(paciente.isActivo())+delimiter+estado;
	}
	
	
}
