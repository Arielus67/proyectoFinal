package models;

import java.io.*;
public class ListaMedicos {

	public boolean agregarMedico(Medico medico) {

		try {
			File archivo = new File("medicos.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
			escritor.write(medico.getCodigo() + ";" + medico.getNombre() + ";" + medico.getEdad() + ";"
					+ medico.getSexo() + ";" + medico.getEspecialidad());
			escritor.newLine();
			escritor.close();
			return true;

		} catch (IOException e) {
			System.out.println("Error al guardar el medico.");
		}
		return false;
	}

	public void eliminarMedico(String codigo) {

		File archivo = new File("medicos.txt");
		File archivoTemp = new File("medicos_temp.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp));

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");

				if (!datos[0].equals(codigo)) {
					bw.write(linea);
					bw.newLine();
				}
			}

			br.close();
			bw.close();

			archivo.delete();
			archivoTemp.renameTo(archivo);

		} catch (IOException e) {
			System.out.println("Error al eliminar medico.");
		}
	}

	public void editarMedico(Medico medicoActualizado) {

		File archivo = new File("medicos.txt");
		File archivoTemp = new File("medicos_temp.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp));

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");

				if (datos[0].equals(medicoActualizado.getCodigo())) {

					bw.write(medicoActualizado.getCodigo() + ";" + medicoActualizado.getNombre() + ";"
							+ medicoActualizado.getEdad() + ";" + medicoActualizado.getSexo() + ";"
							+ medicoActualizado.getEspecialidad());
					bw.newLine();

				} else {

					bw.write(linea);
					bw.newLine();
				}
			}

			br.close();
			bw.close();

			archivo.delete();
			archivoTemp.renameTo(archivo);

		} catch (IOException e) {
			System.out.println("Error al editar medico.");
		}
	}
	
	public Medico buscarMedico(String codigo) {

		File archivo = new File("medicos.txt");

		try {
			if (!archivo.exists()) {
				return null;
			}

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");

				if (datos[0].equals(codigo)) {

					String nombre = datos[1];
					int edad = Integer.parseInt(datos[2]);
					char sexo = datos[3].charAt(0);
					String especialidad = datos[4];

					Medico m = new Medico(nombre, edad, sexo, codigo, especialidad);
					br.close();
					return m;
				}
			}

			br.close();

		} catch (IOException e) {
			System.out.println("Error al buscar medico.");
		}

		return null;
	}

}
