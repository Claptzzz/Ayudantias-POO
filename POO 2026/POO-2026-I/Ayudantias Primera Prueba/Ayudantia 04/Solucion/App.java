import java.util.*;
import java.io.*;

public class App {
	public static Jugador[] jugadores = new Jugador[100];
    public static Scanner scanner = new Scanner(System.in);
    public static Item[] itemsGlobales = new Item[100];
    public static Receta[] recetas = new Receta[100];
    public static int cantUsuarios= 0;
    public static Jugador jugadorActual;
    
    public static void main(String[] args) throws FileNotFoundException{
        cargarBloques();
        cargarRecetas();
        mostrarMenu();
        
        scanner.close();
    }
    private static void mostrarMenu() throws FileNotFoundException {
    	boolean cerrarPrograma = false;
		String op = "";
		do {
			System.out.println("---- SISTEMA DE GESTIÓN DE INVENTARIO ----");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Ver objetos disponibles");
            System.out.println("4. Administrar inventario");
            System.out.println("5. Ver mi inventario");
            System.out.println("6. Ver recetas");
            System.out.println("7. Realizar crafteo");
            System.out.println("8. Cerrar sesión");
            System.out.println("9. Cerrar sistema");
            System.out.print(">> ");
            op = scanner.nextLine();
            
            switch(op) {
            case "1":
            	registrarUsuario();
            	break;
            case "2":
            	iniciarSesion();
            	break;
            case "3":
            	verBloquesDispo();
            	break;
            case "4":
            	administrarInventario();
            	break;
            case "5":
            	verMiInventario();
            	break;
            case "6":
            	verRecetas();
            	break;
            case "7":
            	realizarCrafteo();
            	break;
            case"8":
            	cerrarSesion();
            	break;
            case("9"):
            	cerrarPrograma = cerrarSistema();
            	break;
            default:
            	System.out.println("Ingrese una opción válida.");
            }
			
		}while(!op.equalsIgnoreCase("9") || cerrarPrograma);
		
		
	}
    
    
    private static void verRecetas() {
		for(int i = 0; i<recetas.length; i++) {
			if(recetas[i]!= null) {
				System.out.println(recetas[i].toString());
				System.out.println();
			}
		}
		
	}
	private static boolean cerrarSistema() {
    	System.out.printf("Cantidad de usuarios obtenidos: %d\n", cantUsuarios);
    	System.out.println("Al apagar el sistema los datos obtenidos se eliminarán");
    	System.out.println("¿Seguro que desea cerrar el sistema? (si/no)");
		System.out.print(">> ");
		String resp = scanner.nextLine();
		if(resp.equals("si")) {
			System.out.println("Cerrando programa...");
			return true;
		} else {
			return false;
		}
	}
	private static void cerrarSesion() {
        if(jugadorActual == null){
            System.out.println("No hay ninguna sesión activa.");
            return;
        }

        System.out.println("Guardando inventario de " + jugadorActual.getUser() + "...");
        jugadorActual = null;

        System.out.println("Sesión cerrada correctamente.");
    }
    
    
	private static void realizarCrafteo() {

        Inventario inv = jugadorActual.getInventario();

        String[][] mesa = new String[2][2];

        System.out.println("Mesa de crafteo 2x2");

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){

                System.out.print("Slot del inventario para ["+i+"]["+j+"] (-1 vacio): ");
                int slot = Integer.parseInt(scanner.nextLine());

                if(slot == -1){
                    mesa[i][j] = "";
                }else{

                    Item it = inv.getItem(slot);

                    if(it != null){
                        mesa[i][j] = it.getNombre();
                    }else{
                        mesa[i][j] = "";
                    }

                }

            }
        }

        boolean recetaEncontrada = false;

        for(int r=0;r<recetas.length;r++){

            Receta rec = recetas[r];

            if(compararPatron(mesa, rec.getPatron())){

                recetaEncontrada = true;

                System.out.println("Crafteo exitoso: " + rec.getResultado());

                consumirMateriales(mesa);

                Item nuevo = new Item(rec.getResultado(), "objeto", 1);

                inv.agregarItem(nuevo);

                break;
            }
        }

        if(!recetaEncontrada){
            System.out.println("Receta inválida.");
        }

    }
	
    private static void consumirMateriales(String[][] mesa){
        Inventario inv = jugadorActual.getInventario();
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                String nombre = mesa[i][j];
                if(!nombre.equals("")){
                    for(int s=0;s<36;s++){
                        Item it = inv.getItem(s);
                        if(it != null && it.getNombre().equals(nombre)){
                            it.restarCantidad(1);
                            if(it.getCantidad() == 0){
                                inv.eliminarItem(s);
                            }
                            break;
                        }
                    }
                }
            }
        }

    }
    
	private static boolean compararPatron(String[][] mesa, String[][] patron){
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                if(!mesa[i][j].equals(patron[i][j])){
                    return false;
                }

            }
        }
        return true;
    }
	
	
	private static void verMiInventario() {
		if(jugadorActual == null){
	        System.out.println("No hay jugador activo.");
	        return;
	    }

	    System.out.println("\n=== INVENTARIO ===");
	    jugadorActual.mostrarInventario();
		
	}
	
	private static void administrarInventario() {

	    Inventario invActual= jugadorActual.getInventario();

	    System.out.println("\n1. Agregar item");
	    System.out.println("2. Aumentar cantidad");
	    System.out.println("3. Disminuir cantidad");
	    System.out.print("Opcion: ");

	    String op = scanner.nextLine();
	    scanner.nextLine();

	    switch(op){

	        case "1":
	            System.out.print("Nombre item: ");
	            String nombre = scanner.nextLine();

	            System.out.print("Tipo: ");
	            String tipo = scanner.nextLine();

	            System.out.print("Cantidad: ");
	            int cant = Integer.parseInt(scanner.nextLine());

	            Item item = new Item(nombre, tipo, cant);
	            invActual.agregarItem(item);
	        break;

	        case "2":

	            System.out.print("Slot del item: ");
	            int slot = Integer.parseInt(scanner.nextLine());

	            System.out.print("Cantidad a agregar: ");
	            int agregar = Integer.parseInt(scanner.nextLine());

	            Item it = invActual.getItem(slot);

	            if(it != null){
	                it.agregarCantidad(agregar);
	            }else{
	                System.out.println("Slot vacío.");
	            }

	        break;

	        case "3":

	            System.out.print("Slot del item: ");
	            int slot2 = Integer.parseInt(scanner.nextLine());

	            System.out.print("Cantidad a quitar: ");
	            int quitar = Integer.parseInt(scanner.nextLine());

	            Item it2 = invActual.getItem(slot2);
	            if(it2 != null){
	                it2.restarCantidad(quitar);
	                if(it2.getCantidad() == 0){
	                    invActual.eliminarItem(slot2);
	                }

	            }else{
	                System.out.println("Slot vacío.");
	            }

	        break;

	    }

	}
	
	private static void verBloquesDispo() {
		for(int i = 0; i<itemsGlobales.length; i++) {
			if(itemsGlobales[i]!= null) {
				System.out.println(i++ +"): "+ itemsGlobales[i].toString());
			}
			else {
				break;
			}
		}
		
	}
	private static void iniciarSesion() {
		boolean isValid = true;
		String nombre = "";
		String password = "";
		Jugador j;
		do {
			System.out.println("---Iniciar sesión---");
			System.out.print("- nombre usuario: ");
			nombre = scanner.nextLine();
			System.out.println("- contraseña: ");
			password = scanner.nextLine();
			
			j = verificarJugador(nombre, password);
			if(j== null) {
				System.out.println("El usuario no existe :c");
				isValid = false;
			}
			
		}while(!isValid);
		jugadorActual = j;
		System.out.printf("Bienvenido %s!", jugadorActual.getUser());
		System.out.println("Retornando al menú...");
		System.out.println();
		
	}
	
	private static void registrarUsuario() {
		boolean isValid = true;
		String nombre = "";
		String password = "";
		do {
			System.out.println("---Registrar usuario---");
			System.out.print("- nombre usuario: ");
			nombre = scanner.nextLine();
			System.out.println("- contraseña: ");
			password = scanner.nextLine();
			
			Jugador jugador = verificarJugador(nombre, password);
			if(jugador != null) {
				System.out.println("El usuario ya existe!");
				isValid = false;
			} else {
				crearJugador(nombre, password);
			}
			
		}while(!isValid);
		
		System.out.println("Sesión iniciada correctamente!");
		System.out.println("Retornando al menú...");
		System.out.println();
		
	}
	
	private static void crearJugador(String nombre, String password) {
		Jugador j = new Jugador(nombre, password);
		if(cantUsuarios < jugadores.length){
		    jugadores[cantUsuarios] = j;
		    cantUsuarios++;
		}
		else{
		    System.out.println("No se pueden registrar más jugadores.");
		}
		
	}
	
	//verificar si existe el jugador en los datos utilizando su usuario
	private static Jugador verificarJugador(String nombre, String password) {
		for(int i=0; i<cantUsuarios; i++) {
			if(jugadores[i].getUser().equalsIgnoreCase(nombre) && jugadores[i].getPassword().equalsIgnoreCase(password)) {
				return jugadores[i];
			}
		}
		return null;
	}
	
	//para cargar las recetas de forma global y ver las válidas jejej
	private static void cargarRecetas() throws FileNotFoundException {
		File arch = new File("recetas.txt");
        Scanner lector = new Scanner(arch);
        int i = 0;
        while(lector.hasNextLine()){
            String[] partes = lector.nextLine().split(";");
            recetas[i] = new Receta(partes[0], partes[1], partes[2], partes[3], partes[4]);
            i++;
        }
        lector.close();
		
	}
	
	// ver los bloques disponibles en el mundo
	public static void cargarBloques() throws FileNotFoundException{
        File arch = new File("bloques.txt");
        Scanner lector = new Scanner(arch);
        int i = 0;
        while(lector.hasNextLine()){
            String[] partes = lector.nextLine().split(";");
            itemsGlobales[i] = new Item(partes[0], partes[1], Integer.parseInt(partes[2]));
            i++;
        }
        lector.close();

    }


}
