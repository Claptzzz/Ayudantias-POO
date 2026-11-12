package Logica;

import java.util.List;
import java.util.ArrayList;
import Dominio.*;
import Visitor.*;

public class SystemImpl implements ISystem {
	private static List<Planta> almanaque = new ArrayList<Planta>();
	private static List<Planta> jardin = new ArrayList<Planta>();
	private static int soles = 100;
	private IVisitor visitor = new VisitorPlanta();

	private static instance;

	private SystemImpl() { }

	publis static SystemImpl getInstance() {
		if (instance == null) instance = new SystemImpl();

		return instance;
	}

	@Override
	public void crearPlanta(String tipo, String nombre, String costo, String recarga, String parametro, String extra) {
		almanaque.add(FactoryPlantas.crearPlanta(tipo, nombre, costo, recarga, parametro, extra));
	}

	@Override
	public String verAlmanaque() {
		String mensaje = "";
		
		for (Planta p: almanaque) {
			mensaje += p.getNombre() + "\n";
		}
		
		if (mensaje.equals("")) return "No hay ninguna planta cargada";
		
		return mensaje;
	}

	@Override
	public String verFicha(String planta) {
		
		for (Planta p: almanaque) {
			if (p.getNombre().equalsIgnoreCase(planta)) return p.toString();
		}
		
		return "Esa planta no existe";
	}

	@Override
	public String plantar(String planta) {
		
		for (Planta p: almanaque) {
			if (p.getNombre().equalsIgnoreCase(planta)) {
				
				if (p.getCosto() <= soles) {
					jardin.add(p);
					soles -= p.getCosto();
					return planta + " plantada con éxito";
				} else return "No tienes suficientes soles para plantar " + planta;
			}
		}
		
		return "Esa planta no existe";
	}

	@Override
	public String simularTurno() {
		
		String mensaje = "";
		
		for (Planta p: jardin) {
			if (p instanceof Atacantes) {
				((Atacantes) p).atacar();
				
				if (p instanceof UnUso) {
					jardin.remove(p);
				}
			
			} else if (p instanceof Productoras) {
				((Productoras) p).Producir();
				soles += ((Productora) p).getRecarga();
			}
		}
		
		if (mensaje.equals("")) return "No hay ninguna planta en el jardín";
		
		visitor.restart();
		
		return mensaje;
	}

	@Override
	public String verEstadisticas() {
		for (Planta p: jardin) {
			p.aceptar(visitor);
		}
		
		return visitor.verEstadisticas();
	}

}
