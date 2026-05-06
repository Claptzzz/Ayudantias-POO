package dominio;
public class ExposicionTematica extends Exposicion{
	private String palabraClave;
	private String editorial;
	public String getPalabraClave() {
		return palabraClave;
	}
	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public ExposicionTematica(String nombre, int capMaxima, double valorMaximo, String palabraClave, String editorial) {
		super(nombre, capMaxima, valorMaximo);
		this.palabraClave = palabraClave;
		this.editorial = editorial;
		
	}
	@Override
	public boolean cumpleCriterio(Pieza pieza) {
		 return pieza.cumpleTematica(palabraClave, editorial);
	}
	@Override
	public String getDescripcionTipo() {
		return "Tematica | palabra juego: " + palabraClave +
	               " | editorial comic: " + editorial;
	}

}
