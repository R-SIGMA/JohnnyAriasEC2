package com.examen.EC2JohnnyArias_Bodega.service;

import java.util.List;

import com.examen.EC2JohnnyArias_Bodega.dto.ClienteDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.ClienteDTOResponse;

public interface ClienteService {

	public void guardar(ClienteDTORequest cliente);
	public void editar(ClienteDTORequest cliente);
	public void eliminar(Integer id);
	public List<ClienteDTOResponse> listar();
	public ClienteDTOResponse obtenerPorId(Integer id);
	
}
