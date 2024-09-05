/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.partematerias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FelixDDP
 */
public class MateriaDAO {
    public void insertarMateria(int alumnoId, String materia, int horas) {
        try (Connection conn = Connect.getConnection()) {
            String sql = "INSERT INTO MateriaEsp (alumno_id, materia, horas) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alumnoId);
            stmt.setString(2, materia);
            stmt.setInt(3, horas);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarMateria(int alumnoId, String materia) {
        try (Connection conn = Connect.getConnection()) {
            String sql = "DELETE FROM MateriaEsp WHERE alumno_id = ? AND materia = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alumnoId);
            stmt.setString(2, materia);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Materia> obtenerMateriasPorAlumno(int alumnoId) {
        List<Materia> resultados = new ArrayList<>();
        String sql = "SELECT A.nombre AS nombre_alumno, M.materia AS nombre_materia, ME.materia AS nombre_materiaesp " +
                     "FROM Alumno A " +
                     "JOIN Materia M ON M.curso_id = A.id_curso " +
                     "JOIN MateriaEsp ME ON ME.id_materia = A.id " +
                     "WHERE A.id = ?";

        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alumnoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombreAlumno = rs.getString("nombre_alumno");
                String nombreMateria = rs.getString("nombre_materia");
                String nombreMateriaEsp = rs.getString("nombre_materiaesp");
                resultados.add(new Materia(rs.getInt("id"), rs.getString("nombre"), rs.getString("materia"), rs.getInt("horas")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }

    public void insertarMateriaPorCurso(int cursoId, String materia, int horas) {
        try (Connection conn = Connect.getConnection()) {
            // Insertar la materia para todos los alumnos del curso
            String sql = "INSERT INTO Materia (curso_id, materia, horas) " +
                         "SELECT id_curso, ?, ? FROM Alumnos WHERE curso_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, materia);
            stmt.setInt(2, horas);
            stmt.setInt(3, cursoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarMateriaPorCurso(int cursoId, String materia) {
        try (Connection conn = Connect.getConnection()) {
            // Eliminar la materia para todos los alumnos del curso
            String sql = "DELETE FROM Materia WHERE materia = ? AND curso_id IN " +
                         "(SELECT id_curso FROM Alumnos WHERE curso_id = ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, materia);
            stmt.setInt(2, cursoId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Materia> obtenerMateriasPorCurso(int cursoId) {
        List<Materia> materias = new ArrayList<>();
        try (Connection conn = Connect.getConnection()) {
            // Obtener todas las materias para los alumnos del curso
            String sql = "SELECT M.curso_id, M.materia, M.horas FROM Materias M " +
                         "JOIN Alumnos A ON M.curso_id = A.id_curso WHERE A.id_curso = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cursoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                materias.add(new Materia(rs.getInt("curso_id"), rs.getString("nombre"), rs.getInt("horas")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }
    
} 
