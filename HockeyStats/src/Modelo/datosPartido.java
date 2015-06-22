package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class datosPartido {
	
	// Nombre de los campos de la tabla cadetes de la BD
	private Connection conexion;
	private ResultSet resultado;
	private Statement statement;
			
	public datosPartido() {
		//Iniciamos la conexion
		conexion = hockeyBD.getConexion();
	}
			
	public String[] consultaPartido() {
			//me creo mi arraylist de partidos
			ArrayList<String> partidos=new ArrayList<String>();
			//creo el array con el que devolvere los datos de los partidos en el jlist
			String[] arrayPartidos = new String[partidos.size()];
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("select * from partidos;");//realizo la consulta que me devuelve a todos los jugadores
			while (resultado.next()) {
				//añado a mi arraylist los jugadores
				partidos.add(" "+resultado.getString("diapartido")+" "+resultado.getString("contraquien")+" (local(0) visitante(1))--> "+resultado.getString("localvisitante"));
			}
			//transformo el arraylist en un array para pasarselo al jlist despues
			arrayPartidos = partidos.toArray(arrayPartidos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();//cerramos statement
				resultado.close();// cerramos resultset
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayPartidos;
	}	
	
	public void insertarPartidos(String diapartido, String contraquien, String localvisitante){
		try {
			statement = conexion.createStatement();
			statement.executeUpdate("insert into partidos(diapartido, contraquien, localvisitante) values('"+diapartido +"','"+ contraquien +"',"+ localvisitante+");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String[] consultaEquipo() {
		//ArrayList con los nombres de los jugadores
		ArrayList<String> nombreEquipo=new ArrayList<String>();
		//creo el array con el que devolvere los nombres de los jugadores en el jbox
		String[] arrayNombreEquipo = new String[nombreEquipo.size()];
	try {
		statement = conexion.createStatement();
		resultado = statement.executeQuery("select id from partidos;");//realizo la consulta que me devuelve el nombre de los jugadores
		while (resultado.next()) {
			//añado a mi arraylist los nombres
			nombreEquipo.add(resultado.getString("id"));
		}
		//transformo el arraylist en un array para pasarselo al jlist despues
		arrayNombreEquipo = nombreEquipo.toArray(arrayNombreEquipo);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			statement.close();//cerramos statement
			resultado.close();// cerramos resultset
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return arrayNombreEquipo;
	}
}
