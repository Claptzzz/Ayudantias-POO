import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Coleccionista {
	private Pieza[] inventario;
	private int cantidadActual;
	
	public Coleccionista(int capacidadMaxima) {
		this.inventario = new Pieza[capacidadMaxima];
		this.cantidadActual = 0;
	}
	
	public Pieza[] getInventario() {
		return inventario;
	}
	public void setInventario(Pieza[] inventario) {
		this.inventario = inventario;
	}
	public int getCantidadActual() {
		return cantidadActual;
	}
	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public boolean cargarArchivo(String string) {
		boolean agregada = false;
		
		File arch = new File("piezas.txt");
		try {
			Scanner lector = new Scanner(arch);
			while(lector.hasNextLine()) {
				String[] partes = lector.nextLine().split(";");
				 String tipo = partes[0];
                 String codigo = partes[1];
                 String nombre = partes[2];
                 int año = Integer.parseInt(partes[3]);
                 double valor = Double.parseDouble(partes[4]);
                 
                 Pieza nueva = null;
                 
                 if (tipo.equalsIgnoreCase("CARTA")) {
                     String juego = partes[5];
                     int rareza = Integer.parseInt(partes[6]);
                     nueva = new Carta(codigo, nombre, año, valor, juego, rareza);
                 } else if (tipo.equalsIgnoreCase("COMIC")) {
                     String editorial = partes[5];
                     int numeroEdicion = Integer.parseInt(partes[6]);
                     nueva = new Comic(codigo, nombre, año, valor, editorial, numeroEdicion);
                 }
                 if (nueva != null) {
                     agregada = agregarPieza(nueva);
                 } else {
                	 	agregada = false;
                 }
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return agregada;
		}
		return agregada;
		
	}

	private boolean agregarPieza(Pieza nueva) {
		 if (cantidadActual >= inventario.length) {
	            return false;
	        }

	        int posicionExistente = buscarPosicionPorCodigo(nueva.getCodigo());

	        if (posicionExistente == -1) {
	            inventario[cantidadActual] = nueva;
	            cantidadActual++;
	            return true;
	        }

	        Pieza existente = inventario[posicionExistente];

	        if (nueva.getAño() < existente.getAño()) {
	            inventario[posicionExistente] = nueva;
	            return true;
	        }

	        return false;
	}

	private int buscarPosicionPorCodigo(String codigo) {
		for (int i = 0; i < cantidadActual; i++) {
            if (inventario[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
	}

	public void mostrarInventario() {
		if (cantidadActual == 0) {
            System.out.println("Inventario vacio.");
            return;
        }

        for (int i = 0; i < cantidadActual; i++) {
            System.out.println("[" + i + "] " + inventario[i]);
        }
		
	}

	public Pieza buscarPorCodigo(String codigoBuscar) {
		int pos = buscarPosicionPorCodigo(codigoBuscar);
        if (pos == -1) {
            return null;
        }
        return inventario[pos];
	}

}
