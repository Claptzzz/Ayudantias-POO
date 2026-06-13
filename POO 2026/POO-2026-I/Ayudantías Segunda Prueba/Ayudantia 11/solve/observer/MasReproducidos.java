package observer;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;

public class MasReproducidos implements ObservadorReproduccion {

	private List<String> titulos;
	private List<Integer> conteos;

	public MasReproducidos() {
		titulos = new ArrayList<String>();
		conteos = new ArrayList<Integer>();
	}

	@Override
	public void alReproducir(Contenido c) {
		String t = c.getTitulo();
		for (int i = 0; i < titulos.size(); i++) {
			if (titulos.get(i).equals(t)) {
				conteos.set(i, conteos.get(i) + 1);
				return;
			}
		}
		titulos.add(t);
		conteos.add(1);
	}

	public void imprimirTrending(int topN) {
		if (titulos.isEmpty()) {
			System.out.println("(aun no hay reproducciones)");
			return;
		}

		List<String> tt = new ArrayList<String>();
		List<Integer> cc = new ArrayList<Integer>();
		for (int i = 0; i < titulos.size(); i++) {
			tt.add(titulos.get(i));
			cc.add(conteos.get(i));
		}

		for (int i = 0; i < tt.size(); i++) {
			for (int j = i + 1; j < tt.size(); j++) {
				if (cc.get(j) > cc.get(i)) {
					int tmpC = cc.get(i);
					cc.set(i, cc.get(j));
					cc.set(j, tmpC);
					String tmpT = tt.get(i);
					tt.set(i, tt.get(j));
					tt.set(j, tmpT);
				}
			}
		}

		System.out.println("=== Trending ===");
		int limite = topN;
		if (limite > tt.size()) limite = tt.size();
		for (int i = 0; i < limite; i++) {
			System.out.println("  " + tt.get(i) + ": " + cc.get(i) + " reproducciones");
		}
	}
}
