package Logica;

public interface ISystem {
	void addUser(String type, String name, String surname, int number, String extra);

	void addSticker(int id, String description, String approved);

	boolean exists(int n);

	String sendMessage(int n, String msg);

	String sendSticker(int n, int id);

	String getBlocked();

	String getApproved();

	boolean existsAdmin(int numAdmin);

	String giveException(int numAdmin, int numUser);

	String viewChat();
	
}
