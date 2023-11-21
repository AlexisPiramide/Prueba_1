package com.AlexisTorres.Prueba_1.Dominio.Especialista;

import java.util.List;

public interface EspecialistaRepository {

    Especialista getEspecialista(Integer id);
    List<Especialista> getAllEspecialistas(String especialidad);
}
