package Logica;

import Dominio.*;
import java.util.List;
import java.util.ArrayList;

public class SystemImpl implements ISystem {
	
	private static List<User> users = new ArrayList<User>();
	private static List<Sticker> stickers = new ArrayList<Sticker>();
	private static List<String> chat = new ArrayList<String>();

	@Override
	public void addUser(String type, String name, String surname, int number, String extra) {
		if (type.equals("Admin")) users.add(new Admin(name, surname, number, extra));
		else users.add(new Student(name, surname, number, extra));
	}

	@Override
	public void addSticker(int id, String description, String approved) {
		if (approved.equals("Si")) stickers.add(new Sticker(id, description, true));
		else stickers.add(new Sticker (id, description, false));
	}

	@Override
	public boolean exists(int n) {
		for (User u: users) {
			if (u.getNumber() == n) return true;
		}
		return false;
	}

	@Override
	public String sendMessage(int n, String msg) {
		User u = getUser(n);
		
		if (u.canSendMessage()) {
			chat.add(u.getFullName() + ": " + msg);
			
			if (!u.isAdmin()) ((Student) u).sendMessage();
			
			return "Mensaje enviado correctamente!";
		} else return u.getBlockReason();
	}

	private User getUser(int n) {
		for (User u: users) {
			if (u.getNumber() == n) return u;
		}
		return null;
	}

	@Override
	public String sendSticker(int n, int id) {
		User u = getUser(n);
		Sticker s = getSticker(id);
		
		if (u.canSendSticker(s)) {
			chat.add(u.getFullName() + ": *" + s.getDescription() + "*");
			
			if (!u.isAdmin()) ((Student) u).sendMessage();
			
			return "Sticket enviado correctamente!";
			
		} else return u.getStickerReason(s);
	}

	private Sticker getSticker(int id) {
		for (Sticker s: stickers) { 
			if (s.getId() == id) return s;
		}
		
		return null;
	}

	@Override
	public String getBlocked() {
		String list = "=== Lista de usuarios bloqueados ===\n";
		
		for (User u: users) {
			if (!u.canSendMessage()) list += ("- " + u.getFullName() + " | " + ((Student) u).getGroup() + "\n");
		}
		
		return list;
	}

	@Override
	public String getApproved() {
		String list = "=== Lista de stickers aprobados ===\n";
		
		for (Sticker s: stickers) {
			if (s.isApproved()) list += ("- " + s.getId() + ". " + s.getDescription() + "\n"); 
		}
		
		return list;
	}

	@Override
	public boolean existsAdmin(int numAdmin) {
		for (User u: users) {
			if (u.getNumber() == numAdmin && u.isAdmin()) return true;
		}
		return false;
	}

	@Override
	public String giveException(int numAdmin, int numStudent) {
		
		if (exists(numStudent)) {
			User admin = getUser(numAdmin);
			User student = getUser(numStudent);
			
			if (student.isAdmin()) return "El alumno es un administrador";
			
			((Student) student).giveException();
			
			chat.add(admin.getFullName() + " le dio excepcion a " + student.getFullName());
			
			return "Excepcion existosa!";
			
		} else return "No existe ese alumno";
	}

	@Override
	public String viewChat() {
		String list = "=== chat ===\n";
		for (String s: chat) list += (s + "\n");
			
		return list;
	}
	
}
