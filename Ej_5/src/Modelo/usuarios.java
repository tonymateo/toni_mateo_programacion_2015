package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;


public class usuarios {
	
	//Consulta SQL para que me devuelva el usuario
	private static String USUARIOS = "SELECT nombre FROM usuario";
	
	//Me creo los atributos necesarios para manejar sentencias SQL
	
	private Connection conexion=null;//conexion
	private Statement instruccion = null;//Sentencias sql
	private ResultSet resultados = null;//devuelve datos
	
	
	public usuarios(){
		this.conexion=conexionBD.getConexion();
	}
	
	public ArrayList<String> getUsuarios(){
		//Creo un arraylist para almacenar los datos que recibo de la consulta mysql
		ArrayList<String> usuarios=new ArrayList<String>();
		try{
			//Creo un canal para conectarme a la BD
			this.instruccion = this.conexion.createStatement();
			this.resultados = instruccion.executeQuery(USUARIOS);
					
			//Recorro los resultados y los almacenamos en un ArrayList			
			while( resultados.next()){
				//Me devuelve los resultados del select y le extraigo la columna que yo quiero
				usuarios.add(resultados.getString("nombre"));
			}
		}catch( SQLException excepcionSql ) {
			excepcionSql.printStackTrace();
		}finally{
			try{
				resultados.close();
				instruccion.close();
			}
			catch( SQLException excepcionSql ) 
			{
				excepcionSql.printStackTrace();
			}
		}
		return usuarios;
	}
}
