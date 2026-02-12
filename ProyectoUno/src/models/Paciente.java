package models;

public class Paciente extends Persona {

	private String identificacion;
	private String contacto;
	private Enfermedad enfermedad;
	
	public Paciente() {
	}
	public Paciente(String identificacion, String nombre, int edad,char sexo, String contacto, Enfermedad enfermedad, char delimiter) {
		super(nombre, edad, sexo, delimiter);
		this.identificacion = identificacion;
		this.contacto = contacto;
		this.enfermedad = enfermedad;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public Enfermedad getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}
	@Override
	public String toString() {
		return identificacion +super.getDelimiter()+super.toString()+ contacto + super.getDelimiter()+ enfermedad.getNombreEnfermedad()+super.getDelimiter()+enfermedad.getGravedad();
	}

}
