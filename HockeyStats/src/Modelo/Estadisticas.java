package Modelo;

public class Estadisticas {
	
	private String idJugador="";
	private String idPartido="";
	private String minutosjugados="";
	private String golesmarcados=""; 
	
	public Estadisticas(String idJugador, String idPartido, String minutosjugados, String golesmarcados) {
		
	this.idJugador=idJugador;
	this.idPartido=idPartido;
	this.minutosjugados=minutosjugados;
	this.golesmarcados=golesmarcados;
	}
	
	//Getters y setters
	public String getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(String idJugador) {
		this.idJugador = idJugador;
	}
	
	public String getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(String idPartido) {
		this.idPartido = idPartido;
	}
	
	public String getMinutosJugados() {
		return minutosjugados;
	}

	public void setMinutosJugados(String minutosjugados) {
		this.minutosjugados = minutosjugados;
	}
	
	public String getGolesMarcados() {
		return golesmarcados;
	}

	public void setGolesMarcados(String golesmarcados) {
		this.golesmarcados = golesmarcados;
	}
}
