package com.AlexisTorres.Prueba_1.Dominio.Proyecto;

import com.AlexisTorres.Prueba_1.Dominio.Tareas.Tarea;

import java.util.List;

public class Proyecto {
    private Integer id;
    private String nombre;

    private List<Tarea> tareas;

    public Proyecto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.tareas=null;
    }

    public Proyecto(Integer id, String nombre, List<Tarea> tareas) {
        this.id = id;
        this.nombre = nombre;
        this.tareas=tareas;
    }

    public Proyecto(String nombre) {
        this.id=null;
        this.nombre = nombre;
        this.tareas=null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

}
