package models;

public class Medico extends Persona{

	private String codigo;
	private String especialidad;
	
	public Medico(String nombre, int edad, char sexo,String codigo, String especialidad) {
		super(nombre, edad,sexo);
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
		return super.toString()+"Medico [codigo=" + codigo + ", especialidad=" + especialidad + "]";
	}
	
	
}
