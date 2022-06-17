package com.examen.EC2JohnnyArias_Bodega.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examen.EC2JohnnyArias_Bodega.model.Usuario;
import com.examen.EC2JohnnyArias_Bodega.repository.UsuarioRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioRepository rep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = rep.findByNombre(username);
		
		if(usuario != null) {
			
			List<GrantedAuthority> granted = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol());
			granted.add(authority);
			
			return new User(usuario.getNombre(), usuario.getPassword(), granted);
		} else {
			throw new UsernameNotFoundException("ERROR! El usuario no existe");
		}
	}

}
