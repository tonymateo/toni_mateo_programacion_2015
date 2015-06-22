package Principal;

import Modelo.hockeyBD;
import Vista.vistaPrincipal;


public class HockeyApp {

	public static void main(String[] args) {
		//Conecto a la BD
		hockeyBD nuevaConexion;
		
		nuevaConexion=new hockeyBD("localhost","estadisticasequipo","root","tonphp");
		
		//Comprueba la conexion
		if(nuevaConexion.connectBD()==true){
			System.out.println("Conectado a la BD");
		}
		else{ System.out.println("Ha habido un problema con la conexión");
		}
		
		//Llamo a mis vistas
		vistaPrincipal principal = new vistaPrincipal();
		principal.setVisible(true);
	}
	


}
