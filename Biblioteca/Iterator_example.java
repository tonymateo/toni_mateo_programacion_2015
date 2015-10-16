package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterator_example {

	public static void main(String[] args) {
		
		ArrayList<Persona> personas=new ArrayList<Persona>();
		
		Persona p = new Persona("Manolo",20);
		
		personas.add(p);
		personas.add(new Persona("Pedro",20));
		
		Iterator it = personas.iterator();
		while(it.hasNext()){
			Persona p2 = (Persona) it.next();
			p2.print();
		}

	}

}
