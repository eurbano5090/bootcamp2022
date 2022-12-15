package com.edutecno.jpacrud.service.Impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.edutecno.jpacrud.VO.EstudianteVO;
import com.edutecno.jpacrud.modelo.Estudiante;
import com.edutecno.jpacrud.repository.EstudianteRepository;
import com.edutecno.jpacrud.service.EstudianteService;
import com.edutecno.jpacrud.VO.NumberVO;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	private static final Logger log = LoggerFactory.getLogger(EstudianteServiceImpl.class);

	@Autowired
	EstudianteRepository dao;

	EstudianteVO respuesta;


	@Override
	@Transactional
	public EstudianteVO findById(Integer id_estudiante) {
		respuesta = new EstudianteVO(new ArrayList<Estudiante>(), "ocurrio un error", "102");
		try {
			Estudiante estudiante=dao.findById(id_estudiante).get();
			respuesta.setMensaje("se encuentra estudiante:" + estudiante.getNombre());
			respuesta.setCodigo("0");
		//	respuesta.estudiantes.add(estudiante);

		} catch (Exception e) {
			log.error("Estudiante Service: Error en metodo findById()", e);
		}
		return respuesta;
	}
	
	@Override
	@Transactional
	public EstudianteVO findByCursoContaining(String codigo_curso) {
		respuesta = new EstudianteVO(new ArrayList<Estudiante>(), "ocurrio un error", "102");
		try {
			respuesta.setEstudiantes((List<Estudiante>) dao.findByCurso(codigo_curso));
			respuesta.setMensaje("se encuentran estudiantes");
			respuesta.setCodigo("0");

			System.out.println("Metodo Find by codigo curso. Encontramos: ");
			System.out.println(respuesta.getEstudiantes().toString());

		} catch (Exception e) {
			log.error("Estudiante Service: Error en metodo findByCursoContaining()", e);
		}
		return respuesta;
	}


	@Override
	@Transactional
	public EstudianteVO getAllEstudiantes() {
		respuesta = new EstudianteVO(new ArrayList<Estudiante>(), "ocurrio un error", "102");
		try {
			respuesta.setEstudiantes((List<Estudiante>) dao.findAll());
			respuesta.setMensaje("se han encontrado usuarios");
			respuesta.setCodigo("0");
			respuesta.getEstudiantes();
			System.out.println(respuesta.getEstudiantes());

		} catch (Exception e) {
			log.trace("Estudiante Service: Error en metodo getAllEstudiantes()", e);
		}
		return respuesta;
	}


	@Override
	@Transactional
	public EstudianteVO add(Estudiante estudiante) {
		respuesta = new EstudianteVO(new ArrayList<Estudiante>(), "ocurrio un error", "102");
		try {
			dao.save(estudiante);
			respuesta.setMensaje("se agrego :" + estudiante.getNombre());
			respuesta.setCodigo("0");

		} catch (Exception e) {
			log.trace("Estudiante Service: Error en metodo add()", e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public EstudianteVO update(Estudiante estudiante) {
	respuesta = new EstudianteVO(new ArrayList<Estudiante>(), "ocurrio un error", "102");
		try {
			dao.save(estudiante);
			respuesta.setMensaje("se actualizo estudiante :" + estudiante.getNombre());
			respuesta.setCodigo("0");

		} catch (Exception e) {
			log.error("Estudiante Service: Error en metodo update()", e);
		}
		return respuesta;

		
	}

	@Override
	@Transactional
	public EstudianteVO delete(Estudiante estudiante) {
		respuesta = new EstudianteVO(new ArrayList<Estudiante>(), "ocurrio un error", "102");
		try {
			respuesta.setMensaje("se borro estudiante :" +estudiante.getNombre());
			
			dao.delete(estudiante);
			respuesta.setCodigo("0");

		} catch (Exception e) {
			log.trace("Usuario Service: Error en metodo delete()", e);
		}
		return respuesta;
	}

	@Override
	public EstudianteVO findByRegionContaining(String codigo_region) {
		respuesta = new EstudianteVO(new ArrayList<Estudiante>(), "ocurrio un error", "102");
		try {
			respuesta.setEstudiantes((List<Estudiante>) dao.findByRegion(Integer.valueOf(codigo_region)));
			respuesta.setMensaje("se encuentran estudiantes");
			respuesta.setCodigo("0");
			System.out.println(respuesta.getEstudiantes().toString());
		} catch (Exception e) {
			log.error("Estudiante Service: Error en metodo findByRegionContaining()", e);
		}
		return respuesta;
	}

	@Override
	public EstudianteVO findByRegionandCursoContaining(String codigo_region, String codigo_curso) {
		respuesta = new EstudianteVO(new ArrayList<Estudiante>(), "ocurrio un error", "102");
		try {
			respuesta.setEstudiantes((List<Estudiante>) dao.findByRegionAndCurso(Integer.valueOf(codigo_region), codigo_curso));
			respuesta.setMensaje("se encuentran estudiantes");
			respuesta.setCodigo("0");
			System.out.println(respuesta.getEstudiantes().toString());
		} catch (Exception e) {
			log.error("Estudiante Service: Error en metodo findByRegionandCursoContaining()", e);
		}
		return respuesta;
	}

	@Override
	public EstudianteVO update(EstudianteVO estudiante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public NumberVO getPageCount(long registrosPorPagina) {
		NumberVO respuesta = new NumberVO(0, "Ha ocurrido un error", "109" );
		try {
			long registros = dao.count();
			if(registrosPorPagina == 0 && registros == 0) {
				respuesta.setValor(1);
			}else {
				respuesta.setValor((registros/registrosPorPagina) + (registros % registrosPorPagina == 0 ? 0 : 1));
			}
			respuesta.setCodigo("201");
			respuesta.setMensaje(String.format("Hay %d paginas", respuesta.getValor()));
		} catch (Exception e) {
			log.trace("Producto Service: Error en getPageCount", e);
		}
		return respuesta;
	}


	@Override
	@Transactional
	public EstudianteVO getPage(Integer pagina, Integer cantidad) {
		respuesta = new EstudianteVO(new ArrayList<Estudiante>(),"Ha ocurrido un error", "108" );
		try {
			Pageable pageable = PageRequest.of(pagina,cantidad);
			Page<Estudiante> responsePage = dao.findAll(pageable);
			respuesta.setEstudiantes(responsePage.getContent());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getEstudiantes().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Producto Service: Error en getPage", e);
		}
		return respuesta;
	}
	


	

}


	

		
	


