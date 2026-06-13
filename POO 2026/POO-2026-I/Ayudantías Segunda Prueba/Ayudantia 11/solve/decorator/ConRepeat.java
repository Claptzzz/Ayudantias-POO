package decorator;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;

public class ConRepeat extends PlaylistDecorador {

	private int veces;

	public ConRepeat(PlaylistComponente playlist, int veces) {
		super(playlist);
		this.veces = veces;
	}

	@Override
	public List<Contenido> obtenerLista() {
		List<Contenido> base = playlist.obtenerLista();
		List<Contenido> res = new ArrayList<Contenido>();
		for (int i = 0; i < veces; i++) {
			for (Contenido c : base) res.add(c);
		}
		return res;
	}

	@Override
	public String descripcion() {
		return playlist.descripcion() + " [x" + veces + "]";
	}
}
