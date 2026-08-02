package com.work.springSecurity.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.work.springSecurity.entity.UserEntity;
import com.work.springSecurity.repository.UserEntityRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private UserEntityRepository repo;

	// database => user [raj, raj76, raj76@gmail.com, 7123, ROLE_USER]

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity u = repo.findByUsername(username).orElseThrow(RuntimeException::new);

		Set<GrantedAuthority> authorities = u.getRoles().stream().map(a -> new SimpleGrantedAuthority(a.name()))
				.collect(Collectors.toSet());

		return new User(u.getUsername(), u.getPassword(), authorities);
		// spring_security -> user -> {user [raj, raj76, raj76@gmail.com, 7123,
		// ROLE_USER]}
	}

}