package modelo;

import java.time.LocalDate;

public class Partido {
	// Atributos
	private String equipoLocal;
	private String equipoVisitante;
	private int golesLocal;
	private int golesVisitante;
	private String lugar;
	private String fecha;

	// Constructor
	public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante, String lugar,
			String fecha) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.lugar = lugar;
		this.fecha = fecha;
	}

	// Getters y Setters
	public String getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	// Método para imprimir los detalles del partido
	@Override
	public String toString() {
		return "Partido entre " + equipoLocal + " y " + equipoVisitante + "\n" + "Goles " + equipoLocal + ": "
				+ golesLocal + " | Goles " + equipoVisitante + ": " + golesVisitante + "\n" + "Lugar: " + lugar
				+ "\nFecha: " + fecha;
	}
}
