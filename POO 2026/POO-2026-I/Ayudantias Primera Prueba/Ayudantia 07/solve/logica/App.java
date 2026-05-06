package logica;
import java.util.Scanner;

import dominio.*; 
public class App {
	public static Coleccionista coleccionista = new Coleccionista(100);
	public static Scanner sc = new Scanner(System.in);
	public static Exposicion[] exposiciones = new Exposicion[100];
	public static int cantExposiciones = 0;
	
	public static void main(String[] args) {
        if(coleccionista.cargarArchivo("piezas.txt")) {
        		System.out.println("Inventario cargado correctamente!");
        }else {
        		System.out.println("El inventario no pudo ser cargado.");
        }
        
        mostrarMenu();
	}

	private static void mostrarMenu() {
		String opcion = "";
		do {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Mostrar todas las piezas del inventario");
			System.out.println("2. Crear una exposicion tematica");
			System.out.println("3. Crear una exposicion de rareza");
			System.out.println("4. Mostrar todas las exposiciones y sus piezas");
			System.out.println("5. Buscar una pieza por codigo en el inventario y mostrar las exposiciones a las que pertenece");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opcion: ");
			opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\n=== INVENTARIO ===");
                    coleccionista.mostrarInventario();
                    break;

                case "2":
                    System.out.print("Nombre de la exposicion tematica: ");
                    String nombreTematica = sc.nextLine();

                    System.out.print("Capacidad maxima: ");
                    int capacidadTematica = Integer.parseInt(sc.nextLine());

                    System.out.print("Valor maximo total permitido: ");
                    double valorMaxTematica = Double.parseDouble(sc.nextLine());

                    System.out.print("Palabra clave para juego de cartas: ");
                    String palabraJuego = sc.nextLine();

                    System.out.print("Editorial exacta para comics: ");
                    String editorial = sc.nextLine();

                    exposiciones[cantExposiciones] = new ExposicionTematica(
                            nombreTematica,
                            capacidadTematica,
                            valorMaxTematica,
                            palabraJuego,
                            editorial
                    );

                    exposiciones[cantExposiciones].construirDesdeInventario(
                            coleccionista.getInventario(),
                            coleccionista.getCantidadActual()
                    );

                    cantExposiciones++;
                    System.out.println("Exposicion tematica creada correctamente.");
                    break;

                case "3":
                    System.out.print("Nombre de la exposicion de rareza: ");
                    String nombreRareza = sc.nextLine();

                    System.out.print("Capacidad maxima: ");
                    int capacidadRareza = Integer.parseInt(sc.nextLine());

                    System.out.print("Valor maximo total permitido: ");
                    double valorMaxRareza = Double.parseDouble(sc.nextLine());

                    System.out.print("Rareza minima para cartas: ");
                    int rarezaMin = Integer.parseInt(sc.nextLine());

                    System.out.print("Numero de edicion minimo para comics: ");
                    int edicionMin = Integer.parseInt(sc.nextLine());

                    exposiciones[cantExposiciones] = new ExposicionRareza(
                            nombreRareza,
                            capacidadRareza,
                            valorMaxRareza,
                            rarezaMin,
                            edicionMin
                    );

                    exposiciones[cantExposiciones].construirDesdeInventario(
                            coleccionista.getInventario(),
                            coleccionista.getCantidadActual()
                    );

                    cantExposiciones++;
                    System.out.println("Exposicion de rareza creada correctamente.");
                    break;

                case "4":
                    System.out.println("\n=== EXPOSICIONES ===");
                    mostrarExposiciones(exposiciones, cantExposiciones);
                    break;

                case "5":
                    System.out.print("Ingrese codigo a buscar: ");
                    String codigoBuscar = sc.nextLine();

                    Pieza encontrada = coleccionista.buscarPorCodigo(codigoBuscar);

                    if (encontrada == null) {
                        System.out.println("No existe en el inventario.");
                    } else {
                        System.out.println("Pieza encontrada:");
                        System.out.println(encontrada);
                        
                        System.out.println("\nExposiciones a las que pertenece:");
                        mostrarExposicionesDeUnaPieza(codigoBuscar, exposiciones, cantExposiciones);
                    }
                    break;

                case "6":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
			
		}while(!opcion.equals("6"));
        
		sc.close();
        
		
	}

	public static void mostrarExposicionesDeUnaPieza(String codigo, Exposicion[] exposiciones, int cantidadExposiciones) {
        boolean encontrada = false;

        for (int i = 0; i < cantidadExposiciones; i++) {
            if (exposiciones[i].contieneCodigo(codigo)) {
                System.out.println("La pieza esta en: " + exposiciones[i].getNombre());
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("La pieza no pertenece a ninguna exposicion.");
        }
    }
	
	public static void mostrarExposiciones(Exposicion[] exposiciones, int cantidadExposiciones) {
        if (cantidadExposiciones == 0) {
            System.out.println("No hay exposiciones creadas.");
            return;
        }

        for (int i = 0; i < cantidadExposiciones; i++) {
            System.out.println("\n--- Exposicion [" + i + "] ---");
            exposiciones[i].mostrarExposicion();
        }
    }

}
