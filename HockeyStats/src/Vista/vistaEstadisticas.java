package Vista;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Estadisticas;
import Modelo.Jugador;
import Modelo.datosEstadisticas;
import Modelo.datosJugador;
import Modelo.datosPartido;

import javax.swing.JComboBox;

public class vistaEstadisticas extends JPanel {
	
	private datosJugador datos;
	private datosPartido datosP;
	private datosEstadisticas datosEs;
	private vistaPrincipal vPrincipal;
	private JTextField textoGoles;
	private JTextField textoMinutos;
	private String id;
	
	/**
	 * Create the panel.
	 */
	public vistaEstadisticas(vistaPrincipal vPrincipal) {
		setBounds(new Rectangle(0, 0, 430, 350));
		setLayout(null);
		
		datos = new datosJugador();
		datosP= new datosPartido();
		datosEs = new datosEstadisticas();
			
		//Boton atras
		JButton atras = new JButton("Volver");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.cambiarManejador();
			}
		});
		atras.setBounds(10, 11, 110, 24);
		add(atras);
		
		//Partidos
		JLabel lblPartidos = new JLabel("Partidos");
		lblPartidos.setBounds(10, 69, 63, 14);
		add(lblPartidos);
		
		String[] dP=datosP.consultaEquipo();
		
		JComboBox boxPartidos = new JComboBox();
		boxPartidos.setBounds(10, 94, 142, 20);
		add(boxPartidos);
		for(int a=0;a<dP.length;a++){
			boxPartidos.addItem(dP[a]);
		}
		
		//Jugadores
		JLabel lblNewLabel = new JLabel("Jugadores");
		lblNewLabel.setBounds(179, 69, 78, 14);
		add(lblNewLabel);
		
		String[] dj=datos.consultaNombreJugador();
		ArrayList<Estadisticas> dE=datosEs.consultaEstadisticas();
		
		JComboBox boxJugadores = new JComboBox();
		boxJugadores.setBounds(180, 94, 154, 20);
		add(boxJugadores);
		for(int i=0;i<dj.length;i++){
			boxJugadores.addItem(dj[i]);
		}
				
		//Goles
		JLabel lblGoles = new JLabel("Goles Marcados");
		lblGoles.setBounds(10, 152, 110, 14);
		add(lblGoles);
		
		textoGoles = new JTextField();
		textoGoles.setBounds(10, 177, 142, 20);
		add(textoGoles);
		textoGoles.setColumns(10);
		
		//Minutos
		JLabel lblMinutos = new JLabel("Minutos Jugados");
		lblMinutos.setBounds(180, 152, 110, 14);
		add(lblMinutos);
		
		textoMinutos = new JTextField();
		textoMinutos.setColumns(10);
		textoMinutos.setBounds(180, 177, 154, 20);
		add(textoMinutos);
		
		//Boton guardar
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(245, 208, 89, 23);
		add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datosEs.insertarEstadisticas(boxJugadores.getSelectedItem().toString(), boxPartidos.getSelectedItem().toString(), textoGoles.getText(), textoMinutos.getText());
			}
		});

	}
}
