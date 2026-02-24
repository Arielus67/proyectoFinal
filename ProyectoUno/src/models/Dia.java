package models;

/**
 * La clase Dia representa un día dentro de un horario,
 * incluyendo el rango de horas disponibles.
 * 
 * Contiene información sobre:
 * el nombre del día, la hora de inicio (desde),
 * la hora de finalización (hasta) y un delimitador
 * para estructurar los datos en formato de texto.
 * 
 * @author Luis
 * @author Ariel
 */
public class Dia {

	/**
	 * Nombre del día.
	 */
	private String dia;

	/**
	 * Hora de inicio del horario.
	 */
	private int desde;

	/**
	 * Hora de finalización del horario.
	 */
	private int hasta;

	/**
	 * Delimitador utilizado para separar los datos en formato String.
	 */
	private char delimiter;

	/**
	 * Constructor que inicializa los atributos del día.
	 * 
	 * @param dia Nombre del día
	 * @param desde Hora de inicio
	 * @param hasta Hora de finalización
	 * @param delimiter Carácter delimitador
	 */
	public Dia(String dia, int desde, int hasta, char delimiter) {
		super();
		this.dia = dia;
		this.desde = desde;
		this.hasta = hasta;
		this.delimiter = delimiter;
	}

	/**
	 * Obtiene el nombre del día.
	 * 
	 * @return nombre del día
	 */
	public String getDia() {
		return dia;
	}

	/**
	 * Establece el nombre del día.
	 * 
	 * @param dia nuevo nombre del día
	 */
	public void setDia(String dia) {
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
	 * Obtiene la hora de inicio.
	 * 
	 * @return hora desde
	 */
	public int getDesde() {
		return desde;
	}

	/**
	 * Establece la hora de inicio.
	 * 
	 * @param desde nueva hora de inicio
	 */
	public void setDesde(int desde) {
		this.desde = desde;
	}

	/**
	 * Obtiene la hora de finalización.
	 * 
	 * @return hora hasta
	 */
	public int getHasta() {
		return hasta;
	}

	/**
	 * Establece la hora de finalización.
	 * 
	 * @param hasta nueva hora de finalización
	 */
	public void setHasta(int hasta) {
		this.hasta = hasta;
	}

	/**
	 * Retorna una representación en cadena del día
	 * incluyendo el rango horario.
	 * 
	 * @return datos del día en formato String
	 */
	@Override
	public String toString() {
		return dia + ""+delimiter + desde + ""+delimiter+ hasta+"";
	}
}