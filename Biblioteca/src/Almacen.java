import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Almacen {
	
	public String nuevotitulo="";
	public String nuevoAutor="";
	
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
	}
}
