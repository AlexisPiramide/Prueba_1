package com.AlexisTorres.Prueba_1.Data.SQL;

import com.AlexisTorres.Prueba_1.Application.EspecialidadUseCases;
import com.AlexisTorres.Prueba_1.Application.EspecialistaUseCases;
import com.AlexisTorres.Prueba_1.Application.ProyectoUsecases;
import com.AlexisTorres.Prueba_1.Application.TareaUseCases;
import com.AlexisTorres.Prueba_1.Connexion.ConnexionBD;
import com.AlexisTorres.Prueba_1.Dominio.Especialista.Especialista;
import com.AlexisTorres.Prueba_1.Dominio.Proyecto.Proyecto;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.Tarea;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RepositorySQLTest {

    private ProyectoUsecases proyectoUsecases;
    private TareaUseCases tareaUsecases;
    private EspecialistaUseCases especialistaUseCases;
    private EspecialidadUseCases especialidadUseCases;

    public RepositorySQLTest(){

        this.proyectoUsecases = new ProyectoUsecases(
                new RepositorySQL()
        );

        this.tareaUsecases = new TareaUseCases(
                new RepositorySQL()
        );

        this.especialistaUseCases = new EspecialistaUseCases(
                new RepositorySQL()
        );

        this.especialidadUseCases = new EspecialidadUseCases(
                new RepositorySQL()
        );

    }
    public boolean Limpiardatos() {
        try {
            Connection connection = ConnexionBD.getConexion("planificador");

            String deleteTareas = "DELETE FROM tareas";
            PreparedStatement preparedStatementDeleteTareas = connection.prepareStatement(deleteTareas);
            preparedStatementDeleteTareas.executeUpdate();

            String deleteEspecialistas = "DELETE FROM especialistas";
            PreparedStatement preparedStatementDeleteEspecialistas = connection.prepareStatement(deleteEspecialistas);
            preparedStatementDeleteEspecialistas.executeUpdate();

            String deleteProyectos = "DELETE FROM proyectos";
            PreparedStatement preparedStatementDeleteProyectos = connection.prepareStatement(deleteProyectos);
            preparedStatementDeleteProyectos.executeUpdate();

            String deleteEspecialidades = "DELETE FROM especialidades";
            PreparedStatement preparedStatementDeleteEspecialidades = connection.prepareStatement(deleteEspecialidades);
            preparedStatementDeleteEspecialidades.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean Añadirdatos() {
        try {
            Connection connection = ConnexionBD.getConexion("planificador");

            String insertProyectos = "INSERT INTO proyectos (`id`, `nombre`) VALUES " +
                    "('1', 'Sitio web con Spring Boot y React'), " +
                    "('2', 'Aplicación Next.js con Node.js backend'), " +
                    "('3', 'Despliegue en AWS con DevOps Pipeline')";


            PreparedStatement preparedStatementProyectos = connection.prepareStatement(insertProyectos);
            preparedStatementProyectos.executeUpdate();

            String insertEspecialidades = "INSERT INTO especialidades (codigo, nombre) VALUES " +
                    "('FRONT', 'Desarrollo Frontend'), " +
                    "('BACK', 'Desarrollo Backend'), " +
                    "('DEVOPS', 'DevOps')";

            PreparedStatement preparedStatementEspecialidades = connection.prepareStatement(insertEspecialidades);
            preparedStatementEspecialidades.executeUpdate();

            String insertEspecialistas = "INSERT INTO especialistas (id, nombre, especialidad) VALUES " +
                    "('1','Desarrollador Frontend React', 'FRONT'), " +
                    "('2','Desarrollador Backend Spring Boot', 'BACK'), " +
                    "('3','DevOps Engineer', 'DEVOPS'), " +
                    "('4','Desarrollador Frontend Next.js', 'FRONT'), " +
                    "('5','Desarrollador Backend Node.js', 'BACK'), " +
                    "('6','DevOps Specialist AWS', 'DEVOPS')";

            PreparedStatement preparedStatementEspecialistas = connection.prepareStatement(insertEspecialistas);
            preparedStatementEspecialistas.executeUpdate();

            String insertTareas = "INSERT INTO tareas (codigo, nombre, proyecto, especialidad, especialista) VALUES " +
                    "('T1', 'Desarrollo de interfaz con React', 1, 'FRONT', 1), " +
                    "('T2', 'Desarrollo de backend con Spring Boot', 1, 'BACK', 2), " +
                    "('T3', 'Despliegue en AWS con DevOps', 3, 'DEVOPS', 3), " +
                    "('T4', 'Desarrollo de componentes en Next.js', 1, 'FRONT', 4), " +
                    "('T5', 'Implementación de API en Node.js', 2, 'BACK', 5), " +
                    "('T6', 'Configuración de entorno en AWS', 3, 'DEVOPS', 6)";

            PreparedStatement preparedStatementTareas = connection.prepareStatement(insertTareas);
            preparedStatementTareas.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    boolean limpiarbase(){
        Limpiardatos();
        Añadirdatos();
        return true;
    }

    @Test
    void LimpiardatosTest(){
        assertEquals(true,Limpiardatos());
    }

    @Test
    void AñadirdatosTest() {
        Limpiardatos();
        assertEquals(true,Añadirdatos());
    }

    @Test
    void limpiarBaseTest(){
        assertEquals(true,limpiarbase());
    }


    @Test
    void getProjecto() {
        limpiarbase();
        Proyecto proyecto= new Proyecto(1,"Sitio web con Spring Boot y React",new ArrayList<>());
        assertEquals(proyecto.getId(),proyectoUsecases.getProyecto(1).getId());
        assertEquals(proyecto.getNombre(),proyectoUsecases.getProyecto(1).getNombre());
    }

    @Test
    void eliminarProyecto() {
        limpiarbase();
        assertEquals(true,proyectoUsecases.eliminarProyecto(1));

    }

    @Test
    void nuevoProyecto() {
        Proyecto proyecto = new Proyecto(6,"HTML");
        limpiarbase();
        assertEquals(true,proyectoUsecases.añadirproyecto(proyecto));
    }

    @Test
    void getAllTareas() {
        limpiarbase();
        assertEquals(3,tareaUsecases.getAllTareas(1).size());
    }

    @Test
    void eliminarTarea() {
        limpiarbase();
        assertEquals(true,tareaUsecases.eliminartareas(1));
    }

    @Test
    void añadirTarea() {
        Especialista especialista = new Especialista(10,"Pepe","DEVOPS");
        Tarea tarea = new Tarea("TG2","MYSQL Purge","DEVOPS",especialista);
        limpiarbase();
        assertEquals(true,tareaUsecases.añadirtarea(tarea));

    }

    @Test
    void getEspecialista() {
        Especialista especialista = new Especialista(1,"Desarrollador Frontend React","FRONT");
        limpiarbase();
        assertEquals(especialista.getNombre(),especialistaUseCases.getEspecialista(1).getNombre());
        assertEquals(especialista.getId(),especialistaUseCases.getEspecialista(1).getId());
        assertEquals(especialista.getEspecialidad(),especialistaUseCases.getEspecialista(1).getEspecialidad());
    }

    @Test
    void getAllEspecialidades() {
        assertEquals(3,especialidadUseCases.getAllEspecialidades().size());
    }

    @Test
    void getAllEspecialistas() {

        assertEquals(2,especialistaUseCases.getAllEspecialistas("DEVOPS").size());
    }
}