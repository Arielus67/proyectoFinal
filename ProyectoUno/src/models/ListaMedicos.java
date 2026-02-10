package models;

import java.io.*;
import java.util.ArrayList;
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

	public ArrayList<Medico> obtenerMedicos() {

	    ArrayList<Medico> lista = new ArrayList<>();
	    File archivo = new File("medicos.txt");

	    if (!archivo.exists()) {
	        return lista;
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

	        String linea;

	        while ((linea = br.readLine()) != null) {

	            String[] datos = linea.split(";");

	            if (datos.length < 5) continue;

	            Medico m = new Medico(
	                datos[1],                       // nombre
	                Integer.parseInt(datos[2]),     // edad
	                datos[3].charAt(0),             // sexo
	                datos[0],                       // codigo
	                datos[4]                        // especialidad
	            );

	            lista.add(m);
	        }

	    } catch (Exception e) {
	        System.out.println("Error al leer médicos.");
	        e.printStackTrace();
	    }

	    return lista;
	}
	
	public String[] getColumnsMedicos() {
		return new String[] { "Código", "Nombre", "Edad", "Sexo", "Especialidad" };
	}

	public Object[][] getDatosMedicos() {

		File archivo = new File("medicos.txt");

		if (!archivo.exists()) {
			return new Object[0][getColumnsMedicos().length];
		}

		int filas = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			while (br.readLine() != null) {
				filas++;
			}
		} catch (IOException e) {
			System.out.println("Error al contar médicos");
		}

		Object[][] data = new Object[filas][getColumnsMedicos().length];

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

			String linea;
			int i = 0;

			while ((linea = br.readLine()) != null) {

				String[] datos = linea.split(";");

				data[i][0] = datos[0]; // codigo
				data[i][1] = datos[1]; // nombre
				data[i][2] = Integer.parseInt(datos[2]); // edad
				data[i][3] = datos[3]; // sexo
				data[i][4] = datos[4]; // especialidad

				i++;
			}

		} catch (IOException e) {
			System.out.println("Error al leer médicos");
		}

		return data;
	}


}
