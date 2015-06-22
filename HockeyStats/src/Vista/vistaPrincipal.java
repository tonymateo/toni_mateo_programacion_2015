package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

public class vistaPrincipal extends JFrame {

	private JPanel contentPane;
	//Variables para despues hacer el cardLayaout
	private Principal vManejador;
	private vistaJugadores vJugador;
	private vistaPartidos vPartido;
	private vistaNuevoPartido vNPartido;
	private vistaEstadisticas vEstadisticas;
	private vistaEstadisticasJugador vEJugador;

	/**
	 * Vista Principal
	 */
	public vistaPrincipal() {
		setTitle("Hockey Stats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		vManejador=new Principal(this);
		contentPane.add(vManejador,"Principal");
		
		vJugador=new vistaJugadores(this);
		contentPane.add(vJugador,"vistaJugadores");
		
		vPartido=new vistaPartidos(this);
		contentPane.add(vPartido,"vistaPartidos");
		
		vNPartido=new vistaNuevoPartido(this);
		contentPane.add(vNPartido,"vistaNuevoPartido");
		
		vEstadisticas = new vistaEstadisticas(this);
		contentPane.add(vEstadisticas,"vistaEstadisticas");
		
		vEJugador = new vistaEstadisticasJugador(this);
		contentPane.add(vEJugador,"vistaEstadisticasJugador");
	}
	
	public void cambiarManejador(){
		CardLayout c=(CardLayout)contentPane.getLayout();
		c.show(contentPane, "Principal");
	}

	public void cambiarVistaPartidos(){
		CardLayout c=(CardLayout)contentPane.getLayout();
		c.show(contentPane, "vistaPartidos");
	}
	
	public void cambiarVistaJugadores(){
		CardLayout c=(CardLayout)contentPane.getLayout();
		c.show(contentPane, "vistaJugadores");
	}
	public void cambiarVistaNuevoPartido(){
		CardLayout c=(CardLayout)contentPane.getLayout();
		c.show(contentPane, "vistaNuevoPartido");
	}
	public void cambiarVistaEstadisticas(){
		CardLayout c=(CardLayout)contentPane.getLayout();
		c.show(contentPane, "vistaEstadisticas");
	}
	public void cambiarVistaEstadisticasJugador(){
		CardLayout c=(CardLayout)contentPane.getLayout();
		c.show(contentPane, "vistaEstadisticasJugador");
	}
}
