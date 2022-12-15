package com.edutecno.jpacrud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.jpacrud.service.CursoService;
import com.edutecno.jpacrud.service.EstudianteService;
import com.edutecno.jpacrud.service.RegionService;
import com.edutecno.jpacrud.util.Util;

@Controller
public class CursoController {
	
	@Autowired
	private EstudianteService svc;
	
	@Autowired
	private RegionService regionsvc;
	
	@Autowired
	private CursoService cursosvc;
	
	@GetMapping("/cursos")
	public String home(Model model,@RequestParam(defaultValue = "1") Integer p){
	
		model.addAttribute("Region", regionsvc.getAllRegiones());
		model.addAttribute("Curso", cursosvc.getAllCursos());
		return "cursos";
	}

}
