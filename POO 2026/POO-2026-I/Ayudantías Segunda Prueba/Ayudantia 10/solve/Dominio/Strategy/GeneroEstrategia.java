package Strategy;

import java.util.*;

import Dominio.Contenido;

public class GeneroEstrategia implements Recomendacion {
	@Override
	public List<Contenido> recomendar(List<Contenido> catalogo) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("¿Qué género desea priorizar?");
		System.out.print("> ");
		String genero = scan.nextLine();
		
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i).getGenero().equalsIgnoreCase(genero)) catalogo.add(0, catalogo.remove(i));
		}

		return catalogo;
	}
	
	@Override
	public String verEstrategia() {
		return "El catálogo se actualizó por género";
	}

}
