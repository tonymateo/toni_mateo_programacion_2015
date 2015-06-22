package Modelo;

public class Partidos {

	private String diapartido="";
	private String contraquien="";
	private String localvisitante=""; 
		
	public Partidos(String diapartido, String contraquien, String localvisitante) {
	this.diapartido=diapartido;
	this.contraquien=contraquien;
	this.localvisitante=localvisitante;
	}
		
	//Getters y setters
	public String getPartido() {
		return diapartido;
	}

	public void setPartido(String diapartido) {
		this.diapartido = diapartido;
	}
		
	public String getContraQuien() {
		return contraquien;
	}

	public void setContraQuien(String contraquien) {
		this.contraquien = contraquien;
	}
		
	public String getLocalVisitante() {
		return localvisitante;
	}

	public void setNumero(String localvisitante) {
		this.localvisitante = localvisitante;
	}	
}