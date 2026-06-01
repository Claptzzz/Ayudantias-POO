package Dominio;

public class PrecioVisitor implements CeluVisitor{
	private int precioIPhone = 0;
	private int precioSamsung = 0;
	
	public PrecioVisitor() {
		super();
	}

	@Override
	public void visitar(iPhone I) {
		precioIPhone = precioIPhone + (I.getPrecio() * I.getVentas());
		
	}

	@Override
	public void visitar(Samsung P) {
		precioSamsung = precioSamsung + (P.getPrecio() * P.getVentas());
		
	}

	public int getPrecioIPhone() {
		return precioIPhone;
	}

	public void setPrecioIPhone(int precioIPhone) {
		this.precioIPhone = precioIPhone;
	}

	public int getPrecioSamsung() {
		return precioSamsung;
	}

	public void setPrecioSamsung(int precioSamsung) {
		this.precioSamsung = precioSamsung;
	}

}
