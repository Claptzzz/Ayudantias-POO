package adapter;

public class ContenidoApple {

	private String etiqueta;
	private String titulo;
	private String artista;
	private String categoria;
	private double minutos;
	private double estrellas;
	private String explicito;

	public ContenidoApple(String etiqueta, String titulo, String artista, String categoria, double minutos, double estrellas, String explicito) {
		this.etiqueta = etiqueta;
		this.titulo = titulo;
		this.artista = artista;
		this.categoria = categoria;
		this.minutos = minutos;
		this.estrellas = estrellas;
		this.explicito = explicito;
	}

	public String getEtiqueta() { return etiqueta; }
	public String getTitulo() { return titulo; }
	public String getArtista() { return artista; }
	public String getCategoria() { return categoria; }
	public double getMinutos() { return minutos; }
	public double getEstrellas() { return estrellas; }
	public String getExplicito() { return explicito; }
}
