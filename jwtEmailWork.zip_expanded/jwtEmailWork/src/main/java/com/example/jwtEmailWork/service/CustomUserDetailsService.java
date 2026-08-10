package com.example.jwtEmailWork.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.jwtEmailWork.entity.UserEntity;
import com.example.jwtEmailWork.repository.UserEntityRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private UserEntityRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity u = repo.findByUsername(username).orElseThrow();
		
		Set<GrantedAuthority> authorities = u.getRoles().stream().map(
				a -> new SimpleGrantedAuthority(a.name())
				).collect(Collectors.toSet());
		
		return new User(u.getUsername(), u.getPassword(), authorities);
	}


}
