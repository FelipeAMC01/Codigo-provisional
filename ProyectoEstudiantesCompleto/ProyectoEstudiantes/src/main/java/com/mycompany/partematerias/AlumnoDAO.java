/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.partematerias;

import static com.mycompany.partematerias.Connect.getConnection;
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
public class AlumnoDAO {

    // Listar todos los alumnos
    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = getConnection();
        String sql = "SELECT * FROM alumno ORDER BY id;";
        try {
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setId_Alumno(rs.getInt("id"));
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellido(rs.getString("Apellido"));
                alumno.setCedula(rs.getString("Cedula"));
                alumno.setCurso(rs.getInt("Curso"));
                alumno.setContacto(rs.getString("Contacto"));
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al listar los alumnos: " + e.getMessage());
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return alumnos;
    }

    // Buscar alumno por ID
    public boolean findById(Alumno alumno) {
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = getConnection();
        String sql = "SELECT * FROM alumno WHERE id = ?;";
        try {
            ps = conect.prepareStatement(sql);
            ps.setInt(1, alumno.getId_Alumno());
            rs = ps.executeQuery();
            if (rs.next()) {
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellido(rs.getString("Apellido"));
                alumno.setCedula(rs.getString("Cedula"));
                alumno.setCurso(rs.getInt("Curso"));
                alumno.setContacto(rs.getString("Contacto"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al buscar alumno: " + e.getMessage());
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    // Buscar alumno por cédula
    public boolean findByCedula(Alumno alumno) {
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = getConnection();
        String sql = "SELECT * FROM alumno WHERE Cedula = ?;";
        try {
            ps = conect.prepareStatement(sql);
            ps.setString(1, alumno.getCedula());
            rs = ps.executeQuery();
            if (rs.next()) {
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellido(rs.getString("Apellido"));
                alumno.setCedula(rs.getString("Cedula"));
                alumno.setCurso(rs.getInt("Curso"));
                alumno.setContacto(rs.getString("Contacto"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al buscar alumno: " + e.getMessage());
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    // Agregar nuevo alumno
    public boolean agregarAlumno(Alumno alumno) {
        PreparedStatement ps;
        Connection conect = getConnection();
        String sql = "INSERT INTO alumno(Nombre, Apellido, Cedula, Curso, Contacto) VALUES(?, ?, ?, ?, ?);";
        try {
            ps = conect.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getCedula());
            ps.setInt(4, alumno.getCurso());
            ps.setString(5, alumno.getContacto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al agregar alumno: " + e.getMessage());
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    // Actualizar alumno
    public boolean actualizarAlumno(Alumno alumno) {
        PreparedStatement ps;
        Connection conect = getConnection();
        String sql = "UPDATE alumno SET Nombre = ?, Apellido = ?, Cedula = ?, Curso = ?, Contacto = ? WHERE id = ?;";
        try {
            ps = conect.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getCedula());
            ps.setInt(4, alumno.getCurso());
            ps.setString(5, alumno.getContacto());
            ps.setInt(6, alumno.getId_Alumno());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al actualizar alumno: " + e.getMessage());
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    // Eliminar alumno por cédula
    public boolean eliminarAlumnoPorId(int idAlumno) {
    // Implementa la lógica para eliminar por ID aquí
    // Ejemplo:
    String sql = "DELETE FROM alumno WHERE id = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idAlumno);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar por ID: " + e.getMessage());
        return false;
    }
}

public boolean eliminarAlumnoPorCedula(String cedula) {
    // Implementa la lógica para eliminar por cédula aquí
    // Ejemplo:
    String sql = "DELETE FROM alumno WHERE cedula = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, cedula);
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        System.out.println("Error al eliminar por cédula: " + e.getMessage());
        return false;
    }
}
}


