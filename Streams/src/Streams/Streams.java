package Streams;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class Streams {
	
	public static File fichero1 = new File("entrada.txt"); 
	public static File fichero2 = new File("entrada1.txt");
	public static File ficheroOrigen = new File("Origen.txt");
	public static File ficheroDestino = new File("Destino.txt");
	public static String comillas = "\"";
	
	
	public static void main(String[] args) throws IOException {
		
		//Toni Mateo
		//Primera parte Ejercicio 1c
		///////
		/**Metodos metodo = new Metodos();
		 *//*si el metodo compararConteido me devuelve true; imprimo por pantalla: son iguales, si no: no son iguales
			if(metodo.compararContenido(fichero1, fichero2)==true){
				System.out.println("son iguales");
			}else{
				System.out.println("no son iguales");
			}**/
		
		///////
		//Toni Mateo
		//Segunda parte Ejercicio 1c
		Metodos buscador = new Metodos();
		try {
			System.out.println("Escribe una palabra para buscar");
			String palabraParaBuscar = ""; //me creo un string vacio que luego se rellenará con la palabra que el usuario desee buscar
			Scanner entrada = new Scanner (System.in); //Creación de un objeto Scanner
			palabraParaBuscar = entrada.nextLine (); //Invoco un método sobre un objeto Scanner
			//me creo una variable posicion de tipo int en la cual me guardo lo que devuelve el metodo buscarPalabra
			int posicion = buscador.buscarPalabra(fichero1, palabraParaBuscar.toString(), false);
			//como el metodo devuelve -1 siempre, a no ser que encuentre la palabra que el usuario ha buscado, utilizo esto para imprimir por pantalla si la palabra existe y donde la he encontrado
				if (posicion == -1)
					{
						System.out.println("Lo siento pero tu palabra "+comillas+palabraParaBuscar+comillas+" no se encuentra en el texto");
				}else{
						System.out.println("He encontrado la palabra "+comillas+palabraParaBuscar+comillas+" en la línea "+posicion);
					}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/////
		//Ejercicio 1d
		}
}