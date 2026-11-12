package Dominio;

import Visitor.IVisitor;

public abstract class Planta {
	protected String nombre;
	protected int costo;
	protected int recarga;
	
	public Planta(String nombre, int costo, int recarga) {
		this.nombre = nombre;
		this.costo = costo;
		this.recarga = recarga;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCosto() {
		return costo;
	}

	public int getRecarga() {
		return recarga;
	}
	
	public abstract void aceptar(IVisitor v);
	
	@Override
	public abstract String toString();
	
}
