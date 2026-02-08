package models;

import java.io.*;
import java.util.ArrayList;
;

public class ListaCitas {

	public boolean agregarCita(Cita cita) {

		try {
			File archivo = new File("cita.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true));
			escritor.write(cita.getPaciente().getIdentificacion() + ";" + cita.getPaciente().getNombre()+";" + cita.getPaciente().getEnfermedad() + ";" +cita.getMedico().getCodigo() +  ";" + cita.getMedico().getNombre() + ";"
					+ cita.getMedico().getEspecialidad());
			escritor.newLine();
			escritor.close();
			return true;

		} catch (IOException e) {
			System.out.println("Error al guardar el paciente.");
		}
		return false;
	}
	public ArrayList<Paciente> obtenerPacientes() {

	    ArrayList<Paciente> lista = new ArrayList<>();
	    File archivo = new File("pacientes.txt");

	    try {
	        BufferedReader br = new BufferedReader(new FileReader(archivo));
	        String linea;

	        while ((linea = br.readLine()) != null) {

	            String[] datos = linea.split(";");

	            Enfermedad en = new Enfermedad(
	                    datos[5],
	                    Integer.parseInt(datos[6])
	            );

	            Paciente p = new Paciente(
	                    datos[1],
	                    Integer.parseInt(datos[2]),
	                    datos[3].charAt(0),
	                    datos[0],
	                    datos[4],
	                    en
	            );

	            lista.add(p);
	        }

	        br.close();

	    } catch (IOException e) {
	        System.out.println("Error al leer pacientes.");
	    }

	    return lista;
	}
	public ArrayList<Medico> obtenerMedicos() {

	    ArrayList<Medico> lista = new ArrayList<>();
	    File archivo = new File("medicos.txt");

	    try {
	        BufferedReader br = new BufferedReader(new FileReader(archivo));
	        String linea;

	        while ((linea = br.readLine()) != null) {

	            String[] datos = linea.split(";");


	            Medico m = new Medico(
	                    datos[1],
	                    Integer.parseInt(datos[2]),
	                    datos[3].charAt(0),
	                    datos[0],
	                    datos[4]
	                    
	            );

	            lista.add(m);
	        }

	        br.close();

	    } catch (IOException e) {
	        System.out.println("Error al leer medicos.");
	    }

	    return lista;
	}	
	public ArrayList<Cita> obtenerCitas() {

	    ArrayList<Cita> lista = new ArrayList<>();
	    File archivo = new File("Citas.txt");

	    try {
	        BufferedReader br = new BufferedReader(new FileReader(archivo));
	        String linea;

	        while ((linea = br.readLine()) != null) {

	            String[] datos = linea.split(";");

	            // ===== ENFERMEDAD =====
	            Enfermedad en = new Enfermedad(
	                datos[5],
	                Integer.parseInt(datos[6])
	            );

	            // ===== PACIENTE =====
	            Paciente p = new Paciente(
	                datos[1],                       // nombre
	                Integer.parseInt(datos[2]),     // edad
	                datos[3].charAt(0),             // sexo
	                datos[0],                       // identificacion
	                datos[4],                       // contacto
	                en
	            );

	            // ===== MEDICO =====
	            Medico m = new Medico(
	                datos[7],                       // nombre
	                Integer.parseInt(datos[8]),     // edad
	                datos[9].charAt(0),             // sexo
	                datos[10],                      // codigo
	                datos[11]                       // especialidad
	            );

	            // ===== CITA =====
	            Cita c = new Cita(p, m);
	            lista.add(c);
	        }

	        br.close();

	    } catch (IOException e) {
	        System.out.println("Error al leer citas.");
	    }

	    return lista;
	}


}
