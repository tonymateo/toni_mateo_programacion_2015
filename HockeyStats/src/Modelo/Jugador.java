package Modelo;

public class Jugador {

	private String nombre="";
	private String apellidos="";
	private String numero=""; 
	
	public Jugador(String nombre, String apellidos, String numero) {
	this.nombre=nombre;
	this.apellidos=apellidos;
	this.numero=numero;
	}
	
	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
