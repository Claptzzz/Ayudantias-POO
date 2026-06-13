package visitor;

import dominio.Cancion;
import dominio.Podcast;

public interface VisitorContenido {
	void visitar(Cancion c);
	void visitar(Podcast p);
}
