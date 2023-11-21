package com.AlexisTorres.Prueba_1.Data.RES;

import com.AlexisTorres.Prueba_1.Application.EspecialidadUseCases;
import com.AlexisTorres.Prueba_1.Application.EspecialistaUseCases;
import com.AlexisTorres.Prueba_1.Application.ProyectoUsecases;
import com.AlexisTorres.Prueba_1.Application.TareaUseCases;
import com.AlexisTorres.Prueba_1.Data.SQL.RepositorySQL;
import com.AlexisTorres.Prueba_1.Dominio.Especialista.Especialista;
import com.AlexisTorres.Prueba_1.Dominio.Especialista.EspecialistaRepository;
import com.AlexisTorres.Prueba_1.Dominio.Especilidad.Especialidad;
import com.AlexisTorres.Prueba_1.Dominio.Proyecto.Proyecto;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProyectoRESController {

    private ProyectoUsecases proyectoUsecases;
    private TareaUseCases tareaUsecases;
    private EspecialistaUseCases especialistaUseCases;
    private EspecialidadUseCases especialidadUseCases;

    public ProyectoRESController(){

        this.proyectoUsecases = new ProyectoUsecases(
                new RepositorySQL()
        );

        this.tareaUsecases = new TareaUseCases(
                new RepositorySQL()
        );

        this.especialistaUseCases = new EspecialistaUseCases(
                new RepositorySQL()
        );

        this.especialidadUseCases = new EspecialidadUseCases(
                new RepositorySQL()
        );

    }



    @GetMapping("/api/proyectos")
    List<Proyecto> getAllProyectos(){
        return this.proyectoUsecases.getAllProyectos();
    }

    @GetMapping("/api/proyecto/{id}")
    Proyecto getAllFromProyecto(@PathVariable Integer id) {
        Proyecto proyecto = this.proyectoUsecases.getProyecto(id);

        List<Tarea> tareas = this.tareaUsecases.getAllTareas(id);
        List<Tarea> tareasConEspecialista = new ArrayList<>();
        for (Tarea tarea : tareas) {
            Integer especialistaId = tarea.getId_especialista();
            Especialista especialista = especialistaUseCases.getEspecialista(especialistaId);

            tareasConEspecialista.add(new Tarea(tarea.getCodigo(), tarea.getNombre(), tarea.getEspecialidad(), especialista));


        }

        proyecto.setTareas(tareasConEspecialista);
        return proyecto;
    }

    @PostMapping("/api/proyecto/{id}") Proyecto añadirtarea(@PathVariable Integer id, @RequestBody Tarea tarea) {
        tarea.setId_projecto(id);
        tareaUsecases.añadirtarea(tarea);
        return proyectoUsecases.getProyecto(id);
    }

    @DeleteMapping("/api/proyecto/{id}") List<Proyecto> eliminarProyecto(@PathVariable Integer id) {
        proyectoUsecases.eliminarProyecto(id);
        return this.proyectoUsecases.getAllProyectos();
    }

    @GetMapping("/api/especialidades") List<Especialidad> getAllEspecialidades(){
        List<Especialidad> listaEspecialidades = especialidadUseCases.getAllEspecialidades();

        for (Especialidad e: listaEspecialidades) {
            List<Especialista> listaEspecialistas = especialistaUseCases.getAllEspecialistas(e.getCodigo());
            e.setEspecilistas(listaEspecialistas);
        }

        return listaEspecialidades;
    }
}
