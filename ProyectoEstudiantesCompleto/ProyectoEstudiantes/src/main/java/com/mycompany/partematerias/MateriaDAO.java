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

    public void insertarMateria(int alumnoId, int materiaId, int horas) {
        try (Connection conn = Connect.getConnection()) {
            String sql = "INSERT INTO alumno_materias (id_alumno, id_materia, horas) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alumnoId);
            stmt.setInt(2, materiaId);
            stmt.setInt(3, horas);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarMateria(int alumnoId, int materiaId) {
        try (Connection conn = Connect.getConnection()) {
            String sql = "DELETE FROM alumno_materias WHERE id_alumno = ? AND id_materia = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alumnoId);
            stmt.setInt(2, materiaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Materia> obtenerMateriasPorAlumno(int alumnoId) {
        List<Materia> resultados = new ArrayList<>();
        String sql = "SELECT M.nombre AS nombre_materia, AM.horas " +
                     "FROM alumno_materias AM " +
                     "JOIN materias M ON AM.id_materia = M.id " +
                     "WHERE AM.id_alumno = ?";

        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alumnoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nombreMateria = rs.getString("nombre_materia");
                int horas = rs.getInt("horas");
                resultados.add(new Materia(nombreMateria, horas));
            }

            // Mensaje si no hay materias asignadas
            if (resultados.isEmpty()) {
                System.out.println("Aún no tiene materias asignadas.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }

    public void insertarMateriaPorCurso(int idCurso, int idMateria, Integer horas) {
    try (Connection conn = Connect.getConnection()) {
        String sql = "INSERT INTO curso_materias (id_curso, id_materia, horas) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idCurso);
        stmt.setInt(2, idMateria);
        
        if (horas == null) {
            stmt.setNull(3, java.sql.Types.INTEGER);
        } else {
            stmt.setInt(3, horas);
        }
        
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void eliminarMateriaPorCurso(int cursoId, int materiaId) {
    try (Connection conn = Connect.getConnection()) {
        String sql = "DELETE FROM curso_materias WHERE id_materia = ? AND id_curso = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, materiaId);
        stmt.setInt(2, cursoId);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public List<Materia> obtenerMateriasPorCurso(int cursoId) {
    List<Materia> materias = new ArrayList<>();
    try (Connection conn = Connect.getConnection()) {
        String sql = "SELECT M.nombre, CM.horas " + // Aquí se usa CM.horas
                     "FROM curso_materias CM " +
                     "JOIN materias M ON CM.id_materia = M.id " +
                     "WHERE CM.id_curso = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cursoId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("nombre");
            int horas = rs.getInt("horas");
            materias.add(new Materia(nombre, horas));
        }

        if (materias.isEmpty()) {
            System.out.println("Aún no hay materias asignadas para este curso.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return materias;
}
}
