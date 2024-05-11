package com.example.demo.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexControlador {
	
	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("titulo", "Soy el titulo");
		model.addAttribute("saludo", "Hola");
		model.addAttribute("show", false);
		//List<String> series = null; //List.of("Dexter", "Game of thrones", "Vikings");
		//model.addAttribute("series", series);
		return "index";   // hace referencia al index.html
	}
	
	@GetMapping(value = "/index-mv")
	public ModelAndView indexMV(ModelAndView mv) {
		mv.addObject("titulo", "Titulo de MV");
		mv.addObject("saludo", "Saludo de MV");
		mv.addObject("show", true);
		//List<String> series = List.of("Dexter", "Game of thrones", "Vikings");
		//mv.addObject("series", series);
		mv.setViewName("index");
		return mv;
	}
	
	@ModelAttribute("series")  // atributo del index
	public List<String> getSeries() {
		return List.of("Dexter", "Game of thrones", "Vikings", "Flash", "The last of us");
	}
	
	@PostMapping("/index-post")
	public String indexRequestMapping() {
		return "index";
	}
}