package models;

import java.io.*;

public class ListaPacientes {

	public boolean agregarPaciente(Paciente paciente) {

		try {
			File archivo = new File("pacientes.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
			escritor.write(paciente.getIdentificacion() + ";" + paciente.getNombre() + ";" + paciente.getEdad() + ";"
					+ paciente.getSexo() + ";" + paciente.getContacto() + ";" + paciente.getEnfermedad().getNombreEnfermedad()+";"+
					paciente.getEnfermedad().getGravedad());
			escritor.newLine();
			escritor.close();
			return true;

		} catch (IOException e) {
			System.out.println("Error al guardar el paciente.");
		}
		return false;
	}

	public void eliminarPaciente(String identificacion) {

		File archivo = new File("pacientes.txt");
		File archivoTemp = new File("pacientes_temp.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp));

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");

				if (!datos[0].equals(identificacion)) {
					bw.write(linea);
					bw.newLine();
				}
			}

			br.close();
			bw.close();

			archivo.delete();
			archivoTemp.renameTo(archivo);

		} catch (IOException e) {
			System.out.println("Error al eliminar paciente.");
		}
	}

	public void editarPaciente(Paciente pacienteActualizado) {

		File archivo = new File("pacientes.txt");
		File archivoTemp = new File("pacientes_temp.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemp));

			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");

				if (datos[0].equals(pacienteActualizado.getIdentificacion())) {

					bw.write(pacienteActualizado.getIdentificacion() + ";" + pacienteActualizado.getNombre() + ";"
							+ pacienteActualizado.getEdad() + ";" + pacienteActualizado.getSexo() + ";"
							+ pacienteActualizado.getContacto() + ";"
							+ pacienteActualizado.getEnfermedad().getNombreEnfermedad() + ";"
							+ pacienteActualizado.getEnfermedad().getGravedad());
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
			System.out.println("Error al editar paciente.");
		}
	}

}
