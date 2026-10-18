package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Conejo;
import dominio.Cuyi;
import dominio.Gato;
import dominio.Paciente;
import dominio.Perro;

public class Main {
	
	static ArrayList<Paciente> pacientes;
	static Scanner s;
	
	public static void main(String[] args) throws FileNotFoundException {
		cargarPacientes();
		Menu();
		s.close();
	}

	private static void Menu() {
		int opcion;
		s = new Scanner(System.in);
		do {
			System.out.println("===== VeteriRoss =====");
			System.out.println("1) Mostrar pacientes");
			System.out.println("2) Agregar paciente");
			System.out.println("3) Calcular precio");
			System.out.println("4) Salir");
			System.out.print("Opción: ");
			opcion = s.nextInt();
			s.nextLine();
			System.out.println();
			
			switch(opcion) {
			case 1:
				mostrarPacientes();
				break;
			case 2:
				agregarPaciente();
				break;
			case 3:
				consultarPrecio();
				break;
			case 4:
				System.out.println("Adios...");
				break;
			default:
				System.out.println("Opción incorrecta. Reingrese");
				break;
			}
			System.out.println();
		} while (opcion != 4);
	}

	private static void mostrarPacientes() {
		// Cada paciente usa el toString de su propia clase
		for (Paciente p: pacientes) {
			System.out.println(p);
		}
	}

	private static void agregarPaciente() {
		System.out.print("Especie: ");
		String especie = s.nextLine();
		
		if (!especie.equals("Cuyi") && !especie.equals("Gato") && !especie.equals("Perro") && !especie.equals("Conejo")) {
			System.out.println("Especie no válida.");
			return;
		}
		
		System.out.print("Nombre: ");
		String nombre = s.nextLine();
		System.out.print("Peso: ");
		int peso = s.nextInt();
		System.out.print("Edad: ");
		int edad = s.nextInt();
		
		Paciente nuevo = null;
		switch(especie) {
		case "Cuyi":
			System.out.print("Largo dientes: ");
			int largoDientes = s.nextInt();
			System.out.print("Velocidad: ");
			int velocidad = s.nextInt();
			nuevo = new Cuyi(nombre, peso, edad, largoDientes, velocidad);
			break;
		case "Gato":
			System.out.print("Largo cola: ");
			int largoCola = s.nextInt();
			nuevo = new Gato(nombre, peso, edad, largoCola);
			break;
		case "Perro":
			System.out.print("Vacunas pendientes: ");
			int vacunasPendientes = s.nextInt();
			nuevo = new Perro(nombre, peso, edad, vacunasPendientes);
			break;
		case "Conejo":
			System.out.print("Largo orejas: ");
			int largoOrejas = s.nextInt();
			nuevo = new Conejo(nombre, peso, edad, largoOrejas);
			break;
		}
		s.nextLine();
		
		pacientes.add(nuevo);
		System.out.println("Paciente agregado correctamente.");
	}

	private static void consultarPrecio() {
		//El precio de la atención de Willow es $79.0
		System.out.print("Nombre del paciente: ");
		String nombre = s.nextLine();
		
		for (Paciente p: pacientes) {
			if (p.getNombre().equals(nombre)) {
				System.out.println("El precio de la atención de " + p.getNombre() + " es $" + p.calcularPrecio());
				return;
			}
		}
		System.out.println("No existe un paciente con ese nombre.");
	}

	private static void cargarPacientes() throws FileNotFoundException {
		pacientes = new ArrayList<>();
		File arch = new File("src/txt/pacientes.txt");
		s = new Scanner(arch);
		//Cuyi-Nako-3-8-3-4
		while(s.hasNextLine()) {
			String[] linea = s.nextLine().split("-");
			
			String especie = linea[0];
			String nombre = linea[1];
			int peso = Integer.parseInt(linea[2]);
			int edad = Integer.parseInt(linea[3]);
			
			switch(especie) {
			case "Cuyi":
				int largoDientes = Integer.parseInt(linea[4]);
				int velocidad = Integer.parseInt(linea[5]);
				pacientes.add(new Cuyi(nombre, peso, edad, largoDientes, velocidad));
				break;
			case "Gato":
				int largoCola = Integer.parseInt(linea[4]);
				pacientes.add(new Gato(nombre, peso, edad, largoCola));
				break;
			case "Perro":
				int vacunasPendientes = Integer.parseInt(linea[4]);
				pacientes.add(new Perro(nombre, peso, edad, vacunasPendientes));
				break;
			case "Conejo":
				int largoOrejas = Integer.parseInt(linea[4]);
				pacientes.add(new Conejo(nombre, peso, edad, largoOrejas));
				break;
			}
		}
		s.close();
	}
}