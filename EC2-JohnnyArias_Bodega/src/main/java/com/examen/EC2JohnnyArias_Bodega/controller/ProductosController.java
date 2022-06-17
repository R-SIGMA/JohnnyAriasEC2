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

import com.examen.EC2JohnnyArias_Bodega.dto.ProductosDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.ProductosDTOResponse;
import com.examen.EC2JohnnyArias_Bodega.service.ProductosService;

@RestController
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductosService serv;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProductosDTOResponse>> listar(){
		return new ResponseEntity<List<ProductosDTOResponse>>(serv.listar(), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProductosDTORequest producto){
		serv.guardar(producto);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<ProductosDTOResponse> listarPorId(@PathVariable Integer id) {
		ProductosDTOResponse p = serv.obtenerPorId(id);
		
		if(p != null)
			return new ResponseEntity<ProductosDTOResponse>(p, HttpStatus.OK);
		
		return new ResponseEntity<ProductosDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@PatchMapping("/editar")
	public ResponseEntity<Void> editar(@RequestBody ProductosDTORequest producto){
		ProductosDTOResponse p = serv.obtenerPorId(producto.getIdProducto());
		
		if(p != null) {
			serv.editar(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ProductosDTOResponse p = serv.obtenerPorId(id);
		
		if(p != null) {
			serv.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
