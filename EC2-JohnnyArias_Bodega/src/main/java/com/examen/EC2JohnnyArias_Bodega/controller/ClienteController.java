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

import com.examen.EC2JohnnyArias_Bodega.dto.ClienteDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.ClienteDTOResponse;
import com.examen.EC2JohnnyArias_Bodega.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService serv;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ClienteDTOResponse>> listar(){
		return new ResponseEntity<List<ClienteDTOResponse>>(serv.listar(), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest cliente){
		serv.guardar(cliente);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<ClienteDTOResponse> listarPorId(@PathVariable Integer id) {
		ClienteDTOResponse c = serv.obtenerPorId(id);
		
		if(c != null)
			return new ResponseEntity<ClienteDTOResponse>(c, HttpStatus.OK);
		
		return new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@PatchMapping("/editar")
	public ResponseEntity<Void> editar(@RequestBody ClienteDTORequest cliente){
		ClienteDTOResponse c = serv.obtenerPorId(cliente.getIdCliente());
		
		if(c != null) {
			serv.editar(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ClienteDTOResponse c = serv.obtenerPorId(id);
		
		if(c != null) {
			serv.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
