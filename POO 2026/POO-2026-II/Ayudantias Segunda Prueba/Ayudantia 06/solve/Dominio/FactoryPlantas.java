package Dominio;

public class FactoryPlantas {
	
	public static Planta crearPlanta(String tipo, String nombre, String costo, String recarga, String parametro, String extra) {
		
		switch (tipo) {
			case "productora":
				return new Productora(nombre, Integer.parseInt(costo), Integer.parseInt(recarga), Integer.parseInt(parametro), Integer.parseInt(extra));
				
			case "ataque":
				return new Ataque(nombre, Integer.parseInt(costo), Integer.parseInt(recarga), Integer.parseInt(parametro), extra);
				
			case "defensa":
				return new Defensa(nombre, Integer.parseInt(costo), Integer.parseInt(recarga), Integer.parseInt(parametro), extra);
				
			case "unuso":
				return new UnUso(nombre, Integer.parseInt(costo), Integer.parseInt(recarga), Integer.parseInt(parametro), extra);
				
			default:
				return null;
		}
	}
	
}
