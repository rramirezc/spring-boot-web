package com.bolsadeideas.springboot.web.app.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework !!!");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Jhon");
		usuario.setApellido("Ramirez");
		usuario.setEmail("Jhon@correo.gmail.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo","Perfil del usuario:" + usuario.getNombre());
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo","Listado de Usuarios:");		
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Jhon","Ramirez","jhon@gmail.com"));
		usuarios.add(new Usuario("Jhon1","Ramirez1","jhon1@gmail.com"));
		usuarios.add(new Usuario("Jhon2","Ramirez2","jhon2@gmail.com"));
		
		return usuarios;
	}
	
}