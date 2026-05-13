package Dominio;

public class Admin extends User implements Filter {
	private String role;
	
	public Admin(String name, String surname, int number, String role) {
		super(name, surname, number);
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}

	@Override
	public boolean canSendMessage() {
		return true;
	}

	@Override
	public boolean canSendSticker(Sticker s) {
		return true;
	}

	@Override
	public String getBlockReason() {
		return "Esto nunca deberia imprimirse";
	}

	@Override
	public String getStickerReason(Sticker s) {
		return "Esto nunca deberia imprimirse";
	}

	@Override
	public boolean isAdmin() {
		return true;
	}

}
