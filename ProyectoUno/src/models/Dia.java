package models;

import java.util.Arrays;

public class Dia {

	private String dia;
	private int desde;
	private int hasta;
	private char delimiter;

	public Dia(String dia, int desde, int hasta, char delimiter) {
		super();
		this.dia = dia;
		this.desde = desde;
		this.hasta = hasta;
		this.delimiter = delimiter;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public char getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	public int getDesde() {
		return desde;
	}
	public void setDesde(int desde) {
		this.desde = desde;
	}
	public int getHasta() {
		return hasta;
	}
	public void setHasta(int hasta) {
		this.hasta = hasta;
	}
	@Override
	public String toString() {
		return dia + ""+delimiter + desde + ""+delimiter+ hasta+"";
	}

	
	
}
