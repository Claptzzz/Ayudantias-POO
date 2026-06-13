package visitor;

import java.util.ArrayList;
import java.util.List;

import dominio.Cancion;
import dominio.Podcast;

public class EstadisticasVisitor implements VisitorContenido {

	private double sumaRatingCanciones;
	private double sumaRatingPodcasts;
	private long sumaDuracionCanciones;
	private long sumaEpisodiosPodcasts;
	private int countCanciones;
	private int countPodcasts;
	private List<String> generosCanciones;
	private List<Integer> contadoresCanciones;
	private List<String> generosPodcasts;
	private List<Integer> contadoresPodcasts;

	public EstadisticasVisitor() {
		sumaRatingCanciones = 0;
		sumaRatingPodcasts = 0;
		sumaDuracionCanciones = 0;
		sumaEpisodiosPodcasts = 0;
		countCanciones = 0;
		countPodcasts = 0;
		generosCanciones = new ArrayList<String>();
		contadoresCanciones = new ArrayList<Integer>();
		generosPodcasts = new ArrayList<String>();
		contadoresPodcasts = new ArrayList<Integer>();
	}

	@Override
	public void visitar(Cancion c) {
		sumaRatingCanciones += c.getRating();
		sumaDuracionCanciones += c.getDuracion();
		countCanciones++;
		registrarGenero(generosCanciones, contadoresCanciones, c.getGenero());
	}

	@Override
	public void visitar(Podcast p) {
		sumaRatingPodcasts += p.getRating();
		sumaEpisodiosPodcasts += p.getDuracion();
		countPodcasts++;
		registrarGenero(generosPodcasts, contadoresPodcasts, p.getGenero());
	}

	private void registrarGenero(List<String> generos, List<Integer> contadores, String g) {
		for (int i = 0; i < generos.size(); i++) {
			if (generos.get(i).equalsIgnoreCase(g)) {
				contadores.set(i, contadores.get(i) + 1);
				return;
			}
		}
		generos.add(g);
		contadores.add(1);
	}

	public void imprimir() {
		System.out.println("=== Estadisticas ===");

		if (countCanciones > 0) {
			double ratingProm = sumaRatingCanciones / countCanciones;
			double durProm = (double) sumaDuracionCanciones / countCanciones;
			System.out.println("Rating promedio canciones: " + ratingProm);
			System.out.println("Duracion promedio canciones: " + durProm + " seg");
			System.out.println("Genero mas frecuente (canciones): " + masFrecuente(generosCanciones, contadoresCanciones));
		} else {
			System.out.println("(sin canciones)");
		}

		if (countPodcasts > 0) {
			double ratingProm = sumaRatingPodcasts / countPodcasts;
			double epProm = (double) sumaEpisodiosPodcasts / countPodcasts;
			System.out.println("Rating promedio podcasts: " + ratingProm);
			System.out.println("Episodios promedio podcasts: " + epProm);
			System.out.println("Genero mas frecuente (podcasts): " + masFrecuente(generosPodcasts, contadoresPodcasts));
		} else {
			System.out.println("(sin podcasts)");
		}
	}

	private String masFrecuente(List<String> generos, List<Integer> contadores) {
		if (generos.isEmpty()) return "N/A";
		String mejor = generos.get(0);
		int max = contadores.get(0);
		for (int i = 1; i < generos.size(); i++) {
			if (contadores.get(i) > max) {
				max = contadores.get(i);
				mejor = generos.get(i);
			}
		}
		return mejor;
	}
}
