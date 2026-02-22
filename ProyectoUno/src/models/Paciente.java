package models;

public class Paciente extends Persona {

	private String identificacion;
	private String contacto;
	private Enfermedad enfermedad;
	private boolean activo;
	
	public Paciente() {
	}
	public Paciente(String identificacion, String nombre, int edad,char sexo, String contacto, boolean activo,char delimiter) {
		super(nombre, edad, sexo, delimiter);
		this.identificacion = identificacion;
		this.contacto = contacto;
		this.activo=activo;
	}
	public Paciente(String identificacion, String nombre, int edad,char sexo, String contacto, Enfermedad enfermedad, boolean activo,char delimiter) {
		super(nombre, edad, sexo, delimiter);
		this.identificacion = identificacion;
		this.contacto = contacto;
		this.enfermedad = enfermedad;
		this.activo=activo;
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
	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String activo(boolean activo) {
		String salida ="";
		if(activo) {
			salida = "activo";
		}else {
			salida = "inactivo";
		}
		return salida;
	}
	@Override
	public String toString() {
		return identificacion +super.getDelimiter()+super.toString()+ contacto + super.getDelimiter()+ enfermedad+super.getDelimiter()+activo(activo);
	}

}
