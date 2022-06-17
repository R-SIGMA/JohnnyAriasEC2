package com.examen.EC2JohnnyArias_Bodega.dto;

import com.examen.EC2JohnnyArias_Bodega.model.Productos;

public class BodegaDTOResponse {

	private Integer idBodega;

    private String nombre;
    private String direccion;
    
    private Productos producto;
    
    public BodegaDTOResponse() {}

    public BodegaDTOResponse(Integer idBodega, String nombre, String direccion, Productos producto) {
		this.idBodega = idBodega;
		this.nombre = nombre;
		this.direccion = direccion;
		this.producto = producto;
	}

	public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
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

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

}
