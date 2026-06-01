package Dominio;

public abstract class User implements Filter {
	private String name;
	private String surname;
	private int number;
	
	public User(String name, String surname, int number) {
		this.name = name;
		this.surname = surname;
		this.number = number;
	}

	public String getFullName() {
		return name + " " + surname;
	}

	public String getSurname() {
		return surname;
	}

	public int getNumber() {
		return number;
	}
}
