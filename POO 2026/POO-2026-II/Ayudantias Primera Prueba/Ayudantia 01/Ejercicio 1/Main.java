package ejercicio_1;

import java.util.Scanner;

public class Main {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] agrs) {
		int opcion;
		
		do {
			System.out.println("Bievenido Aura Farmer");
			System.out.println("1) Ingresar competidor");
			System.out.println("2) Salir");
			System.out.print("Ingrese opcion: ");
			
			opcion = s.nextInt();
			s.nextLine();
			
			if (opcion == 1) {
				ingresarAuraFarmer();
			} else if (opcion == 2) {
				System.out.println("Adios...");
			} else {
				System.out.println("Opcion Incorrecta. Reingrese.");
			}
		} while(opcion!=2);
	}

	private static void ingresarAuraFarmer() {
		// TODO Auto-generated method stub
		String name;
		System.out.print("Ingresa el nombre del farmeador de aura: ");
		name = s.next();
		System.out.printf("%s registrado!%n", name);
		}
}
