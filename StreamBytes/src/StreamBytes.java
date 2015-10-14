import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class StreamBytes {
	
	static String usuarioOrigen = "";
	static String usuarioDestino = "";
	public static String comillas = "\"";
	//String rutaFicheroOrigen = "C:\\Users\\t.mateo\\Desktop\\Workspace Dam_2\\workspaceEclipse\\Git\\carpeta_proyectos\\Stream_bytes\\lena.jpg";//Ruta al fichero de origen
    //String rutaFicheroDestino = "destino.txt"; //Ruta al fichero de destino
	
	public static void main(String[] args) {
		System.out.println("indica el fichero origen, a ser posible usando el siguiente modelo:");
		System.out.println("");
		System.out.println(comillas+"C:\\Users\\t.mateo\\Desktop\\Workspace Dam_2\\lena.jpg"+comillas);
		//me creo un string vacio que luego se rellenará con la palabra que el usuario desee buscar
		Scanner entrada = new Scanner (System.in); //Creación de un objeto Scanner
		usuarioOrigen = entrada.nextLine (); //Invoco un método sobre un objeto Scanner
		System.out.println("Indica el fichero destino");
		//me creo un string vacio que luego se rellenará con la palabra que el usuario desee buscar
		Scanner salida = new Scanner (System.in); //Creación de un objeto Scanner
		usuarioDestino = salida.nextLine (); //Invoco un método sobre un objeto Scanner
		CopiaFicheroBinario();
	}
	
	public static void abrirFichero(){  
	    
	}
	
	public static void CopiaFicheroBinario (){  
		try{
			
		File ficheroOrigen = new File(usuarioOrigen);//Creamos objeto de tipo fichero con la ruta origen.
	    File ficheroDestino = new File(usuarioDestino);//Creamos objeto de tipo fichero con la ruta destino.
	        
	    BufferedInputStream leerFicheroOrigen;//Creo un objeto flujo buffer de lectura .
	    BufferedOutputStream escribirFicheroDestio;//Creo un objeto flujo buffer de escritura.
	    
	    //me creo 2 objetos tipo FileInputStream para luego poder usar el buffered
	    FileInputStream fls = new FileInputStream(ficheroOrigen);
	    FileOutputStream fos = new FileOutputStream(ficheroDestino);
	    
	    leerFicheroOrigen = new BufferedInputStream(fls);//Inicializo lectorFicheroOrigen con un fileImputStream del fichero origen
        escribirFicheroDestio = new BufferedOutputStream(fos);//Inicializo escritorFicheroDestino con un fileOutputStream del fichero destino
	        
	            int copiaEnBytes;//variable donde me guardo los bytes copiados
	            
	            while((copiaEnBytes=(leerFicheroOrigen).read()) != -1){ //mientras no llegue a fin de fichero...
	                System.out.println(copiaEnBytes);//imprimo lo que he leido 
	                escribirFicheroDestio.write(copiaEnBytes);//se copia el flujo de bytes al fichero destino.
	            }
	            
	            leerFicheroOrigen.close();//cierro el flujo de lectura
	            escribirFicheroDestio.close();//cierro el flujo de escritura
	            
	        }
	        catch(FileNotFoundException e){
	            e.printStackTrace();//si no encuentra el archivo, lanzo una excepcion
	            
	        }
	        catch(IOException e){
	            e.printStackTrace();//si ha escrito mal la ruta, lanzo una excepcion
	        }
	}
}
