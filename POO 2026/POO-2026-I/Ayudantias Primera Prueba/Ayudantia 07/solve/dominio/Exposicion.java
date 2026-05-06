public abstract class Exposicion {
	protected String nombre;
	protected int capMaxima;
	protected double valorMaximo;
	protected Pieza[] piezas;
    protected int cantidadActual;

	
	public Exposicion(String nombre, int capMaxima, double valorMaximo) {
		this.nombre = nombre;
		this.capMaxima = capMaxima;
		this.valorMaximo = valorMaximo;
		this.piezas = new Pieza[capMaxima];
        this.cantidadActual = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapMaxima() {
		return capMaxima;
	}
	public void setCapMaxima(int capMaxima) {
		this.capMaxima = capMaxima;
	}
	public double getValorMaximo() {
		return valorMaximo;
	}
	public void setValorMaximo(int valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public void construirDesdeInventario(Pieza[] inventario, int cantidadInventario) {
		for (int i = 0; i < cantidadInventario; i++) {
            if (cantidadActual >= capMaxima) {
                break;
            }

            Pieza pieza = inventario[i];
            if (puedeAgregar(pieza)) {
                piezas[cantidadActual] = pieza;
                cantidadActual++;
            }
        }
		
	}

	private boolean puedeAgregar(Pieza pieza) {
		if (pieza == null) {
            return false;
        }
        if (cantidadActual >= capMaxima) {
            return false;
        }
        if (contieneCodigo(pieza.getCodigo())) {
            return false;
        }

        double nuevoTotal = calcularValorActual() + pieza.getValor();
        if (nuevoTotal > valorMaximo) {
            return false;
        }

        return cumpleCriterio(pieza);
	}

	private double calcularValorActual() {
		double suma = 0;
        for (int i = 0; i < cantidadActual; i++) {
            suma += piezas[i].getValor();
        }
        return suma;
	}

	public boolean contieneCodigo(String codigo) {
	        return buscarPosicionPorCodigo(codigo) != -1;
	}
	
	public int buscarPosicionPorCodigo(String codigo) {
        for (int i = 0; i < cantidadActual; i++) {
            if (piezas[i].getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return -1;
    }

	 public abstract boolean cumpleCriterio(Pieza pieza);

	 public abstract String getDescripcionTipo();
	 
	 public void mostrarExposicion() {
	        System.out.println("Nombre exposicion: " + nombre);
	        System.out.println("Capacidad maxima: " + capMaxima);
	        System.out.println("Cantidad actual: " + cantidadActual);
	        System.out.println("Valor maximo: $" + valorMaximo);
	        System.out.println("Valor actual: $" + calcularValorActual());
	        System.out.println("Tipo exposicion: " + getDescripcionTipo());

	        if (cantidadActual == 0) {
	            System.out.println("No hay piezas en esta exposicion.");
	        } else {
	            for (int i = 0; i < cantidadActual; i++) {
	                System.out.println("[" + i + "] " + piezas[i]);
	            }
	        }
	    }
}
