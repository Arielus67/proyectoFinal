package models;

public class Enfermedad {

	private String nombreEnfermedad;
	private int gravedad;
	private char delimiter;
	public Enfermedad(String nombreEnfermedad, int gravedad, char delimiter) {
		super();
		this.nombreEnfermedad = nombreEnfermedad;
		this.gravedad = gravedad;
		this.delimiter=delimiter;
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
	
	public char getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	@Override
	public String toString() {
		return nombreEnfermedad + delimiter + gravedad;
	}

}
