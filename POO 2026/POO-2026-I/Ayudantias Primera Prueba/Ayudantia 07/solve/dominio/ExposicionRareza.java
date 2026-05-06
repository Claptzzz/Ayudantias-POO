package dominio;
public class ExposicionRareza extends Exposicion {
	private int rarezaMinima;
	private int numEdicion;
	public ExposicionRareza(String nombre, int capMaxima, double valorMaximo, int rarezaMinima, int numEdicion) {
		super(nombre, capMaxima, valorMaximo);
		this.rarezaMinima = rarezaMinima;
		this.numEdicion=numEdicion;
	}
	public int getRarezaMinima() {
		return rarezaMinima;
	}
	public void setRarezaMinima(int rarezaMinima) {
		this.rarezaMinima = rarezaMinima;
	}
	public int getNumEdicion() {
		return numEdicion;
	}
	public void setNumEdicion(int numEdicion) {
		this.numEdicion = numEdicion;
	}
	@Override
	public boolean cumpleCriterio(Pieza pieza) {
		return pieza.cumpleRareza(rarezaMinima, numEdicion);
	}
	@Override
	public String getDescripcionTipo() {
		return "Rareza | rareza minima carta: " + rarezaMinima +
	               " | numero edicion minimo comic: " + numEdicion;
	}

}
