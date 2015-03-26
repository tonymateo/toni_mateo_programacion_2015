import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PruebaBoton extends JFrame {

	private JPanel contentPane;
	private JTextField palabra;
	private JTextField palabra2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaBoton frame = new PruebaBoton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaBoton() {
		//Creo un JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Primera palabra
		JLabel texto = new JLabel("palabra");
		texto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		texto.setBounds(39, 26, 56, 20);
		contentPane.add(texto);
		
		//Creo el contenido de la palabra 
		palabra = new JTextField();
		palabra.setBounds(20, 48, 86, 20);
		contentPane.add(palabra);
		palabra.setColumns(10);
		
		
		//Mi segunda palabra
		JLabel lblPalabra = new JLabel("palabra 2");
		lblPalabra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPalabra.setBounds(28, 134, 67, 20);
		contentPane.add(lblPalabra);
		
		//Contenido de la segunda palabra
		palabra2 = new JTextField();
		palabra2.setColumns(10);
		palabra2.setBounds(20, 165, 86, 20);
		contentPane.add(palabra2);
		
		
		//Creo un boton
		JButton boton = new JButton("Copia");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Esto es otra parte del cogido por lo tanto las variables que necesito debo añadirlas aqui dentro
				String texto1="";
				texto1=palabra.getText();
				palabra2.setText(texto1);
			}
		});
		boton.setBounds(20, 91, 89, 23);
		contentPane.add(boton);
	}
}
