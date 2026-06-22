package Dominio;
import Strategy.Estrategia;
import Strategy.EstrategiaNeutral;

public class Jugador {

    private String nombre;

    private Estrategia estrategia;

    private int agresividad;
    private int defensividad;
    private int largoPlazo;

    private int tiempoTotal;

    private int jugadasAgresivas;
    private int jugadasDefensivas;
    private int jugadasNeutrales;

    private int piezasPerdidasSeguidas;
    private int jugadasSinComer;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.estrategia = new EstrategiaNeutral();
    }

    public String getNombre() {
        return nombre;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public int getAgresividad() {
        return agresividad;
    }

    public int getDefensividad() {
        return defensividad;
    }

    public int getLargoPlazo() {
        return largoPlazo;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void sumarAgresividad(int puntos) {
        agresividad += puntos;
    }

    public void sumarDefensividad(int puntos) {
        defensividad += puntos;
    }

    public void sumarLargoPlazo(int puntos) {
        largoPlazo += puntos;
    }

    public void sumarTiempo(int tiempo) {
        tiempoTotal += tiempo;
    }

    public int getJugadasAgresivas() {
        return jugadasAgresivas;
    }

    public int getJugadasDefensivas() {
        return jugadasDefensivas;
    }

    public int getJugadasNeutrales() {
        return jugadasNeutrales;
    }

    public void sumarJugadaAgresiva() {
        jugadasAgresivas++;
    }

    public void sumarJugadaDefensiva() {
        jugadasDefensivas++;
    }

    public void sumarJugadaNeutral() {
        jugadasNeutrales++;
    }

    public int getPiezasPerdidasSeguidas() {
        return piezasPerdidasSeguidas;
    }

    public void setPiezasPerdidasSeguidas(int piezasPerdidasSeguidas) {
        this.piezasPerdidasSeguidas = piezasPerdidasSeguidas;
    }

    public void aumentarPiezasPerdidasSeguidas() {
    	if (piezasPerdidasSeguidas == 2) {
    		return;
    	}
        piezasPerdidasSeguidas++;
    }

    public int getJugadasSinComer() {
        return jugadasSinComer;
    }

    public void setJugadasSinComer(int jugadasSinComer) {
        this.jugadasSinComer = jugadasSinComer;
    }

    public void aumentarJugadasSinComer() {
    	if (jugadasSinComer == 3) {
    		return;
    	}
        jugadasSinComer++;
    }
}
