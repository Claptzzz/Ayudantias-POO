package solve;
public class Contenido {
	public String titulo;
	public String artista;
	public String genero;
	public int duracion;
	public int rating;
	public boolean explicito;
	
	public Contenido(String titulo, String artista, String genero, int duracion, int rating, boolean explicito) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.genero = genero;
		this.duracion = duracion;
		this.rating = rating;
		this.explicito = explicito;
	}



	public String mostrar() {
		return titulo + " - " + artista;
	}
}
