package Visitor;

import Dominio.*;

public interface IVisitor {
	void visit(Ataque a);
	void visit(Defensa d);
	void visit(UnUso u);
	void visit(Productora p);
	String verEstadisticas();
	void restart();
}
