package adapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppleMusic {

	private List<ContenidoApple> contenidos;

	public AppleMusic() {
		contenidos = new ArrayList<ContenidoApple>();
	}

	public void cargarDesdeArchivo(String ruta) throws IOException {
		File file = new File(ruta);
		Scanner s = new Scanner(file);

		while (s.hasNextLine()) {
			String linea = s.nextLine();
			String[] p = linea.split("\\|");
			String etiqueta = p[0];
			String titulo = p[1];
			String artista = p[2];
			String categoria = p[3];
			double minutos = Double.parseDouble(p[4]);
			double estrellas = Double.parseDouble(p[5]);
			String explicito = p[6];
			contenidos.add(new ContenidoApple(etiqueta, titulo, artista, categoria, minutos, estrellas, explicito));
		}

		s.close();
	}

	public List<ContenidoApple> getContenidos() {
		return contenidos;
	}
}
