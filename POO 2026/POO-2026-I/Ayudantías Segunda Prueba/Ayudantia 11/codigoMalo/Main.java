package solve;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Contenido> catalogo = new ArrayList<Contenido>();
	static List<Contenido> historial = new ArrayList<Contenido>();
	static List<String> titulosReprod = new ArrayList<String>();
	static List<Integer> conteoReprod = new ArrayList<Integer>();
	static List<String> artistasReprod = new ArrayList<String>();
	static List<Integer> conteoArtistas = new ArrayList<Integer>();

	static List<Contenido> playlist = new ArrayList<Contenido>();
	static String nombrePlaylist = "";

	static Scanner s = new Scanner(System.in);
	
	private static void cargarArch() throws IOException {
		File file = new File("catalogo.txt");
		Scanner sFile = new Scanner(file);
		
		while (sFile.hasNextLine()) {
			String linea = sFile.nextLine();
			String[] partes = linea.split(";");
			if (partes[0].equals("cancion")) {
				Cancion c = new Cancion(partes[1], partes[2], partes[3], Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),partes[6].equals("true"));
				catalogo.add(c);
			} else if (partes[0].equals("podcast")) {
				Podcast pd = new Podcast(partes[1], partes[2], partes[3], Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),partes[6].equals("true"));
				catalogo.add(pd);
			}
		}
		sFile.close();
		
	}

	public static void main(String[] args) throws IOException {
		cargarArch();

		String opcion = "";
		do {
			System.out.println();
			System.out.println("=== Bienvenido a Spotify ===");
			System.out.println("1) Mostrar catalogo");
			System.out.println("2) Importar Apple Music");
			System.out.println("3) Reproducir contenido");
			System.out.println("4) Recomendaciones");
			System.out.println("5) Estadisticas");
			System.out.println("6) Crear playlist");
			System.out.println("7) Aplicar modos y reproducir playlist");
			System.out.println("8) Ver trending");
			System.out.println("9) Ver historial");
			System.out.println("10) Salir");
			System.out.print("> ");

			opcion = s.nextLine();

			if (opcion.equals("1")) verCatalogo();
			else if (opcion.equals("2")) cargarApple(); 	
			else if (opcion.equals("3")) reproducir();
			else if (opcion.equals("4")) recomendaciones();
			else if (opcion.equals("5")) estadisticas();
			else if (opcion.equals("6")) crearPlaylist();	
			else if (opcion.equals("7")) reproducirPlaylist();
			else if (opcion.equals("8")) verTrending();
			else if (opcion.equals("9")) verHistorial();
			else if (opcion.equals("10")) {
				System.out.println("Xao loko!");
			} else {
				System.out.println("Opcion invalida.");
			}

			System.out.println();
		} while (!opcion.equals("10"));

		s.close();
	}

	private static void verHistorial() {
		if (historial.isEmpty()) {
			
			System.out.println("Sin reproducciones");
			
		} else {
			
			System.out.println("=== Historial ===");
			for (int i = 0; i < historial.size(); i++) {
				Contenido c = historial.get(i);
				System.out.println((i + 1) + ". " + c.titulo + " - " + c.artista);
			}
		}
	}

	private static void verTrending() {
		System.out.print("Top N: ");
		int n = Integer.parseInt(s.nextLine());
		
		if (titulosReprod.isEmpty()) {
			System.out.println("(aun no hay reproducciones)");
			
		} else {
			
			List<String> tt = new ArrayList<String>();
			List<Integer> cc = new ArrayList<Integer>();
			
			for (int i = 0; i < titulosReprod.size(); i++) {
				tt.add(titulosReprod.get(i));
				cc.add(conteoReprod.get(i));
			}
			
			for (int i = 0; i < tt.size(); i++) {
				for (int j = i + 1; j < tt.size(); j++) {
					
					if (cc.get(j) > cc.get(i)) {
						
						int tmpC = cc.get(i);
						cc.set(i, cc.get(j));
						cc.set(j, tmpC);
						
						String tmpT = tt.get(i);
						tt.set(i, tt.get(j));
						tt.set(j, tmpT);
					}
				}
			}
			
			System.out.println("=== Trending ===");
			
			int lim = n;
			if (lim > tt.size()) lim = tt.size();
			
			for (int i = 0; i < lim; i++) {
				
				System.out.println("  " + tt.get(i) + ": " + cc.get(i) + " reproducciones");
			}
		}
		
	}

	private static void reproducirPlaylist() {
		
		if (playlist.isEmpty()) {
			System.out.println("No hay playlist. Debes crear una antes");
			
		} else {
			
			System.out.print("Solo favoritas (rating >= 4)? (s/n): ");
			boolean modoSoloFav = s.nextLine().equals("s");
			
			System.out.print("Filtro explicito? (s/n): ");
			boolean modoFiltroExpl = s.nextLine().equals("s");
			
			System.out.print("Al azar? (s/n): ");
			boolean modoAlAzar = s.nextLine().equals("s");
			
			System.out.print("Repetir cuantas veces? (1 = sin repeat): ");
			int repeat = Integer.parseInt(s.nextLine());
			
			if (repeat < 1) repeat = 1;

			List<Contenido> lista = new ArrayList<Contenido>();
			for (Contenido c : playlist) lista.add(c);

			if (modoSoloFav) {
				
				List<Contenido> tmp = new ArrayList<Contenido>();
				for (Contenido c : lista) {
					if (c.rating >= 4) tmp.add(c);
				}
				lista = tmp;
			}
			
			if (modoFiltroExpl) {
				
				List<Contenido> tmp = new ArrayList<Contenido>();
				for (Contenido c : lista) {
					if (!c.explicito) tmp.add(c);
				}
				lista = tmp;
			}
			
			if (modoAlAzar) Collections.shuffle(lista);

			List<Contenido> lista2 = new ArrayList<Contenido>();
			for (int r = 0; r < repeat; r++) {
				for (Contenido c : lista) lista2.add(c);
			}

			System.out.println("> Reproduciendo playlist: " + nombrePlaylist + " (" + lista2.size() + " contenidos)");
			
			if (lista2.isEmpty()) {
				System.out.println("(playlist vacia)");
			} else {
				
				for (int i = 0; i < lista2.size(); i++) {
					Contenido c = lista2.get(i);
					System.out.println("  > " + c.titulo + " - " + c.artista);
					historial.add(c);

					boolean encT = false;
					for (int j = 0; j < titulosReprod.size(); j++) {
						if (titulosReprod.get(j).equals(c.titulo)) {
							conteoReprod.set(j, conteoReprod.get(j) + 1);
							encT = true;
						}
					}
					
					if (!encT) {
						titulosReprod.add(c.titulo);
						conteoReprod.add(1);
					}

					boolean encA = false;
					
					for (int j = 0; j < artistasReprod.size(); j++) {
						if (artistasReprod.get(j).equals(c.artista)) {
							conteoArtistas.set(j, conteoArtistas.get(j) + 1);
							encA = true;
						}
					}
					
					if (!encA) {
						artistasReprod.add(c.artista);
						conteoArtistas.add(1);
					}
				}
			}
		}
	}

	private static void crearPlaylist() {
		System.out.print("Nombre de la playlist: ");
		nombrePlaylist = s.nextLine();
		
		playlist.clear();
		
		System.out.println("Playlist '" + nombrePlaylist + "' creada.");
		System.out.println("Ingresa titulos (vacio para terminar):");
		String t = "";
		
		do {
			System.out.print("> ");
			
			t = s.nextLine();
			
			if (!t.equals("")) {
				
				Contenido enc = null;
				
				for (int i = 0; i < catalogo.size(); i++) {
					if (catalogo.get(i).titulo.equalsIgnoreCase(t)) enc = catalogo.get(i);
				}
				
				if (enc == null) System.out.println("  (no encontrado: " + t + ")");
				
				else {
					playlist.add(enc);
					System.out.println("  + " + enc.titulo);
				}
			}
			
		} while (!t.equals(""));
		
	}

	private static void estadisticas() {
		double sumRatC = 0;
		double sumRatP = 0;
		
		long sumDurC = 0;
		long sumEpP = 0;
		
		int nC = 0;
		int nP = 0;
		
		List<String> gC = new ArrayList<String>();
		List<Integer> ccC = new ArrayList<Integer>();
		
		List<String> gP = new ArrayList<String>();
		List<Integer> ccP = new ArrayList<Integer>();

		for (int i = 0; i < catalogo.size(); i++) {
			
			Contenido c = catalogo.get(i);
			
			if (c instanceof Cancion) {
				sumRatC += c.rating;
				sumDurC += c.duracion;
				nC++;
				
				boolean enc = false;
				
				for (int j = 0; j < gC.size(); j++) {
					if (gC.get(j).equalsIgnoreCase(c.genero)) {
						ccC.set(j, ccC.get(j) + 1);
						enc = true;
					}
				}
				
				if (!enc) {
					gC.add(c.genero);
					ccC.add(1);
				}
				
			} else if (c instanceof Podcast) {
				sumRatP += c.rating;
				sumEpP += c.duracion;
				nP++;
				boolean enc = false;
				for (int j = 0; j < gP.size(); j++) {
					if (gP.get(j).equalsIgnoreCase(c.genero)) {
						ccP.set(j, ccP.get(j) + 1);
						enc = true;
					}
				}
				
				if (!enc) {
					gP.add(c.genero);
					ccP.add(1);
				}
			}
		}

		System.out.println("=== Estadisticas ===");
		if (nC > 0) {
			System.out.println("Rating promedio canciones: " + (sumRatC / nC));
			System.out.println("Duracion promedio canciones: " + ((double) sumDurC / nC) + " seg");
			String maxG = "N/A";
			int max = 0;
			for (int j = 0; j < gC.size(); j++) {
				if (ccC.get(j) > max) {
					max = ccC.get(j);
					maxG = gC.get(j);
				}
			}
			
			System.out.println("Genero mas frecuente (canciones): " + maxG);
		} else {
			
			System.out.println("(sin canciones)");
		}
		
		if (nP > 0) {
			
			System.out.println("Rating promedio podcasts: " + (sumRatP / nP));
			System.out.println("Episodios promedio podcasts: " + ((double) sumEpP / nP));
			String maxG = "N/A";
			int max = 0;
			for (int j = 0; j < gP.size(); j++) {
				if (ccP.get(j) > max) {
					max = ccP.get(j);
					maxG = gP.get(j);
				}
			}
			
			System.out.println("Genero mas frecuente (podcasts): " + maxG);
			
		} else {
			
			System.out.println("(sin podcasts)");
		}
		
	}

	private static void recomendaciones() {
		System.out.println("Algoritmo:");
		System.out.println("  1) Por rating");
		System.out.println("  2) Por genero");
		System.out.println("  3) Aleatoria");
		System.out.print("> ");
		String alg = s.nextLine();
		
		System.out.print("Cantidad: ");
		int x = Integer.parseInt(s.nextLine());

		if (alg.equals("1")) {
			
			List<Contenido> copia = new ArrayList<Contenido>();
			
			for (Contenido c : catalogo) copia.add(c);
			
			for (int i = 0; i < copia.size(); i++) {
				for (int j = i + 1; j < copia.size(); j++) {
					if (copia.get(j).rating > copia.get(i).rating) {
						Contenido tmp = copia.get(i);
						copia.set(i, copia.get(j));
						copia.set(j, tmp);
					}
				}
			}
			
			int lim = x;
			
			if (lim > copia.size()) lim = copia.size();
			
			for (int i = 0; i < lim; i++) {
				Contenido c = copia.get(i);
				System.out.println("- " + c.titulo + " - " + c.artista + " (rating " + c.rating + ")");
			}
			
		} else if (alg.equals("2")) {
			
			System.out.print("Genero: ");
			String g = s.nextLine();
			
			int n = 0;
			
			for (int i = 0; i < catalogo.size(); i++) {
				Contenido c = catalogo.get(i);
				if (c.genero.equalsIgnoreCase(g) && n < x) {
					System.out.println("- " + c.titulo + " - " + c.artista);
					n++;
				}
			}
			
			if (n == 0) System.out.println("(sin contenido del genero " + g + ")");
			
		} else if (alg.equals("3")) {
			
			List<Contenido> copia = new ArrayList<Contenido>();
			
			for (Contenido c : catalogo) copia.add(c);
			
			Collections.shuffle(copia);
			
			int lim = x;
			
			if (lim > copia.size()) lim = copia.size();
			
			for (int i = 0; i < lim; i++) {
				Contenido c = copia.get(i);
				System.out.println("- " + c.titulo + " - " + c.artista);
			}
			
		} else {
			System.out.println("Algoritmo invalido.");
		}
		
	}

	private static void reproducir() {
		System.out.print("Titulo: ");
		String titulo = s.nextLine();
		
		Contenido encontrado = null;
		
		for (int i = 0; i < catalogo.size(); i++) {
			if (catalogo.get(i).titulo.equalsIgnoreCase(titulo)) {
				encontrado = catalogo.get(i);
			}
		}
		
		if (encontrado == null) {
			
			System.out.println("No se encontro: " + titulo);
		} else {
			
			System.out.println("> Reproduciendo: " + encontrado.titulo + " - " + encontrado.artista);
			historial.add(encontrado);

			boolean encontradoT = false;
			
			for (int i = 0; i < titulosReprod.size(); i++) {
				if (titulosReprod.get(i).equals(encontrado.titulo)) {
					conteoReprod.set(i, conteoReprod.get(i) + 1);
					encontradoT = true;
				}
			}
			
			if (!encontradoT) {
				
				titulosReprod.add(encontrado.titulo);
				conteoReprod.add(1);
			}

			boolean encontradoA = false;
			
			for (int i = 0; i < artistasReprod.size(); i++) {
				if (artistasReprod.get(i).equals(encontrado.artista)) {
					conteoArtistas.set(i, conteoArtistas.get(i) + 1);
					encontradoA = true;
				}
			}
			
			if (!encontradoA) {
				artistasReprod.add(encontrado.artista);
				conteoArtistas.add(1);
			}
		}
		
	}

	private static void cargarApple() throws IOException {
		File file = new File("apple_music.txt");
		Scanner sFile = new Scanner(file);
		int n = 0;
		
		while (sFile.hasNextLine()) {
			
			String linea = sFile.nextLine();
			String[] partes = linea.split("\\|");
			
			if (partes[0].equals("[SONG]")) {
				
				double mins = Double.parseDouble(partes[4]);
				int dur = (int) Math.round(mins * 60);
				int rating = (int) Math.round(Double.parseDouble(partes[5]));
				boolean expl = false;
				if (partes[6].equals("1")) expl = true;
				
				Cancion c = new Cancion(partes[1], partes[2], partes[3], dur, rating, expl);
				catalogo.add(c);
				
				n++;
				
			} else if (partes[0].equals("[EPISODE]")) {
				
				int ep = (int) Math.round(Double.parseDouble(partes[4]));
				int rating = (int) Math.round(Double.parseDouble(partes[5]));
				boolean expl = false;
				if (partes[6].equals("1")) expl = true;
				
				Podcast pd = new Podcast(partes[1], partes[2], partes[3], ep, rating, expl);
				catalogo.add(pd);
				
				n++;
			}
		}
		sFile.close();
		System.out.println("Importados " + n + " contenidos desde Apple Music.");
		
	}

	private static void verCatalogo() {
		
		if (catalogo.isEmpty()) {
			
			System.out.println("Catalogo vacio");
		} else {
			
			for (int i = 0; i < catalogo.size(); i++) {
				
				Contenido c = catalogo.get(i);
				String tipo = "";
				
				if (c instanceof Cancion) tipo = "cancion";
				else tipo = "podcast";
				
				String marca = "";
				
				if (c.explicito) marca = " [E]";
				
				System.out.println((i + 1) + ". [" + tipo + "] " + c.titulo + " - " + c.artista + " | " + c.genero + " | rating: " + c.rating + marca);
			}
		}
	}
}
