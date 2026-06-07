package Visitor;

import Dominio.Pelicula;
import Dominio.Serie;

import java.util.*;

public class VisitorGenero implements IVisitor {
	private static ArrayList<String> generosPelis = new ArrayList<String>();
	private static ArrayList<Integer> conteosPelis = new ArrayList<Integer>();
	
	private static ArrayList<String> generosSeries = new ArrayList<String>();
	private static ArrayList<Integer> conteosSeries = new ArrayList<Integer>();
	
	private static void funcion(ArrayList<String> generos, ArrayList<Integer> conteo, String genero) {
		for (int i = 0; i < generos.size(); i++) {
			if (generos.get(i).equals(genero)) {
				conteo.set(i, conteo.get(i) + 1);
				return;
			}
		}
		
		generos.add(genero);
		conteo.add(0);
		
	}
	
	@Override
	public void visit(Pelicula p) {
		String genero = p.getGenero();
		
		funcion(generosPelis, conteosPelis, genero);

	}

	@Override
	public void visit(Serie s) {
		String genero = s.getGenero();
		
		funcion(generosSeries, conteosSeries, genero);

	}
	
	private static String max(ArrayList<String> generos, ArrayList<Integer> conteo) {
		
		int maximo = 0;
		String generoMax = null;
		
		for (int i = 0; i < generos.size(); i++) {
			if (conteo.get(i) > maximo) {
				maximo = conteo.get(i);
				generoMax = generos.get(i);
			}
		}
		
		return generoMax;
	}

	@Override
	public String verResultados() {
		return "Género más común de peliculas: " + max(generosPelis, conteosPelis) 
				+ "\nGénero más común de series: " + max(generosSeries, conteosSeries);
	
	}

}
