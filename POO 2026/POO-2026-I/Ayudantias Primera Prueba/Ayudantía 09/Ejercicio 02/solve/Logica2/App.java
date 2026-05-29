package Logica2;

import java.util.Scanner;


public class App {
	private static SistemaImpl s; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
         s = new SistemaImpl();
        
        System.out.println("=== INGRESO DE PARTICIPANTES ===");

        for (int i = 1; i <= 5; i++) {
            System.out.println("\nParticipante " + i);
            System.out.print("Nombre de usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Comentario: ");
            String comentario = sc.nextLine();
            System.out.print("¿Sigue la cuenta? (si/no): ");
            String sigue = sc.nextLine().toLowerCase();
            
            while (!sigue.equals("si") && !sigue.equals("no")) {
            	System.out.print("¿Sigue la cuenta? (si/no): ");
                sigue = sc.nextLine().toLowerCase();
            }

            s.añadirUsuario(nombre, comentario, sigue);

        }
        
        s.buscarGanador();
        s.resultados();
        sc.close();

	}

}
