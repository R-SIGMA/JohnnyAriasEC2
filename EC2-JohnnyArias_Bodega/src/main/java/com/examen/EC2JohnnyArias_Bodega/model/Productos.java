package com.examen.EC2JohnnyArias_Bodega.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "productos")
@JsonIgnoreProperties({"itemsBodega","itemsCliente"})
public class Productos implements Serializable{
	
	private static final long serialVersionUID = 8272401950645251L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

	@Column(name = "producto")
    private String producto;
	@Column(name = "descripcion")
    private String descripcion;
	@Column(name = "precio")
    private Double precio;
	@Column(name = "stock")
    private Integer stock;

    @OneToMany(mappedBy = "producto")
    private List<Bodega> itemsBodega = new ArrayList<>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "productos_cliente",
			joinColumns = @JoinColumn(name="id_producto",
					foreignKey = @ForeignKey(foreignKeyDefinition="foreign key(id_producto) references productos(id_producto)")),
			inverseJoinColumns = @JoinColumn(name="id_cliente",
					foreignKey = @ForeignKey(foreignKeyDefinition="foreign key(id_cliente) references cliente(id_cliente)")))
    private List<Cliente> itemsCliente = new ArrayList<>();
    
    public Productos() {}

    public Productos(Integer idProducto, String producto, String descripcion, Double precio, Integer stock,
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
