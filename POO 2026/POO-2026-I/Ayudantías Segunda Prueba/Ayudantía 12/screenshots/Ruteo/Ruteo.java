import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ruteo extends JFrame {
	private JButton boton1;
	private JButton boton2;
	private JButton botonRevelador;
	private JButton botonEscondido;
	
	private JLabel mensaje;
	private Dibujar panel;
	
	public Ruteo() {
		
		setTitle("Ventana");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		mensaje = new JLabel("Bienvenido", SwingConstants.CENTER);
		add(mensaje, BorderLayout.NORTH);
		
		panel = new Dibujar();
		add(panel, BorderLayout.CENTER);
		
		JPanel botones = new JPanel();
		
		boton1 = new JButton("Botón 1");
		boton2 = new JButton("Botón 2");
		botonRevelador = new JButton("Botón 3");
		botonEscondido = new JButton("Botón Secreto");
		
		botonEscondido.setVisible(false);
		
		botones.add(boton1);
		botones.add(boton2);
		botones.add(botonRevelador);
		botones.add(botonEscondido);
		
		botonRevelador.addActionListener(e -> {
			botonEscondido.setVisible(true);
			mensaje.setText("¡Apareció el botón secreto!");
		});
		
		botonEscondido.addActionListener(e -> {
			mensaje.setText("¡Encontraste el botón secreto!");
			panel.mostrarCirculo();
		});
		
		add(botones, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ruteo();
	}
	
	class Dibujar extends JPanel {
		private boolean dibujarCirculo = false;
		
		public void mostrarCirculo() {
			dibujarCirculo = true;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.drawRect(50, 50, 200, 100);
			
			if (dibujarCirculo) {
				g.fillOval(300, 100, 100, 100);
			}
		}
	}

}
