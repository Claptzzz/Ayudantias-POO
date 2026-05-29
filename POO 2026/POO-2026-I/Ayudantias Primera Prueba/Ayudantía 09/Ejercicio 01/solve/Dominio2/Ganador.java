package Dominio2;

public class Ganador {
	private static Ganador instancia;
    private final Usuario ganador;

    private Ganador(Usuario ganador) {
    	this.ganador = ganador;
    }

    public static Ganador getInstancia(Usuario ganador) {
        if (instancia == null) {
            instancia = new Ganador(ganador);
        }
        return instancia;
    }

    public Usuario getGanador() {
        return ganador;
    }

}