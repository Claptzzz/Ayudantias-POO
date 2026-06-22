package Strategy;

import Dominio.Jugada;
import Dominio.Jugador;

public class EstrategiaDefensiva implements Estrategia {

    @Override
    public void evaluar(Jugada jugada, Jugador jugador) {

        if(jugada.isComePieza()) {
            jugador.sumarDefensividad(2);
            jugador.sumarLargoPlazo(1);
        }
        else {
            jugador.sumarDefensividad(5);
            jugador.sumarLargoPlazo(2);
        }

        if(jugada.getTiempo() > 10) {
            jugador.sumarLargoPlazo(5);
        }

        jugador.sumarJugadaDefensiva();
    }
}
