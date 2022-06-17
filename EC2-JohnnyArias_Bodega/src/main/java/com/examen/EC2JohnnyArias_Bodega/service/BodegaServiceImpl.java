package com.examen.EC2JohnnyArias_Bodega.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.EC2JohnnyArias_Bodega.dto.BodegaDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.BodegaDTOResponse;
import com.examen.EC2JohnnyArias_Bodega.model.Bodega;
import com.examen.EC2JohnnyArias_Bodega.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {
	
	@Autowired
	public BodegaRepository rep;
	
	@Override
	public void guardar(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		
		b.setIdBodega(bodega.getIdBodega());
		b.setNombre(bodega.getNombre());
		b.setDireccion(bodega.getDireccion());
		b.setProducto(bodega.getProducto());
		
		rep.save(b);
	}

	@Override
	public void editar(BodegaDTORequest bodega) {
		Bodega b = new Bodega();
		
		b.setIdBodega(bodega.getIdBodega());
		b.setNombre(bodega.getNombre());
		b.setDireccion(bodega.getDireccion());
		b.setProducto(bodega.getProducto());
		
		rep.saveAndFlush(b);
	}

	@Override
	public void eliminar(Integer id) {
		rep.deleteById(id);
	}

	@Override
	public List<BodegaDTOResponse> listar() {
		List<BodegaDTOResponse> list = new ArrayList<BodegaDTOResponse>();
		
		for(Bodega bodega : rep.findAll()) {
			BodegaDTOResponse b = new BodegaDTOResponse();
			
			b.setIdBodega(bodega.getIdBodega());
			b.setNombre(bodega.getNombre());
			b.setDireccion(bodega.getDireccion());
			b.setProducto(bodega.getProducto());
			
			list.add(b);
		}
		
		return list;
	}

	@Override
	public BodegaDTOResponse obtenerPorId(Integer id) {
		Bodega bodega = rep.findById(id).orElse(null);
		
		BodegaDTOResponse b = new BodegaDTOResponse();
		
		b.setIdBodega(bodega.getIdBodega());
		b.setNombre(bodega.getNombre());
		b.setDireccion(bodega.getDireccion());
		b.setProducto(bodega.getProducto());
		
		return b;
	}

}
