package com.examen.EC2JohnnyArias_Bodega.service;

import java.util.List;

import com.examen.EC2JohnnyArias_Bodega.dto.BodegaDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.BodegaDTOResponse;

public interface BodegaService {

	public void guardar(BodegaDTORequest bodega);
	public void editar(BodegaDTORequest bodega);
	public void eliminar(Integer id);
	public List<BodegaDTOResponse> listar();
	public BodegaDTOResponse obtenerPorId(Integer id);
	
}
