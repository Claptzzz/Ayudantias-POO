package strategy;

import java.util.List;

import dominio.Contenido;

public interface EstrategiaRecomendacion {
	List<Contenido> recomendar(List<Contenido> catalogo);
}
