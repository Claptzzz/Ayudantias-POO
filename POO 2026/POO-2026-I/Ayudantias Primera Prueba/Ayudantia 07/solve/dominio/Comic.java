public class Comic extends Pieza {
	private String editorial;
	private int numEdicion;

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumEdicion() {
		return numEdicion;
	}

	public void setNumEdicion(int numEdicion) {
		this.numEdicion = numEdicion;
	}

	public Comic(String tipo, String codigo, String nombre, int año, double valor, String editorial, int numEdicion) {
		super(tipo, codigo, nombre, año, valor);
		this.editorial = editorial;
		this.numEdicion = numEdicion;
		
	}

	@Override
	public boolean cumpleRequerimiento(String requerimiento) {
		return editorial.equalsIgnoreCase(requerimiento);
	}

	@Override
	public boolean compararNumero(int minimoIndicado) {
		return numEdicion>= minimoIndicado;
	}

	@Override
	public String toString() {
		return "Comic [editorial=" + editorial + ", numEdicion=" + numEdicion + "]";
	}
	

}
