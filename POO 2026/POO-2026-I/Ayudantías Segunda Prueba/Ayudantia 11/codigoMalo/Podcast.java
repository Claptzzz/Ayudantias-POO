package solve;
public class Podcast extends Contenido {
	
	public Podcast(String titulo, String artista, String genero, int duracion, int rating, boolean explicito) {
		super(titulo, artista, genero, duracion, rating, explicito);
	}

	public String mostrar() {
		String marca = "";
		if (explicito) marca = " [E]";
		return "[podcast] " + titulo + " - " + artista + " | " + genero + " | rating: " + rating + " | " + duracion + " episodios" + marca;
	}
}
