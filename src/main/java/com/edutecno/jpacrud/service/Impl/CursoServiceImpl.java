package com.edutecno.jpacrud.service.Impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.jpacrud.VO.CursoVO;
import com.edutecno.jpacrud.VO.RegionVO;
import com.edutecno.jpacrud.modelo.Curso;
import com.edutecno.jpacrud.modelo.Region;
import com.edutecno.jpacrud.repository.CursoRepository;
import com.edutecno.jpacrud.repository.RegionRepository;
import com.edutecno.jpacrud.service.CursoService;
@Service
public class CursoServiceImpl implements CursoService {

	private static final Logger log = LoggerFactory.getLogger(CursoServiceImpl.class);

	@Autowired
	CursoRepository dao;
	
	CursoVO respuesta;
	
	@Override
	public CursoVO getAllCursos() {
		respuesta = new CursoVO(new ArrayList<Curso>(), "ocurrio un error", "102");
		try {
			respuesta.setCursos((List<Curso>) dao.findAll());
			respuesta.setMensaje("se han encontrado CURSOS");
			respuesta.setCodigo("0");
			respuesta.getCursos();
			System.out.println(respuesta.getCursos().toString());

		} catch (Exception e) {
			log.trace("Curso Service: Error en metodo getAllCursos()", e);
		}
		return respuesta;
	}

	
	}


