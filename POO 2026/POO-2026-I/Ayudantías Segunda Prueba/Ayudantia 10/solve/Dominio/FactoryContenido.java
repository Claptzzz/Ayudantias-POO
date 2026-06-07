package Dominio;

public class FactoryContenido {
	public static Contenido crearObjeto(String tipo, String nombre, String genero, int duracion, double rating) {
		if (tipo.equalsIgnoreCase("Pelicula")) return new Pelicula(nombre, genero, rating, duracion);
		if (tipo.equalsIgnoreCase("Serie")) return new Serie(nombre, genero, rating, duracion);
		
		return null;
	}
}
