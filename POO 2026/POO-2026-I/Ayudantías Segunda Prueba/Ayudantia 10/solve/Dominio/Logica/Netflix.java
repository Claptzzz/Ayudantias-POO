package Logica;

import Dominio.*;
import Strategy.*;
import java.util.ArrayList;
import java.util.List;
import Visitor.*;

public class Netflix implements ISystem {
	private static Netflix instance;
	private static List<Contenido> catalogo = new ArrayList<Contenido>();
	private static Recomendacion estrategia;
	private static IVisitor visitor;
	
	private Netflix() {
		
	}
	
	public static Netflix getInstance() {
		if (instance == null) instance = new Netflix();
		
		return instance;
	}

	@Override
	public void crearObjeto(String tipo, String nombre, String genero, int duracion, double rating) {
		Contenido c = FactoryContenido.crearObjeto(tipo, nombre, genero, duracion, rating);
		catalogo.add(c);
	}

	@Override
	public void verCatalogo() {
		for (Contenido c: catalogo) System.out.println(c + "\n======================");
		
	}

	@Override
	public String recomendaciones(String opcion) {
		
		establecerEstrategia(Integer.parseInt(opcion));
		
		estrategia.recomendar(catalogo);
		return estrategia.verEstrategia();
		
	}

	private void establecerEstrategia(int opcion) {
		estrategia = FactoryEstrategia.crearEstrategia(opcion);
	}

	@Override
	public String estadisticas(String opcion) {
		if (opcion.equals("1")) visitor = new VisitorRating();
		else if (opcion.equals("2")) visitor = new VisitorDuracion();
		else if (opcion.equals("3")) visitor = new VisitorGenero();
		
		return visitarCatalogo();
		
	}

	private String visitarCatalogo() {
		for (Contenido c: catalogo) c.aceptar(visitor);
		
		return visitor.verResultados();
	}
}
