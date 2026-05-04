package Logica;

import Dominio.Persona;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class App {
	private static List<Persona> list = new ArrayList<Persona>();
	private static List<Persona> eliminados = new ArrayList<Persona>();
	private static int k;
	
	public static void main(String[] args) throws IOException {
		cargarArch();
		
		jugar();
		
		resultados();
	}

	private static void resultados() {
		
		System.out.println();
		System.out.println("--- Resultados ---");
		System.out.println("Ganador: " + list.get(0).getNombre() + " con nota " + list.get(0).getNota());
		System.out.println("Perdedores (en orden): ");
		for (Persona p: eliminados) System.out.println("- " + p.getNombre() + " " + p.getNota() + " -> " + p.getNotaFinal()); 
	}

	private static void jugar() {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		while (list.size() > 1) {
			
			int idxMax = list.size() - 1;
			int actual = r.nextInt(idxMax + 1);
			
			for (int i = 0; i < k; i++) {
				
				String op = "";
				
				do {
					System.out.println();
					System.out.println("La bomba la tiene " + list.get(actual).getNombre());
					System.out.println("¿Qué desea hacer?");
					System.out.println("1. Pasarla a la izquierda");
					System.out.println("2. Pasarla a la derecha");
					System.out.print("> ");
					op = s.nextLine();
					System.out.println();
					
					if (op.equals("1")) {
						System.out.println("La pasaste a la izquierda!");
						
						actual--;
						if (actual == -1) actual = idxMax;
						
					} else if (op.equals("2")) {
						System.out.println("La pasaste a la derecha!");
						
						actual++;
						if (actual > idxMax) actual = 0;
						
					} else {
						System.out.println("Ingrese una opción válida!");
						System.out.println();
					}
					
				} while (!op.equals("1") && !op.equals("2"));
				
			}
			
			System.out.println();
			System.out.println(list.get(actual).getNombre() + " fue eliminado!");
			eliminados.add(list.remove(actual));
			
		}
		
		s.close();
	}

	private static void cargarArch() throws IOException {
		
		File file = new File("txts/TalleresPOO.txt");
		Scanner sFile = new Scanner(file);
		
		k = Integer.parseInt(sFile.nextLine());
		
		while (sFile.hasNextLine()) {
			String linea = sFile.nextLine();
			String[] partes = linea.split(";");
			
			String nombre = partes[0];
			String apellido = partes[1];
			double nota = Double.parseDouble(partes[2]);
			
			list.add(new Persona(nombre, apellido, nota));
		}
		
		sFile.close();
	}

}
