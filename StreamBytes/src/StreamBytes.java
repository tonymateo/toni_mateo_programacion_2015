import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class StreamBytes {
	
	//Toni Mateo 
	//ejercicio 1e
	
	static String usuarioOrigen = "";
	static String usuarioDestino = "";
	public static String comillas = "\"";
	static int contador = 0;
	
	//pruebas C:\Users\2dam\Desktop\lena.jpg
	public static void main(String[] args){
		abrirFichero();
		CopiaFicheroBinario();
	}
	
	public static void abrirFichero(){
		
		System.out.println("indica el fichero origen, a ser posible usando el siguiente modelo:");
		System.out.println("");
		System.out.println(comillas+"C:\\Users\\t.mateo\\Desktop\\Workspace Dam_2\\lena.jpg"+comillas);
		//me creo un string vacio que luego se rellenará con la palabra que el usuario desee buscar
		Scanner entrada = new Scanner (System.in); //Creación de un objeto Scanner
		usuarioOrigen = entrada.nextLine (); //Invoco un método sobre un objeto Scanner

		System.out.println("Indica la ruta donde quieres que se copie el fichero anterior"+"\n"+
				"(CUIDADO: si no se espicifica ruta, el fichero se copiará en la carpeta de este proyecto)");
		//me creo un string vacio que luego se rellenará con la palabra que el usuario desee buscar
		Scanner salida = new Scanner (System.in); //Creación de un objeto Scanner
		usuarioDestino = salida.nextLine (); //Invoco un método sobre un objeto Scanner
		
		CopiaFicheroBinario();
		//hago una comprobación final para ver si la copia se ha realizado con exito o no
		if(usuarioDestino!=null){
			System.out.println("Copia realizada con éxito");
			System.out.println("He copiado un total de "+comillas+contador+comillas+" bytes");
		}else{
			System.out.println("Lo siento pero el archivo "+comillas+" esta vacio");
		}
	}
	
	public static void CopiaFicheroBinario (){  
		
		try{
			File ficheroOrigen = new File(usuarioOrigen);
			File ficheroDestino = new File(usuarioDestino);
	    
			//me creo 2 objetos tipo FileInputStream para luego poder usar el buffered
			FileInputStream fr = new FileInputStream(ficheroOrigen);
			FileOutputStream fw = new FileOutputStream(ficheroDestino);
	    
			BufferedInputStream leerFicheroOrigen = new BufferedInputStream(fr);
			BufferedOutputStream escribirFicheroDestio = new BufferedOutputStream(fw);
	        
			int copiaEnBytes;//variable donde me guardo los bytes copiados
	            
			while((copiaEnBytes=(leerFicheroOrigen).read()) != -1){ //mientras no llegue al final del fichero...(-1)
				escribirFicheroDestio.write(copiaEnBytes);//los bytes que tengo guardados en la variable anterior las escribo en el fichero destino
				contador++;
			}
			leerFicheroOrigen.close();
			escribirFicheroDestio.close();
	        }
	        catch(FileNotFoundException e){
	            e.printStackTrace();//si no encuentra el archivo, lanzo una excepcion
	        }
	        catch(IOException e){
	            e.printStackTrace();//si ha escrito mal la ruta, lanzo una excepcion
	        }
		
	}
}
