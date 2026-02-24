package models;

/**
 * La clase Horario representa el día asignado dentro de un horario.
 * Contiene un objeto de tipo Dia y un delimitador que permite
 * estructurar su representación en formato de texto.
 * 
 * @author Luis
 * @author Ariel
 */
public class Horario {

	/**
	 * Día asociado al horario.
	 */
	private Dia dia;

	/**
	 * Delimitador utilizado para separar los datos en formato String.
	 */
    private char delimiter;

    /**
     * Constructor que inicializa el día y el delimitador.
     * 
     * @param dia Día asignado al horario
     * @param delimiter Carácter delimitador
     */
	public Horario(Dia dia, char delimiter) {
		super();
		this.dia = dia;
		this.delimiter = delimiter;
	}

	/**
	 * Obtiene el día del horario.
	 * 
	 * @return día
	 */
	public Dia getDia() {
		return dia;
	}

	/**
	 * Establece el día del horario.
	 * 
	 * @param dia nuevo día
	 */
	public void setDia(Dia dia) {
		this.dia = dia;
	}

	/**
	 * Obtiene el delimitador.
	 * 
	 * @return delimitador
	 */
	public char getDelimiter() {
		return delimiter;
	}

	/**
	 * Establece el delimitador.
	 * 
	 * @param delimiter nuevo delimitador
	 */
	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * Retorna una representación en cadena del horario.
	 * 
	 * @return datos del horario en formato String
	 */
	@Override
	public String toString() {
		return dia + "" + delimiter;
	}
    
}