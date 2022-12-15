package com.edutecno.jpacrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.jpacrud.VO.TutorVO;
import com.edutecno.jpacrud.modelo.Estudiante;
import com.edutecno.jpacrud.modelo.Tutor;


@Repository
 public interface TutorRepository extends CrudRepository<Tutor,Integer>  {

	@Query("from Tutor A inner join Curso B on A.codigo_comuna=B.codigo_comuna join Plan_formativo C on C.codigo_plan_formativo=B.codigo_plan_formativo where B.codigo_curso=?1 ")
	 List <Tutor> findTutorCurso(Integer codigo_curso);
	
	@Query("from Tutor T JOIN Curso cc ON T.codigo_comuna = cc.codigo_comuna JOIN Comuna  cco on T.codigo_comuna = cco.codigo_comuna JOIN Region  cr on cco.codigo_region = cr.codigo_region JOIN Plan_formativo  cpf on cc.codigo_plan_formativo = cpf.codigo_plan_formativo WHERE cr.codigo_region = ?1 AND cc.codigo_curso = ?2")
	List<Tutor> findByRegionAndCurso(int region, String codigo_curso);
	
	List<Tutor> findByCargo(String cargo);
	
}
	/*@Query("from Tutor A join Curso B on a.codigo_comuna=b.codigo_comuna where codigo_curso like %?1%")
	List<Tutor> findyByCodigoRegion(String codigo_region);
	}
/*  @Query("from Tutor e JOIN Curso cc ON e.codigo_curso = cc.codigo_curso JOIN Comuna  cco on e.codigo_comuna = cco.codigo_comuna JOIN Region  cr on cco.codigo_region = cr.codigo_region JOIN Plan_formativo  cpf on cc.codigo_plan_formativo = cpf.codigo_plan_formativo WHERE cr.codigo_region =  ?1 AND cc.codigo_curso = ?2")
  List<Tutor> findByRegionAndCurso(int region, String nombreCurso);

   @Query("from Tutor e JOIN Curso cc ON e.codigo_curso = cc.codigo_curso JOIN Comuna  cco on e.codigo_comuna = cco.codigo_comuna JOIN Region  cr on cco.codigo_region = cr.codigo_region JOIN Plan_formativo  cpf on cc.codigo_plan_formativo = cpf.codigo_plan_formativo WHERE cr.codigo_region =  ?1")
    List<Tutor> findByRegion(int region);
    
    @Query(select c.codigo_tutor,c.codigo_curso c,t.nombre,t.apellido_pat,t.cargo from curso_modulo_tutor c
inner join tutor t on c.codigo_tutor=t.codigo_tutor;)
*/