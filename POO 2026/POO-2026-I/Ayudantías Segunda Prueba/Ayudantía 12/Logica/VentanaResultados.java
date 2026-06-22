package Logica;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Dominio.Jugador;

public class VentanaResultados extends JFrame {

    private SistemaImpl sistema;
    private JLabel lblResultado;

    public VentanaResultados(SistemaImpl sistema) {

        this.sistema = sistema;

        setTitle("Resultados");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();

        JButton btnTiempo = new JButton("Tiempo");
        JButton btnEstadisticas = new JButton("Estadísticas");
        JButton btnJugadas = new JButton("Jugadas");
        JButton btnPorcentajes = new JButton("Porcentajes");

        panelBotones.add(btnTiempo);
        panelBotones.add(btnEstadisticas);
        panelBotones.add(btnJugadas);
        panelBotones.add(btnPorcentajes);

        lblResultado = new JLabel("Seleccione una opción");

        add(panelBotones, BorderLayout.NORTH);
        add(lblResultado, BorderLayout.CENTER);

        btnTiempo.addActionListener(e -> mostrarTiempo());
        btnEstadisticas.addActionListener(e -> mostrarEstadisticas());
        btnJugadas.addActionListener(e -> mostrarJugadas());
        btnPorcentajes.addActionListener(e -> mostrarPorcentajes());

        setVisible(true);
    }
    
    private void mostrarTiempo() {
        String texto = "";
        for(Jugador j : sistema.getJugadores()) {
            texto += j.getNombre() + ": " + j.getTiempoTotal() + " seg   ";
        }
        lblResultado.setText(texto);
    }
    
    private void mostrarEstadisticas() {
        String texto = "";
        for(Jugador j : sistema.getJugadores()) {
            texto += j.getNombre() + " [A: " + j.getAgresividad() + ", D: " + j.getDefensividad() + ", LP: " + j.getLargoPlazo() + "]   ";
        }
        lblResultado.setText(texto);
    }
    
    private void mostrarJugadas() {
        String texto = "";
        for(Jugador j : sistema.getJugadores()) {
            texto += j.getNombre() + " [Agresivas: " + j.getJugadasAgresivas() + ", Defensivas: " + j.getJugadasDefensivas() + ", Neutrales: " + j.getJugadasNeutrales() + "]   ";
        }
        lblResultado.setText(texto);
    }
    
    private void mostrarPorcentajes() {
        String texto = "";
        for(Jugador j : sistema.getJugadores()) {
            int total = j.getJugadasAgresivas() + j.getJugadasDefensivas() + j.getJugadasNeutrales();
            double pAgresivas = j.getJugadasAgresivas() * 100.0 / total;
            double pDefensivas = j.getJugadasDefensivas() * 100.0 / total;
            double pNeutrales = j.getJugadasNeutrales() * 100.0 / total;
            texto += j.getNombre() + " [A: " + String.format("%.2f", pAgresivas) + "%, D: " + String.format("%.2f", pDefensivas) + "%, N: " + String.format("%.2f", pNeutrales) + "%]   ";
        }
        lblResultado.setText(texto);
    }
}