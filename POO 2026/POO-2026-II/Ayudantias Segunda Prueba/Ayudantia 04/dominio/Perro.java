package dominio;

public class Perro extends Paciente {
	
	private int vacunasPendientes;
	
	public Perro(String nombre, int peso, int edad, int vacunasPendientes) {
		super(nombre, peso, edad);
		this.vacunasPendientes = vacunasPendientes;
	}

	public int getVacunasPendientes() {
		return vacunasPendientes;
	}

	@Override
	public double calcularPrecio() {
		return getPeso() * getEdad() + vacunasPendientes * 20;
	}

	@Override
	public String toString() {
		return "[Perro] " + super.toString() + " | Vacunas pendientes: " + vacunasPendientes;
	}
}