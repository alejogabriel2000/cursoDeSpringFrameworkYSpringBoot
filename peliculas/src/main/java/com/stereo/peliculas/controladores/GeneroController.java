package com.stereo.peliculas.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stereo.peliculas.daos.IGeneroRepository;
import com.stereo.peliculas.entidades.Genero;
import com.stereo.peliculas.servicios.IGeneroService;

@RestController
public class GeneroController {

	private IGeneroService servicio;
	
	public GeneroController(IGeneroService servicio) {
		this.servicio = servicio;
	}
	
	@PostMapping("genero")
	public Long guardar(@RequestParam String nombre) {
		Genero genero = new Genero();
		genero.setNombre(nombre);
		servicio.grabar(genero);
		return genero.getId();
	}
	
	@GetMapping("genero/{id}")
	public String buscarPorId(@PathVariable(name = "id") Long id) {
		return servicio.finfById(id).getNombre();
	}
}
