package Dominio;

public class Muñeca extends Juguete{
	private int calidad;
	private String color;
	
	
	public Muñeca(int id, String tamaño, int calidad, String color) {
		super(id, tamaño);
		this.calidad = calidad;
		this.color = color;
	}

	@Override
	public void puedeRegalar() {
		if (calidad > 70) {
			 this.setEstado(true);
		}
	}


	public int getCalidad() {
		return calidad;
	}


	public void setCalidad(int calidad) {
		this.calidad = calidad;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Muñeca color " + color + ", ID: " + getId() + ", de tamaño: " + getTamaño();
	}
	

}
