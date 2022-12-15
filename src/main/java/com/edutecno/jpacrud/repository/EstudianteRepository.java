package com.edutecno.jpacrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.edutecno.jpacrud.modelo.Estudiante;



@Repository
 public interface EstudianteRepository extends CrudRepository<Estudiante,Integer>, JpaRepository<Estudiante, Integer>  {
	
	@Query("from Estudiante where codigo_curso like %?1%")
	List<Estudiante> findyByCodigoCurso(String codigo_curso);
	
	@Query("from Estudiante where codigo_curso like %?1%")
	List<Estudiante> findyByCodigoRegion(String codigo_region);
	
		
	@Query("from Estudiante e JOIN Curso cc ON e.codigo_curso = cc.codigo_curso JOIN Comuna  cco on e.codigo_comuna = cco.codigo_comuna JOIN Region  cr on cco.codigo_region = cr.codigo_region JOIN Plan_formativo  cpf on cc.codigo_plan_formativo = cpf.codigo_plan_formativo WHERE cr.codigo_region = ?1 AND cc.codigo_curso = ?2")
	List<Estudiante> findByRegionAndCurso(int region, String nombreCurso);
	
	@Query("from Estudiante e JOIN Curso cc ON e.codigo_curso = cc.codigo_curso JOIN Comuna  cco on e.codigo_comuna = cco.codigo_comuna JOIN Region  cr on cco.codigo_region = cr.codigo_region JOIN Plan_formativo  cpf on cc.codigo_plan_formativo = cpf.codigo_plan_formativo WHERE cr.codigo_region =  ?1")
	List<Estudiante> findByRegion(int region);
	
	@Query("from Estudiante e JOIN Curso cc ON e.codigo_curso = cc.codigo_curso JOIN Comuna  cco on e.codigo_comuna = cco.codigo_comuna JOIN Region  cr on cco.codigo_region = cr.codigo_region JOIN Plan_formativo  cpf on cc.codigo_plan_formativo = cpf.codigo_plan_formativo WHERE cc.codigo_curso = ?1")
	List<Estudiante> findByCurso(String nombreCurso);
}
