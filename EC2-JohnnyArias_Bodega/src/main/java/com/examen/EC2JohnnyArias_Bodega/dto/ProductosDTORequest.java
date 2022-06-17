package com.examen.EC2JohnnyArias_Bodega.dto;

import java.util.ArrayList;
import java.util.List;

import com.examen.EC2JohnnyArias_Bodega.model.Bodega;
import com.examen.EC2JohnnyArias_Bodega.model.Cliente;

public class ProductosDTORequest {

	private Integer idProducto;

    private String producto;
    private String descripcion;
    private Double precio;
    private Integer stock;
    
    private List<Bodega> itemsBodega = new ArrayList<>();
    
    private List<Cliente> itemsCliente = new ArrayList<>();
    
    public ProductosDTORequest() {}

    public ProductosDTORequest(Integer idProducto, String producto, String descripcion, Double precio, Integer stock,
			List<Bodega> itemsBodega, List<Cliente> itemsCliente) {
		this.idProducto = idProducto;
		this.producto = producto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.itemsBodega = itemsBodega;
		this.itemsCliente = itemsCliente;
	}

	public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

	public List<Bodega> getItemsBodega() {
		return itemsBodega;
	}

	public void setItemsBodega(List<Bodega> itemsBodega) {
		this.itemsBodega = itemsBodega;
	}

	public List<Cliente> getItemsCliente() {
		return itemsCliente;
	}

	public void setItemsCliente(List<Cliente> itemsCliente) {
		this.itemsCliente = itemsCliente;
	}

}
