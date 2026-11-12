package Logica;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class App {
	
	private static Scanner s = new Scanner(System.in);
	private static ISystem system = SystemImpl.getInstance();

	public static void main(String[] args) throws IOException {
		cargarArchivo();
		menu();
		
		s.close();
	}

	private static void menu() {
		String opcion = "0";
		
		while (!opcion.equals("6")) {
			System.out.println("Bienvenido al menú PvZ");
			System.out.println("1) Ver almanaque completo");
			System.out.println("2) Consultar ficha de planta por su nombre");
			System.out.println("3) Plantar en el jardin");
			System.out.println("4) Simular turno");
			System.out.println("5) Ver estadísticas");
			System.out.println("6) Salir");
			System.out.print("> ");
			
			opcion = s.nextLine();
			
			if (opcion.equals("1")) verAlmanaque();
			else if (opcion.equals("2")) consultarFicha();
			else if (opcion.equals("3")) plantar();
			else if (opcion.equals("4")) simularTurno();
			else if (opcion.equals("5")) verEstadisticas();
			else if (opcion.equals("6")) System.out.println("Adiós!!");
			else System.out.println("Esa no es una opción válida");
			
			System.out.println();
			
		}
		
	}
	
	private static void verEstadisticas() {
		System.out.println();
		
		System.out.println(system.verEstadisticas());
		
	}

	private static void simularTurno() {
		System.out.println();
		
		System.out.println("-- Simulando turno --");
		
		System.out.println(system.simularTurno());
		
	}

	private static void plantar() {
		System.out.println();
		
		System.out.print("Planta: ");
		
		String planta = s.nextLine();
		
		System.out.println(system.plantar(planta));
		
	}

	private static void consultarFicha() {
		System.out.println();
		
		System.out.print("Planta: ");
		
		String planta = s.nextLine();
		
		System.out.println(system.verFicha(planta));
		
	}

	private static void verAlmanaque() {
		System.out.println();
		
		System.out.println("Las plantas conocidas son: ");
		System.out.println(system.verAlmanaque());
	}


	private static void cargarArchivo() throws IOException {
		File f = new File("txts/plantas.txt");
		Scanner sFile = new Scanner(f);

		while (sFile.hasNextLine() ) {
			String line = sFile.nextLine();
			String[] parts = line.split(";");
			
			system.crearPlanta(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
		}
		
		
		sFile.close();
	}

}
