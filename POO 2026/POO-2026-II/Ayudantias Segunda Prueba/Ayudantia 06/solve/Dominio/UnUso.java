package Dominio;

import Visitor.IVisitor;

public class UnUso extends Planta implements Atacantes {
	protected int damage;
	protected String area;
	
	public UnUso(String nombre, int costo, int recarga, int damage, String area) {
		super(nombre, costo, recarga);
		this.damage = damage;
		this.area = area;
	}

	public int getDamage() {
		return damage;
	}

	public String getArea() {
		return area;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\n" +
				"Costo: " + this.costo + "\n" +
				"Recarga: " + this.recarga + "\n" +
				"Daño: " + this.damage + "\n" +
				"Alcance: " + this.area + "\n";
	}

	@Override
	public String atacar() {
		return this.nombre + " ataca con " + this.damage + " de daño y desaparece!";
	}
	
	@Override
	public void aceptar(IVisitor v) {
		v.visit(this);
	}

}
