package decorator;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;

public class SoloFavoritas extends PlaylistDecorador {

	public SoloFavoritas(PlaylistComponente playlist) {
		super(playlist);
	}

	@Override
	public List<Contenido> obtenerLista() {
		List<Contenido> res = new ArrayList<Contenido>();
		for (Contenido c : playlist.obtenerLista()) {
			if (c.getRating() >= 4) res.add(c);
		}
		return res;
	}

	@Override
	public String descripcion() {
		return playlist.descripcion() + " [solo favoritas]";
	}
}
