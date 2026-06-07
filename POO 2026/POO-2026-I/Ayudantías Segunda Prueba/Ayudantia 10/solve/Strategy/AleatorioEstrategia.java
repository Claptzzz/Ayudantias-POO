package Strategy;

import java.util.List;
import java.util.Random;

import Dominio.Contenido;

public class AleatorioEstrategia implements Recomendacion {

	@Override
	public List<Contenido> recomendar(List<Contenido> catalogo) {
		
		int size = catalogo.size();
		
		Random r = new Random();
	
		for (int i = 0; i < 1000; i++) {
			int idx = r.nextInt(0, size);
			int idx2 = r.nextInt(0, size);
			
			catalogo.add(idx2, catalogo.remove(idx));
		}
		
		return catalogo;
	}

	@Override
	public String verEstrategia() {
		return "El catálogo se actualizó por orden aleatorio";
	}

}
