package models;

public class Dia {

	private String dia;
	private String hora;
	private char delimiter;
	public Dia(String dia, String hora, char delimiter) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.delimiter = delimiter;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public char getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	@Override
	public String toString() {
		return dia + ""+ delimiter + "" + hora;
	}
	
	
}
