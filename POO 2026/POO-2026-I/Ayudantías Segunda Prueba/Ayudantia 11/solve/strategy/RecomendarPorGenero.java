package strategy;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;

public class RecomendarPorGenero implements EstrategiaRecomendacion {

	private String genero;
	private int cantidad;

	public RecomendarPorGenero(String genero, int cantidad) {
		this.genero = genero;
		this.cantidad = cantidad;
	}

	@Override
	public List<Contenido> recomendar(List<Contenido> catalogo) {
		List<Contenido> res = new ArrayList<Contenido>();
		for (Contenido c : catalogo) {
			if (c.getGenero().equalsIgnoreCase(genero)) {
				res.add(c);
				if (res.size() >= cantidad) return res;
			}
		}
		return res;
	}
}
