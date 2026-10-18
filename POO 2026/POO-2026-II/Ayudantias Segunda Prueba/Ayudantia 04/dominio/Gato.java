package dominio;

public class Gato extends Paciente {
	
	private int largoCola;
	
	public Gato(String nombre, int peso, int edad, int largoCola) {
		super(nombre, peso, edad);
		this.largoCola = largoCola;
	}

	public int getLargoCola() {
		return largoCola;
	}

	@Override
	public double calcularPrecio() {
		return (getPeso() + getEdad()) * largoCola;
	}

	@Override
	public String toString() {
		return "[Gato] " + super.toString() + " | Largo cola: " + largoCola;
	}
}