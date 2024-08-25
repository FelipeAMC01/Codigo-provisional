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
            String sql = "INSERT INTO Materias (alumno_id, nombre, horas) VALUES (?, ?, ?)";
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
            String sql = "DELETE FROM Materias WHERE alumno_id = ? AND nombre = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alumnoId);
            stmt.setString(2, materia);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Materia> obtenerMateriasPorAlumno(int alumnoId) {
        List<Materia> materias = new ArrayList<>();
        try (Connection conn = Connect.getConnection()) {
            String sql = "SELECT * FROM Materias WHERE alumno_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alumnoId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                materias.add(new Materia(rs.getInt("alumno_id"), rs.getString("nombre"), rs.getInt("horas")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }

    public void insertarMateriaPorCurso(int cursoId, String materia, int horas) {
        try (Connection conn = Connect.getConnection()) {
            // Insertar la materia para todos los alumnos del curso
            String sql = "INSERT INTO Materias (alumno_id, nombre, horas) " +
                         "SELECT id, ?, ? FROM Alumnos WHERE curso_id = ?";
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
            String sql = "DELETE FROM Materias WHERE nombre = ? AND alumno_id IN " +
                         "(SELECT id FROM Alumnos WHERE curso_id = ?)";
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
            String sql = "SELECT M.alumno_id, M.nombre, M.horas FROM Materias M " +
                         "JOIN Alumnos A ON M.alumno_id = A.id WHERE A.curso_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cursoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                materias.add(new Materia(rs.getInt("alumno_id"), rs.getString("nombre"), rs.getInt("horas")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }
    
}
