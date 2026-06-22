package Dominio;

public class Jugada {

    private String nombreJugador;
    private String posicion;
    private String piezaMovida;
    private boolean comePieza;
    private String piezaComida;
    private int tiempo;

    public Jugada(String nombreJugador, String posicion, String piezaMovida, boolean comePieza, String piezaComida, int tiempo){
        this.nombreJugador = nombreJugador;
        this.posicion = posicion;
        this.piezaMovida = piezaMovida;
        this.comePieza = comePieza;
        this.piezaComida = piezaComida;
        this.tiempo = tiempo;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getPiezaMovida() {
        return piezaMovida;
    }

    public boolean isComePieza() {
        return comePieza;
    }

    public String getPiezaComida() {
        return piezaComida;
    }

    public int getTiempo() {
        return tiempo;
    }

    @Override
    public String toString() {
        return nombreJugador + " " + piezaMovida +
                " -> " + posicion;
    }
}