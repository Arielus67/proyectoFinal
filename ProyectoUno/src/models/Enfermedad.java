package models;

public class Enfermedad {

	private String nombreEnfermedad;
	private int gravedad;

	public Enfermedad(String nombreEnfermedad, int gravedad) {
		super();
		this.nombreEnfermedad = nombreEnfermedad;
		this.gravedad = gravedad;
	}

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}

	public int getGravedad() {
		return gravedad;
	}

	public void setGravedad(int gravedad) {
		this.gravedad = gravedad;
	}

	@Override
	public String toString() {
		return "Enfermedad [nombreEnfermedad=" + nombreEnfermedad + ", gravedad=" + gravedad + "]";
	}

}
