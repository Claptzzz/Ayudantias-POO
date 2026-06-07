package Logica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
	static ISystem netflix = Netflix.getInstance();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		cargarArchivo();
		menu();
		
	}

	private static void menu() {
		String opcion;
		do {
			System.out.println("=== Bienvenido al menú ===");
			System.out.println("1. Mostrar catálogo");
			System.out.println("2. Obtener recomendaciones");
			System.out.println("3. Mostrar estadísticas generales");
			System.out.println("4. Salir");
			System.out.print("> ");
			
			opcion = s.nextLine();
			System.out.println();
			
			if (opcion.equals("1")) verCatalogo();
			else if (opcion.equals("2")) recomendaciones();
			else if (opcion.equals("3")) estadisticas();
			else if (opcion.equals("4")) System.out.println("Adios!");
			else System.out.println("Opción inválida!");
			
		} while (!opcion.equals("4"));
	}
	
	

	private static void estadisticas() {
		String opcion;

		System.out.println("=== Estadísticas ===");
		System.out.println("1. Ratings promedios");
		System.out.println("2. Duraciones promedios");
		System.out.println("3. Género más frecuente");
		System.out.println("4. Salir");
		System.out.print("> ");
		
		opcion = s.nextLine();
		System.out.println();
		
		if (opcion.equals("4")) System.out.println("Volviendo al menú principal...");
		else System.out.println(netflix.estadisticas(opcion));
		
	}

	private static void recomendaciones() {
		String opcion;

		System.out.println("=== Recomendaciones ===");
		System.out.println("1. Por rating");
		System.out.println("2. Por género");
		System.out.println("3. Aleatoria");
		System.out.println("4. Salir");
		System.out.print("> ");
		
		opcion = s.nextLine();
		System.out.println();
		
		if (opcion.equals("4")) System.out.println("Volviendo al menú principal...");
		else System.out.println(netflix.recomendaciones(opcion));
		
	}
	
	private static void verCatalogo() {
		netflix.verCatalogo();
		
	}

	private static void cargarArchivo() throws IOException {
		File file = new File("txts/catalogo.txt");
		Scanner sFile = new Scanner(file);
		
		while (sFile.hasNextLine()) {
			String linea = sFile.nextLine();
			
			String[] partes = linea.split(";");
			
			String tipo = partes[0];
			String nombre = partes[1];
			String genero = partes[2];
			int duracion = Integer.parseInt(partes[3]);
			double rating = Double.parseDouble(partes[4]);
			
			netflix.crearObjeto(tipo, nombre, genero, duracion, rating);
		
		}
		
		sFile.close();
		
	}
}
