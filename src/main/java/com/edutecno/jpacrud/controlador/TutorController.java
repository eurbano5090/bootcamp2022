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
import com.edutecno.jpacrud.VO.TutorVO;
import com.edutecno.jpacrud.modelo.Estudiante;
import com.edutecno.jpacrud.modelo.Tutor;
import com.edutecno.jpacrud.service.CursoService;
import com.edutecno.jpacrud.service.RegionService;
import com.edutecno.jpacrud.service.TutorService;

@Controller
public class TutorController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TutorService svc;
	
	@Autowired
	private RegionService regionsvc;
	
	@Autowired
	private CursoService cursosvc;
	
	public TutorController() {
		new ArrayList<Tutor>();
		
	}
	public void setTutor(Tutor tutor) {
	}
	
	@GetMapping("/tutores")
	public String home(Model model) {
		model.addAttribute("VO",svc.getAllTutores().getTutores());
		return "/tutores";
	}
	
	@GetMapping("/buscarTutor")
	public String buscar(Model model) {
		model.addAttribute("VO",svc.getAllTutores().getTutores());
		return "/buscarTutor";
	}
/*	@PostMapping("/buscarTutor")
	public String buscar(Model model, @ModelAttribute Tutor tutor,@RequestParam String cargo,RedirectAttributes ra){
    	
    		//busqueda por region
    		TutorVO resultado = (TutorVO) svc.findByCargo(tutor);
    		ra.addFlashAttribute("mensaje", resultado.getMensaje());
    		model.addAttribute("mensaje", resultado.getMensaje());
            model.addAttribute("VO", resultado);

        return "/buscarTutor";
	} */
	
	
/*	@PostMapping("/buscarTutor")
	public ModelAndView findByCargo(Model model, @ModelAttribute Tutor tutor,@RequestParam String cargo, RedirectAttributes ra) {
	    TutorVO resultado = (TutorVO) svc.findByCargo(cargo);
	    if (resultado.getCodigo().equals("0")) {
	    	log.info("Tutor a buscar: " + cargo);
	        model.addAttribute("mensaje", resultado.getMensaje());
	        model.addAttribute("VO", resultado.getTutores());
	       
	        return new ModelAndView("buscarTutor");
	    } else {
	    	try {
	       resultado = svc.getAllTutores();
	        return new ModelAndView("redirect:/buscarTutor");
	    } catch (Exception e) {
	        log.error("Error", e);
	    }
	    	return new ModelAndView("redirect:/buscarTutor");
	    }*/
	    

		@PostMapping("/buscarTutor")
		public String buscar(Model model, @ModelAttribute Tutor tutor,  @RequestParam String cod_curso,@RequestParam int cod_region, RedirectAttributes ra) {
	  
	    	 if(!cod_curso.equals("0") ) {
	    		//busqueda por curso y region
	    		TutorVO resultado = (TutorVO) svc.findByRegionAndCurso(cod_region, cod_curso);
	    		ra.addFlashAttribute("mensaje", resultado.getMensaje());
	    		model.addAttribute("mensaje", resultado.getMensaje());
	            model.addAttribute("VO", resultado.getTutores());
	    	}
	    	
	        model.addAttribute("Region", regionsvc.getAllRegiones());
			model.addAttribute("Curso", cursosvc.getAllCursos());
			
	        return "buscarTutor";
}}
