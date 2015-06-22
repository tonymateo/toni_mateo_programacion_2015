package Vista;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Estadisticas;
import Modelo.datosEstadisticas;
import Modelo.datosPartido;

public class vistaEstadisticasJugador extends JPanel {
	
	private datosEstadisticas datos;
	private vistaPrincipal vPrincipal;
	private JTextField textoGoles;
	private JTextField textoMinutos;
	/**
	 * Create the panel.
	 */
	public vistaEstadisticasJugador(vistaPrincipal vPrincipal) {
		setBounds(new Rectangle(0, 0, 430, 350));
		setLayout(null);
		
		datos= new datosEstadisticas();
				
		//boton atras
		JButton atras = new JButton("Volver");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.cambiarManejador();
			}
		});
		atras.setBounds(10, 11, 110, 24);
		add(atras);
		
		//Goles Marcados
		JLabel lblGoles = new JLabel("Goles Marcados");
		lblGoles.setBounds(74, 150, 110, 14);
		add(lblGoles);
			
		textoGoles = new JTextField();
		textoGoles.setBounds(74, 175, 110, 20);
		add(textoGoles);
		textoGoles.setColumns(10);
			
		//Minutos Jugados
		JLabel lblMinutos = new JLabel("Minutos Jugados");
		lblMinutos.setBounds(211, 150, 110, 14);
		add(lblMinutos);
			
		textoMinutos = new JTextField();
		textoMinutos.setColumns(10);
		textoMinutos.setBounds(211, 175, 110, 20);
		add(textoMinutos);

		//Jugadores
		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setBounds(133, 64, 78, 14);
		add(lblJugadores);
				
		//Me creo mi variable dEstadisticas que sera un arrayList de objetos estadistica que luego le pasare al comboBox
		ArrayList<Estadisticas> dE=datos.consultaEstadisticas();
		
		JComboBox boxJugadores = new JComboBox();
		boxJugadores.setBounds(133, 89, 110, 20);
		add(boxJugadores);
		for(int i=0;i<dE.size();i++){
			boxJugadores.addItem(dE.get(i).getIdJugador());
		}
		boxJugadores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int a=0;a<boxJugadores.getItemCount();a++){
					//compruebo que el elemento que he seleccionado en el combobox corresponde con alguno de la base de datos 
					if (boxJugadores.getSelectedItem() == dE.get(a).getIdJugador()){
						//si coincide el seleccionado con el combo box rellena los demas campos con los datos restantes
						textoGoles.setText(dE.get(a).getGolesMarcados());
						textoMinutos.setText(dE.get(a).getMinutosJugados());
						
					}
						
				}
				
			}
		});
		}
	}