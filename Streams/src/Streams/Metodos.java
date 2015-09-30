package Streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Metodos {
	
	public boolean compararContenido(File fichero1, File fichero2) throws IOException{
		boolean repite=true;
		while (repite==true){
		FileReader fr = new FileReader(Streams.fichero1);
		FileReader fr2 = new FileReader(Streams.fichero2);
		
		BufferedReader bfr = new BufferedReader(fr);
		BufferedReader bfr2 = new BufferedReader(fr2);
		
		String texto= bfr.readLine();
		String texto2= bfr2.readLine();
		
		System.out.println("1º FICHERO");
		System.out.println(texto);
		System.out.println("2º FICHERO");
		System.out.println(texto2);
		
		if (fichero1.canRead()==false && fichero1.canRead()==false){
			if (texto.equalsIgnoreCase(texto2)){
				System.out.println("Son iguales");
				bfr.close();
				bfr2.close();
			}else{
				System.out.println("NO Son iguales");
				repite=false;
				}
			}else{
				repite=false;
			}
		}
		return true;
	}
}
