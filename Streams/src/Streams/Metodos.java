package Streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Metodos {

	//Toni Mateo
	//Primera parte Ejercicio 1c
	///////
	public boolean compararContenido(File fichero1, File fichero2) throws IOException{
		//primero compruebo que el fichero tiene permisos de lectura y existe, si no es asi, lanzo una excepcion
		if (fichero1.canRead() && fichero1.exists() && fichero2.canRead() && fichero2.exists()){
			try{
				FileReader fr = new FileReader(Streams.fichero1);
				FileReader fr2 = new FileReader(Streams.fichero2);
		
				BufferedReader bfr = new BufferedReader(fr);
				BufferedReader bfr2 = new BufferedReader(fr2);
		
				//me guardo el contenido de la primera linea del fichero entrada.txt
				String texto = bfr.readLine();
				//me guardo el contenido de la primera linea del segundo fichero entrada1.txt
				String texto2 = bfr2.readLine();
		
				//compruebo que las 2 primeras lineas de ambos ficheros sean iguales
				while ((texto != null) || (texto2 != null)){
					//si son iguales ya paso a leer las siguientes lineas y las comparo otra vez
					if(texto.equals(texto2)){
						texto = bfr.readLine();
						texto2 = bfr2.readLine();
					}else{
						//si en algun momento no son iguales el metodo me devuelve falso
						return false;
					}
				}
				//cierro los documentos que he leido
				bfr.close();
				bfr2.close();
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}
			}else{
				throw new IOException("Algún fichero no tiene permisos de escritura o de lectura, o el fichero no existe");
			}
		//si son iguales me devuelve verdadero
		return true;
	}
	
	//Toni Mateo
	//Segunda parte Ejercicio 1c
	///////
	public int buscarPalabra (File ficheroParaBuscar, String palabraParaBuscar, boolean primera_aparicion) throws IOException{
			//compruebo que el fichero existe y que se puede leer si no es asi, lanzo una excepcion
			if(ficheroParaBuscar.exists() && ficheroParaBuscar.canRead()){
				try {
					int contadorLineas=1;
					FileReader fr;
					fr = new FileReader(Streams.fichero1);
		
					BufferedReader bfr = new BufferedReader(fr);
		
					String texto = bfr.readLine();
		
					while(texto != null){
						if(texto.equals(palabraParaBuscar)){
							return contadorLineas;
						}else{
							texto = bfr.readLine();
							contadorLineas++;	
						}
					}
					}catch(FileNotFoundException e) {
						e.printStackTrace();
					}
				}else{
				throw new IOException("No se ha encontrado el fichero");
			}
	return -1;
	}
	
	//Toni Mateo
	//Ejercicio 1d
	///////
	public void ordenarFichero(File Origen, File Destino, int tipo_orden) throws FileNotFoundException{
		BufferedReader bfr = new BufferedReader(new FileReader(Streams.ficheroOrigen));
		try {
			String texto = bfr.readLine();
			ArrayList<String> textoParaOrdenar = null;
			textoParaOrdenar.add(texto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}