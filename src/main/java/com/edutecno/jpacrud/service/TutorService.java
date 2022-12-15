package com.edutecno.jpacrud.service;

import java.util.List;

import com.edutecno.jpacrud.VO.TutorVO;
import com.edutecno.jpacrud.modelo.Estudiante;
import com.edutecno.jpacrud.modelo.Tutor;

public interface TutorService {
	
	public TutorVO getAllTutores();
	
	public  List<TutorVO> findByCargo(String cargo);
	
	List<TutorVO> findByRegionAndCurso(int region, String codigo_curso);

	//public TutorVO findByRegionContaining(int cod_region);

}
