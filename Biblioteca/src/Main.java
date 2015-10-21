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
		/**
		//puedo guardar los libros que quiera en el archivo file que quiera gracias al método "guardar" 
		//definido en la clase almacen
		almacen.guardar(l1, "almacen.dat");
		almacen.guardar(l2, "almacen.data");
		
		//y puedo recuperar todos los libros guardados en el archivo file especificado y pueden ser de diferentes files
		l4=almacen.recuperar("almacen.dat");
		l5=almacen.recuperar("almacen.data");
		
		l4.print();
		l5.print();
		**/
		//me creo un arraylist de objetos Libro al cual le voy a añadir mis libros creados que luego podre recorrer para 
		//imprimirlos por pantalla usando el iteratr
		ArrayList<Libro> biblioteca=new ArrayList<Libro>();

		biblioteca.add(l1);
		biblioteca.add(l2);
		biblioteca.add(l3);
		
		Iterator it = biblioteca.iterator();
		while(it.hasNext()){
			Libro todosLosLibros = (Libro) it.next();
			todosLosLibros.print();
		}
		
		almacen.cambiarValores(l1);
		l1.print();
	}
}
