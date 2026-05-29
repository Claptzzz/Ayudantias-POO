package Dominio;

public class Pelota extends Juguete{
	private String color;
	private boolean desinflada;

	public Pelota(int id, String tamaño, String color, boolean desinflada) {
		super(id, tamaño);
		this.color = color;
		this.desinflada = desinflada;
	}
	
	@Override
	public void puedeRegalar() {
		if (!desinflada) {
			 this.setEstado(true);
		}
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public boolean isDesinflada() {
		return desinflada;
	}


	public void setDesinflada(boolean desinflada) {
		this.desinflada = desinflada;
	}


	@Override
	public String toString() {
		return "Pelota color " + color + ", ID: " + getId() + ", de tamaño: " + getTamaño();
	}

}
