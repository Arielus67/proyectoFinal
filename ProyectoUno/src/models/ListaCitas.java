package models;

import java.io.*;
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
}
