package Dominio;

public class Persona {
	private String nombre;
	private String apellido;
	private double nota;
	private boolean tieneBomba;
	
	public Persona (String nombre, String apellido, double nota) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota = nota;
		this.tieneBomba = false;
	}

	public double getNota() {
		return nota;
	}

	public double getNotaFinal() {
		if (nota - 1.5 < 1) return 1;
		return nota - 1.5;
	}

	public String getNombre() {
		return nombre + " " + apellido;
	}
	
	public boolean getEstado() {
		return tieneBomba;
	}
	
	public void cambiarEstado() {
		tieneBomba = !tieneBomba;
	}
	
}
