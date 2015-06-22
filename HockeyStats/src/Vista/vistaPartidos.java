package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;

import Modelo.datosPartido;

public class vistaPartidos extends JPanel {
	
	private vistaPrincipal vPrincipal;
	private datosPartido datos;

	/**
	 * Create the panel.
	 */
	public vistaPartidos(vistaPrincipal vPrincipal) {
		setBounds(new Rectangle(0, 0, 430, 350));
		setLayout(null);
		
		datos= new datosPartido();
		
		//Partidos
		JLabel lblPartidos = new JLabel("Partidos Jugados");
		lblPartidos.setBounds(21, 61, 134, 14);
		add(lblPartidos);
		
		//Boton atras
		JButton atras = new JButton("Volver");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.cambiarManejador();
			}
		});
		atras.setBounds(10, 11, 110, 24);
		add(atras);
		
		//Lista con los partidos
		String[] dp=datos.consultaPartido();
		
		JList list = new JList(dp);
		list.setBounds(20, 89, 300, 300);
		add(list);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(20, 89, 300, 80);
		add(scrollPane);

	}
}
