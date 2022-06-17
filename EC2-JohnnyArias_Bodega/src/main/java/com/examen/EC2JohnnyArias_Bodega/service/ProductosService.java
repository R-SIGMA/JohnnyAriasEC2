package com.examen.EC2JohnnyArias_Bodega.service;

import java.util.List;

import com.examen.EC2JohnnyArias_Bodega.dto.ProductosDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.ProductosDTOResponse;


public interface ProductosService {

	public void guardar(ProductosDTORequest producto);
	public void editar(ProductosDTORequest producto);
	public void eliminar(Integer id);
	public List<ProductosDTOResponse> listar();
	public ProductosDTOResponse obtenerPorId(Integer id);
}
