package Logica;

import Dominio.Cancion;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class App2 {
	private static List<Cancion> list = new LinkedList<Cancion>();
	private static Scanner s = new Scanner(System.in);
	private static int actual = 0;
	
	public static void main(String[] args) throws IOException{
		cargarArch();
		
		menu();
	}

	private static void menu() {
		String op = "0";
		
		do {
			System.out.println("--- Bienvenido al menú ---");
			System.out.println("1) Mostrar canción actual");
			System.out.println("2) Avanzar canción");
			System.out.println("3) Retroceder canción");
			System.out.println("4) Ordenar siguientes");
			System.out.println("5) Agregar canciones");
			System.out.println("6) Eliminar canciones");
			System.out.println("7) Ver playlist");
			System.out.println("8) Salir");
			System.out.println("¿Qué desea hacer?");
			System.out.print("> ");
			op = s.nextLine();
			
			if (op.equals("1")) mostrarCancion();
			else if (op.equals("2")) avanzar();
			else if (op.equals("3")) retroceder();
			else if (op.equals("4")) ordenar();
			else if (op.equals("5")) agregar();
			else if (op.equals("6")) eliminar();
			else if (op.equals("7")) ver();
			else if (op.equals("8")) System.out.println("Hasta pronto!");
			else { 
				System.out.println("Ingrese una opción válida!s");
			}
			System.out.println();
			
		} while (!op.equals("8"));
		
	}

	private static void ver() {
		for (int i = 0; i < list.size(); i++) {
			if (i == actual) System.out.println(list.get(i).toString() + " -> Actual");
			else System.out.println(list.get(i).toString());
		}	
	}

	private static void eliminar() {
		System.out.println();
		
		System.out.print("Ingrese nombre: ");
		String nombre = s.nextLine();
		
		for (Cancion c: list) {
			if (c.getNombre().equalsIgnoreCase(nombre)) {
				list.remove(c);
				return;
			}
		}
		
		System.out.println("No se encontró esa canción!");
	}

	private static void agregar() {
		System.out.println();
		
		System.out.print("Ingrese nombre: ");
		String nombre = s.nextLine();
		
		System.out.print("Ingrese artista: ");
		String artista = s.nextLine();
		
		System.out.print("Ingrese tiempo (min:seg): ");
		String tiempo = s.nextLine();
		
		int seg = convertirTiempo(tiempo);
		
		System.out.print("Ingrese posición en top 1000: ");
		int pos = Integer.parseInt(s.nextLine());
		
		System.out.print("Ingrese fecha (dd/mm/aaaa): ");
		String fecha = s.nextLine();
		
		list.add(new Cancion(nombre, artista, seg, pos, fecha));
		
		System.out.println("Canción agregada con éxito!");
		
	}

	private static void ordenar() {
		String op = "";
		System.out.println();
		System.out.println("Segun criterio: ");
		System.out.println("1) Duración");
		System.out.println("2) Posición en el top 1000");
		System.out.println("3) Fecha publicación");
		System.out.print("> ");
		op = s.nextLine();
		
		if (op.equals("1")) duracion();
		else if (op.equals("2")) posicion();
		else if (op.equals("3")) fecha();
		else System.out.println("Opción no es válida");
		System.out.println("Playlist ordenada exitosamente!");
	}

	private static void fecha() {
		for (int a = actual + 1; a < list.size() - 1; a++) {
			for (int b = a + 1; b < list.size(); b++) {
				
				String[] partesA = list.get(a).getFecha().split("/");
				int diaA = Integer.parseInt(partesA[0]);
				int mesA = Integer.parseInt(partesA[1]);
				int yearA = Integer.parseInt(partesA[2]);
				
				String[] partesB = list.get(b).getFecha().split("/");
				int diaB = Integer.parseInt(partesB[0]);
				int mesB = Integer.parseInt(partesB[1]);
				int yearB = Integer.parseInt(partesB[2]);
				
				if (yearA < yearB) {
					Cancion aux = list.get(a);
					list.set(a, list.get(b));
					list.set(b, aux);
				} else if (yearA == yearB) {
					if (mesA < mesB) {
						Cancion aux = list.get(a);
						list.set(a, list.get(b));
						list.set(b, aux);
					} else if (mesA == mesB) {
						if (diaA < diaB) {
							Cancion aux = list.get(a);
							list.set(a, list.get(b));
							list.set(b, aux);
						}
					}
				}
			}
		}
	}

	private static void posicion() {
		for (int a = actual + 1; a < list.size() - 1; a++) {
			for (int b = a + 1; b < list.size(); b++) {
				if (list.get(a).getPos() > list.get(b).getPos()) {
					
					Cancion aux = list.get(a);
					list.set(a, list.get(b));
					list.set(b, aux);
					
				}
			}
		}
	}

	private static void duracion() {
		for (int a = actual + 1; a < list.size() - 1; a++) {
			for (int b = a + 1; b < list.size(); b++) {
				if (list.get(a).getSegundos() > list.get(b).getSegundos()) {
					
					Cancion aux = list.get(a);
					list.set(a, list.get(b));
					list.set(b, aux);
					
				}
			}
		}
	}

	private static void retroceder() {
		System.out.println();
		
		if (actual - 1 < 0) System.out.println("Estás en la primera canción");
		else {
			System.out.println("Canción anterior!");
			actual--;
		}
		
	}

	private static void avanzar() {
		System.out.println();
		int size = list.size();
		
		if (actual + 1 >= size) System.out.println("Estás en la última canción");
		else {
			System.out.println("Siguiente canción!");
			actual++;
		}
	}

	private static void mostrarCancion() {
		System.out.println();
		System.out.println("Canción actual: " + list.get(actual).toString());
		
	}

	private static void cargarArch() throws IOException {
		File file = new File("txts/canciones.txt");
		Scanner sFile = new Scanner(file);
		
		while (sFile.hasNextLine()) {
			String linea = sFile.nextLine();
			String[] partes = linea.split(";");
			
			String nombre = partes[0];
			String artista = partes[1];
			
			String tiempo = partes[2]; //min:seg
			
			int seg = convertirTiempo(tiempo);
			
			int pos = Integer.parseInt(partes[3]);
			
			String fecha = partes[4];
			
			list.add(new Cancion(nombre, artista, seg, pos, fecha));
		}
		
		sFile.close();
	}

	private static int convertirTiempo(String tiempo) {
		String[] partes = tiempo.split(":");
		
		int min = Integer.parseInt(partes[0]);
		int seg = Integer.parseInt(partes[1]);
		
		return min * 60 + seg;
	}
}
