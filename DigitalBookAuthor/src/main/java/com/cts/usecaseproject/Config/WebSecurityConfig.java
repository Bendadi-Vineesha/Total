package com.cts.usecaseproject.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.cts.usecaseproject.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(jwtUserDetailsService);

	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.cors().and().csrf().disable()

				.authorizeRequests()

				.antMatchers("/author/createauthor","/author/authenticate").permitAll()
				.antMatchers("/author/createbook","/author/msg","/api/v1/digitalbooks/books/create").access("hasRole('AUTHOR')")
			//	.antMatchers("/all/**").access("hasAnyRole('MANAGER','ADMIN')")
				// .antMatchers("/manager/**").access("hasRole('MANAGER')")
				// .antMatchers("/admin/**").access("hasRole('ADMIN')")

				.anyRequest().authenticated().and()

				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		return httpSecurity.build();
	}
}
