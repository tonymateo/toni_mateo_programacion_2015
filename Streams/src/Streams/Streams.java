package Streams;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class Streams {
	
	public static File fichero1 = new File("entrada.txt"); 
	public static File fichero2 = new File("entrada1.txt");
	public static String comillas = "\"";
	
	
	public static void main(String[] args) throws IOException {
			/**Metodos metodo = new Metodos();
			if(metodo.compararContenido(fichero1, fichero2)==true){
				System.out.println("son iguales");
			}else{
				System.out.println("no son iguales");
			}**/
		Metodos buscador = new Metodos();
		try {
			System.out.println("Escribe una palabra para buscar");
			String palabraParaBuscar = "";
		    Scanner entrada = new Scanner (System.in); //Creaci�n de un objeto Scanner
		    palabraParaBuscar = entrada.nextLine (); //Invoco un m�todo sobre un objeto Scanner
			int posicion = buscador.buscarPalabra(fichero1, palabraParaBuscar.toString(), false);
			if (posicion == -1)
			{
				System.out.println("Lo siento pero tu palabra "+comillas+palabraParaBuscar+comillas+" no se encuentra en el texto");
			}else{
				System.out.println("He encontrado la palabra "+comillas+palabraParaBuscar+comillas+" en la l�nea "+posicion);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
