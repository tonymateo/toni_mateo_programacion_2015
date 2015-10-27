import java.util.ArrayList;
import java.util.Iterator;


public class Main {

	
	public static void main(String[] args) {
		
		//nombre, autor, any, editor, paginas
		Libro l1=new Libro("El Hobbit", "J.R.R. Tolkien", 2002, "Minotauro", 288);
		Libro l2=new Libro("La Chica del Tren", "Paula Hawkins", 2015, "Editorial Planeta", 496);	
		Libro l3=new Libro("El  Regreso del Cantón", "Matilde Asensi", 2015, "Editorial Planeta", 608);
		Libro l4=null;
		Libro l5=null;
		
		Almacen almacen=new Almacen();
		
		//puedo guardar los libros que quiera en el archivo file que quiera gracias al método "guardar" 
		//definido en la clase almacen
		almacen.guardar(l3, l3.getNombre()+".dat");
		almacen.guardar(l2, "almacen.dat");
		
		//y puedo recuperar todos los libros guardados en el archivo file especificado y pueden ser de diferentes files
		l4=almacen.recuperar(l3.getNombre()+".dat");
		l5=almacen.recuperar("almacen.dat");
		
		l4.print();
		
		//Guardar lista de Libros
		//Me creo un arraylist de objetos Libro
		ArrayList<Libro> listaLibros=new ArrayList<Libro>();
		listaLibros.add(l1);
		listaLibros.add(l2);
		listaLibros.add(l3);
		almacen.guardarListaLibros(listaLibros);
		
		almacen.cambiarValores(l3);
		l3.print();
		
		/**System.out.println("Te voy a imprimir el libro de otro fichero \n");
		l5.print();
	
		}**/
		
	}
}
