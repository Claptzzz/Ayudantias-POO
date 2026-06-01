package Dominio;

public class CeluFactory {
	
	public static Celular crearCelular(String modelo, String color, String pais, int ventas, float rating) {
		if (modelo.equals("Samsung P67")) {
			return new Samsung(color, pais, ventas, rating);
		} else if (modelo.equals("iPhone 103")) {
			return new iPhone(color, pais, ventas, rating);
		}
		return null;
    }


}
