package com.AlexisTorres.Prueba_1.Data.Controller;


import com.AlexisTorres.Prueba_1.Application.ProyectoUsecases;
import com.AlexisTorres.Prueba_1.Data.SQL.RepositorySQL;
import com.AlexisTorres.Prueba_1.Dominio.Proyecto.Proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProyectoController {
    private ProyectoUsecases usecases;

    public ProyectoController() {
        this.usecases = new ProyectoUsecases(new RepositorySQL());
    }

    @GetMapping("/proyectos")
    String proyectos(Model model) {

        List<Proyecto> proyectos = usecases.getAllProyectos();
        model.addAttribute("proyectos", proyectos);
        return "index";
    }

    @GetMapping("/proyecto/nuevo")
    public String NuevoProyecto(Model model) {
        return "nuevo.html";
    }

    @PostMapping("/proyecto/save")
    public String NuevoProyectoPost(@RequestParam("nombre") String nombre) {

        usecases.añadirproyecto(new Proyecto(nombre));
        return "redirect:/proyectos";
    }
}