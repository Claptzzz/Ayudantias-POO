package strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dominio.Contenido;

public class RecomendarAleatoria implements EstrategiaRecomendacion {

	private int cantidad;

	public RecomendarAleatoria(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public List<Contenido> recomendar(List<Contenido> catalogo) {
		List<Contenido> copia = new ArrayList<Contenido>();
		for (Contenido c : catalogo) copia.add(c);
		Collections.shuffle(copia);

		List<Contenido> res = new ArrayList<Contenido>();
		int limite = cantidad;
		if (limite > copia.size()) limite = copia.size();
		for (int i = 0; i < limite; i++) res.add(copia.get(i));
		return res;
	}
}
