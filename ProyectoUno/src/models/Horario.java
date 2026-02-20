package models;

public class Horario {

	private Dia[] dia;
    private char delimiter;

	public Horario(Dia[] dia, char delimiter) {
		super();
		this.dia = dia;
		this.delimiter = delimiter;
	}
	
	public Dia[] getDia() {
		return dia;
	}

	public void setDia(Dia[] dia) {
		this.dia = dia;
	}

	public char getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	
	public void createSchedule(Dia item) {
		
		for (int i = 0; i < dia.length; i++) {
			dia[i]=item;
		}
	}
	@Override
	public String toString() {
		return dia + "" + delimiter;
	}
    
}