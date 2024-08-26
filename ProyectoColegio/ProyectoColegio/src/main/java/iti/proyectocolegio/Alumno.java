/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iti.proyectocolegio;

/**
 *
 * @author RTB1
 */
public class Alumno {
    private int id_Alumno;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private String Curso;
    private String Contacto;

    public Alumno(){}
    public Alumno(int id_Alumno){
        this.id_Alumno = id_Alumno;
    }
    public Alumno(String nombre, String apellido, String cedula, String curso, String contacto){
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Cedula = cedula;
        this.Curso = curso;
        this.Contacto = contacto;
    }

    public Alumno(int id_Alumno, String nombre, String apellido, String cedula,String Curso, String Contacto){
        this.id_Alumno = id_Alumno;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Cedula = cedula;
        this.Curso = Curso;
        this.Contacto = Contacto;
    }

    public int getId_Alumno() {
        return id_Alumno;
    }

    public void setId_Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        this.Cedula = cedula;
    }
    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "Id_Alumno=" + id_Alumno +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Cedula='" + Cedula + '\'' +
                ", Curso='" + Curso + '\'' +
                ", Contacto='" + Contacto + '\'' +
                '}';
    }

}
