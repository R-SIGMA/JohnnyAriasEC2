package com.examen.EC2JohnnyArias_Bodega.dto;

import java.util.ArrayList;
import java.util.List;

import com.examen.EC2JohnnyArias_Bodega.model.Productos;

public class ClienteDTOResponse {

	private Integer idCliente;

    private String nombre;
    private String direccion;
    private Integer dni;
    
    private List<Productos> itemsProductos = new ArrayList<>();
    
    public ClienteDTOResponse() {}

    public ClienteDTOResponse(Integer idCliente, String nombre, String direccion, Integer dni, List<Productos> itemsProductos) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.itemsProductos = itemsProductos;
	}

	public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

	public List<Productos> getItemsProductos() {
		return itemsProductos;
	}

	public void setItemsProductos(List<Productos> itemsProductos) {
		this.itemsProductos = itemsProductos;
	}

}
