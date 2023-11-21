package com.AlexisTorres.Prueba_1.Data.Controller;

import com.AlexisTorres.Prueba_1.Application.TareaUseCases;
import com.AlexisTorres.Prueba_1.Data.SQL.RepositorySQL;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.Tarea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TareaController {


    private TareaUseCases usecases;

    public TareaController() {
        this.usecases = new TareaUseCases(new RepositorySQL());
    }

    @GetMapping("/error")
    public String handleError() {

        return "error.html";
    }

    @GetMapping("/proyecto/{id}")
    String infoproyecto(Model model, @PathVariable Integer id) {

        List<Tarea> tareas = usecases.getAllTareas(id);
        String Projecto = null;
        for (Tarea t: tareas) {
             Projecto  = t.getNombreProjecto();
        }
        model.addAttribute("idProyecto", id);
        model.addAttribute("tareas", tareas);
        model.addAttribute("nombreproyecto", Projecto);
        return "tareas";
    }

    @PostMapping("/proyecto/borrar")
    String deletetareas(Model model, @RequestParam(name = "idProyecto") Integer id) {
        usecases.eliminartareas(id);
        return "redirect:/proyectos";
    }
}
