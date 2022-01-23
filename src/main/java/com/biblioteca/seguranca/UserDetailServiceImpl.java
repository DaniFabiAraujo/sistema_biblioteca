package com.biblioteca.seguranca;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.biblioteca.modelo.Usuario;
import com.biblioteca.repositorio.UsuarioRepositorio;

@Repository
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio ur;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = ur.findByUsername(username);
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(usuario.getRole()));
		
		User userSpring = new User(usuario.getUsername(), usuario.getPassword(), authorities);
		
		return userSpring;
	}

}
