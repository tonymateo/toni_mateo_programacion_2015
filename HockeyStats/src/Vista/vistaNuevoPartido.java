package Vista;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import Modelo.datosPartido;

public class vistaNuevoPartido extends JPanel {
	
	private datosPartido datos;
	private vistaPrincipal vPrincipal;
	private JTextField textoDia;
	private JTextField textoEnemigo;
	private JTextField textovisitante;
	/**
	 * Create the panel.
	 */
	public vistaNuevoPartido(vistaPrincipal vPrincipal) {
		setBounds(new Rectangle(0, 0, 430, 350));
		setLayout(null);
		
		datos= new datosPartido();
		
		//atras
		JButton atras = new JButton("Volver");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.cambiarManejador();
			}
		});
		atras.setBounds(10, 11, 110, 24);
		add(atras);
		
		//Dia del partido
		JLabel lblDia = new JLabel("Dia del partido");
		lblDia.setBounds(10, 64, 139, 14);
		add(lblDia);
		
		textoDia = new JTextField();
		textoDia.setBounds(10, 104, 146, 20);
		add(textoDia);
		textoDia.setColumns(10);
		
		//Contrincante
		JLabel lblEnemigo = new JLabel("Contra quien se jugo el patido?");
		lblEnemigo.setBounds(10, 148, 197, 14);
		add(lblEnemigo);
		
		textoEnemigo = new JTextField();
		textoEnemigo.setBounds(10, 174, 146, 20);
		add(textoEnemigo);
		textoEnemigo.setColumns(10);
		
		//Lado del equipo
		JLabel lblvisitante = new JLabel("Local o visitante?");
		lblvisitante.setBounds(182, 79, 119, 14);
		add(lblvisitante);
		
		textovisitante = new JTextField();
		textovisitante.setBounds(182, 104, 146, 20);
		add(textovisitante);
		textovisitante.setColumns(10);
		
		//boton guardar cambios
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(196, 173, 89, 23);
		add(btnGuardar);
		
		JLabel lblAaaammdd = new JLabel("(aaaa-mm-dd)");
		lblAaaammdd.setBounds(10, 79, 146, 14);
		add(lblAaaammdd);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datos.insertarPartidos(textoDia.getText(), textoEnemigo.getText(), cambiaEquipo(textovisitante.getText()));
			}
		});
		
	}
	//Metodo el cual sirve para que al visitante o local en la base de datos me lo escriba como un int y no como un string
	public String cambiaEquipo(String Equipo){
		//Cojo la primera letra y la comparo. Si escribo local sera un 0 visitante un 1
		String local = Equipo.substring(0, 1);
		if(local.compareToIgnoreCase("l")==0){
			return "0";
		}else{
			return "1";
		}
	}
}