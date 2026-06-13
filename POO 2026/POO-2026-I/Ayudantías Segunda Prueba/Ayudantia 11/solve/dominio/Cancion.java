package dominio;

import visitor.VisitorContenido;

public class Cancion extends Contenido {

	public Cancion(String titulo, String artista, String genero, int duracion, int rating, boolean explicito) {
		super(titulo, artista, genero, duracion, rating, explicito);
	}

	@Override
	public String mostrar() {
		String marca = "";
		if (isExplicito()) marca = " [E]";
		return "[cancion] " + getTitulo() + " - " + getArtista() + " | " + getGenero() + " | rating: " + getRating() + " | " + getDuracion() + " seg" + marca;
	}

	@Override
	public void aceptar(VisitorContenido v) {
		v.visitar(this);
	}
}
