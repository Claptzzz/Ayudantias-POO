package Strategy;

public class FactoryEstrategia {
	public static Recomendacion crearEstrategia(int opcion) {
		if (opcion == 1) return new RatingEstrategia();
		if (opcion == 2) return new GeneroEstrategia();
		if (opcion == 3) return new AleatorioEstrategia();
		return null;
	}
}
