package Visitor;

import Dominio.Pelicula;
import Dominio.Serie;

public class VisitorDuracion implements IVisitor {
	private static double duracionPeli = 0;
	private static int conteoPeli = 0;
	
	private static double duracionSerie = 0;
	private static int conteoSerie = 0;

	@Override
	public void visit(Pelicula p) {
		duracionPeli += p.getMinutos();
		conteoPeli++;
	}

	@Override
	public void visit(Serie s) {
		duracionSerie += s.getCantidadEpisodios();
		conteoSerie++; 
	}

	@Override
	public String verResultados() {
		
		return "Promedio minutos de peliculas: " + (duracionPeli / conteoPeli) 
				+ "\nPromedio cantidad de episodios de series: " + (duracionSerie / conteoSerie);
	}

}
