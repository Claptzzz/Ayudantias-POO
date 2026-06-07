package Strategy;

import java.util.List;

import Dominio.Contenido;

public class RatingEstrategia implements Recomendacion {

	@Override
	public List<Contenido> recomendar(List<Contenido> catalogo) {
		for (int i = 0; i < catalogo.size() - 1; i++) {
			for (int j = i + 1; j < catalogo.size(); j++) {
				if (catalogo.get(i).getRating() < catalogo.get(j).getRating()) {
					Contenido aux = catalogo.get(i);
					catalogo.set(i, catalogo.get(j));
					catalogo.set(j, aux);
				}
			}
		}
			
		return catalogo;
	}

	@Override
	public String verEstrategia() {
		return "El catálogo se actualizó por rating";
	}

}
