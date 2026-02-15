package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {

	private String name;
	private char delimiter;
	private File file;

	public Archivo(String name, char delimiter) {
		this.name = name;
		this.delimiter = delimiter;
		this.file = new File(name);
	}

	public boolean createFile() throws IOException {
		return file.createNewFile();
	}

	public void add(String data) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bw.write(data);
		bw.newLine();
		bw.close();
	}

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

}
