
public class Item {
	private String nombre;
	private String tipo;
	private int cantidad;
    
    public Item(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void agregarCantidad(int cant) {
        this.cantidad += cant;
    }
    public void restarCantidad(int cant) {
        this.cantidad -= cant;
        if(this.cantidad<0){
            this.cantidad=0;
        }
    }

    @Override
	public String toString() {
		return nombre+ "("+ tipo +"):"+ cantidad;
	}

}