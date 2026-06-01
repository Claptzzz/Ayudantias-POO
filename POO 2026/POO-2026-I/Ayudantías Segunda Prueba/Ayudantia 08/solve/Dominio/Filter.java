package Dominio;

public interface Filter {
	
	boolean canSendMessage();
	
	boolean canSendSticker(Sticker s);
	
	String getBlockReason();
	
	String getStickerReason(Sticker s);
	
	boolean isAdmin();
}
