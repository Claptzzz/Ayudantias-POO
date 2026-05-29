package Dominio;

public class RatingVisitor implements CeluVisitor{
	private float ratingIPhone = 0;
	private int cantIPhone = 0;
	private float ratingSamsung = 0;
	private int cantSamsung = 0;
	private float finalIphone;
	private float finalSamsung;

	public RatingVisitor() {
		super();
	}

	@Override
	public void visitar(iPhone I) {
		ratingIPhone = ratingIPhone + I.getRating();
		cantIPhone++;
		
	}

	@Override
	public void visitar(Samsung P) {
		ratingSamsung = ratingSamsung + P.getRating();
		cantSamsung++;
		
	}
	
	public void calcIphone() {
		finalIphone = ratingIPhone / cantIPhone;
		
	}
	public void calcSamsung() {
		finalSamsung = ratingSamsung / cantSamsung;
		
	}

	public float getFinalIphone() {
		return finalIphone;
	}

	public void setFinalIphone(float finalIphone) {
		this.finalIphone = finalIphone;
	}

	public float getFinalSamsung() {
		return finalSamsung;
	}

	public void setFinalSamsung(float finalSamsung) {
		this.finalSamsung = finalSamsung;
	}
	
}
