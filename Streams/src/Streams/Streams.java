package Streams;

import java.io.File;
import java.io.IOException;


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
		}
}
