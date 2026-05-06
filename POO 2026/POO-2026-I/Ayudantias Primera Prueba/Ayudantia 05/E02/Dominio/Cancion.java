package Dominio;

public class Cancion {
	private String nombre;
	private String artista;
	private int segundos;
	private int pos;
	private String fecha;
	
	public Cancion(String nombre, String artista, int segundos, int pos, String fecha) {
		this.nombre = nombre;
		this.artista = artista;
		this.segundos = segundos;
		this.pos = pos;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getArtista() {
		return artista;
	}

	public int getSegundos() {
		return segundos;
	}

	public int getPos() {
		return pos;
	}

	public String getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return nombre + " - " + artista;
	}

}
