package Dominio2;

public class UsuarioFactory {
	
	public static Usuario crearUsuario(String nombre, String comentario, String sigueCuenta) {
		if (sigueCuenta.equals("si")) {
			return new Usuario(nombre, comentario, true);
		} else if (sigueCuenta.equals("no")) {
			return new Usuario(nombre, comentario, false);
		}
		return new Usuario(nombre, comentario, false);
    }

}