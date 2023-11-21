package com.AlexisTorres.Prueba_1.Application;

import com.AlexisTorres.Prueba_1.Dominio.Especialista.EspecialistaRepository;
import com.AlexisTorres.Prueba_1.Dominio.Especilidad.Especialidad;
import com.AlexisTorres.Prueba_1.Dominio.Especilidad.EspecialidadRepository;

import java.util.List;

public class EspecialidadUseCases {

    private EspecialidadRepository especialidadRepository;

    public EspecialidadUseCases(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public List<Especialidad> getAllEspecialidades(){
        return this.especialidadRepository.getAllEspecialidades();
    }
}
