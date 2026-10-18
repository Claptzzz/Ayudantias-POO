package dominio;

public class Cuyi extends Paciente {
	
	private int largoDientes;
	private int velocidad;
	
	public Cuyi(String nombre, int peso, int edad, int largoDientes, int velocidad) {
		super(nombre, peso, edad);
		this.largoDientes = largoDientes;
		this.velocidad = velocidad;
	}

	public int getLargoDientes() {
		return largoDientes;
	}

	public int getVelocidad() {
		return velocidad;
	}

	@Override
	public double calcularPrecio() {
		// Se castea a double para evitar la division entera
		return (getPeso() * getEdad() + largoDientes * 100) / (double) velocidad;
	}

	@Override
	public String toString() {
		return "[Cuyi] " + super.toString() + " | Largo dientes: " + largoDientes + " | Velocidad: " + velocidad;
	}
}