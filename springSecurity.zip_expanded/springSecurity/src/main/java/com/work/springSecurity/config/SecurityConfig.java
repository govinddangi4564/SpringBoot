package com.work.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import com.work.springSecurity.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final CustomUserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
//		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public SecurityContextRepository securityContextRepository() {
		return new HttpSessionSecurityContextRepository();
	}

	// api/auth/register , api/auth/login

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				// Configure authorization rules
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**", "/public/**").permitAll()
						.requestMatchers(HttpMethod.GET, "/api/products/**").hasAnyRole("USER", "ADMIN")
						.requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN").anyRequest()
						.authenticated())
				// Enable HTTP Basic authentication for REST APIs & testing
				.httpBasic(httpBasic -> {
				})
				// Configure Session Management
				.sessionManagement(
						session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(1) // Limit
																														// single
																														// login
																														// session
																														// per
																														// user
				)
				// Configure Logout
				.logout(logout -> logout.logoutUrl("/api/auth/logout")
						.logoutSuccessHandler((request, response, authentication) -> {
							response.setStatus(200);
							response.setContentType("application/json");
							response.getWriter().write("{\"message\": \"Logged out successfully!\"}");
						}).invalidateHttpSession(true).deleteCookies("JSESSIONID"))
				// Allow frames for H2 Console viewing during development
				.headers(headers -> headers.frameOptions(frame -> frame.disable()))
				// Disable CSRF for simple REST testing (Enable in production with
				// CookieCsrfTokenRepository)
				.csrf(csrf -> csrf.disable());

		http.authenticationProvider(authenticationProvider());

		return http.build();
	}
}
