package decorator;

import java.util.List;

import dominio.Contenido;

public interface PlaylistComponente {
	List<Contenido> obtenerLista();
	String descripcion();
}
