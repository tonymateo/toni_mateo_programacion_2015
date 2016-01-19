import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

	public class Principal {
		public static void main(String[] args) {
			String inicial="";
			GestionPersistencia persistencia = new GestionPersistencia();
			
			//Persona p = new Persona("Toni", 25, "50667847T");
			//Persona p = new Persona("Alex", 20, "161237812D");
			//Persona p = new Persona("Alex", 20, "161237812D");
			//Persona p = new Persona("Alejandro", 20, "987686373S");
			//Persona p = new Persona("Tonas", 29, "198376590P");
			//persistencia.insertarPersona(p);

			//persistencia.recuperarPersonaPorNombre("Alejandro");
			//persistencia.recuperarPersonaPorInicial("A");
			persistencia.recuperarPersonaPorDni("161237812D");
			//persistencia.recuperarPersonaPorEdad(10, 30);
			/*
			try{
				bbdd.store(p);
				bbdd.commit();
				System.out.println("Se ha guardado correctamente");*/
				
				/*Query q = bbdd.query();		
				q.constrain(Persona.class);
				q.descend("nombre").constrain("Pepe");
				Constraint c1 = q.descend("edad").constrain(20).greater();
				Constraint c2 = q.descend("edad").constrain(30).smaller();
				c1.or(c2);
				
				ObjectSet<Persona> res = q.execute();
				
				for(Persona p2: res){
					p2.print();
				}
				
			}finally{
				bbdd.close();
			}*/
		}
	}