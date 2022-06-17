package com.examen.EC2JohnnyArias_Bodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.EC2JohnnyArias_Bodega.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

	Usuario findByNombre(String nombre);
	
}
