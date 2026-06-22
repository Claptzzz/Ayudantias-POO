package Logica;

import Dominio.Jugada;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	private static SistemaImpl s = new SistemaImpl();
	
	public static void main(String[] args) {
		ArrayList<Jugada> jugadas = leerArchivo();
		s.setJugadas(jugadas);
        s.analizarPartida();
        s.mostrarResultados();
        new VentanaResultados(s);
    }

	private static ArrayList<Jugada> leerArchivo() {
		ArrayList<Jugada> jugadas = new ArrayList<>();

	    try {
	    	File arch = new File("jugadas.txt");
	    	Scanner scanner = new Scanner(arch);

	        while(scanner.hasNextLine()) {
	            String linea = scanner.nextLine();
	            String[] datos = linea.split(";");
	            String nombre = datos[0];
	            String posicion = datos[1];
	            String piezaMovida = datos[2];
	            boolean comePieza = datos[3].equals("si");
	            String piezaComida = datos[4];
	            int tiempo = Integer.parseInt(datos[5]);
	            jugadas.add(new Jugada(nombre,posicion,piezaMovida,comePieza,piezaComida,tiempo));
	        }
			scanner.close();

	    } catch (FileNotFoundException e) {
	        System.out.println("No se encontró el archivo.");
	    }
	    return jugadas;
	}
}