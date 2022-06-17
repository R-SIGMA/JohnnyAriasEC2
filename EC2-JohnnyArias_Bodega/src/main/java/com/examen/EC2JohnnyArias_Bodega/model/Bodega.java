package com.examen.EC2JohnnyArias_Bodega.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bodega")
public class Bodega implements Serializable{

	private static final long serialVersionUID = -1278886731108033978L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBodega;

    private String nombre;
    private String direccion;

    @ManyToOne
	@JoinColumn(name="id_producto",
	foreignKey = @ForeignKey(foreignKeyDefinition="foreign key(id_producto) references productos(id_producto)"))
    private Productos producto;
    
    public Bodega() {}

    public Bodega(Integer idBodega, String nombre, String direccion, Productos producto) {
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
