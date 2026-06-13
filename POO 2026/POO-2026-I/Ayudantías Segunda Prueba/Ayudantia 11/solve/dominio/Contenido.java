package dominio;

import visitor.VisitorContenido;

public abstract class Contenido {

	private String titulo;
	private String artista;
	private String genero;
	private int duracion;
	private int rating;
	private boolean explicito;

	public Contenido(String titulo, String artista, String genero, int duracion, int rating, boolean explicito) {
		this.titulo = titulo;
		this.artista = artista;
		this.genero = genero;
		this.duracion = duracion;
		this.rating = rating;
		this.explicito = explicito;
	}

	public abstract String mostrar();

	public abstract void aceptar(VisitorContenido v);

	public String getTitulo() { return titulo; }
	public String getArtista() { return artista; }
	public String getGenero() { return genero; }
	public int getDuracion() { return duracion; }
	public int getRating() { return rating; }
	public boolean isExplicito() { return explicito; }
}
