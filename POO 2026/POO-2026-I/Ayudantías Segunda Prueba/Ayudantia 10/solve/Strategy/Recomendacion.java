package Strategy;

import java.util.*;
import Dominio.*;

public interface Recomendacion {
	List<Contenido> recomendar(List<Contenido> catalogo);
	String verEstrategia();
}
