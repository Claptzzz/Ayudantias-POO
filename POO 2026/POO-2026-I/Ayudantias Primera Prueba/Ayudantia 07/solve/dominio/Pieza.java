public abstract class Pieza {
	protected String codigo;
	protected String nombre;
	protected int año;
	protected double valor;
	
	public Pieza(String codigo, String nombre, int año, double valor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.año = año;
		this.valor = valor;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public abstract boolean cumpleTematica(String palabraJuego, String editorialComic);

    public abstract boolean cumpleRareza(int rarezaMinima, int numeroEdicionMinimo);

	@Override
	public String toString() {
		return getTipo() + " | Codigo: " + codigo +" | Nombre: " + nombre + " | Año: " + año +" | Valor: $" + valor + " | " + detalle();
	}

	protected abstract String getTipo();

	protected abstract String detalle();

}
