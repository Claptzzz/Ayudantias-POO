package strategy;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;

public class RecomendarPorRating implements EstrategiaRecomendacion {

	private int cantidad;

	public RecomendarPorRating(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public List<Contenido> recomendar(List<Contenido> catalogo) {
		List<Contenido> copia = new ArrayList<Contenido>();
		for (Contenido c : catalogo) copia.add(c);

		for (int i = 0; i < copia.size(); i++) {
			for (int j = i + 1; j < copia.size(); j++) {
				if (copia.get(j).getRating() > copia.get(i).getRating()) {
					Contenido tmp = copia.get(i);
					copia.set(i, copia.get(j));
					copia.set(j, tmp);
				}
			}
		}

		List<Contenido> res = new ArrayList<Contenido>();
		int limite = cantidad;
		if (limite > copia.size()) limite = copia.size();
		for (int i = 0; i < limite; i++) res.add(copia.get(i));
		return res;
	}
}
