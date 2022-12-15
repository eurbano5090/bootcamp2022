package com.edutecno.jpacrud.controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	

	@RequestMapping("/login")
	public String redireccionador(HttpServletRequest request) {
		if(request.isUserInRole("ADMIN")) {
			return "redirect:/home";
		}else {
			return "redirect:/cursos";
		}
	}}