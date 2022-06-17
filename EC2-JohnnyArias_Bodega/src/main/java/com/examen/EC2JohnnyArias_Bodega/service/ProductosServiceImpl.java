package com.examen.EC2JohnnyArias_Bodega.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.EC2JohnnyArias_Bodega.dto.ProductosDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.ProductosDTOResponse;
import com.examen.EC2JohnnyArias_Bodega.model.Productos;
import com.examen.EC2JohnnyArias_Bodega.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	public ProductosRepository rep;
	
	@Override
	public void guardar(ProductosDTORequest producto) {
		Productos p = new Productos();
		
		p.setIdProducto(producto.getIdProducto());
		p.setProducto(producto.getProducto());
		p.setDescripcion(producto.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setStock(producto.getStock());
		p.setItemsBodega(producto.getItemsBodega());
		p.setItemsCliente(producto.getItemsCliente());
		
		rep.save(p);
	}

	@Override
	public void editar(ProductosDTORequest producto) {
		Productos p = new Productos();
		
		p.setIdProducto(producto.getIdProducto());
		p.setProducto(producto.getProducto());
		p.setDescripcion(producto.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setStock(producto.getStock());
		p.setItemsBodega(producto.getItemsBodega());
		p.setItemsCliente(producto.getItemsCliente());
		
		rep.saveAndFlush(p);
	}

	@Override
	public void eliminar(Integer id) {
		rep.deleteById(id);
	}

	@Override
	public List<ProductosDTOResponse> listar() {
		List<ProductosDTOResponse> list = new ArrayList<ProductosDTOResponse>();
		
		for(Productos producto : rep.findAll()) {
			ProductosDTOResponse p = new ProductosDTOResponse();
			
			p.setIdProducto(producto.getIdProducto());
			p.setProducto(producto.getProducto());
			p.setDescripcion(producto.getDescripcion());
			p.setPrecio(producto.getPrecio());
			p.setStock(producto.getStock());
			p.setItemsBodega(producto.getItemsBodega());
			p.setItemsCliente(producto.getItemsCliente());
			
			list.add(p);
		}
		
		return list;
	}

	@Override
	public ProductosDTOResponse obtenerPorId(Integer id) {
		Productos producto = rep.findById(id).orElse(null);
		
		ProductosDTOResponse p = new ProductosDTOResponse();
		
		p.setIdProducto(producto.getIdProducto());
		p.setProducto(producto.getProducto());
		p.setDescripcion(producto.getDescripcion());
		p.setPrecio(producto.getPrecio());
		p.setStock(producto.getStock());
		p.setItemsBodega(producto.getItemsBodega());
		p.setItemsCliente(producto.getItemsCliente());
		
		return p;
	}

}
