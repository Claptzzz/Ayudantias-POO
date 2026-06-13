package decorator;

import java.util.List;

import dominio.Contenido;

public abstract class PlaylistDecorador implements PlaylistComponente {

	protected PlaylistComponente playlist;

	public PlaylistDecorador(PlaylistComponente playlist) {
		this.playlist = playlist;
	}

	@Override
	public List<Contenido> obtenerLista() {
		return playlist.obtenerLista();
	}

	@Override
	public String descripcion() {
		return playlist.descripcion();
	}
}
