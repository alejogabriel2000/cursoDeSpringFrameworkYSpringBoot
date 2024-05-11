package com.example.demo.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Equipo;
import com.example.demo.models.Jugador;
import com.example.demo.servicios.IEquipoService;

@Controller
public class ParametrosController {
	
	@Autowired
	@Qualifier("equiposEspaña")
	IEquipoService equipoService;
	
	// otra forma sin autowired
	/*private IEquipoService equipoService;
	
	public ParametrosController(IEquipoService equipoService) {
		this.equipoService = equipoService;
	}
	*/
	// http://localhost:8080/parametros?valor=este%20es%20mi%20valor
	// http://localhost:8080/parametros?valor=este%20es%20mi%20valor&valor_dos=segundo%20valor
	@GetMapping("/parametros")
	public String parametros(@RequestParam(defaultValue = "valor default") String valor, @RequestParam(defaultValue = "", name = "valor_dos") String otroValor, Model model) {
		model.addAttribute("titulo", "Parametros");
		model.addAttribute("parametro", valor);
		model.addAttribute("otroValor", otroValor);
		return "parametros";
	}
	
	// http://localhost:8080/equipos/RealMadrid/1
	// http://localhost:8080/equipos/RealMadrid/9
	@GetMapping("equipos/{nombre}/{numero}")
	public String parametrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model) {
		Optional<Equipo> equipoOptional = equipoService.getTodos().stream().filter(equipo -> nombre.toLowerCase().equals(equipo.getNombre().toLowerCase())).findFirst();
		if (equipoOptional.isPresent()) {
			Optional<Jugador> jugadorOptional = equipoOptional.get().getPlantilla().stream().filter(jugador -> numero == jugador.getNumero()).findFirst();
			
			if(jugadorOptional.isPresent()) {
				model.addAttribute("jugador", jugadorOptional.get());
			}
		}
		return "parametros";
	}
	


}
