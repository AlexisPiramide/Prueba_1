package com.AlexisTorres.Prueba_1.Application;

import com.AlexisTorres.Prueba_1.Dominio.Proyecto.Proyecto;
import com.AlexisTorres.Prueba_1.Dominio.Proyecto.ProyectoRepository;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.Tarea;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.TareaRepository;

import java.util.List;

public class ProyectoUsecases {
    private ProyectoRepository proyectoRepository;
    private TareaRepository tareaRepository;

    public ProyectoUsecases(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }
    public List<Proyecto> getAllProyectos() {
        return this.proyectoRepository.getAllProyectos();
    }

    public Proyecto getProyecto(Integer id){
        return this.proyectoRepository.getProjecto(id);
    }

    public Boolean añadirproyecto(Proyecto proyecto) {
        return this.proyectoRepository.nuevoProyecto(proyecto);
    }

    public boolean eliminarProyecto(Integer id){
        return this.proyectoRepository.eliminarProyecto(id);
    }
}
