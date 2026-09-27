package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dominio.Dinosaurio;

public class Main {
	
	static Dinosaurio[] dinos;
	static Scanner s;
	
	public static void main(String[] args) throws FileNotFoundException {
		cargarHabitat();
		cargarInusual();
		setHijos();
		Menu();
		s.close();
	}

	private static void Menu() {
		int opcion;
		s = new Scanner(System.in);
		do {
			System.out.println("--- Bienvenido Jossender!! ---");
			System.out.println();
			System.out.println("1) Revisar bitacora");
			System.out.println("2) Comparar habitat");
			System.out.println("3) Calcular el mas fuerte");
			System.out.println("4) Ver Hijos");
			System.out.println("5) Salir");
			System.out.println();
			System.out.print("Ingrese opcion: ");
			opcion = s.nextInt();
			s.nextLine();
			
			switch(opcion) {
			case 1:
				revisarBitacora();
				break;
			case 2:
				comparar();
				break;
			case 3:
				masFuerte();
				break;
			case 4:
				verHijos();
				break;
			case 5:
				System.out.println("Hasta luego!!");
				break;
			default:
				System.out.println("Opcion incorrecta. Reingrese");
				break;
			}
		} while (opcion!=5);
		
	}
	
	private static void setHijos() {
		for(Dinosaurio d: dinos) {
			String nombreHijo = d.getNombreHijo();
			if (nombreHijo != null) {
				for (Dinosaurio h: dinos) {
					if (h.getName().equals(nombreHijo)) {
						d.setHijo(h);
					}
				}
			}
		}
	}

	private static void verHijos() {
		System.out.println("--- Hijos ---");
		for (Dinosaurio d: dinos) {
			if (d.getHijo() != null) {
				System.out.printf("%s es padre de %s%n", d.getName(), d.getHijo().getName());
			}
		}
		
	}

	private static void masFuerte() {
		// TODO Auto-generated method stub
		Dinosaurio max = dinos[0];
		
		for (Dinosaurio d: dinos) {
			if (d.getPuntaje() > max.getPuntaje()) {
				max = d;
			}
		}
		//El Oviraptor es el mas fuerte con 676767 puntos!!
		System.out.printf("El %s es el mas fuerte con %f puntos!!%n", max.getName(), max.getPuntaje());
		
	}

	private static void comparar() {
		// TODO Auto-generated method stub
		//El Gallimimus fue visto en el Pantano, siendo que su habitat usual es Desierto
		for (Dinosaurio d: dinos) {
			if (d.getInusual() != null)	{
				System.out.printf("El %s fue visto en el %s, siendo que su habitat usual es el %s%n", d.getName(), d.getInusual(), d.getHabitat());
			}
		}
	}

	private static void revisarBitacora() {
		// TODO Auto-generated method stub
		for (Dinosaurio d: dinos) {
			System.out.println(d);
		}
	}

	private static void cargarInusual() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File arch = new File("src/txts/Inusual.txt");
		s = new Scanner(arch);
		//Velociraptor-Bosque
		while(s.hasNextLine()) {
			String[] linea = s.nextLine().split("-");
			String name = linea[0];
			String inusual = linea[1];
			
			for (int i=0; i<dinos.length; i++) {
				if (dinos[i].getName().equals(name)) {
					dinos[i].setInusual(inusual);
					break;
				}
			}
		}
	}

	private static void cargarHabitat() throws FileNotFoundException {
		// TODO Auto-generated method stub
		dinos = new Dinosaurio[50];
		File arch = new File("src/txts/Bitacora.txt");
		//Tyrannosaurus;Carnivoro;28;Bosque
		s = new Scanner(arch);
		int idx = 0;
		while(s.hasNextLine()) {
			String[] linea = s.nextLine().split(";");
			
			String name = linea[0];
			String dieta = linea[1];
			int edad = Integer.parseInt(linea[2]);
			String habitat = linea[3];
			
			if (linea.length == 5) {
				String nombreHijo = linea[4];
				dinos[idx] = new Dinosaurio(name, dieta, edad, habitat);
				dinos[idx].setNombreHijo(nombreHijo);
			} else {
				dinos[idx] = new Dinosaurio(name, dieta, edad, habitat);
			}
			idx++;
		}
	}
}
