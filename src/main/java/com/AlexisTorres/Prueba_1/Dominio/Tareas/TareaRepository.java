package com.AlexisTorres.Prueba_1.Dominio.Tareas;

import java.util.List;

public interface TareaRepository {


    List<Tarea> getAllTareas(Integer codigoprojecto);
    boolean eliminarTarea(Integer id);

    boolean añadirTarea(Tarea tarea);
}
