package Visitor;

import Dominio.Pelicula;
import Dominio.Serie;

public class VisitorRating implements IVisitor {
	private static double ratingPeli = 0;
	private static int conteoPeli = 0;
	
	private static double ratingSerie = 0;
	private static int conteoSerie = 0;

	@Override
	public void visit(Pelicula p) {
		ratingPeli += p.getRating();
		conteoPeli++;
	}

	@Override
	public void visit(Serie s) {
		ratingSerie += s.getRating();
		conteoSerie++; 
	}

	@Override
	public String verResultados() {
		
		return "Promedio rating peliculas: " + (ratingPeli / conteoPeli) 
				+ "\nPromedio rating series: " + (ratingSerie / conteoSerie);
	}

}
