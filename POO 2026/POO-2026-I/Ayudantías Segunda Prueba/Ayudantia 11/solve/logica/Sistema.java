package logica;

import java.io.IOException;

import decorator.PlaylistComponente;
import dominio.Playlist;
import strategy.EstrategiaRecomendacion;

public interface Sistema {

	void cargarCatalogo(String ruta) throws IOException;
	void importarAppleMusic(String ruta) throws IOException;
	void mostrarCatalogo();
	void reproducir(String titulo);
	void recomendar(EstrategiaRecomendacion estrategia);
	void mostrarEstadisticas();
	void crearPlaylist(String nombre);
	void agregarAPlaylist(String titulo);
	Playlist getPlaylistActiva();
	void reproducirPlaylist(PlaylistComponente p);
	void mostrarTrending(int topN);
	void mostrarHistorial();
}
