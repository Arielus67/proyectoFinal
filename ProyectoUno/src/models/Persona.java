package models;

public class Persona {

	private String nombre;
	private int edad;
	private char sexo;
	private char delimiter;

	public Persona() {}
	public Persona(String nombre, int edad, char sexo, char delimiter) {

		this.nombre = nombre;
		this.edad = edad;
		this.sexo=sexo;
		this.delimiter=delimiter;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public char getDelimiter() {
		return delimiter;
	}
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	@Override
	public String toString() {
		return nombre +delimiter+ edad +delimiter + sexo +delimiter ;
	}

	
}
