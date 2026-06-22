package Strategy;

import Dominio.Jugada;
import Dominio.Jugador;

public class EstrategiaNeutral implements Estrategia {

    @Override
    public void evaluar(Jugada jugada, Jugador jugador) {

        if(jugada.isComePieza()) {
            jugador.sumarLargoPlazo(3);
            jugador.sumarDefensividad(1);
        }
        else {
            jugador.sumarLargoPlazo(5);
            jugador.sumarDefensividad(2);
        }

        if(jugada.getTiempo() > 10) {
            jugador.sumarLargoPlazo(5);
        }

        jugador.sumarJugadaNeutral();
    }
}