package Streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Metodos {
	public String texto = null;
	public String texto2 = null;
	
	public boolean compararContenido(File fichero1, File fichero2) throws IOException{
			if (fichero1.canRead()==true && fichero2.canRead()==true){
				//comparo lo que he leido de los 2 ficheros
				if (leyendoF1(fichero1).equalsIgnoreCase(leyendoF2(fichero2))){
					System.out.println("1º FICHERO");
					System.out.println(leyendoF1(fichero1));
					System.out.println("2º FICHERO");
					System.out.println(leyendoF2(fichero2));
					System.out.println("Son iguales");
				}else{
					System.out.println("1º FICHERO");
					System.out.println(leyendoF1(fichero1));
					System.out.println("2º FICHERO");
					System.out.println(leyendoF2(fichero2));
					System.out.println("NO Son iguales");
					}
				}else{
					System.out.println("No va");
					}
			return true;
		}
	//método que me lee el primer fichero y me devuelve lo que ha leido
	public String leyendoF1(File fichero1) throws IOException{
		FileReader fr = new FileReader(Streams.fichero1);

		BufferedReader bfr = new BufferedReader(fr);
		
		while (bfr.readLine()!=null){
			//leo la primera linea y me la guardo en la variable texto
			texto = bfr.readLine();
				if (bfr.readLine()==null){
					System.out.println("este es el texto que me guardo del 1"+texto);
					break;
				}
			}
		bfr.close();
		return texto;
		
	}
	//método que me lee el segundo fichero y me devuelve el string que ha leido
	public String leyendoF2(File fichero2) throws IOException{
		FileReader fr2 = new FileReader(Streams.fichero2);
	
		BufferedReader bfr2 = new BufferedReader(fr2);
		
		while (bfr2.readLine()!=null){
			//leo el segundo documento y me lo guardo en la variable texto2
			texto2 = bfr2.readLine();
				if (bfr2.readLine()==null){
					System.out.println("este es el texto que me guardo del 2"+texto2);
					break;
				}
			}
		bfr2.close();
		return texto2;
		
	}
}
