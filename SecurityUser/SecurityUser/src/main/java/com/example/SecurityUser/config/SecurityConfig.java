package com.example.SecurityUser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.SecurityUser.service.JwtFilterReq;
import com.example.SecurityUser.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtFilterReq jwtfilter;
	
	@Autowired
	private UserService userservice;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userservice);
	}
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.csrf().disable().authorizeRequests().antMatchers("/Secure/subs", "/Secure/auth").permitAll()
			.antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
			.permitAll()
			.anyRequest().authenticated();
			http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	}
		@Bean
		public PasswordEncoder passwordEncoder() {
			
			return NoOpPasswordEncoder.getInstance();
		}

		@Override
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception{
			return super.authenticationManagerBean();
		}
}