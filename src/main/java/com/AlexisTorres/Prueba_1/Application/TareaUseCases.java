package com.AlexisTorres.Prueba_1.Application;

import com.AlexisTorres.Prueba_1.Dominio.Proyecto.Proyecto;
import com.AlexisTorres.Prueba_1.Dominio.Proyecto.ProyectoRepository;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.Tarea;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.TareaRepository;

import java.util.List;

public class TareaUseCases {

    private TareaRepository tareaRepository;

    public TareaUseCases(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }


    public List<Tarea> getAllTareas(Integer id) {
        return this.tareaRepository.getAllTareas(id);
    }

    public boolean eliminartareas(Integer id){
        return this.tareaRepository.eliminarTarea(id);
    }

    public boolean añadirtarea(Tarea tarea){
        return this.tareaRepository.añadirTarea(tarea);
    }


}
