package Dominio;

public class Student extends User implements Filter {
	private String group;
	private int messagesSent;
	private boolean exception;
	
	public Student(String name, String surname, int number, String group) {
		super(name, surname, number);
		this.group = group;
		this.messagesSent = 0;
		this.exception = false;
	}

	public String getGroup() {
		return group;
	}

	public int getMessagesSent() {
		return messagesSent;
	}

	public boolean isException() {
		return exception;
	}

	@Override
	public boolean canSendMessage() {
		if (exception) return true;
		if (group.equals("X")) return false;
		if (messagesSent >= 3) return false;
		return true;
	}

	@Override
	public boolean canSendSticker(Sticker s) {
		if (group.equals("X")) return false;
		if (messagesSent >= 3) return false;
		if (s == null) return false;
		if (!s.isApproved()) return false;
		return true;
	}

	@Override
	public String getBlockReason() {
		if (group.equals("X")) return "Error: No pertenece a ningun paralelo";
		if (messagesSent >= 3) return "Error: No puede mandar mas mensajes";
		
		return "Esto nunca deberia imprimirse";
	}

	@Override
	public String getStickerReason(Sticker s) {
		if (group.equals("X")) return "Error: No pertenece a ningun paralelo";
		if (messagesSent >= 3) return "Error: No puede mandar mas mensajes";
		if (s == null) return "Error: El sticker no existe";
		if (!s.isApproved()) return "Error: El sticker no esta aprobado";
		return "Esto nunca deberia imprimirse";
	}

	@Override
	public boolean isAdmin() {
		return false;
	}

	public void giveException() {
		exception = true;	
	}

	public void sendMessage() {
		messagesSent++;
		
	}

}
