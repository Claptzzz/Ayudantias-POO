package dominio;

public class ContenidoFactory {

	public static Contenido crear(String tipo, String titulo, String artista, String genero, int duracion, int rating, boolean explicito) {
		if (tipo.equalsIgnoreCase("cancion")) return new Cancion(titulo, artista, genero, duracion, rating, explicito);
		if (tipo.equalsIgnoreCase("podcast")) return new Podcast(titulo, artista, genero, duracion, rating, explicito);
		return null;
	}

	public static Contenido desdeLineaCatalogo(String linea) {
		String[] p = linea.split(";");
		String tipo = p[0];
		String titulo = p[1];
		String artista = p[2];
		String genero = p[3];
		int duracion = Integer.parseInt(p[4]);
		int rating = Integer.parseInt(p[5]);
		boolean explicito = p[6].equals("true");
		return crear(tipo, titulo, artista, genero, duracion, rating, explicito);
	}
}
