package Modelo;

public class CD {

	private int id;
	private String titulo;
	private String artista;
	private String pais;
	private String sello;
	private double precio;
	private int año;

	public CD(int id, String titulo, String artista, String pais, String sello, double precio, int año) {
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.pais = pais;
		this.sello = sello;
		this.precio = precio;
		this.año = año;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSello() {
		return sello;
	}

	public void setSello(String sello) {
		this.sello = sello;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	@Override
	public String toString() {
		return "CD: " + id + "\n" +
				" Título: " + titulo + "\n" +
				" Artista: " + artista + "\n" +
				" País: " + pais + "\n" +
				" Sello: " + sello + "\n" +
				" Precio: " + precio + "\n" +
				" Año: " + año + "\n" +
				"************************";
	}

	
}
