import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class Almacen {
	
	private String nuevotitulo="";
	private String nuevoAutor="";
	private ObjectOutputStream salidaLibros=null;
	
	public Almacen(){
	}

	public void guardar(Libro libro, String file){
		
		ObjectOutputStream out=null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(libro);
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			intentarCerrar(out);
		}
	}
	
	public Libro recuperar(String file) {
		Libro l = null;
        ObjectInputStream in=null;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            l = (Libro) in.readObject();            
        } catch (ClassNotFoundException ex) {
            System.err.println("Error de fichero");
        } catch (IOException ex) {
        	System.err.println("Error IO");
        }finally{
            intentarCerrar(in);
        }
        return l;
	}

	public void intentarCerrar(Closeable aCerrar) {
		try {
			if (aCerrar != null) {
				aCerrar.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
	
	public void cambiarValores(Libro libroParaCambiar){
		//metodo el cual recibe el libro que va a ser modificado y despues pidiendo al usuario el nuevo nombre y el autor, los modifica
		System.out.println("El siguiente libro va a ser modificado: ");
		libroParaCambiar.print();
		
		System.out.println("Por favor introduce el nuevo Nombre: ");
		Scanner sc = new Scanner(System.in);
		String nombre=sc.nextLine();
		libroParaCambiar.setNombre(nombre);
		
		System.out.println("Por favor introduce el nuevo Autor: ");
		Scanner sc2 = new Scanner(System.in);
		String autor=sc.nextLine();
		libroParaCambiar.setAutor(autor);
		sc.close();
		sc2.close();
	}
	
	public void guardarListaLibros(ArrayList<Libro> librosParaListar){
		//Me creo un String para los libros que me pasen en el método
		String nombreArchivos = "listaLibros";
		File listaLibros = new File(nombreArchivos);
		
		//abro un flujo de datos para guardar los libros
		try {
			salidaLibros =new ObjectOutputStream(new FileOutputStream(listaLibros));
		} catch (IOException e) {
			System.err.println("Error al abrir el archivo");
		}
		try {//guardo los libros uno a uno en mi array mediante el iterator
		Iterator it= librosParaListar.iterator();
		System.out.println("Se han guardado los siguientes libros: ");
		while(it.hasNext()){
			Libro libro=(Libro) it.next();
			salidaLibros.writeObject(libro);
			libro.print();
			System.out.println("");
		}
		} catch (IOException e) {
			System.err.println("Error al escribir los libros");
		}finally{
			//intento cerrar el flujo de datos
			try {
				salidaLibros.close();
			} catch (IOException e) {
				System.err.println("No se ha podido cerrar el archivo");}
		}
	}
}
