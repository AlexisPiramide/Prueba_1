package com.AlexisTorres.Prueba_1.Application;

import com.AlexisTorres.Prueba_1.Dominio.Especialista.Especialista;
import com.AlexisTorres.Prueba_1.Dominio.Especialista.EspecialistaRepository;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.TareaRepository;

import java.util.List;

public class EspecialistaUseCases {

    private EspecialistaRepository especialistaRepository;

    public EspecialistaUseCases(EspecialistaRepository especialistaRepository) {
        this.especialistaRepository = especialistaRepository;
    }

    public Especialista getEspecialista(Integer id){
       return  this.especialistaRepository.getEspecialista(id);
    }

    public List<Especialista> getAllEspecialistas(String especialidad){
        return  this.especialistaRepository.getAllEspecialistas(especialidad);
    }
}
