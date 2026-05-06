public class Carta extends Pieza {
	private String juego;
	private int nivelRareza;
	
	public Carta(String codigo, String nombre, int año, double valor, String juego, int nivelRareza) {
		super(codigo, nombre, año, valor);
		this.juego= juego;
		this.nivelRareza = nivelRareza;
	}

	public String getJuego() {
		return juego;
	}
	public void setJuego(String juego) {
		this.juego = juego;
	}
	public int getNivelRareza() {
		return nivelRareza;
	}
	public void setNivelRareza(int nivelRareza) {
		this.nivelRareza = nivelRareza;
	}

	@Override
	public boolean cumpleTematica(String palabraJuego, String editorialComic) {
		if(palabraJuego.equals(juego)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean cumpleRareza(int rarezaMinima, int numeroEdicionMinimo) {
		return nivelRareza >= rarezaMinima;
	}

	@Override
	protected String getTipo() {
		return "CARTA";
	}

	@Override
	protected String detalle() {
		return "Juego: " + juego + " | Rareza: " + nivelRareza;
	}
	
}
