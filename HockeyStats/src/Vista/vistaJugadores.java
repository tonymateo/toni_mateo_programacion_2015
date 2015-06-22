package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

import Modelo.Jugador;
import Modelo.datosJugador;

import javax.swing.JScrollPane;
import java.awt.Rectangle;

public class vistaJugadores extends JPanel {

	private vistaPrincipal vPrincipal;
	private datosJugador datos;
	
	/**
	 * Create the panel.
	 */
	public vistaJugadores(vistaPrincipal vPrincipal) {
		setBounds(new Rectangle(0, 0, 430, 350));
		setLayout(null);
		
		datos = new datosJugador();
		
		//boton atras
		JButton atras = new JButton("Volver");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.cambiarManejador();
			}
		});
		atras.setBounds(10, 11, 110, 24);
		add(atras);
		
		//Jugadores
		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setBounds(20, 53, 66, 14);
		add(lblJugadores);
		
		String[] dj=datos.consultaJugador();
		
		//Jlist con los jugadores
		JList list = new JList(dj);
		list.setBounds(20, 89, 300, 300);
		add(list);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(20, 89, 300, 80);
		add(scrollPane);
		
		

	}
}
