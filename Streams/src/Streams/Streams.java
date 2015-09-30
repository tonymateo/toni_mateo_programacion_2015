package Streams;

import java.io.File;
import java.io.IOException;


public class Streams {
	//private File fichero1=null;
	//private File fichero2=null;
	
	static File fichero1 = new File("entrada.txt"); 
	static File fichero2 = new File("entrada1.txt");
	
	
	public static void main(String[] args) throws IOException {
			Metodos metodo = new Metodos();
			metodo.compararContenido(fichero1, fichero2);
		}
}
