package Dominio;

public class Auto extends Juguete {
	private String color;
	private int ruedas;
	private boolean control;
	
	
	public Auto(int id, String tamaño, String color, int ruedas, boolean control) {
		super(id, tamaño);
		this.color = color;
		this.ruedas = ruedas;
		this.control = control;
	}

	@Override
	public void puedeRegalar() {
		if (ruedas == 4) {
			 this.setEstado(true);
		}
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getRuedas() {
		return ruedas;
	}


	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}


	public boolean isControl() {
		return control;
	}


	public void setControl(boolean control) {
		this.control = control;
	}


	@Override
	public String toString() {
		return "Auto color " + color + ", ¿con control remoto? " + control + ", ID: " + getId() + ", de tamaño: " + getTamaño();
	}
	
	
	
	

}
