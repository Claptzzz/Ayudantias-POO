package Logica;

public interface ISystem {

	void crearObjeto(String tipo, String nombre, String genero, int duracion, double rating);

	void verCatalogo();
	
	String recomendaciones(String opcion);

	String estadisticas(String opcion);

}
