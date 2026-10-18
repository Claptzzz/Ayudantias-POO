package dominio;

public class Conejo extends Paciente {
	
	private int largoOrejas;
	
	public Conejo(String nombre, int peso, int edad, int largoOrejas) {
		super(nombre, peso, edad);
		this.largoOrejas = largoOrejas;
	}

	public int getLargoOrejas() {
		return largoOrejas;
	}

	@Override
	public double calcularPrecio() {
		return getPeso() * 2 + getEdad() * largoOrejas;
	}

	@Override
	public String toString() {
		return "[Conejo] " + super.toString() + " | Largo orejas: " + largoOrejas;
	}
}