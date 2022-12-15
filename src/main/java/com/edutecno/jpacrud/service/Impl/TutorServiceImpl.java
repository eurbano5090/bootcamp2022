package com.edutecno.jpacrud.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.jpacrud.VO.EstudianteVO;
import com.edutecno.jpacrud.VO.TutorVO;
import com.edutecno.jpacrud.modelo.Estudiante;
import com.edutecno.jpacrud.modelo.Tutor;
import com.edutecno.jpacrud.repository.TutorRepository;
import com.edutecno.jpacrud.service.TutorService;


@Service
public class TutorServiceImpl implements TutorService{

private static final org.slf4j.Logger log = LoggerFactory.getLogger(RegionServiceImpl.class);
	
	@Autowired
	TutorRepository dao;
	
	TutorVO respuesta;

	
	@Override
	public TutorVO getAllTutores() {
		respuesta = new TutorVO(new ArrayList<Tutor>(), "ocurrio un error", "102");
		try {
			respuesta.setTutores((List<Tutor>) dao.findAll());
			respuesta.setMensaje("se han encontrado usuarios");
			respuesta.setCodigo("0");
			respuesta.getTutores();
			System.out.println(respuesta.getTutores());

		} catch (Exception e) {
			log.trace("Region Service: Error en metodo getAllRegiones()", e);
		}
		return respuesta;

}


	@Override
	public List<TutorVO> findByCargo(String cargo) {
		respuesta = new TutorVO(new ArrayList<Tutor>(), "ocurrio un error", "102");
		try {
			respuesta.setTutores((List<Tutor>) dao.findByCargo(cargo));
			respuesta.setMensaje("se han encontrado usuarios");
			respuesta.setCodigo("0");
			respuesta.getTutores();
			System.out.println(respuesta.getTutores());
		} catch (Exception e) {
			log.trace("Region Service: Error en metodo getAllRegiones()", e);
		}
		return (List<TutorVO>) respuesta;
	}


	@Override
	public List<TutorVO> findByRegionAndCurso(int region, String codigo_curso) {
		respuesta = new TutorVO(new ArrayList<Tutor>(), "ocurrio un error", "102");
		try {
			respuesta.setTutores(dao.findByRegionAndCurso(region, codigo_curso));
			respuesta.setMensaje("se encuentran estudiantes");
			respuesta.setCodigo("0");
			System.out.println(respuesta.getTutores().toString());
		} catch (Exception e) {
			log.error("Estudiante Service: Error en metodo findByRegionContaining()", e);
		}
		return (List<TutorVO>) respuesta;
		
	}


/*	@Override
	public TutorVO findByRegionContaining(int cod_region) {
		respuesta.setTutores(dao.);;
		return null;
	}*/
	}
