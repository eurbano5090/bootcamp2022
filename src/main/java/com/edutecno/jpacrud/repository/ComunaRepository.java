package com.edutecno.jpacrud.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.jpacrud.modelo.Comuna;
import com.edutecno.jpacrud.modelo.Estudiante;


@Repository
 public interface ComunaRepository extends CrudRepository<Comuna,Integer>  {


	
}
