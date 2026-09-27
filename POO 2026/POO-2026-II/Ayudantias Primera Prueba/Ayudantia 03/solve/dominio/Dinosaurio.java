package dominio;

public class Dinosaurio {
	
	//Tyrannosaurus;Carnivoro;28;Bosque
	private String name;
	private String dieta;
	private int edad;
	private String habitat;
	private double puntaje;
	private String inusual;
	private String nombreHijo;
	private Dinosaurio hijo;
	
	public Dinosaurio(String name, String dieta, int edad, String habitat) {
		this.name = name;
		this.dieta = dieta;
		this.edad = edad;
		this.habitat = habitat;
	}
	
	public Dinosaurio getHijo() {
		return hijo;
	}
	
	public void setHijo(Dinosaurio d) {
		this.hijo = d;
	}
	
	public String getNombreHijo() {
		return nombreHijo;
	}
	
	public void setNombreHijo(String nombre) {
		this.nombreHijo = nombre;
	}
	
	public String getInusual() {
		return inusual;
	}
	
	public void setInusual(String aux) {
		this.inusual = aux;
	}

	public String getName() {
		return name;
	}

	public String getDieta() {
		return dieta;
	}

	public int getEdad() {
		return edad;
	}

	public String getHabitat() {
		return habitat;
	}

	public double getPuntaje() {
		
		/*
		Bosque: EdadEstimada * 2
		Llanura: (EdadEstimada + 50) * 2/3
		Pantano: (EdadEstimada - 10) * 2
		Desierto: (EdadEstimada + 150) / 2
		 */
		
		if (habitat == "Bosque") {
			this.puntaje = edad*2;
			
		} else if (habitat == "Llanura") {
			this.puntaje = (edad+50) * 2/3;
			
		} else if (habitat == "Pantano") {
			this.puntaje = (edad-10)*2;
			
		} else {
			this.puntaje = (edad+150)/2;
			
		}
		return puntaje;
	}

	@Override
	public String toString() {
		return "Un " + name + " que es " + dieta + " y vive aproximadamente " + edad + " en el habitat: " + habitat;
	}

	
	
	//Un Gallimimus que es Omnivoro y vive aproximadamente 16 anios en el habitat: Desierto
}


















