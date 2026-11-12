package Dominio;

import Visitor.IVisitor;

public class Defensa extends Planta {
	protected int vida;
	protected String defensa;
	
	public Defensa(String nombre, int costo, int recarga, int vida, String defensa) {
		super(nombre, costo, recarga);
		this.vida = vida;
		this.defensa = defensa;	
	}

	public int getVida() {
		return vida;
	}

	public String getDefensa() {
		return defensa;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\n" +
				"Costo: " + this.costo + "\n" +
				"Recarga: " + this.recarga + "\n" +
				"Defensa: " + this.vida + "\n" +
				"Defensa extra: " + this.defensa + "\n";
	}
	
	@Override
	public void aceptar(IVisitor v) {
		v.visit(this);
	}
	
}
