package com.edutecno.jpacrud.controlador;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edutecno.jpacrud.VO.EstudianteVO;

import com.edutecno.jpacrud.modelo.Estudiante;
import com.edutecno.jpacrud.service.CursoService;
import com.edutecno.jpacrud.service.EstudianteService;
import com.edutecno.jpacrud.service.RegionService;
import com.edutecno.jpacrud.util.Util;

@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EstudianteService svc;
	
	@Autowired
	private RegionService regionsvc;
	
	@Autowired
	private CursoService cursosvc;
	
	public HomeController() {
		new ArrayList<Estudiante>();
		
	}
	
	public void setEstudiante(Estudiante estudiante) {
	}
	
	@GetMapping({"/","/inicio"})
	public String home(Model model) {
		return "inicio";
	}

	@GetMapping("/home")
	public String home(Model model,@RequestParam(defaultValue = "1") Integer p){
		model.addAttribute("VO",svc.getAllEstudiantes());
		model.addAttribute("Region", regionsvc.getAllRegiones());
		model.addAttribute("Curso", cursosvc.getAllCursos());
		return "home";
	}

	@PostMapping("/buscar")
	public String buscar(Model model, @ModelAttribute Estudiante estudiante,  @RequestParam String cod_curso,@RequestParam String cod_region, RedirectAttributes ra) {
    	if(cod_curso.equals("0") && !cod_region.equals("0")) {
    		//busqueda por region
    		EstudianteVO resultado = svc.findByRegionContaining(cod_region);
    		ra.addFlashAttribute("mensaje", resultado.getMensaje());
    		model.addAttribute("mensaje", resultado.getMensaje());
            model.addAttribute("VO", resultado);
    		
    	}else if(!cod_curso.equals("0") && cod_region.equals("0")) {
    		//busqueda por curso
    		EstudianteVO resultado = svc.findByCursoContaining(cod_curso);
    		ra.addFlashAttribute("mensaje", resultado.getMensaje());
    		model.addAttribute("mensaje", resultado.getMensaje());
            model.addAttribute("VO", resultado);
    	}else if(!cod_curso.equals("0") && !cod_region.equals("0")) {
    		//busqueda por curso y region
    		EstudianteVO resultado = svc.findByRegionandCursoContaining(cod_region, cod_curso);
    		ra.addFlashAttribute("mensaje", resultado.getMensaje());
    		model.addAttribute("mensaje", resultado.getMensaje());
            model.addAttribute("VO", resultado);
    	}
        model.addAttribute("Region", regionsvc.getAllRegiones());
		model.addAttribute("Curso", cursosvc.getAllCursos());
		
        return "buscar";
        
        
	}
	
}