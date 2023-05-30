package com.henrry.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.henrry.spring.models.Equipo;
import com.henrry.spring.models.Jugador;

@Controller
public class ParametrosController {

  @GetMapping("/parametros")
  public String parametros(@RequestParam(required = false) String valor, Model model) {
    model.addAttribute("parametro", valor);

    return "parametros";
  }

  @GetMapping("/equipos/{nombre}/{numero}")
  public String parametrosPorPath(@PathVariable String nombre, @PathVariable int numero, Model model) {
    Optional<Equipo> equipoOptional = getEquipos().stream()
        .filter(equipo -> nombre.toLowerCase().equals(equipo.getNombre().toLowerCase())).findFirst();

    if (equipoOptional.isPresent()) {
      Optional<Jugador> jugadorOptional = equipoOptional.get().getPlantilla().stream()
          .filter(jugador -> numero == jugador.getNumero()).findFirst();

      if (jugadorOptional.isPresent()) {
        Jugador jugadorEquipo = jugadorOptional.get();
        model.addAttribute("jugador", jugadorEquipo);
      }
    }
    return "parametros";
  }

  public List<Equipo> getEquipos() {
    Equipo barcelona = new Equipo();
    barcelona.setNombre("Barcelona");
    barcelona.addJugador(new Jugador("TER STEGEN", 1));
    barcelona.addJugador(new Jugador("ARAUJO", 4));
    barcelona.addJugador(new Jugador("BUSQUETS", 5));
    barcelona.addJugador(new Jugador("LEWANDOSKI", 9));
    barcelona.addJugador(new Jugador("DEMBELE", 7));

    Equipo realMadrid = new Equipo();
    realMadrid.setNombre("Real Madrid");
    realMadrid.addJugador(new Jugador("COURTOIS", 1));
    realMadrid.addJugador(new Jugador("CARVAJAL", 2));
    realMadrid.addJugador(new Jugador("MODRIC", 10));
    realMadrid.addJugador(new Jugador("BENZEMA", 9));
    realMadrid.addJugador(new Jugador("HAZARD", 7));

    return List.of(barcelona, realMadrid);
  }

}
