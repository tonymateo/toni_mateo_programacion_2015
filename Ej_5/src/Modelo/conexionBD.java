package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexionBD {
	
//Datos de la conexion
	static final String mysql_controler="com.mysql.jdbc.Driver";

//Datos de la base de datos
	private String host;
	private String basedatos;
	private String user;
	private String password;
	

//Conexion
 	private static Connection conexion = null;
	
	public conexionBD(String host,String basedatos,String user,String password){
		this.host=host;
		this.basedatos=basedatos;
		this.user=user;
		this.password=password;
	}
	//Creo una conexion con la bd
	public boolean connectBD(){
		//Carga controlador para la conexion y si no hace un return false
		try{
			Class.forName(mysql_controler);
		//Me conecto a la BD
			conexion= DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.basedatos,this.user,this.password);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}catch(ClassNotFoundException e2){
			e2.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static Connection getConexion(){
		return conexion;
	}

}
