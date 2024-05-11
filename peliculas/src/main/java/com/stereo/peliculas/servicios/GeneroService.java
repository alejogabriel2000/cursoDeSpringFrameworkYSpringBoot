package com.stereo.peliculas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stereo.peliculas.daos.IGeneroRepository;
import com.stereo.peliculas.entidades.Genero;

@Service
public class GeneroService implements IGeneroService {
	
	@Autowired
	private IGeneroRepository generoRepository;

	@Override
	public void grabar(Genero genero) {
		generoRepository.save(genero);
		
	}

	@Override
	public Genero finfById(Long id) {
		return generoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		generoRepository.deleteById(id);
		
	}

	@Override
	public List<Genero> findAll() {
		return (List<Genero>) generoRepository.findAll();
	}

}
