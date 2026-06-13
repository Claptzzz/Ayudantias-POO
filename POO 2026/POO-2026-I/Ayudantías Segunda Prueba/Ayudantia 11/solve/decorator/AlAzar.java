package decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dominio.Contenido;

public class AlAzar extends PlaylistDecorador {

	public AlAzar(PlaylistComponente playlist) {
		super(playlist);
	}

	@Override
	public List<Contenido> obtenerLista() {
		List<Contenido> lista = new ArrayList<Contenido>();
		for (Contenido c : playlist.obtenerLista()) lista.add(c);
		Collections.shuffle(lista);
		return lista;
	}

	@Override
	public String descripcion() {
		return playlist.descripcion() + " [al azar]";
	}
}
