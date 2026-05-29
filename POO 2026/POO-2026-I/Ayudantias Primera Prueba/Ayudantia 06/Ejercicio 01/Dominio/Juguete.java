package Dominio;

public abstract class Juguete {
	private int id;
	private String tamaño;
	private boolean estado;

	public Juguete(int id, String tamaño) {
		this.id = id;
		this.tamaño = tamaño;
		this.estado = false;
	}

	public abstract void puedeRegalar();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTamaño() {
		return tamaño;
	}


	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Juguete [id=" + id + ", tamaño=" + tamaño + ", estado=" + estado + "]";
	}

}
