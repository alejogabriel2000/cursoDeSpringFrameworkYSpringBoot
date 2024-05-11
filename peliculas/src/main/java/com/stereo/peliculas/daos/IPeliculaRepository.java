package com.stereo.peliculas.daos;

import org.springframework.data.repository.CrudRepository;

import com.stereo.peliculas.entidades.Pelicula;

public interface IPeliculaRepository  extends CrudRepository<Pelicula, Long> {

}
