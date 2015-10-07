package Streams;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Streams {
	
	public static File fichero1 = new File("entrada.txt"); 
	public static File fichero2 = new File("entrada1.txt");
	
	
	public static void main(String[] args) throws IOException {
			Metodos metodo = new Metodos();
			if(metodo.compararContenido(fichero1, fichero2)==true){
				System.out.println("son iguales");
			}else{
				System.out.println("no son iguales");
			}
		/**Metodos buscador = new Metodos();
		try {
			//System.out.println("Escribe una palabra para buscar");
			//InputStream palabraParaBuscar = System.in;
			int posicion = buscador.buscarPalabra(fichero1, palabraParaBuscar.toString()"hola", false);
			System.out.println("He encontrado tu palabra en la línea"+posicion);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}**/
		}
}
