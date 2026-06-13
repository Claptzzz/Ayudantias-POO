package observer;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;

public class HistorialReproduccion implements ObservadorReproduccion {

	private List<Contenido> historial;

	public HistorialReproduccion() {
		historial = new ArrayList<Contenido>();
	}

	@Override
	public void alReproducir(Contenido c) {
		historial.add(c);
	}

	public void imprimir() {
		if (historial.isEmpty()) {
			System.out.println("Sin reproducciones aun.");
			return;
		}
		System.out.println("=== Historial ===");
		for (int i = 0; i < historial.size(); i++) {
			Contenido c = historial.get(i);
			System.out.println((i + 1) + ". " + c.getTitulo() + " - " + c.getArtista());
		}
	}
}
