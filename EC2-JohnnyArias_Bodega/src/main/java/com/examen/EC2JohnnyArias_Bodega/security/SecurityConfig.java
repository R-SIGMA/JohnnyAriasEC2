package com.examen.EC2JohnnyArias_Bodega.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailService serv;

	@Autowired
	private TokenFilter filter;
	
	@Autowired
	private EntryPoint entry;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(serv).passwordEncoder(encriptado());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/crearToken").permitAll()
		.antMatchers("/productos/listar").hasAnyRole("ADMIN", "USER")
		.antMatchers("/productos/listar/*").hasAnyRole("ADMIN", "USER")
		.antMatchers("/productos/guardar").hasAnyRole("ADMIN")
		.antMatchers("/productos/editar").hasAnyRole("ADMIN")
		.antMatchers("/productos/eliminar").hasAnyRole("ADMIN")
		.antMatchers("/bodega/*").hasAnyRole("ADMIN")
		.antMatchers("/cliente/*").hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(entry)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
		.csrf().disable();
		
	}
	
	@Bean
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
}
