package com.stereo.peliculas.servicios;

import java.util.List;

import com.stereo.peliculas.entidades.Genero;

public interface IGeneroService {
	
	void grabar(Genero genero);
	
	Genero finfById(Long id);
	
	void eliminar(Long id);

	List<Genero> findAll();

}
