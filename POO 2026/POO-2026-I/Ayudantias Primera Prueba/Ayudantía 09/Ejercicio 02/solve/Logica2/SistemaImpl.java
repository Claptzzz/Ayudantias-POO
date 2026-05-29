package Logica2;

import Dominio2.*;
import java.util.ArrayList;
import java.util.Random;

public class SistemaImpl implements Sistema{
	private ArrayList<Usuario> participantes = new ArrayList<>();
    private Ganador ganador = null;
    
	@Override
	public void buscarGanador() {
		Random random = new Random();
        ArrayList<Usuario> copia = new ArrayList<>();
        while (!participantes.isEmpty()) {
            int indice = random.nextInt(participantes.size());
            Usuario posibleGanador = participantes.get(indice);
            String comentario = posibleGanador.getComentario().toLowerCase();

            System.out.println(comentario);
            System.out.println(posibleGanador.isSigueCuenta());
            System.out.println(comentario.contains("yo"));
            System.out.println(comentario.contains(":trebolcuatrohojas:"));

            if (posibleGanador.isSigueCuenta() && comentario.contains("yo") && comentario.contains(":trebolcuatrohojas:")) {
                ganador = Ganador.getInstancia(posibleGanador);
                participantes.remove(indice);
                break;

            }
            copia.add(posibleGanador);
            participantes.remove(indice);
        }
        
        while (!copia.isEmpty()) {
        	participantes.add(copia.get(0));
        	copia.remove(0);
        }
		
	}
	@Override
	public void resultados() {
		System.out.println("");
        System.out.println("RESULTADOS DEL SORTEO");

        if (ganador != null) {
            System.out.println("Ganador de 100 lucas:");
            System.out.println("Usuario: " + ganador.getGanador().getNombre());
            System.out.println("Comentario: " + ganador.getGanador().getComentario());

            for (Usuario u : participantes) {
            	System.out.println("- " + u.getNombre());
            }

        } else {
            System.out.println("Ningún participante cumplió los requisitos.");
            System.out.println("Todos ganan 20 lucas.");
            for (Usuario u : participantes) {
                System.out.println("- " + u.getNombre());
            }
        }
		
	}
	public SistemaImpl() {

	}

    public void añadirUsuario(String nombre, String comentario, String sigue){
        Usuario u = UsuarioFactory.crearUsuario(nombre, comentario, sigue);
        participantes.add(u);
    }
	
	public ArrayList<Usuario> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(ArrayList<Usuario> participantes) {
		this.participantes = participantes;
	}
	public Ganador getGanador() {
		return ganador;
	}
	public void setGanador(Ganador ganador) {
		this.ganador = ganador;
	}

}
