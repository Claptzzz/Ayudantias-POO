package dominio;

import visitor.VisitorContenido;

public class Podcast extends Contenido {

	public Podcast(String titulo, String artista, String genero, int duracion, int rating, boolean explicito) {
		super(titulo, artista, genero, duracion, rating, explicito);
	}

	@Override
	public String mostrar() {
		String marca = "";
		if (isExplicito()) marca = " [E]";
		return "[podcast] " + getTitulo() + " - " + getArtista() + " | " + getGenero() + " | rating: " + getRating() + " | " + getDuracion() + " episodios" + marca;
	}

	@Override
	public void aceptar(VisitorContenido v) {
		v.visitar(this);
	}
}
