package com.AlexisTorres.Prueba_1.Data.SQL;

import com.AlexisTorres.Prueba_1.Connexion.ConnexionBD;
import com.AlexisTorres.Prueba_1.Dominio.Especialista.Especialista;
import com.AlexisTorres.Prueba_1.Dominio.Especialista.EspecialistaRepository;
import com.AlexisTorres.Prueba_1.Dominio.Especilidad.Especialidad;
import com.AlexisTorres.Prueba_1.Dominio.Especilidad.EspecialidadRepository;
import com.AlexisTorres.Prueba_1.Dominio.Proyecto.Proyecto;
import com.AlexisTorres.Prueba_1.Dominio.Proyecto.ProyectoRepository;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.Tarea;
import com.AlexisTorres.Prueba_1.Dominio.Tareas.TareaRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorySQL implements ProyectoRepository, TareaRepository, EspecialistaRepository, EspecialidadRepository {
    @Override
    public List<Proyecto> getAllProyectos() {
        List<Proyecto> lista = new ArrayList<>();
        try {
            String Query = "SELECT * FROM proyectos";
            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                lista.add(new Proyecto(id, nombre,new ArrayList<>()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }


    @Override
    public Proyecto getProjecto(Integer id) {
        Proyecto proyecto= null;
        try {
            String Query = "SELECT * FROM proyectos WHERE id='"+id+"'";
            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                proyecto = new Proyecto(id, nombre,new ArrayList<>());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proyecto;
    }

    @Override
    public boolean eliminarProyecto(Integer id) {

        try {
            String Query = "DELETE FROM proyectos WHERE id ='" + id + "'";

            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(Query);
            preparedStatement.execute();


            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean nuevoProyecto(Proyecto proyecto) {
        try {
            String query = "INSERT INTO proyectos (nombre) VALUES ('" + proyecto.getNombre() + "')";

            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(query);
            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tarea> getAllTareas(Integer projecto) {
        List<Tarea> lista = new ArrayList<>();
        try {
            String Query = "SELECT tareas.*,proyectos.nombre as nombreproyecto FROM tareas JOIN proyectos ON tareas.proyecto = proyectos.id WHERE proyectos.id = '"+projecto+"';";

            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String especialidad = rs.getString("especialidad");
                Integer especilista = rs.getInt("especialista");
                String nombreproyecto = rs.getString("nombreproyecto");
                lista.add(new Tarea(codigo, nombre,especialidad,especilista,nombreproyecto));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public boolean eliminarTarea(Integer id) {
        try {
            String Query = "DELETE FROM tareas WHERE proyecto ='" + id + "'";

            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(Query);
            preparedStatement.execute();


            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean añadirTarea(Tarea tarea) {

        try {
            String query = "INSERT INTO 'tareas' ('codigo', 'nombre', 'proyecto', 'especialidad', 'especialista') VALUES ('"+tarea.getCodigo()+"'" +
                    ", '"+tarea.getNombre()+"', '"+tarea.getId_projecto()+"', '"+tarea.getEspecialidad()+"', '"+tarea.getEspecialista()+"')";

            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(query);
            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Especialista getEspecialista(Integer id){
        Especialista especialista= null;
        try {
            String Query = "SELECT * FROM especialistas WHERE id='"+id+"'";
            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String especialidad = rs.getString("especialidad");
                especialista = new Especialista(id, nombre,especialidad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return especialista;
    }

    @Override
    public List<Especialidad> getAllEspecialidades() {
        List<Especialidad> lista = new ArrayList<>();
        try {
            String Query = "SELECT * FROM especialidades";
            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                lista.add(new Especialidad(codigo,nombre,new ArrayList<Especialista>()));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public List<Especialista> getAllEspecialistas(String especialidad) {
        List<Especialista> lista = new ArrayList<>();
        try {
            String Query = "SELECT * FROM especialistas WHERE especialidad='"+especialidad+"'";
            PreparedStatement preparedStatement = ConnexionBD.getConexion("planificador").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                lista.add(new Especialista(id,nombre,especialidad));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }



}
