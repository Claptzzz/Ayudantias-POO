package Dominio;

public class Sticker {
	private int id;
	private String description;
	private boolean approved;
	
	public Sticker(int id, String description, boolean approved) {
		super();
		this.id = id;
		this.description = description;
		this.approved = approved;
	}
	
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public boolean isApproved() {
		return approved;
	}
}
