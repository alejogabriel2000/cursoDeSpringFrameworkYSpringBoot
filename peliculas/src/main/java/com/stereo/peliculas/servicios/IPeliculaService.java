package com.stereo.peliculas.servicios;

import java.util.List;

import com.stereo.peliculas.entidades.Pelicula;

public interface IPeliculaService {
	
	void grabar(Pelicula pelicula);
	
	Pelicula finfById(Long id);
	
	void eliminar(Long id);
	
	List<Pelicula> findAll();
}