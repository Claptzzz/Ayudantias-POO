
package Dominio;

import Visitor.IVisitor;

public class Serie extends Contenido {
	protected int cantidadEpisodios;
	
	public Serie(String nombre, String genero, double rating, int cantidadEpisodios) {
		super(nombre, genero, rating);
		this.cantidadEpisodios = cantidadEpisodios;
	}

	public int getCantidadEpisodios() {
		return cantidadEpisodios;
	}
	
	@Override
	public String toString() {
		return "Serie: " + this.nombre + "\nGénero: " + this.genero
				+ "\nCantidad de episodios: " + this.cantidadEpisodios + "\nRating: " + this.rating;
	}

	@Override
	public void aceptar(IVisitor v) {
		v.visit(this);
	}
	
}
