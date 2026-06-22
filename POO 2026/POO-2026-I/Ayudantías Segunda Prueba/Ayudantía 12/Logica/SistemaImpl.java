package Logica;

import Dominio.Jugada;
import Dominio.Jugador;
import Strategy.EstrategiaAgresiva;
import Strategy.EstrategiaDefensiva;
import Strategy.EstrategiaNeutral;
import java.util.ArrayList;

public class SistemaImpl implements Sistema{
	 private ArrayList<Jugador> jugadores = new ArrayList<>();
	 private ArrayList<Jugada> jugadas;

	 public SistemaImpl() {}

	 @Override
	 public void analizarPartida() {
		 crearJugadores();
		 for(Jugada jugada : jugadas) {
			 Jugador jugador = buscarJugador(jugada.getNombreJugador());
			 Jugador rival = obtenerRival(jugador);
			 actualizarContadores(jugador, rival, jugada);
			 actualizarEstrategia(jugador, jugada);
			 jugador.getEstrategia().evaluar(jugada, jugador);
			 jugador.sumarTiempo(jugada.getTiempo());
		 }
	 }
	 
	 private void actualizarContadores(Jugador jugador, Jugador rival, Jugada jugada) {
		 if(jugada.isComePieza()) {
			 jugador.setJugadasSinComer(0);
			 rival.aumentarPiezasPerdidasSeguidas();
		 } else {
			 jugador.aumentarJugadasSinComer();
		 } 
	}
	 
	 private void actualizarEstrategia(Jugador jugador, Jugada jugada) {
		 if(jugada.isComePieza() && jugada.getPiezaComida().equals("Reina")) {
			 jugador.setEstrategia(new EstrategiaNeutral());
		 } else if(jugador.getJugadasSinComer() == 3) {
			 jugador.setEstrategia(new EstrategiaAgresiva());
			 if (jugador.getPiezasPerdidasSeguidas() == 2) {
				 jugador.setPiezasPerdidasSeguidas(0);
			 }
		 } else if(jugador.getPiezasPerdidasSeguidas() == 2) {
			 jugador.setEstrategia(new EstrategiaDefensiva());
			 if (jugador.getJugadasSinComer() == 3) {
				 jugador.setJugadasSinComer(0);
			 }
		 }
	 }
	 
	 private Jugador obtenerRival(Jugador jugador){
		 for(Jugador j : jugadores){
			 if(!j.equals(jugador)) {
				 return j;
			 }
		 }
		 return null;
	 }
	 
	 private void crearJugadores() {
		 Jugada j = jugadas.get(0);
		 jugadores.add(new Jugador(j.getNombreJugador()));
		 j = jugadas.get(1);
		 jugadores.add(new Jugador(j.getNombreJugador()));
	 }
	 
	 private Jugador buscarJugador(String nombre) {
		 for(Jugador jugador : jugadores) {
			 if(jugador.getNombre().equals(nombre)) {
				 return jugador;
			 }
		 }
		 return null;
	 }
	 
	 public void mostrarResultados() {
		    System.out.println("Resultados finales");
		    for(Jugador jugador : jugadores) {
		        System.out.println("Jugador: " + jugador.getNombre());
		        System.out.println("Tiempo total: " + jugador.getTiempoTotal() + " segundos");
		        System.out.println("Agresividad: " + jugador.getAgresividad());
		        System.out.println("Defensividad: " + jugador.getDefensividad());
		        System.out.println("Largo plazo: " + jugador.getLargoPlazo());

		        int totalJugadas = jugador.getJugadasAgresivas() + jugador.getJugadasDefensivas() + jugador.getJugadasNeutrales();

		        System.out.println("Jugadas agresivas: " + jugador.getJugadasAgresivas());
		        System.out.println("Jugadas defensivas: " + jugador.getJugadasDefensivas());
		        System.out.println("Jugadas neutrales: " + jugador.getJugadasNeutrales());

		        if(totalJugadas > 0) {
		            double porcentajeAgresivas = jugador.getJugadasAgresivas() * 100.0 / totalJugadas;
		            double porcentajeDefensivas = jugador.getJugadasDefensivas() * 100.0 / totalJugadas;
		            double porcentajeNeutrales = jugador.getJugadasNeutrales() * 100.0 / totalJugadas;

		            System.out.printf("%% Agresivas: %.2f%%\n", porcentajeAgresivas);
		            System.out.printf("%% Defensivas: %.2f%%\n",  porcentajeDefensivas);
		            System.out.printf("%% Neutrales: %.2f%%\n", porcentajeNeutrales);
		        }

		        System.out.println("----------------------------");
		    }
		}

	 public ArrayList<Jugada> getJugadas() {
		 return jugadas;
	 }

	 public void setJugadas(ArrayList<Jugada> jugadas) {
		 this.jugadas = jugadas;
	 }

	 public ArrayList<Jugador> getJugadores() {
		 return jugadores;
	 }

	 public void setJugadores(ArrayList<Jugador> jugadores) {
		 this.jugadores = jugadores;
	 }
	 
	 

}
