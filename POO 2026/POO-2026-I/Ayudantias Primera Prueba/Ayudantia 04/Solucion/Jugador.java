public class Jugador {
	 private String user;
	 private String password;
	 public String getPassword() {
		return password;
	}

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 private Inventario inventario;

	 public Jugador(String user, String password) {
	        this.user = user;
	        this.password = password;
	        this.inventario = new Inventario();
	 }

	 public Inventario getInventario(){
		 return inventario;
	 }
	 
	 public String getUser() {
		return user;
	 }
	 
	 public void mostrarInventario() {
		 inventario.mostrarInventario();
	}
	 
}
