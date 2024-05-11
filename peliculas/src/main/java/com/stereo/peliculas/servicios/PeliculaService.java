package com.stereo.peliculas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stereo.peliculas.daos.IPeliculaRepository;
import com.stereo.peliculas.entidades.Pelicula;

@Service
public class PeliculaService implements IPeliculaService {

	@Autowired
	private IPeliculaRepository peliculaRepository;

	@Override
	public void grabar(Pelicula pelicula) {
		peliculaRepository.save(pelicula);
		
	}

	@Override
	public Pelicula finfById(Long id) {
		return peliculaRepository.findById(id).orElse(null);

	}

	@Override
	public void eliminar(Long id) {
		peliculaRepository.deleteById(id);
		
	}

	@Override
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculaRepository.findAll();
	}
	
}
