package dominio;

public abstract class Paciente {
	
	protected String nombre;
	protected int peso;
	protected int edad;
	
	public Paciente(String nombre, int peso, int edad) {
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPeso() {
		return peso;
	}

	public int getEdad() {
		return edad;
	}
	
	// Cada especie calcula su precio a su manera
	public abstract double calcularPrecio();

	@Override
	public String toString() {
		return nombre + " | Peso: " + peso + " | Edad: " + edad;
	}
}