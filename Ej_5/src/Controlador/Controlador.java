package Controlador;

import Modelo.conexionBD;
import Vistas.Vista;


public class Controlador {

	public static void main(String[] args) {
		conexionBD nuevaConexion;
		
		nuevaConexion=new conexionBD("localhost","bdjuegos","root","tonphp");
		
		//Comprueba la conexion
		if(nuevaConexion.connectBD()==true){
			System.out.println("Conectado a la BD");
		}
		else{ System.out.println("Ha habido un problema con la conexión");
		}
		
		//Lanzo mis Vistas
		Vista Vista= new Vista();
		Vista.setVisible(true);
	}

}
