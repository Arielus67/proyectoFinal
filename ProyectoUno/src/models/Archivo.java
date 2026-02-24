package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La clase Archivo permite gestionar operaciones básicas
 * de almacenamiento en archivos de texto.
 * 
 * Proporciona funcionalidades como:
 * crear archivos, agregar datos, leer contenido,
 * eliminar registros, actualizar información
 * y validar existencia de datos.
 * 
 * Utiliza un delimitador para estructurar la información.
 * 
 * @author Luis
 * @author Ariel
 */
public class Archivo {

	/**
	 * Nombre del archivo.
	 */
	private String name;

	/**
	 * Delimitador utilizado para separar los datos.
	 */
	private char delimiter;

	/**
	 * Referencia al archivo físico.
	 */
	private File file;

	/**
	 * Constructor que inicializa el archivo.
	 * 
	 * @param name Nombre del archivo
	 * @param delimiter Delimitador utilizado
	 */
	public Archivo(String name, char delimiter) {
		this.name = name;
		this.delimiter = delimiter;
		this.file = new File(name);
	}

	/**
	 * Crea el archivo si no existe.
	 * 
	 * @return true si se creó correctamente
	 * @throws IOException error de acceso
	 */
	public boolean createFile() throws IOException {
		return file.createNewFile();
	}

	/**
	 * Agrega una nueva línea de datos al archivo.
	 * 
	 * @param data información a guardar
	 * @throws IOException error de escritura
	 */
	public void add(String data) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bw.write(data);
		bw.newLine();
		bw.close();
	}

	/**
	 * Obtiene todo el contenido del archivo.
	 * 
	 * @return contenido completo
	 * @throws IOException error de lectura
	 */
	public String getData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String list = "";
		String line;
		while ((line = br.readLine()) != null) {
			list += line + "\n";
		}
		br.close();
		return list;
	}

	/**
	 * Elimina un registro basado en su identificador.
	 * 
	 * @param id identificador del registro
	 * @throws IOException error de acceso
	 */
	public void delete(String id) throws IOException {
		StringBuilder contenido = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String linea;
		while ((linea = br.readLine()) != null) {
			contenido.append(linea).append("\n");
		}
		br.close();
		String[] lineas = contenido.toString().split("\n");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		for (String l : lineas) {
			if (!l.startsWith(id)) {
				bw.write(l);
				bw.newLine();
			}
		}
		bw.close();
	}

	/**
	 * Actualiza un registro basado en su identificador.
	 * 
	 * @param id identificador del registro
	 * @param data nueva información
	 * @throws IOException error de acceso
	 */
	public void update(String id, String data) throws IOException {
		StringBuilder contenido = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String linea;
		while ((linea = br.readLine()) != null) {
			contenido.append(linea).append("\n");
		}
		br.close();
		String[] lineas = contenido.toString().split("\n");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		for (String l : lineas) {
			if (l.startsWith(id))
				bw.write(data);
			else
				bw.write(l);
			bw.newLine();
		}
		bw.close();
	}

	/**
	 * Obtiene un registro por su identificador.
	 * 
	 * @param id identificador
	 * @return línea encontrada o null
	 * @throws IOException error de lectura
	 */
	public String getById(String id) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String linea;
		while ((linea = br.readLine()) != null) {
			if (linea.startsWith(id))
				return linea;
		}
		br.close();
		return null;
	}

	/**
	 * Verifica si un identificador ya existe.
	 * 
	 * @param id identificador a validar
	 * @return true si ya existe
	 * @throws IOException error de lectura
	 */
	public boolean dontRepeat(String id) throws IOException {

		id = id.trim();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(String.valueOf(delimiter));

				if (datos.length > 0 && datos[0].trim().equals(id)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Verifica si ya existe una cita en la misma fecha y hora.
	 * 
	 * @param id identificador del médico
	 * @param hora hora de la cita
	 * @param dias día
	 * @param mes mes
	 * @return true si ya existe
	 * @throws IOException error de lectura
	 */
	public boolean dontRepeatCita(String id, int hora, String dias, String mes) throws IOException {

		id = id.trim();
		dias = dias.trim();
		mes = mes.trim();
		String horas = hora + "";

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(String.valueOf(delimiter));

				if (datos.length > 0 && datos[1].trim().equals(id) && datos[7].trim().equals(horas)
						&& datos[8].trim().equals(dias) && datos[9].trim().equals(mes)) {

					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Verifica si un médico trabaja un día específico.
	 * 
	 * @param cedula identificador del médico
	 * @param diaBuscado día a verificar
	 * @return true si trabaja ese día
	 * @throws IOException error de lectura
	 */
	public boolean medicoTrabajaEseDia(String cedula, String diaBuscado) throws IOException {

	    diaBuscado = diaBuscado.trim().toLowerCase();

	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

	        String linea;

	        while ((linea = br.readLine()) != null) {

	            String[] datos = linea.split(",");

	            if (datos.length > 5) {

	                String ced = datos[0].trim();

	                if (ced.equals(cedula)) {

	                    String diasCampo = datos[5].trim();

	                    String[] diasSeparados = diasCampo.split("-");

	                    for (int i = 0; i < diasSeparados.length; i++) {

	                        String dia = diasSeparados[i].trim();

	                        if (!dia.isEmpty() && dia.equals(diaBuscado)) {
	                            return true;
	                        }
	                    }
	                }
	            }
	        }
	    }

	    return false;
	}
}