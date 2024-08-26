/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iti.proyectocolegio;
import iti.proyectocolegio.Alumno
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static iti.connect.Connect.getConnection;

/**
 *
 * @author RTB1
 */
public class AlumnoDAO {
    public List<Alumno> listarAlumno(){
        List<Alumno> alumno = new ArrayList<>();

        // Trabajo con clase de conexion a BD
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = getConnection();
        String sql = "SELECT * FROM Alumno ORDER BY id_Alumno;";
        try{
            ps = conect.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var alumno = new Alumno();
                alumno.setId_Alumno(rs.getInt("id_Alumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setCedula(rs.getString("cedula"));
                alumno.setCurso(rs.getString("Curso"));
                alumno.setContacto(rs.getString("Contacto"));
                alumno.add(alumno);
            }
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al listar los Alumnos: " + e.getMessage());
        }
        finally {
            try{
                conect.close();
            }
            catch (Exception e){
                System.out.println("Error al cerrar conexion " + e.getMessage());
            }
        }
        return alumno;
    }

    public boolean findById(Alumno alumno) {
        PreparedStatement ps;
        ResultSet rs;
        Connection conect = getConnection();
        String sql = "SELECT * FROM alumno WHERE id_Alumno = ?;";
        try{
            ps = conect.prepareStatement(sql);
            ps.setInt(1, Alumno.getId_Alumno());
            rs = ps.executeQuery();
            while (rs.next()){
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellido(rs.getString("Apellido"));
                alumno.setCedula(rs.getString("Cedula"));
                alumno.setCurso(rs.getString("Curso"));
                alumno.setContacto(rs.getString("Contacto"));
                return true;
            }
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al buscar Alumno: " + e.getMessage());
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
        String sql = "INSERT INTO estudiante(cedula, nombre, apellido, telefono, email) " +
                "VALUES(?, ?, ?, ?, ?);";
        try{
            ps = conect.prepareStatement(sql);
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setString(1, alumno.getCedula());
            ps.setString(4, alumno.getCurso());
            ps.setString(5, alumno.getContacto());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al agregar Alumno: " + e.getMessage());
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
                "WHERE id_Alumno=?;";
        try{
            ps = conect.prepareStatement(sql);
            
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setString(1, alumno.getCedula());
            ps.setString(4, alumno.getCurso());
            ps.setString(5, alumno.getContacto());
            ps.setInt(6, alumno.getId_Alumno());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al actualizar Alumno: " + e.getMessage());
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
        String sql = "DELETE FROM alumno WHERE id_Alumno = ?;";
        try{
            ps = conect.prepareStatement(sql);
            ps.setInt(1, alumno.getId_Alumno());
            ps.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println("Ocurrio un error al eliminar Alumno: " + e.getMessage());
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
