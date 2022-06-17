package com.examen.EC2JohnnyArias_Bodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.EC2JohnnyArias_Bodega.dto.BodegaDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.BodegaDTOResponse;
import com.examen.EC2JohnnyArias_Bodega.service.BodegaService;

@RestController
@RequestMapping("/bodega")
public class BodegaController {

	@Autowired
	private BodegaService serv;
	
	@GetMapping("/listar")
	public ResponseEntity<List<BodegaDTOResponse>> listar(){
		return new ResponseEntity<List<BodegaDTOResponse>>(serv.listar(), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody BodegaDTORequest bodega){
		serv.guardar(bodega);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<BodegaDTOResponse> listarPorId(@PathVariable Integer id) {
		BodegaDTOResponse b = serv.obtenerPorId(id);
		
		if(b != null)
			return new ResponseEntity<BodegaDTOResponse>(b, HttpStatus.OK);
		
		return new ResponseEntity<BodegaDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@PatchMapping("/editar")
	public ResponseEntity<Void> editar(@RequestBody BodegaDTORequest bodega){
		BodegaDTOResponse b = serv.obtenerPorId(bodega.getIdBodega());
		
		if(b != null) {
			serv.editar(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		BodegaDTOResponse b = serv.obtenerPorId(id);
		
		if(b != null) {
			serv.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
