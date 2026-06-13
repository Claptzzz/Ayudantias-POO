package logica;

import java.io.IOException;
import java.util.Scanner;

import decorator.AlAzar;
import decorator.ConRepeat;
import decorator.FiltroExplicito;
import decorator.PlaylistComponente;
import decorator.SoloFavoritas;
import dominio.Playlist;
import strategy.EstrategiaRecomendacion;
import strategy.RecomendarAleatoria;
import strategy.RecomendarPorGenero;
import strategy.RecomendarPorRating;

public class App {

	private static Scanner s = new Scanner(System.in);
	private static Sistema sys = SistemaImpl.getInstancia();

	public static void main(String[] args) throws IOException {
		sys.cargarCatalogo("catalogo.txt");
		menu();
		s.close();
	}

	private static void menu() throws IOException {
		String opcion = "";
		do {
			System.out.println();
			System.out.println("=== Spotify ===");
			System.out.println("1) Mostrar catalogo");
			System.out.println("2) Importar Apple Music");
			System.out.println("3) Reproducir contenido");
			System.out.println("4) Recomendaciones");
			System.out.println("5) Estadisticas");
			System.out.println("6) Crear playlist");
			System.out.println("7) Aplicar modos y reproducir playlist");
			System.out.println("8) Ver trending");
			System.out.println("9) Ver historial");
			System.out.println("0) Salir");
			System.out.print("> ");

			opcion = s.nextLine();

			if (opcion.equals("1")) sys.mostrarCatalogo();
			else if (opcion.equals("2")) sys.importarAppleMusic("apple_music.txt");
			else if (opcion.equals("3")) reproducir();
			else if (opcion.equals("4")) recomendar();
			else if (opcion.equals("5")) sys.mostrarEstadisticas();
			else if (opcion.equals("6")) crearPlaylist();
			else if (opcion.equals("7")) aplicarModos();
			else if (opcion.equals("8")) verTrending();
			else if (opcion.equals("9")) sys.mostrarHistorial();
			else if (opcion.equals("0")) System.out.println("Chao!");
			else System.out.println("Opcion invalida.");

			System.out.println();
		} while (!opcion.equals("0"));
	}

	private static void reproducir() {
		System.out.print("Titulo: ");
		String t = s.nextLine();
		sys.reproducir(t);
	}

	private static void recomendar() {
		System.out.println("Algoritmo:");
		System.out.println("  1) Por rating");
		System.out.println("  2) Por genero");
		System.out.println("  3) Aleatoria");
		System.out.print("> ");
		String alg = s.nextLine();

		System.out.print("Cantidad: ");
		int x = Integer.parseInt(s.nextLine());

		EstrategiaRecomendacion estrategia = null;

		if (alg.equals("1")) {
			estrategia = new RecomendarPorRating(x);
		} else if (alg.equals("2")) {
			System.out.print("Genero: ");
			String g = s.nextLine();
			estrategia = new RecomendarPorGenero(g, x);
		} else if (alg.equals("3")) {
			estrategia = new RecomendarAleatoria(x);
		} else {
			System.out.println("Algoritmo invalido.");
			return;
		}

		sys.recomendar(estrategia);
	}

	private static void crearPlaylist() {
		System.out.print("Nombre de la playlist: ");
		String nombre = s.nextLine();
		sys.crearPlaylist(nombre);

		System.out.println("Ingresa titulos (vacio para terminar):");
		String t = "";
		do {
			System.out.print("> ");
			t = s.nextLine();
			if (!t.equals("")) sys.agregarAPlaylist(t);
		} while (!t.equals(""));
	}

	private static void aplicarModos() {
		Playlist base = sys.getPlaylistActiva();
		if (base == null || base.tamano() == 0) {
			System.out.println("No hay playlist activa con contenido. Crea una primero.");
			return;
		}

		PlaylistComponente decorada = base;

		System.out.print("Solo favoritas (rating >= 4)? (s/n): ");
		String r1 = s.nextLine();
		if (r1.equals("s")) decorada = new SoloFavoritas(decorada);

		System.out.print("Filtro explicito? (s/n): ");
		String r2 = s.nextLine();
		if (r2.equals("s")) decorada = new FiltroExplicito(decorada);

		System.out.print("Al azar? (s/n): ");
		String r3 = s.nextLine();
		if (r3.equals("s")) decorada = new AlAzar(decorada);

		System.out.print("Repetir cuantas veces? (1 = sin repeat): ");
		int veces = Integer.parseInt(s.nextLine());
		if (veces > 1) decorada = new ConRepeat(decorada, veces);

		sys.reproducirPlaylist(decorada);
	}

	private static void verTrending() {
		System.out.print("Top N: ");
		int n = Integer.parseInt(s.nextLine());
		sys.mostrarTrending(n);
	}
}
