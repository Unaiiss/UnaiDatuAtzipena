package Modelo;

public class Mensaje {

	private String emisor;
	private String destinatario;
	private String fecha;
	private String hora;
	private String asunto;
	private String contenido;

	public Mensaje(String emisor, String destinatario, String fecha, String hora, String asunto, String contenido) {
		this.emisor = emisor;
		this.destinatario = destinatario;
		this.fecha = fecha;
		this.hora = hora;
		this.asunto = asunto;
		this.contenido = contenido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Mensaje [fecha=" + fecha + ", hora=" + hora + ", destinatario=" + destinatario + ", emisor=" + emisor
				+ ", asunto=" + asunto + ", contenido=" + contenido + "]";
	}

}
