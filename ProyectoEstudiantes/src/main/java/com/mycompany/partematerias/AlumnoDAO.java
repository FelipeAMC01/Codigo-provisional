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
    public List<Alumno> listarAlumnos(){
        List<Alumno> alumnos = new ArrayList<>();

        // Trabajo con clase de conexion a BD
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = getConnection();
        String sql = "SELECT * FROM alumno ORDER BY id;";
        try{
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var alumno = new Alumno();
                alumno.setId_Alumno(rs.getInt("id"));
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellido(rs.getString("Apellido"));
                alumno.setCedula(rs.getString("Cedula"));
                alumno.setCurso(rs.getInt("Curso"));
                alumno.setContacto(rs.getString("Contacto"));
                alumnos.add(alumno);
                
            }
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al listar los alumnos: " + e.getMessage());
        }
        finally {
            try{
                conect.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return alumnos;
    }

    public boolean findById(Alumno alumno) {
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = getConnection();
        String sql = "SELECT * FROM alumno WHERE  id= ?;";
        try{
            ps = conect.prepareStatement(sql);
            ps.setInt(1, alumno.getId_Alumno());
            rs = ps.executeQuery();
            while (rs.next()){
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellido(rs.getString("Apellido"));
                alumno.setCedula(rs.getString("Cedula"));
                alumno.setCurso(rs.getInt("Curso"));
                alumno.setContacto(rs.getString("Contacto"));
                return true;
            }
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al buscar alumno: " + e.getMessage());
        }
        finally {
            try{
                conect.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    }

    // Buscar alumno por cedula
    
    
    public boolean findByCedula(Alumno alumno) {
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = getConnection();
        String sql = "SELECT * FROM alumno WHERE Cedula = ?;";
        try{
            ps = conect.prepareStatement(sql);
            
            ps.setString(1, alumno.getCedula());
            rs = ps.executeQuery();
            while (rs.next()){
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellido(rs.getString("Apellido"));
                alumno.setCedula(rs.getString("Cedula"));
                alumno.setCurso(rs.getInt("Curso"));
                alumno.setContacto(rs.getString("Contacto"));
                return true;
            }
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al buscar alumno: " + e.getMessage());
        }
        finally {
            try{
                conect.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    
    }
    
        
    public boolean agregarAlumno(Alumno alumno){
        PreparedStatement ps;
        Connection conect = getConnection();
        String sql = "INSERT INTO alumno(Nombre, Apellido, Cedula, Curso, Contacto) " +
                "VALUES(?, ?, ?, ?, ?);";
        try{
            ps = conect.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getCedula());
            ps.setInt(4, alumno.getCurso());
            ps.setString(5, alumno.getContacto());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al agregar alumno: " + e.getMessage());
        }
        finally {
            try{
                conect.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    }

    public boolean actualizarAlumno(Alumno alumno){
        PreparedStatement ps;
        Connection conect = getConnection();
        String sql = "UPDATE alumno SET nombre=?, apellido=?, cedula=?, Curso=?, Contacto=? " +
                "WHERE id=?;";
        try{
            ps = conect.prepareStatement(sql);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getCedula());
            ps.setInt(4, alumno.getCurso());
            ps.setString(5, alumno.getContacto());
            ps.setInt(6, alumno.getId_Alumno());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al actualizar alumno: " + e.getMessage());
        }
        finally {
            try{
                conect.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    }

    public boolean eliminarAlumno(Alumno alumno){
        PreparedStatement ps;
        Connection conect = getConnection();
        String sql = "DELETE FROM alumno WHERE id = ?;";
        try{
            ps = conect.prepareStatement(sql);
            ps.setInt(1, alumno.getId_Alumno());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al eliminar alumno: " + e.getMessage());
        }
        finally {
            try{
                conect.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    }
       
    //Eliminar Alumno por cedula
    
    public boolean eliminarAlumnoCedula(Alumno alumno){
        PreparedStatement ps;
        Connection conect = getConnection();
        String sql = "DELETE FROM alumno WHERE Cedula = ?;";
        try{
            ps = conect.prepareStatement(sql);
            ps.setString(01, alumno.getCedula());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al eliminar alumno: " + e.getMessage());
        }
        finally {
            try{
                conect.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return false;
    }

}
