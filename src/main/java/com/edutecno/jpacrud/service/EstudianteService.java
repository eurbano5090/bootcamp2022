package com.edutecno.jpacrud.service;

import java.util.List;

import com.edutecno.jpacrud.VO.EstudianteVO;
import com.edutecno.jpacrud.VO.NumberVO;
import com.edutecno.jpacrud.modelo.Estudiante;



public interface EstudianteService {

	public EstudianteVO getAllEstudiantes();

	public EstudianteVO findById(Integer id_estudiante);

	public EstudianteVO add(Estudiante estudiante);

	public EstudianteVO update(EstudianteVO estudiante);

	public EstudianteVO delete(Estudiante estudiante);

	public EstudianteVO findByCursoContaining(String codigo_curso);

	public EstudianteVO findByRegionContaining(String codigo_region);
	
	public EstudianteVO findByRegionandCursoContaining(String codigo_region,String codigo_curso);

	EstudianteVO update(Estudiante estudiante);

	public NumberVO getPageCount(long registrosPorPagina);
	
	public EstudianteVO getPage(Integer pagina, Integer cantidad);
	
}
