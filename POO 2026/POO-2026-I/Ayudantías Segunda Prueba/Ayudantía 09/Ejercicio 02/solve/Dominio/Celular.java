package Dominio;

public abstract class Celular {
	private String color;
	private String pais;
	private int ventas;
	private int precio;
	private float rating;
	
	public Celular(String color, String pais, int ventas, float rating) {
		super();
		this.color = color;
		this.pais = pais;
		this.ventas = ventas;
		this.precio = 0;
		this.rating = rating;
	}
	
	public abstract void calcularPrecio();
	public abstract void aceptar(CeluVisitor visitor);
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

}