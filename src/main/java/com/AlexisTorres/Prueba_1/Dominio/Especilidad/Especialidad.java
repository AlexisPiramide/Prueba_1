package com.AlexisTorres.Prueba_1.Dominio.Especilidad;

import com.AlexisTorres.Prueba_1.Dominio.Especialista.Especialista;

import java.util.List;

public class Especialidad {

    private String nombre;
    private String codigo;

    private List<Especialista> especilistas;

    public Especialidad(String codigo,String nombre, List<Especialista> especilistas) {
        this.codigo= codigo;
        this.nombre = nombre;
        this.especilistas = especilistas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Especialista> getEspecilistas() {
        return especilistas;
    }

    public void setEspecilistas(List<Especialista> especilistas) {
        this.especilistas = especilistas;
    }
}
