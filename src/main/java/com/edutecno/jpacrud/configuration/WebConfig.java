package com.edutecno.jpacrud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/inicio").permitAll()
		.antMatchers("/cursos").hasRole("USER")
		.antMatchers("/home").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		
	}
	@Bean
	public HttpFirewall looseHttpFirewall() {
		StrictHttpFirewall firewal= new StrictHttpFirewall();
		firewal.setAllowBackSlash(true);
		firewal.setAllowSemicolon(true);
		firewal.setAllowUrlEncodedSlash(true);
		return firewal;
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.inMemoryAuthentication()
	 .passwordEncoder(passwordEncoder())
	 .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
	 .and()
	 .withUser("admin").password(passwordEncoder().encode("Currently")).roles("ADMIN");
	}
/*  @Bean
  @Override
  public UserDetailsService userDetailsServiceBean() throws Exception {
	// TODO Auto-generated method stub
	return super.userDetailsServiceBean();
}*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
