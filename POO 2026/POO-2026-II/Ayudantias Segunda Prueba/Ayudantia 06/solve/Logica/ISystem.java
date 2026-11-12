package Logica;

public interface ISystem {

	void crearPlanta(String tipo, String nombre, String costo, String recarga, String parametro, String extra);

	String verAlmanaque();

	String verFicha(String planta);

	String plantar(String planta);

	String simularTurno();

	String verEstadisticas();

}
