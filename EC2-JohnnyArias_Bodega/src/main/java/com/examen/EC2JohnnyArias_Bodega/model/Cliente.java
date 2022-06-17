package com.examen.EC2JohnnyArias_Bodega.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = -861807303829849260L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nombre;
    private String direccion;
    private Integer dni;

    @ManyToMany(mappedBy = "itemsCliente", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Productos> itemsProductos = new ArrayList<>();
    
    public Cliente() {}

    public Cliente(Integer idCliente, String nombre, String direccion, Integer dni, List<Productos> itemsProductos) {
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
