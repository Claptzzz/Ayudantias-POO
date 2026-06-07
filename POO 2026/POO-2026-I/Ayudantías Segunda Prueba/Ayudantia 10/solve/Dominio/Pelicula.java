package Dominio;

import Visitor.IVisitor;

public class Pelicula extends Contenido {
	protected int minutos;

	public Pelicula(String nombre, String genero, double rating, int minutos) {
		super(nombre, genero, rating);
		this.minutos = minutos;
	}

	public int getMinutos() {
		return minutos;
	}

	@Override
	public String toString() {
		return "Película: " + this.nombre + "\nGénero: " + this.genero
				+ "\nMinutos: " + this.minutos + "\nRating: " + this.rating;
	}

	@Override
	public void aceptar(IVisitor v) {
		v.visit(this);	
	}
	
	
}
