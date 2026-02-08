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
		File archivoTemp = new File("medico_temp.txt");

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
}
