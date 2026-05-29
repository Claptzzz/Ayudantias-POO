package Dominio;

import java.util.ArrayList;

public class Niño {
	private String nombre;
	private int edad;
	ArrayList<Juguete> regalos  = new ArrayList<>();
	
	//arraylist no existe. No está creada
	//si el codigo hace regalos.add
	
	
	public Niño(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public ArrayList<Juguete> getRegalos() {
		return regalos;
	}


	public void setRegalos(ArrayList<Juguete> regalos) {
		this.regalos = regalos;
	}


	@Override
	public String toString() {
		return "Niño [nombre=" + nombre + ", edad=" + edad + ", regalos=" + regalos + "]";
	}
	
}
