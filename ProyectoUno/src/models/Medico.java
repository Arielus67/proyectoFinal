package models;

public class Medico extends Persona{

	private String codigo;
	private String especialidad;
	private Paciente horario;
	public Medico(String nombre, int edad, char sexo,String codigo, String especialidad, Paciente horario) {
		super(nombre, edad,sexo);
		this.codigo = codigo;
		this.especialidad = especialidad;
		this.horario = horario;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Paciente getHorario() {
		return horario;
	}
	public void setHorario(Paciente horario) {
		this.horario = horario;
	}
	@Override
	public String toString() {
		return super.toString()+"Medico [codigo=" + codigo + ", especialidad=" + especialidad + ", horario=" + horario + "]";
	}
	
	
}
