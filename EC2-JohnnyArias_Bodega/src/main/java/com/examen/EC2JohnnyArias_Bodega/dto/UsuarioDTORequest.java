package com.examen.EC2JohnnyArias_Bodega.dto;

public class UsuarioDTORequest {

	private String nombre;
	private String password;
	
	public UsuarioDTORequest() {}

	public UsuarioDTORequest(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
