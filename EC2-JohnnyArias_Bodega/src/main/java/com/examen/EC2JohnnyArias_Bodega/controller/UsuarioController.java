package com.examen.EC2JohnnyArias_Bodega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.EC2JohnnyArias_Bodega.dto.UsuarioDTORequest;
import com.examen.EC2JohnnyArias_Bodega.dto.UsuarioDTOResponse;
import com.examen.EC2JohnnyArias_Bodega.security.JwtUtil;
import com.examen.EC2JohnnyArias_Bodega.security.UserDetailService;

@RestController
public class UsuarioController {

	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailService serv;
	
	@PostMapping("/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest dto){
		
		UserDetails detail = serv.loadUserByUsername(dto.getNombre());
		
		return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(detail.getUsername())));
	}
	
	@GetMapping("/prueba")
	public void prueba() {
		System.out.println("Éxito exitoso.");
	}
	
}
