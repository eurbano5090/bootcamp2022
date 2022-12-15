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
import com.edutecno.jpacrud.service.EstudianteService;

@Controller
public class EstudianteController {

	private static final Logger log = LoggerFactory.getLogger(EstudianteController.class);
	
	@Autowired
	private EstudianteService svc;
	
	public EstudianteController() {
		new ArrayList<Estudiante>();
		
	}
	public void setEstudiante(Estudiante estudiante) {
	}
	
	
	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}

	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Estudiante estudiante, RedirectAttributes ra) {
		EstudianteVO respuestaServicio = svc.add(estudiante);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/estudiante");
		}
	}
	
	@GetMapping("/estudiante")
	public String addForm(Model model) {
		return "estudiante";
}
	
	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String idEstudiante, RedirectAttributes ra) {
	   EstudianteVO respuestaServicio = new EstudianteVO();
	    respuestaServicio.setMensaje("No se pudo eliminar al usuario, intente nuevamente.");

	    try {
	        Estudiante eliminado = new Estudiante();
	        eliminado.setId_estudiante(Integer.parseInt(idEstudiante));
	        respuestaServicio = svc.delete(eliminado);
	        ra.addFlashAttribute("mensaje",
	        respuestaServicio.getMensaje());
	        return new ModelAndView("redirect:/home");
	    } catch (Exception e) {
	        log.error("Error en UsuarioController eliminar", e);
	    }
	    ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
	    respuestaServicio = svc.getAllEstudiantes();
	    ra.addAttribute("VO", respuestaServicio);
	    return new ModelAndView("redirect:/home");
	}
}