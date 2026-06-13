package observer;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;

public class ContadorArtista implements ObservadorReproduccion {

	private List<String> artistas;
	private List<Integer> conteos;

	public ContadorArtista() {
		artistas = new ArrayList<String>();
		conteos = new ArrayList<Integer>();
	}

	@Override
	public void alReproducir(Contenido c) {
		String a = c.getArtista();
		for (int i = 0; i < artistas.size(); i++) {
			if (artistas.get(i).equals(a)) {
				conteos.set(i, conteos.get(i) + 1);
				return;
			}
		}
		artistas.add(a);
		conteos.add(1);
	}

	public List<String> getArtistas() {
		return artistas;
	}

	public List<Integer> getConteos() {
		return conteos;
	}
}
