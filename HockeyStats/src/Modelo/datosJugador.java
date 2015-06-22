package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class datosJugador {

	// Nombre de los campos de la tabla cadetes de la BD
	private Connection conexion;
	private ResultSet resultado;
	private Statement statement;
		
	public datosJugador() {
		//Iniciamos la conexion
		conexion = hockeyBD.getConexion();
	}
		
	public String[] consultaJugador() {
			//me creo mi arraylist de jugadores
			ArrayList<String> jugadores=new ArrayList<String>();
			//creo el array con el que devolvere los datos de los jugadores en el jlist
			String[] arrayJugadores = new String[jugadores.size()];
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("select * from jugadores;");//realizo la consulta que me devuelve a todos los jugadores
			while (resultado.next()) {
				//añado a mi arraylist los jugadores
				jugadores.add(" "+resultado.getString("nombre")+" "+resultado.getString("apellidos")+" -n.Jugador "+resultado.getString("numero"));
			}
			//transformo el arraylist en un array para pasarselo al jlist despues
			arrayJugadores = jugadores.toArray(arrayJugadores);
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
		return arrayJugadores;
	}	
	
	public String[] consultaNombreJugador() {
		//ArrayList con los nombres de los jugadores
		ArrayList<String> nombreJugadores=new ArrayList<String>();
		//creo el array con el que devolvere los nombres de los jugadores en el jbox
		String[] arrayNombreJugadores = new String[nombreJugadores.size()];
	try {
		statement = conexion.createStatement();
		resultado = statement.executeQuery("select id from jugadores;");//realizo la consulta que me devuelve el nombre de los jugadores
		while (resultado.next()) {
			//añado a mi arraylist los nombres
			nombreJugadores.add(resultado.getString("id"));
		}
		//transformo el arraylist en un array para pasarselo al jlist despues
		arrayNombreJugadores = nombreJugadores.toArray(arrayNombreJugadores);
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
	return arrayNombreJugadores;
}	
}
