package models;

public class Diagnostico {

	private String cedula;
	private String diagnostico;
	private char delimiter;
	public Diagnostico(String cedula, String diagnostico, char delimiter) {
		super();
		this.cedula = cedula;
		this.diagnostico = diagnostico;
		this.delimiter = delimiter;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public char getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	@Override
	public String toString() {
		return cedula+""+delimiter+""+diagnostico;
	}
	
}
