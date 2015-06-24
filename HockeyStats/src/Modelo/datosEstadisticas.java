package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class datosEstadisticas {

	private Connection conexion;
	private ResultSet resultado;
	private Statement statement;
			
	public datosEstadisticas() {
		//Iniciamos la conexion
		conexion = hockeyBD.getConexion();
	}
			
	public ArrayList<Estadisticas> consultaEstadisticas() {
		
			//me creo mi arraylist de estadisticas
			ArrayList<Estadisticas> arrayListEstadisticas=new ArrayList<Estadisticas>();
			
		try {
			statement = conexion.createStatement();
			resultado = statement.executeQuery("select j.nombre, e.idpartido, e.minutosjugados, e.golesmarcados FROM estadisticas e INNER JOIN jugadores j ON j.id = e.idjugador;");//realizo la consulta que me devuelve a todos las estadisticas
			while (resultado.next()) {
				Estadisticas estadistica;
				
				//me creo un objeto estadistica al cual le voy a pasar 3 parametros para que cada columna de la base de datos sea 1 objeto distinto
				estadistica=new Estadisticas(resultado.getString("nombre"), resultado.getString("idPartido"), resultado.getString("minutosjugados"), resultado.getString("golesmarcados"));
				arrayListEstadisticas.add(estadistica);
			}
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
		return arrayListEstadisticas;
	}	
	
	public void insertarEstadisticas(String idJugador, String idPartido, String minutosjugados, String golesmarcados){
		try {
			statement = conexion.createStatement();
			statement.executeUpdate("insert into estadisticas(idpartido, idjugador, minutosjugados, golesmarcados) values("+idJugador +","+ idPartido +","+ minutosjugados +","+ golesmarcados+");");
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
}
