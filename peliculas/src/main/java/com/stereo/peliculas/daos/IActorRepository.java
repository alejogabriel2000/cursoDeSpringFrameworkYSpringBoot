package com.stereo.peliculas.daos;

import org.springframework.data.repository.CrudRepository;

import com.stereo.peliculas.entidades.Actor;

public interface IActorRepository extends CrudRepository<Actor, Long>{

}
