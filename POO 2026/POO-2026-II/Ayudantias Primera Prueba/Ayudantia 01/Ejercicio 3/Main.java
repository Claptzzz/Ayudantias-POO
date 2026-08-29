package ejercicio_3;

import java.util.Scanner;

public class Main {
	
	static Scanner s = new Scanner(System.in);
	static String[] personas = new String[100];
	static int[] puntajes = new int[100];

	public static void main(String[] agrs) {
		int opcion;
		
		do {
			System.out.println("Bievenido Aura Farmer");
			System.out.println("1) Ingresar competidor");
			System.out.println("2) Ingresar puntaje");
			System.out.println("3) Mostrar puntajes");
			System.out.println("4) Salir");
			System.out.print("Ingrese opcion: ");
			
			opcion = s.nextInt();
			s.nextLine();
			
			if (opcion == 1) {
				ingresarAuraFarmer();
			} else if (opcion == 2) {
				mostrarParticipantes();
			} else if (opcion == 3) { 
				mostrarPuntajes();
			} else if (opcion == 4) {
				System.out.println("Adios...");
			} else {
				System.out.println("Opcion Incorrecta. Reingrese.");
			}
		} while(opcion!=4);
	}

	private static void mostrarPuntajes() {
		// TODO Auto-generated method stub
		System.out.println("---Puntajes---");
		for (int i=0; i<100; i++) {
			if (personas[i] != null) {
				System.out.printf("%d) %s = %d%n", i, personas[i], puntajes[i]);
			}
		}
	}

	private static void mostrarParticipantes() {
		// TODO Auto-generated method stub
		int opcion;
		System.out.println("Participantes:");
		for (int i=0; i<100; i++) {
			if (personas[i] != null) {
				System.out.printf("%d) %s%n", i, personas[i]);
			}
		}
		System.out.print("Ingresa participante (-1 para salir): ");
		opcion = s.nextInt();
		s.nextLine();
		switch(opcion) {
			case -1: 
				System.out.println("Volviendo al menu..");
				break;
			default: 
				ingresarPuntos(opcion);
				break;
		}
	}

	private static void ingresarPuntos(int i) {
		// TODO Auto-generated method stub
		System.out.printf("Ingresa puntos de %s: ", personas[i]);
		int puntos;
		puntos = s.nextInt();
		s.nextLine();
		puntajes[i] += puntos;
	}

	private static void ingresarAuraFarmer() {
		// TODO Auto-generated method stub
		String name;
		System.out.print("Ingresa el nombre del farmeador de aura: ");
		name = s.next();
		System.out.printf("%s registrado!%n", name);
		for (int i=0; i<100; i++) {
			if (personas[i] == null) {
				personas[i] = name;
				break;
			}
		}
	}
}
