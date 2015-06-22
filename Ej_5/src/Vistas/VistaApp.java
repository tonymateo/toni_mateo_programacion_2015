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
import java.util.Iterator;

import javax.swing.JPasswordField;

public class VistaApp extends JPanel {
	private JPanel base;
	private JPasswordField passwordField;
	private Modelo.usuarios usuarioJuegos=new Modelo.usuarios();

	public VistaApp() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		this.setBounds(0,0,400,400);
				
		//Icono
		Image logo = new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		JLabel icono = new JLabel("");
		icono.setBounds(25, 11, 167, 127);
		icono.setIcon(new ImageIcon(logo));
		add(icono);
				
		//Label de usuario
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(25, 149, 78, 23);
		add(lblNewLabel);
		
		//Campo de la contraseña
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(25, 253, 103, 20);
		add(passwordField);
				
		//Label de la contraseña
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
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
		elecUsuario.setBounds(28, 173, 100, 20);
		//Creo un iterator con el resultado de la bd que nos permite recorrer tdos los usuarios
		Iterator<String> contador=usuarioJuegos.getUsuarios().iterator();
			while(contador.hasNext()){
			//añadimos cada valor del iterator al comboBox
				elecUsuario.addItem(contador.next().toString());
			}
		elecUsuario.setBounds(28, 173, 100, 20);
		add(elecUsuario);
		
		//Boton de login
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(25, 298, 89, 23);
		add(btnLogIn);
		
		//Boton sign in
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(25, 332, 89, 23);
		add(btnSignUp);

	}
}
