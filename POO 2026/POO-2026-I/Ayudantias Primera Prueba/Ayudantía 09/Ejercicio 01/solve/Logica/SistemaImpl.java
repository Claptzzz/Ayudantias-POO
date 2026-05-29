package Logica;

import Dominio.*;
import java.util.ArrayList;

public class SistemaImpl implements Sistema{
	ArrayList<Celular> celus = new ArrayList<>();
	VentasVisitor calcVentas = new VentasVisitor();
	PrecioVisitor calcPrecios = new PrecioVisitor();
	RatingVisitor calcRatings = new RatingVisitor();
	
	@Override
	public void visitarCelus() {
		for (Celular c : celus) {
			c.calcularPrecio();
			c.aceptar(calcVentas);
			c.aceptar(calcPrecios);
			c.aceptar(calcRatings);
		}
		calcRatings.calcIphone();
		calcRatings.calcSamsung();
		
	}
	@Override
	public void resultados() {
		System.out.println("Ventas totales de Samsung: " + calcVentas.getVentasSamsung());
		System.out.println("Ventas totales de iPhone: " + calcVentas.getVentasIPhone());
		System.out.println("Total de dolares vendidos por Samsung: $" + calcPrecios.getPrecioSamsung());
		System.out.println("Total de dolares vendidos por iPhone: $" + calcPrecios.getPrecioIPhone());
		System.out.println("Rating final de los celulares Samsung: " + calcRatings.getFinalSamsung());
		System.out.println("Rating final de los celulares iPhone: " + calcRatings.getFinalIphone());
		String colorphone = calcVentas.colorIphone();
		
		if (colorphone.equals("")) {
			System.out.println("Ambos colores vendieron la misma cantidad de copias.");
		} else {
			System.out.println("El color más popular del modelo iPhone 103 fue el " + colorphone + ".");
		}
		
		String colorsam = calcVentas.colorSamsung();
		if (colorsam.equals("")) {
			System.out.println("Más de un color fue el más popular.");
		} else {
			System.out.println("El color más popular del modelo Samsung P67 fue el " + colorsam + ".");
		}
		
		System.out.println(calcVentas.paises());
		System.out.println(calcVentas.mayoresVentas());
		
	}
	public SistemaImpl() {
	}

	public void añadirCelu(String modelo, String color, String pais, int ventas, float rating){
		Celular celu = CeluFactory.crearCelular(modelo, color, pais, ventas, rating);
		celus.add(celu);
	}
}

