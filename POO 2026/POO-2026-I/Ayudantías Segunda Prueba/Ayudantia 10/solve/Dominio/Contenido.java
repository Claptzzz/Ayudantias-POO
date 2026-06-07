package Dominio;
import Visitor.*;

public abstract class Contenido {
	protected String nombre;
	protected String genero;
	protected double rating;
	
	public Contenido(String nombre, String genero, double rating) {
		this.nombre = nombre;
		this.genero = genero;
		this.rating = rating;
	}
	
	public abstract void aceptar(IVisitor v);

	public String getNombre() {
		return nombre;
	}

	public String getGenero() {
		return genero;
	}

	public double getRating() {
		return rating;
	}
	
}
