package com.examen.EC2JohnnyArias_Bodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.EC2JohnnyArias_Bodega.dto.ClienteDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.ClienteDTOResponse;
import com.examen.EC2JohnnyArias_Bodega.model.Cliente;
import com.examen.EC2JohnnyArias_Bodega.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	public ClienteRepository rep;
	
	@Override
	public void guardar(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setDireccion(cliente.getDireccion());
		c.setDni(cliente.getDni());
		c.setItemsProductos(c.getItemsProductos());
		
		rep.save(c);
	}

	@Override
	public void editar(ClienteDTORequest cliente) {
		Cliente c = new Cliente();
		
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setDireccion(cliente.getDireccion());
		c.setDni(cliente.getDni());
		c.setItemsProductos(c.getItemsProductos());
		
		rep.saveAndFlush(c);
	}

	@Override
	public void eliminar(Integer id) {
		rep.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listar() {
		List<ClienteDTOResponse> list = new ArrayList<ClienteDTOResponse>();
		
		for(Cliente cliente : rep.findAll()) {
			ClienteDTOResponse c = new ClienteDTOResponse();
			
			c.setIdCliente(cliente.getIdCliente());
			c.setNombre(cliente.getNombre());
			c.setDireccion(cliente.getDireccion());
			c.setDni(cliente.getDni());
			c.setItemsProductos(c.getItemsProductos());
			
			list.add(c);
		}
		
		return list;
	}

	@Override
	public ClienteDTOResponse obtenerPorId(Integer id) {
		Cliente cliente = rep.findById(id).orElse(null);
		
		ClienteDTOResponse c = new ClienteDTOResponse();
		
		c.setIdCliente(cliente.getIdCliente());
		c.setNombre(cliente.getNombre());
		c.setDireccion(cliente.getDireccion());
		c.setDni(cliente.getDni());
		c.setItemsProductos(c.getItemsProductos());
		
		return c;
	}

}
