package solve;

import java.util.Scanner;

import java.io.*;

public class MAIN {
	public static void main(String[] args) throws IOException {
		
		String[][][] sopas = cargarSopas();
		String[][] palabras = cargarPalabras(sopas);
		
		System.out.println("---------------------------------");
		
		menu(sopas, palabras);
		
	}

	private static void menu(String[][][] sopas, String[][] palabras) {
		Scanner s = new Scanner(System.in);
		int opcion = 0;
		
		String[][] listas = new String[10][100];
		
		while (opcion != 4) {
			System.out.println("-- Bienvenido a su menú de sopa de letras --");
			
			System.out.println("1) Ver sopas de letras");
			System.out.println("2) Anotar palabra");
			System.out.println("3) Ver avance");
			System.out.println("4) Salir");
			System.out.print(">");
			
			opcion = Integer.parseInt(s.nextLine());
			
			if (opcion == 1) verSopas(sopas, palabras);
			else if (opcion == 2) anotarPalabra(sopas, palabras, listas, s);
			else if (opcion == 3) verAvance(sopas, palabras, listas, s);
			else if (opcion == 4) System.out.println("Adios!!!");
			else System.out.println("Opción inválida");
			
			System.out.println();
		}
		
		s.close();
	}

	private static void verAvance(String[][][] sopas, String[][] palabras, String[][] listas, Scanner s) {
		System.out.println();
		
		System.out.print("Sopa de letras número: ");
		int n = Integer.parseInt(s.nextLine());
		
		if (n > 0 && n < 11 && sopas[n - 1] != null) {
			int idx = n-1;
			
			double total = 0;
			double anotadas = 0;
			
			for (int i = 0; i < 100; i++) {
				if (palabras[idx][i] != null) total++;
				if (listas[idx][i] != null) anotadas++;
			}
			
			double porc = (anotadas/total) * 100.0; 
			
			System.out.printf("El porcentaje de la sopa de letras es %d%n", (int)(porc));
			
		} else System.out.println("Esa no es una sopa de letras válida");
		
	}

	private static void anotarPalabra(String[][][] sopas, String[][] palabras, String[][] listas, Scanner s) {
		
		System.out.println();
		
		System.out.print("Sopa de letras número: ");
		int n = Integer.parseInt(s.nextLine());
		
		if (n > 0 && n < 11 && sopas[n - 1] != null) {
			int idx = n-1;
			
			System.out.println();
			System.out.print("¿Qué palabra deseas anotar?: ");
			String p = s.nextLine();
			
			boolean existe = false;
			
			for (int i = 0; i < 100; i++) {
				if (palabras[idx][i] != null && palabras[idx][i].equalsIgnoreCase(p)) existe = true;
			}
			
			if (existe) {
				for (int i = 0; i < 100; i++) {
					if (listas[idx][i] == null) {
						listas[idx][i] = p; 
						System.out.println("Palabra agregada con éxito");
						return;
					}
					if (listas[idx][i].equalsIgnoreCase(p)) {
						System.out.println("Esa palabra ya fue agregada anteriormente");
						return;
					}
				}
			} else {
				System.out.println("La palabra que quieres agregar no existe en esa sopa de letras");
			}
			
		} else System.out.println("Esa no es una sopa de letras válida");
		
		
		
	}

	private static void verSopas(String[][][] sopas, String[][] palabras) {
		for (int i = 0; i < sopas.length; i++) {
			if (sopas[i] != null) {
				int n = sopas[i].length;
				int m = sopas[i][0].length;
				
				System.out.printf("Sopa de letras número %d: Tamaño %dx%d%n", i+1,n,m);
				
				for (int f = 0; f < n; f++) {
					for (int c = 0; c < m; c++) {
						System.out.print(sopas[i][f][c] + " ");
					}
					System.out.println();
				}
				
				System.out.println("Palabras: ");
				for (String p: palabras[i]) {
					if (p == null) break;
					System.out.print(p + "-");
				}
				
				System.out.println();
			}
		}
		
	}

	private static String[][] cargarPalabras(String[][][] sopas) throws IOException {
		File file = new File("txts/agenda.txt");
		Scanner s = new Scanner(file);
		
		String[][] palabras = new String[10][100];
		
		while (s.hasNextLine()) {
			
			String p = s.nextLine();
			boolean aparece = false;
			
			
			for (int i = 0; i < sopas.length; i++) {
				if (sopas[i] == null) break;
				
				aparece = existe(sopas[i], p);
				
				if (aparece) {
					agregarPalabra(palabras[i], p);
					System.out.printf("La palabra %s aparece en la sopa de letras número %d%n", p, i+1);
					break;
				}
			}
			
			if (!aparece) System.out.printf("La palabra %s no aparece en ninguna sopa de letras%n", p);

		}
		
		s.close();
		
		return palabras;
	}

	private static void agregarPalabra(String[] listado, String p) {
		for (int i = 0; i < 100; i++) {
			if (listado[i] == null) {
				listado[i] = p;
				return;
			}
		}
	}

	private static boolean existe(String[][] sopa, String p) {
		String inicio = Character.toString(p.charAt(0));
		int largo = p.length();
		
		int n = sopa.length;
		int m = sopa[0].length;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (sopa[i][j].equalsIgnoreCase(inicio)) {
					
					int coincidencias = 0;
					
					//Revisamos hacía la derecha
					for (int k = 0; k < largo && j + k < m; k++) {
						if (Character.toString(p.charAt(k)).equalsIgnoreCase(sopa[i][j+k])) {
							coincidencias++;
						} else break;
					}
					
					if (coincidencias == largo) return true;
					coincidencias = 0;
					
					//Revisamos hacía abajo
					for (int k = 0; k < largo && i + k < n; k++) {
						if (Character.toString(p.charAt(k)).equalsIgnoreCase(sopa[i+k][j])) {
							coincidencias++;
						} else break;
					}
					
					if (coincidencias == largo) return true;
					
				}
			}
		}	
		
		return false;
	}

	private static String[][][] cargarSopas() throws IOException {
		File file = new File("txts/sopas.txt");
		Scanner s = new Scanner(file);
		
		String cantidadString = s.nextLine();
		int cantidad = Integer.parseInt(cantidadString);
		
		String[][][] sopas = new String[cantidad][][];
		
		int idx = 0; 
		
		while (s.hasNextLine()) {
			
			String size = s.nextLine();
			String[] partesSize = size.split("x");
			
			int n = Integer.parseInt(partesSize[0]);
			int m = Integer.parseInt(partesSize[1]);
			
			sopas[idx] = new String[n][m];
			
			for (int i = 0; i < n; i++) {
				String fila = s.nextLine();
				String[] columnas = fila.split(",");
				
				for (int j = 0; j < m; j++) {
					
					sopas[idx][i][j] = columnas[j];
				}
			}
			
			idx++;
		}
		
		s.close();
		
		return sopas;
	}
}