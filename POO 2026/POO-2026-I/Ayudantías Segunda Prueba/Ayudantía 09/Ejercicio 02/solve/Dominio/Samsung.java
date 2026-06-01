package Dominio;

public class Samsung extends Celular{
	
	public Samsung(String color, String pais, int ventas, float rating) {
		super(color, pais, ventas, rating);
	}

	@Override
	public void aceptar(CeluVisitor CV) {
		CV.visitar(this);
	}

	@Override
	public void calcularPrecio() {
		int precioBase = 1500;
		String color = this.getColor();
		String pais = this.getPais();
		if (color.equals("gris")){
			precioBase = (int) (precioBase * 1.1);
		}
		switch (pais) {
			case "Estados Unidos":
				precioBase = (int) (precioBase * 1.2);
				break;

			case "Venezuela":
				precioBase = (int) (precioBase * 1.57);
				break;

			case "India":
				precioBase = (int) (precioBase * 0.99);
				break;
}
		
		this.setPrecio(precioBase);
	}

	
}
