package dominio;

import java.util.ArrayList;
import java.util.List;

import decorator.PlaylistComponente;

public class Playlist implements PlaylistComponente {

	private String nombre;
	private List<Contenido> contenidos;

	public Playlist(String nombre) {
		this.nombre = nombre;
		this.contenidos = new ArrayList<Contenido>();
	}

	public void agregar(Contenido c) {
		contenidos.add(c);
	}

	public int tamano() {
		return contenidos.size();
	}

	@Override
	public List<Contenido> obtenerLista() {
		List<Contenido> copia = new ArrayList<Contenido>();
		for (Contenido c : contenidos) copia.add(c);
		return copia;
	}

	@Override
	public String descripcion() {
		return nombre;
	}
}
