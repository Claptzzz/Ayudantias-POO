package Dominio;

import Visitor.IVisitor;

public class Productora extends Planta implements Productoras {
	protected int soles;
	protected int intervalo;
	
	public Productora(String nombre, int costo, int recarga, int soles, int intervalo) {
		super(nombre, costo, recarga);
		this.soles = soles;
		this.intervalo = intervalo;
	}

	public int getSoles() {
		return soles;
	}

	public int getIntervalo() {
		return intervalo;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\n" +
				"Costo: " + this.costo + "\n" +
				"Recarga: " + this.recarga + "\n" +
				"Producción de soles: " + this.soles + "\n" +
				"Tiempo entre producción: " + this.intervalo + "\n";
	}

	@Override
	public String Producir() {
		return this.nombre + " produce " + this.soles + " soles!";
	}
	
	@Override
	public void aceptar(IVisitor v) {
		v.visit(this);
	}

}
