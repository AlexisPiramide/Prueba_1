package com.AlexisTorres.Prueba_1.Dominio.Tareas;

import com.AlexisTorres.Prueba_1.Dominio.Especialista.Especialista;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarea {
    private String codigo, nombre, especialidad;
    private Integer id_projecto, id_especialista;
    private String NombreProjecto;

    private Especialista especialista;

    public Tarea(String codigo, String nombre, String especialidad, Integer id_projecto, Integer id_especialista) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.id_projecto = id_projecto;
        this.id_especialista = id_especialista;
    }

    public Tarea(String codigo, String nombre, String especialidad, Integer id_especialista,String NombreProjecto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.id_projecto = null;
        this.id_especialista = id_especialista;
        this.NombreProjecto = NombreProjecto;
    }

    public Tarea(String codigo, String nombre, String especialidad, Especialista especialista) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.especialista = especialista;
    }

    public String getCodigo() {return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getId_projecto() {
        return id_projecto;
    }

    public void setId_projecto(Integer id_projecto) {
        this.id_projecto = id_projecto;
    }

    public Integer getId_especialista() {
        return id_especialista;
    }

    public void setId_especialista(Integer id_especialista) {
        this.id_especialista = id_especialista;
    }

    public String getNombreProjecto() {
        return NombreProjecto;
    }

    public void setNombreProjecto(String nombreProjecto) {
        NombreProjecto = nombreProjecto;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }
}
