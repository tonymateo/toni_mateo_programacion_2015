package Vistas;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VistaApp extends JPanel {
	private JPanel base;
	private JTextField pass;

	public VistaApp() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		this.setBounds(0,0,400,400);
				
				
		//Label de usuario
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(25, 149, 78, 23);
		add(lblNewLabel);
		
		//Icono
		Image logo= new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		JLabel icono = new JLabel("");
		icono.setBounds(25, 11, 167, 127);
		icono.setIcon(new ImageIcon (logo));
		add(icono);
				
		//Label de la contraseña
		JLabel lblContrasea = new JLabel("Contrasena");
		lblContrasea.setBounds(25, 220, 78, 23);
		add(lblContrasea);
				
		//Boton de juegos
		JButton juegos = new JButton("Juegos >");
		juegos.setBounds(221, 33, 167, 23);
		add(juegos);
				
		//Boton de perfil
		JButton perfil = new JButton("Perfil >");
		perfil.setBounds(221, 69, 167, 23);
		add(perfil);
		
		//Label Usuraio
		JComboBox elecUsuario = new JComboBox();
		elecUsuario.setBounds(25, 183, 167, 23);
		add(elecUsuario);
		
		//Label Contraseña
		pass = new JTextField();
		pass.setBounds(25, 249, 167, 23);
		pass.setColumns(10);
		add(pass);

	}

}
