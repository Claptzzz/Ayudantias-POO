package solve;
public class Cancion extends Contenido {
	
	

	public Cancion(String titulo, String artista, String genero, int duracion, int rating, boolean explicito) {
		super(titulo, artista, genero, duracion, rating, explicito);
	}

	public String mostrar() {
		String marca = "";
		if (explicito) marca = " [E]";
		return "[cancion] " + titulo + " - " + artista + " | " + genero + " | rating: " + rating + " | " + duracion + " seg" + marca;
	}
}
