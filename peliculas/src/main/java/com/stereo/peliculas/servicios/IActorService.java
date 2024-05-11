package com.stereo.peliculas.servicios;

import java.util.List;

import com.stereo.peliculas.entidades.Actor;

public interface IActorService {

	List<Actor> findAll();
	List<Actor> findAllById(List<Long> ids);

}
