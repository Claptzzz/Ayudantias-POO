package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	private static SistemaImpl s;

	public static void main(String[] args) {
		try {
			leerArchivo();
			s = new SistemaImpl();
			s.visitarCelus();
			s.resultados();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo");
		}
	}

	private static void leerArchivo() throws FileNotFoundException {
		File arch = new File("ventas.txt");
		Scanner lector = new Scanner(arch);
		while (lector.hasNextLine()) {
			String linea = lector.nextLine();
			String[] partes = linea.split(",");
			String modelo = partes[0];
			String color = partes[1];
			String pais = partes[2];
			int ventas = Integer.parseInt(partes[3]);
			float rating = Float.parseFloat(partes[4]);
			
			s.añadirCelu(modelo, color, pais, ventas, rating);
		}
		lector.close();
		
	}
}