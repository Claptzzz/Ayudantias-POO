package Logica;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class App {
	private static Scanner s = new Scanner (System.in);
	private static ISystem sys = new SystemImpl();
	
	public static void main(String[] args) throws IOException {
		loadFileUsers();
		loadFileStickers();
		
		menu();
		s.close();
		
	}

	private static void menu() {
		
		String opcion = "";
		
		do {
			System.out.println("=== Bienvenido al chat ===");
			System.out.println("1) Enviar mensaje");
			System.out.println("2) Enviar sticker");
			System.out.println("3) Ver usuarios bloqueados");
			System.out.println("4) Ver stickers disponibles");
			System.out.println("5) Dar excepcion");
			System.out.println("6) Ver chat");
			System.out.println("7) Salir");
			System.out.print("> ");
			

			opcion = s.nextLine();
			
			if (opcion.equals("1")) sendMessage();
			else if (opcion.equals("2")) sendSticker();
			else if (opcion.equals("3")) viewBlockedUsers();
			else if (opcion.equals("4")) viewApprovedStickers();
			else if (opcion.equals("5")) giveException();
			else if (opcion.equals("6")) viewChat();
			else if (opcion.equals("7")) System.out.println("Hasta pronto!");
			else System.out.println("Opcion invalida!");
			
			System.out.println();
			
		} while (!opcion.equals("7"));
		
	}

	private static void viewChat() {
		System.out.println();
		System.out.println(sys.viewChat());
		
	}

	private static void giveException() {
		System.out.println();
		
		System.out.print("Ingrese numero de administrador: ");
		int numAdmin = Integer.parseInt(s.nextLine());
		
		if (sys.existsAdmin(numAdmin)) {
			
			System.out.print("Ingrese numero del usuario: ");
			int numStudent = Integer.parseInt(s.nextLine());
			
			System.out.println(sys.giveException(numAdmin, numStudent));
			
		} else System.out.println("El administrador no existe!");
		
	}

	private static void viewApprovedStickers() {
		System.out.println();
		System.out.println(sys.getApproved());
		
		
		
	}

	private static void viewBlockedUsers() {
		System.out.println();
		System.out.println(sys.getBlocked());
		
	}

	private static void sendSticker() {
		System.out.println();
		
		System.out.print("Ingrese numero: ");
		int n = Integer.parseInt(s.nextLine());
		
		if (sys.exists(n)) {
			
			System.out.print("Ingrese id del sticker: ");
			int id = Integer.parseInt(s.nextLine());
			
			System.out.println(sys.sendSticker(n, id));
			
		} else System.out.println("El usuario no existe!");
		
	}

	private static void sendMessage() {
		System.out.println();
		
		System.out.print("Ingrese numero: ");
		int n = Integer.parseInt(s.nextLine());
		
		if (sys.exists(n)) {
			
			System.out.print("Ingrese mensaje: ");
			String msg = s.nextLine();
			
			System.out.println(sys.sendMessage(n, msg));
			
		} else System.out.println("El usuario no existe!");
	}

	private static void loadFileStickers() throws IOException {
		File file = new File("txts/stickers.txt");
		Scanner sFile = new Scanner(file);
		
		while (sFile.hasNextLine()) {
			
			String line = sFile.nextLine();
			String[] parts = line.split(",");
			
			int id = Integer.parseInt(parts[0]);
			String description = parts[1];
			String approved = parts[2];
			
 			sys.addSticker(id, description, approved);
		}
		
		sFile.close();
		
	}

	private static void loadFileUsers() throws IOException {
		File file = new File("txts/usuarios.txt");
		Scanner sFile = new Scanner(file);
		
		while (sFile.hasNextLine()) {
			
			String line = sFile.nextLine();
			String[] parts = line.split(",");
			
			String type = parts[0];
			String name = parts[1];
			String surname = parts[2];
			int number = Integer.parseInt(parts[3]);
			String extra = parts[4];
			
			sys.addUser(type, name, surname, number, extra);
			
		}
	
		sFile.close();
	}
}
