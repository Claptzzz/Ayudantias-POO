package Visitor;

import Dominio.Ataque;
import Dominio.Defensa;
import Dominio.Productora;
import Dominio.UnUso;

public class VisitorPlanta implements IVisitor {
	protected int costoTotal = 0;
	protected int produccionTotal = 0;
	protected int damageTotal = 0;
	protected int defensaTotal = 0;

	@Override
	public void visit(Ataque a) {
		costoTotal += a.getCosto();
		damageTotal += a.getDamage();

	}

	@Override
	public void visit(Defensa d) {
		costoTotal += d.getCosto();
		defensaTotal += d.getVida();

	}

	@Override
	public void visit(UnUso u) {
		costoTotal += u.getCosto();
		damageTotal += u.getDamage();

	}

	@Override
	public void visit(Productora p) {
		costoTotal += p.getCosto();
		produccionTotal += p.getSoles();
		
	}
	
	@Override
	public String verEstadisticas() {
		return "Coste Total: " + costoTotal + "\n" +
				"Producción Total: " + produccionTotal + "\n" +
				"Daño Total: " + damageTotal + "\n" +
				"Defensa Total: " + defensaTotal;
	}

	@Override
	public void restart() {
		costoTotal = 0;
		produccionTotal = 0;
		damageTotal = 0;
		defensaTotal = 0;
		
	}

}
