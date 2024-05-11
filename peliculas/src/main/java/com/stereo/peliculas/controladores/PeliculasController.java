package com.stereo.peliculas.controladores;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stereo.peliculas.entidades.Pelicula;
import com.stereo.peliculas.servicios.IActorService;
import com.stereo.peliculas.servicios.IGeneroService;
import com.stereo.peliculas.servicios.IPeliculaService;

@Controller
public class PeliculasController {

	private IPeliculaService servicio;

	private IGeneroService generoServicio;
	
	private IActorService actorServicio;

	public PeliculasController(IPeliculaService servicio, IGeneroService generoServicio, IActorService actorServicio) {
		this.servicio = servicio;
		this.generoServicio = generoServicio;
		this.actorServicio = actorServicio;
	}

	@GetMapping("/pelicula")
	public String crear(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("generos", generoServicio.findAll());
		model.addAttribute("actores", actorServicio.findAll());
		model.addAttribute("titulo", "Nueva Pelicula");
		return "pelicula";
	}

	@GetMapping("/pelicula/{id}")
	public String crear(@PathVariable(name = "id") Long id, Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("generos", generoServicio.findAll());
		model.addAttribute("actores", actorServicio.findAll());
		model.addAttribute("titulo", "Editar Pelicula");
		return "pelicula";
	}

	@PostMapping("/pelicula")
	public String guardar(@Valid Pelicula pelicula, BindingResult br, @ModelAttribute(name="ids") String ids, Model model) {
		if (br.hasErrors()) {
			model.addAttribute("generos", generoServicio.findAll());
			model.addAttribute("actores", actorServicio.findAll());
			return "pelicula";
		}
		List<Long> idsProtagonistas = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
		pelicula.setProtagonistas(actorServicio.findAllById(idsProtagonistas));
		servicio.grabar(pelicula);
		return "redirect:home";
	}

	@GetMapping({ "/", "/home", "/index" })
	public String home(Model model) {
		model.addAttribute("msj", "Catalogo actualizado a 2024");
		model.addAttribute("tipoMsj", "success");
		return "home";
	}
}