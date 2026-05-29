package Dominio;

public class Peluche extends Juguete{
	private String tipo;
	private int relleno;
	
	
	public Peluche(int id, String tamaño, String tipo, int relleno) {
		super(id, tamaño);
		this.tipo = tipo;
		this.relleno = relleno;
	}

	@Override
	public void puedeRegalar() {
		if (relleno < 15) {
			 this.setEstado(true);
		}
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public int getRelleno() {
		return relleno;
	}


	public void setRelleno(int relleno) {
		this.relleno = relleno;
	}


	@Override
	public String toString() {
		return "Peluche de " + tipo + ", Id: " + getId() + ", de tamaño: " + getTamaño();
	}
	
}
