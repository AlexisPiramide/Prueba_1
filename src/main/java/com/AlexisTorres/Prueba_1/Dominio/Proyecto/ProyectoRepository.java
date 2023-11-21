package com.AlexisTorres.Prueba_1.Dominio.Proyecto;

import java.util.List;

public interface ProyectoRepository {


    List<Proyecto> getAllProyectos();
    boolean nuevoProyecto(Proyecto proyecto);

    Proyecto getProjecto(Integer id);

    boolean eliminarProyecto(Integer id);



}
