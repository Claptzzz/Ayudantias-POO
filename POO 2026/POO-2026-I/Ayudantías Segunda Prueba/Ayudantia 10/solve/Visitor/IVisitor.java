package Visitor;

import Dominio.*;

public interface IVisitor {
	void visit(Pelicula p);
	void visit(Serie s);
	String verResultados();
}
