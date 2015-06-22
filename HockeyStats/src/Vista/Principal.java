package Vista;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Modelo.datosJugador;

public class Principal extends JPanel {

	private vistaPrincipal vPrincipal;
	/**
	 * Create the panel.
	 */
	public Principal(vistaPrincipal vPrincipal) {
		setBounds(new Rectangle(0, 0, 430, 350));
		
		this.vPrincipal=vPrincipal;
		setLayout(null);
		
		//Pasar a la ventana de Jugadores
		JButton btnJugadores = new JButton("Jugador");
		btnJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPrincipal.cambiarVistaJugadores();
			}
		});
		btnJugadores.setBounds(10, 233, 89, 23);
		add(btnJugadores);
		
		//Pasar a la ventana de partidos
		JButton btnPartidos = new JButton("Partidos");
		btnPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPrincipal.cambiarVistaPartidos();
			}
		});
		btnPartidos.setBounds(109, 233, 89, 23);
		add(btnPartidos);
		
		//Pasar a la ventana de agregar partido
		JButton btnNPartido = new JButton("Agregar Nuevo Partido");
		btnNPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPrincipal.cambiarVistaNuevoPartido();
			}
		});
		btnNPartido.setBounds(10, 283, 188, 23);
		add(btnNPartido);
		
		//Pasar a la ventana de las estadisticas de los jugadores
		JButton btnEstadisticas = new JButton("Estadisticas de Jugadores");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPrincipal.cambiarVistaEstadisticasJugador();
			}
		});
		btnEstadisticas.setBounds(208, 233, 200, 23);
		add(btnEstadisticas);
		
		//Pasar a la ventana de crear nuevas estadisticas
		JButton btnAgregarNuevasEstadisticas = new JButton("Agregar Nuevas Estadisticas");
		btnAgregarNuevasEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vPrincipal.cambiarVistaEstadisticas();
			}
		});
		btnAgregarNuevasEstadisticas.setBounds(208, 283, 200, 23);
		add(btnAgregarNuevasEstadisticas);
		
		//Imagen
		Image logo = new ImageIcon(this.getClass().getResource("/imgHockey.png")).getImage();
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(logo));
		icono.setBounds(109, 11, 188, 211);
		add(icono);

		}
}
