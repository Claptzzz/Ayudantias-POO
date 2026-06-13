package adapter;

import java.util.ArrayList;
import java.util.List;

import dominio.Contenido;
import dominio.ContenidoFactory;

public class AppleMusicAdapter {

	private AppleMusic appleMusic;

	public AppleMusicAdapter(AppleMusic appleMusic) {
		this.appleMusic = appleMusic;
	}

	public List<Contenido> importar() {
		List<Contenido> res = new ArrayList<Contenido>();

		for (ContenidoApple a : appleMusic.getContenidos()) {
			String tipo = "";
			int duracion = 0;

			if (a.getEtiqueta().equals("[SONG]")) {
				tipo = "cancion";
				duracion = (int) Math.round(a.getMinutos() * 60);
			} else if (a.getEtiqueta().equals("[EPISODE]")) {
				tipo = "podcast";
				duracion = (int) Math.round(a.getMinutos());
			} else {
				continue;
			}

			int rating = (int) Math.round(a.getEstrellas());

			boolean explicito = false;
			if (a.getExplicito().equals("1")) explicito = true;

			Contenido c = ContenidoFactory.crear(tipo, a.getTitulo(), a.getArtista(), a.getCategoria(), duracion, rating, explicito);
			res.add(c);
		}

		return res;
	}
}
