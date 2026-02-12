package models;

public class Medico extends Persona{

	private String codigo;
	private String especialidad;
	
	public Medico(String codigo, String nombre, int edad, char sexo, String especialidad, char delimiter) {
		super(nombre, edad,sexo, delimiter);
		this.codigo = codigo;
		this.especialidad = especialidad;
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

	@Override
	public String toString() {
		return codigo + super.getDelimiter() +super.toString()+ especialidad;
	}
	
	
}
