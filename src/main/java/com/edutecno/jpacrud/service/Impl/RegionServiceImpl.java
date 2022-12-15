package com.edutecno.jpacrud.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.edutecno.jpacrud.VO.RegionVO;

import com.edutecno.jpacrud.modelo.Region;
import com.edutecno.jpacrud.repository.RegionRepository;
import com.edutecno.jpacrud.service.RegionService;
@Service
public class RegionServiceImpl implements RegionService {

	private static final Logger log = LoggerFactory.getLogger(RegionServiceImpl.class);
	
	@Autowired
	RegionRepository dao;
	
	RegionVO respuesta;
	
	@Override
	public RegionVO getAllRegiones() {
		respuesta = new RegionVO(new ArrayList<Region>(), "ocurrio un error", "102");
		try {
			respuesta.setRegiones((List<Region>) dao.findAll());
			respuesta.setMensaje("se han encontrado usuarios");
			respuesta.setCodigo("0");
			respuesta.getRegiones();
			System.out.println(respuesta.getRegiones().toString());

		} catch (Exception e) {
			log.trace("Region Service: Error en metodo getAllRegiones()", e);
		}
		return respuesta;
	}

}
