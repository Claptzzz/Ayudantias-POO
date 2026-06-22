package Strategy;

import Dominio.Jugada;
import Dominio.Jugador;

public class EstrategiaAgresiva implements Estrategia {

    @Override
    public void evaluar(Jugada jugada, Jugador jugador) {

        if(jugada.isComePieza()) {
            jugador.sumarAgresividad(5);
            jugador.sumarLargoPlazo(2);
        }
        else {
            jugador.sumarAgresividad(3);
            jugador.sumarLargoPlazo(2);
            jugador.sumarDefensividad(1);
        }

        if(jugada.getTiempo() > 10) {
            jugador.sumarLargoPlazo(5);
        }

        jugador.sumarJugadaAgresiva();
    }
}