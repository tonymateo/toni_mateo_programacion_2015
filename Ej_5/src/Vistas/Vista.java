package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Color;
import java.awt.Panel;
import java.awt.CardLayout;

import javax.swing.JMenuItem;

public class Vista extends JFrame {

	private JPanel contentPane;
	public VistaApp VistaApp;
	
	/**
	 * Create the frame.
	 */
	public Vista() {
		
		//Vista principal
		setTitle("Ejercicio 5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 456);
		
		//Creo el menu en la parte de arriba de mi aplicación
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		//Menu principal
		JMenu mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mnPrincipal.add(mntmPrincipal);
		
		//Menu Juegos
		JMenu mnJuegos = new JMenu("Juegos");
		menuBar.add(mnJuegos);
		
		JMenuItem mntmJuegos = new JMenuItem("Juegos");
		mnJuegos.add(mntmJuegos);
		
		//Menu Perfil
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmPerfil = new JMenuItem("Perfil");
		mnPerfil.add(mntmPerfil);
		getContentPane().setLayout(null);
		
		//creo el objeto que me relaciona con mi clase Vista app 
		JPanel panelPrincipal = new VistaApp();
		
		//lo añado a mi panel creado
		Panel panel = new Panel();
		panel.setBounds(0, 0, 414, 396);
		getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		panel.add(panelPrincipal,"panelPrincipal");
	}
}