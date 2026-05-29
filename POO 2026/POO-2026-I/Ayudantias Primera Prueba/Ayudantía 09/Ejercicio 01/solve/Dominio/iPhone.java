package Dominio;

public class iPhone extends Celular {

	public iPhone(String color, String pais, int ventas, float rating) {
		super(color, pais, ventas, rating);
	}
	
	@Override
	public void aceptar(CeluVisitor CV) {
		CV.visitar(this);
	}
	
	@Override
	public void calcularPrecio() {
		int precioBase = 1700;
		String color = this.getColor();
		String pais = this.getPais();
		if (color.equals("azul") || color.equals("rosado")){
			precioBase = (int) (precioBase * 1.23);
		}
		switch (pais) {
    		case "China":
        		precioBase = (int) (precioBase * 1.2);
        		break;

   		 case "Taiwan":
        		precioBase = (int) (precioBase * 1.11);
        		break;

    	case "España":
        		precioBase = (int) (precioBase * 1.25);
        		break;
		}		
		
		this.setPrecio(precioBase);
	}

}
