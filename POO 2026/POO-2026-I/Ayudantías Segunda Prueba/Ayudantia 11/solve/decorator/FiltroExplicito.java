package decorator;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;

public class FiltroExplicito extends PlaylistDecorador {

	public FiltroExplicito(PlaylistComponente playlist) {
		super(playlist);
	}

	@Override
	public List<Contenido> obtenerLista() {
		List<Contenido> res = new ArrayList<Contenido>();
		for (Contenido c : playlist.obtenerLista()) {
			if (!c.isExplicito()) res.add(c);
		}
		return res;
	}

	@Override
	public String descripcion() {
		return playlist.descripcion() + " [sin explicito]";
	}
}
