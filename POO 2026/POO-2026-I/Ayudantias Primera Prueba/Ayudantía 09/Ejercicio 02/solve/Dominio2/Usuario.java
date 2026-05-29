package Dominio2;

public class Usuario {
    private final String nombre;
    private final String comentario;
    private final boolean sigueCuenta;

    public Usuario(String nombre, String comentario, boolean sigueCuenta) {
        this.nombre = nombre;
        this.comentario = comentario;
        this.sigueCuenta = sigueCuenta;
    }

    public String getNombre() {
        return nombre;
    }
    public String getComentario() {
        return comentario;
    }
    public boolean isSigueCuenta() {
        return sigueCuenta;
    }

}