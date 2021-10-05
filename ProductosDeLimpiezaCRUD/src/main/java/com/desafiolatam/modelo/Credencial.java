package com.desafiolatam.modelo;

public class Credencial {
	private String usuario;
	private String clave;
	
	public Credencial() {
		super();
	}
	public Credencial(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
