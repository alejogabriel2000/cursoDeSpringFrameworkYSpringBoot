package com.example.demo.servicios;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.models.Equipo;
import com.example.demo.models.Jugador;

@Service
@Primary
public class EquipoInglaterraService implements IEquipoService {

	@Override
	public List<Equipo> getTodos() {
		Equipo manchesterUnited = new Equipo();
		manchesterUnited.setNombre("ManchesterUnited");
		manchesterUnited.addJugador(new Jugador("GARNACHO", 49));

		Equipo manchesterCity = new Equipo();
		manchesterCity.setNombre("ManchesterCity");
		manchesterCity.addJugador(new Jugador("J ALVAREZ", 9));

		return List.of(manchesterUnited, manchesterCity);
	}
}