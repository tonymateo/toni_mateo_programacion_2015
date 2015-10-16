
public class Main {

	public static void main(String[] args) {
		Libro p1=new Libro();
		Libro p2=new Libro();	
		Libro p3=new Libro();
			
		Almacen almacen=new Almacen();
		
		almacen.guardar(p1, "almacen.dat");
		almacen.guardar(p2, "almacen.dat");
		
		p3=almacen.recuperar("almacen.dat");
		
	}

}
