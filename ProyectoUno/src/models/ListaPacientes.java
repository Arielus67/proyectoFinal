package models;

import java.io.*;
import java.util.ArrayList;

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
	
	public Paciente buscarPaciente(String identificacion) {

		File archivo = new File("pacientes.txt");

		try {
			if (!archivo.exists()) {
				return null;
			}

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");

				if (datos[0].equals(identificacion)) {

					String nombre = datos[1];
					int edad = Integer.parseInt(datos[2]);
					char sexo = datos[3].charAt(0);
					String contacto = datos[4];
					String nombreEnfermedad = datos[5];
					int gravedad = Integer.parseInt(datos[6]);

					Enfermedad en = new Enfermedad(nombreEnfermedad, gravedad);
					Paciente p = new Paciente(nombre, edad, sexo, identificacion, contacto, en);

					br.close();
					return p;
				}
			}

			br.close();

		} catch (IOException e) {
			System.out.println("Error al buscar paciente.");
		}

		return null;
	}

	public ArrayList<Paciente> obtenerPacientes() {

	    ArrayList<Paciente> lista = new ArrayList<>();
	    File archivo = new File("pacientes.txt");

	    if (!archivo.exists()) {
	        return lista;
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

	        String linea;

	        while ((linea = br.readLine()) != null) {

	            String[] datos = linea.split(";");

	            if (datos.length < 7) continue;

	            Enfermedad en = new Enfermedad(
	                datos[5],
	                Integer.parseInt(datos[6])
	            );

	            Paciente p = new Paciente(
	                datos[1],                       // nombre
	                Integer.parseInt(datos[2]),     // edad
	                datos[3].charAt(0),             // sexo
	                datos[0],                       // identificacion
	                datos[4],                       // contacto
	                en
	            );

	            lista.add(p);
	        }

	    } catch (Exception e) {
	        System.out.println("Error al leer pacientes.");
	        e.printStackTrace();
	    }

	    return lista;
	}

	public String[] getColumnsPacinetes() {
		return new String[] {"Nombre","Edad","Sexo","Identificacion","Contacto","Enfermedad","Gravedad"};
	}
	
	public Object[][] getDatosPacientes() {

		File archivo = new File("pacientes.txt");

		if (!archivo.exists()) {
			return new Object[0][getColumnsPacinetes().length];
		}

		int filas = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			while (br.readLine() != null) {
				filas++;
			}
		} catch (IOException e) {
			System.out.println("Error al contar pacientes");
		}

		Object[][] data = new Object[filas][getColumnsPacinetes().length];

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

			String linea;
			int i = 0;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");

				data[i][0] = datos[1]; // Nombre
				data[i][1] = Integer.parseInt(datos[2]); // Edad
				data[i][2] = datos[3]; // Sexo
				data[i][3] = datos[3]; // Identificacion
				data[i][4] = datos[4]; // Contacto
				data[i][5] = datos[5]; // Enfermedad
				data[i][6] = Integer.parseInt(datos[6]); // Gravedad

				i++;
			}

		} catch (IOException e) {
			System.out.println("Error al leer pacientes");
		}

		return data;
	}
}
