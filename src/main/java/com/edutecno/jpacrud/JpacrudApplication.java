package com.edutecno.jpacrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.edutecno.jpacrud.modelo.Estudiante;
import com.edutecno.jpacrud.repository.EstudianteRepository;
import com.edutecno.jpacrud.service.Impl.EstudianteServiceImpl;

@SpringBootApplication
public class JpacrudApplication {

	private static final Logger log= LoggerFactory.getLogger(JpacrudApplication.class);
	
	//@Autowired
	//private JdbcTemplate jdbcTemplate;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JpacrudApplication.class, args);
	}
	
	  

	
}