package Dominio;

public class VentasVisitor implements CeluVisitor{
	private int ventasIPhone = 0;
	private int ventasSamsung = 0;
	private int PhoneBlanco = 0;
	private int PhoneAzul = 0;
	private int PhoneRosa = 0;
	private int SamBlanco = 0;
	private int SamGris = 0;
	private int phonePais = 0;
	private String nombPais = "";
	private int samPais = 0;
	private String nombPais2 = "";
	
	public VentasVisitor() {
		super();
	}

	@Override
	public void visitar(iPhone I) {
		ventasIPhone = ventasIPhone + I.getVentas();
		if (I.getColor().equals("blanco")) {
			PhoneBlanco = PhoneBlanco + I.getVentas();
		} else if (I.getColor().equals("azul")){
			PhoneAzul = PhoneAzul + I.getVentas();
		} else if (I.getColor().equals("rosado")) {
			PhoneRosa = PhoneRosa + I.getVentas();
		}
		if (I.getVentas() > phonePais) {
			phonePais = I.getVentas();
			nombPais = I.getPais();
		}
	}

	@Override
	public void visitar(Samsung P) {
		ventasSamsung = ventasSamsung + P.getVentas();
		if (P.getColor().equals("blanco")) {
			SamBlanco = SamBlanco + P.getVentas();
		} else if (P.getColor().equals("gris")) {
			SamGris = SamGris + P.getVentas();
		}
		if (P.getVentas() > samPais) {
			samPais = P.getVentas();
			nombPais2 = P.getPais();
		}
	}
	
	public String colorSamsung() {
		if (SamBlanco > SamGris) {
			return "blanco";
		} else if (SamBlanco < SamGris) {
			return "gris";
		} else {
			return "";
		}
	}
	
	public String colorIphone() {
		if (PhoneBlanco > PhoneAzul && PhoneBlanco > PhoneRosa) {
			return "blanco";
		} else if (PhoneAzul > PhoneBlanco && PhoneAzul > PhoneRosa) {
			return "azul";
		} else if (PhoneRosa > PhoneBlanco && PhoneRosa > PhoneAzul) {
			return "rosado";
		} else {
			return "";
		}
	}
	
	public String paises() {
		return "El país con mayor ventas de iPhone fue " + nombPais + " con " + phonePais + " ventas." + "\nEl país con mayor ventas de Samsung fue " + nombPais2 + " con " + samPais + " ventas.";
	}
	
	public String mayoresVentas() {
		if (ventasIPhone > ventasSamsung) {
			return "El modelo con más ventas fue el iPhone 103 con " + ventasIPhone + " ventas.";
		} else if (ventasIPhone < ventasSamsung) {
			return "El modelo con más ventas fue el Samsung P67 con " + ventasSamsung + " ventas.";
		} else {
			return "Ambos celulares tuvieron la misma cantidad de ventas";
		}
	}
	
	public int getVentasIPhone() {
		return ventasIPhone;
	}

	public void setVentasIPhone(int ventasIPhone) {
		this.ventasIPhone = ventasIPhone;
	}

	public int getVentasSamsung() {
		return ventasSamsung;
	}

	public void setVentasSamsung(int ventasSamsung) {
		this.ventasSamsung = ventasSamsung;
	}
	
}

