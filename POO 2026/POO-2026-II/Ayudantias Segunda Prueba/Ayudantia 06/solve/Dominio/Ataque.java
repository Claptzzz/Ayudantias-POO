package Dominio;

import Visitor.IVisitor;

public class Ataque extends Planta implements Atacantes {
	protected int damage;
	protected String habilidad;
	
	public Ataque(String nombre, int costo, int recarga, int damage, String habilidad) {
		super(nombre, costo, recarga);
		this.damage = damage;
		this.habilidad = habilidad;
	}

	public int getDamage() {
		return damage;
	}

	public String getHabilidad() {
		return habilidad;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.nombre + "\n" +
				"Costo: " + this.costo + "\n" +
				"Recarga: " + this.recarga + "\n" +
				"Daño: " + this.damage + "\n" +
				"Habilidad: " + this.habilidad + "\n";
	}

	@Override
	public String atacar() {
		return this.nombre + " ataca con " + this.damage + " de daño!";
	}

	@Override
	public void aceptar(IVisitor v) {
		v.visit(this);
	}
	
}
