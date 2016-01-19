import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

public class GestionPersistencia {
	ObjectContainer bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "prueba.db4o");
	Principal main= new Principal();
	
	public GestionPersistencia() {}
	
	public void insertarPersona(Persona p){
		bbdd.store(p);
		bbdd.commit();
		System.out.println("Se ha guardado correctamente");
	}
	
	public List<Persona> recuperarPersonaPorNombre(String nombre){
		List lista= new ArrayList();
		try{
			Query q = bbdd.query();		
			q.constrain(Persona.class);
			q.descend("nombre").constrain(nombre);
			
			ObjectSet<Persona> res = q.execute();
			
				for(Persona p2: res){
					lista.add(p2);
					p2.print();
				}
		}finally{
			bbdd.close();
		}
		return lista;
	}
	
	public List<Persona> recuperarPersonaPorInicial(String inicio){
		List lista= new ArrayList();
		
		try{
			Query q = bbdd.query();		
			q.constrain(Persona.class);
				
			ObjectSet<Persona> res = q.execute();
			
				for(Persona p2: res){
					if (p2.getNombre().startsWith(inicio)){
						lista.add(q.descend("nombre").constraints());
						p2.print();
					}
				}
		}finally{
			bbdd.close();
		}
		return lista;
	}
	public Persona recuperarPersonaPorDni(String dni){
		Persona devolver = new Persona();
		try{
			Query q = bbdd.query();		
			q.constrain(Persona.class);
			//q.descend("dni").constrain(dni);
			
			ObjectSet<Persona> res = q.execute();
			
				for(Persona p2: res){
					if(p2.getDni().compareTo(dni) == 0){
						p2.print();
						return p2;
					}
				}
		}finally{
			bbdd.close();
		}
		return null;
	}

	public List<Persona> recuperarPersonaPorEdad(int menor, int mayor){
		List lista= new ArrayList();
		
		try{
			Query q = bbdd.query();		
			q.constrain(Persona.class);
			//q.descend("edad").constrain(menor).smaller();
			//q.descend("edad").constrain(menor).greater();
			
			ObjectSet<Persona> res = q.execute();
				for(Persona p2: res){
					if(p2.getEdad()>=menor && p2.getEdad()<=mayor){
						lista.add(p2);
						p2.print();
					}
				}
		}finally{
			bbdd.close();
		}
		return lista;
	}

	public List<Persona> recuperarPersonaAvanzada(){
		return null;
		
	}

}
