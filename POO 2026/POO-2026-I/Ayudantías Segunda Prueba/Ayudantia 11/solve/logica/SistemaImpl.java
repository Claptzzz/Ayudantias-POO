package logica;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adapter.AppleMusic;
import adapter.AppleMusicAdapter;
import decorator.PlaylistComponente;
import dominio.Contenido;
import dominio.ContenidoFactory;
import dominio.Playlist;
import observer.ContadorArtista;
import observer.HistorialReproduccion;
import observer.MasReproducidos;
import observer.ObservadorReproduccion;
import strategy.EstrategiaRecomendacion;
import visitor.EstadisticasVisitor;

public class SistemaImpl implements Sistema {

	private static SistemaImpl instancia;

	private List<Contenido> catalogo;
	private Playlist playlistActiva;
	private HistorialReproduccion historial;
	private MasReproducidos masReproducidos;
	private ContadorArtista contadorArtista;
	private List<ObservadorReproduccion> observadores;

	private SistemaImpl() {
		catalogo = new ArrayList<Contenido>();
		historial = new HistorialReproduccion();
		masReproducidos = new MasReproducidos();
		contadorArtista = new ContadorArtista();
		observadores = new ArrayList<ObservadorReproduccion>();
		observadores.add(historial);
		observadores.add(masReproducidos);
		observadores.add(contadorArtista);
	}

	public static SistemaImpl getInstancia() {
		if (instancia == null) instancia = new SistemaImpl();
		return instancia;
	}

	@Override
	public void cargarCatalogo(String ruta) throws IOException {
		File file = new File(ruta);
		Scanner s = new Scanner(file);
		int n = 0;
		while (s.hasNextLine()) {
			String linea = s.nextLine();
			catalogo.add(ContenidoFactory.desdeLineaCatalogo(linea));
			n++;
		}
		s.close();
		System.out.println("Catalogo cargado: " + n + " contenidos.");
	}

	@Override
	public void importarAppleMusic(String ruta) throws IOException {
		AppleMusic appleMusic = new AppleMusic();
		appleMusic.cargarDesdeArchivo(ruta);

		AppleMusicAdapter adapter = new AppleMusicAdapter(appleMusic);
		List<Contenido> importados = adapter.importar();

		for (Contenido c : importados) catalogo.add(c);
		System.out.println("Importados " + importados.size() + " contenidos desde Apple Music.");
	}

	@Override
	public void mostrarCatalogo() {
		if (catalogo.isEmpty()) {
			System.out.println("Catalogo vacio.");
			return;
		}
		for (int i = 0; i < catalogo.size(); i++) {
			System.out.println((i + 1) + ". " + catalogo.get(i).mostrar());
		}
	}

	@Override
	public void reproducir(String titulo) {
		Contenido c = buscarPorTitulo(titulo);
		if (c == null) {
			System.out.println("No se encontro: " + titulo);
			return;
		}
		System.out.println("> Reproduciendo: " + c.getTitulo() + " - " + c.getArtista());
		notificar(c);
	}

	private Contenido buscarPorTitulo(String titulo) {
		for (Contenido c : catalogo) {
			if (c.getTitulo().equalsIgnoreCase(titulo)) return c;
		}
		return null;
	}

	private void notificar(Contenido c) {
		for (ObservadorReproduccion o : observadores) o.alReproducir(c);
	}

	@Override
	public void recomendar(EstrategiaRecomendacion estrategia) {
		List<Contenido> recs = estrategia.recomendar(catalogo);
		if (recs.isEmpty()) {
			System.out.println("Sin recomendaciones.");
			return;
		}
		System.out.println("=== Recomendaciones ===");
		for (Contenido c : recs) {
			System.out.println("- " + c.getTitulo() + " - " + c.getArtista() + " (rating " + c.getRating() + ")");
		}
	}

	@Override
	public void mostrarEstadisticas() {
		if (catalogo.isEmpty()) {
			System.out.println("Catalogo vacio.");
			return;
		}
		EstadisticasVisitor v = new EstadisticasVisitor();
		for (Contenido c : catalogo) c.aceptar(v);
		v.imprimir();
	}

	@Override
	public void crearPlaylist(String nombre) {
		playlistActiva = new Playlist(nombre);
		System.out.println("Playlist '" + nombre + "' creada.");
	}

	@Override
	public void agregarAPlaylist(String titulo) {
		if (playlistActiva == null) {
			System.out.println("No hay playlist activa. Crea una primero.");
			return;
		}
		Contenido c = buscarPorTitulo(titulo);
		if (c == null) {
			System.out.println("  (no encontrado: " + titulo + ")");
			return;
		}
		playlistActiva.agregar(c);
		System.out.println("  + " + c.getTitulo());
	}

	@Override
	public Playlist getPlaylistActiva() {
		return playlistActiva;
	}

	@Override
	public void reproducirPlaylist(PlaylistComponente p) {
		if (p == null) {
			System.out.println("No hay playlist.");
			return;
		}
		List<Contenido> lista = p.obtenerLista();
		System.out.println("> Reproduciendo playlist: " + p.descripcion() + " (" + lista.size() + " contenidos)");
		if (lista.isEmpty()) {
			System.out.println("(playlist vacia tras aplicar modos)");
			return;
		}
		for (Contenido c : lista) {
			System.out.println("  > " + c.getTitulo() + " - " + c.getArtista());
			notificar(c);
		}
	}

	@Override
	public void mostrarTrending(int topN) {
		masReproducidos.imprimirTrending(topN);
	}

	@Override
	public void mostrarHistorial() {
		historial.imprimir();
	}
}
