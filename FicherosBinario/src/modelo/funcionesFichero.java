package modelo;

import java.io.*;
import java.util.ArrayList;
import modelo.Partido;

public class funcionesFichero {

	private static File fichero = new File("C:\\Users\\in2dm3-d\\Desktop\\Resultados.dat");

	public static ArrayList<Partido> leerFichero() {
		ArrayList<Partido> partidoArray = new ArrayList<>();
		String equipoLocal;
		String equipoVisitante;
		int golesLocal;
		int golesVisitante;
		String lugar;
		String fecha;

		try {
			FileInputStream fic = new FileInputStream(fichero); 
			DataInputStream dis = new DataInputStream(fic);

			while (fic.getChannel().position() < fic.getChannel().size()) {
				// Leer los datos del archivo
				equipoLocal = dis.readUTF();
				equipoVisitante = dis.readUTF();
				golesLocal = dis.readInt();
				golesVisitante = dis.readInt();
				lugar = dis.readUTF();
				fecha = dis.readUTF();

				// Crear el objeto Partido y añadirlo a la lista
				Partido partido = new Partido(equipoLocal, equipoVisitante, golesLocal, golesVisitante, lugar, fecha);
				partidoArray.add(partido);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // Archivo no encontrado
		} catch (IOException e) {
			e.printStackTrace(); // Error de I/O
		}

		return partidoArray;
	}

	public static void escribirFichero(ArrayList<Partido> partidoArray) {
		try {
			FileOutputStream fos = new FileOutputStream(fichero, true);
			DataOutputStream dos = new DataOutputStream(fos);

			for (Partido partido : partidoArray) {
				// Escribir los datos del objeto Partido en el archivo
				dos.writeUTF(partido.getEquipoLocal());
				dos.writeUTF(partido.getEquipoVisitante());
				dos.writeInt(partido.getGolesLocal());
				dos.writeInt(partido.getGolesVisitante());
				dos.writeUTF(partido.getLugar());
				dos.writeUTF(partido.getFecha());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace(); // Archivo no encontrado
		} catch (IOException e) {
			e.printStackTrace(); // Error de I/O
		}
		
	}

}
