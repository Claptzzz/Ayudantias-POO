package Strategy;

import Dominio.Jugada;
import Dominio.Jugador;

public interface Estrategia {

    void evaluar(Jugada jugada, Jugador jugador);

}
