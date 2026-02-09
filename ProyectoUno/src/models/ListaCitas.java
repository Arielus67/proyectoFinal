package models;

import java.io.*;
import java.util.ArrayList;

public class ListaCitas {

    private final String ARCHIVO = "citas.txt";

    
    public boolean agregarCita(Cita cita) {

        try {
            File archivo = new File(ARCHIVO);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));

            Paciente p = cita.getPaciente();
            Medico m = cita.getMedico();

            bw.write(
                p.getIdentificacion() + ";" +
                p.getNombre() + ";" +
                p.getEdad() + ";" +
                p.getSexo() + ";" +
                p.getContacto() + ";" +
                p.getEnfermedad().getNombreEnfermedad() + ";" +
                p.getEnfermedad().getGravedad() + ";" +
                m.getNombre() + ";" +
                m.getEdad() + ";" +
                m.getSexo() + ";" +
                m.getCodigo() + ";" +
                m.getEspecialidad()
            );

            bw.newLine();
            bw.close();
            return true;

        } catch (IOException e) {
            System.out.println("Error al guardar la cita.");
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<Cita> obtenerCitas() {

        ArrayList<Cita> lista = new ArrayList<>();
        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] d = linea.split(";");

                
                if (d.length < 12) continue;

                Enfermedad en = new Enfermedad(
                    d[5],
                    Integer.parseInt(d[6])
                );

                Paciente p = new Paciente(
                    d[1],
                    Integer.parseInt(d[2]),
                    d[3].charAt(0),
                    d[0],
                    d[4],
                    en
                );

                Medico m = new Medico(
                    d[7],
                    Integer.parseInt(d[8]),
                    d[9].charAt(0),
                    d[10],
                    d[11]
                );

                Cita c = new Cita(p, m);
                lista.add(c);
            }

        } catch (Exception e) {
            System.out.println("Error al leer citas.");
            e.printStackTrace();
        }

        return lista;
    }
}
