/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.partematerias;

/**
 *
 * @author FelixDDP
 */
public class Alumno {
    private int Id_Alumno;
    private String Nombre;
    private String Apellido;
    private String Cedula;
    private int Curso;
    private String Contacto;

    public Alumno(){}
    public Alumno(int Id_Alumno){
        this.Id_Alumno = Id_Alumno;
    }
    
    // Constructor para cedula
    
     public Alumno(String Cedula){
        this.Cedula = Cedula;
    }
    
    
    public Alumno(String Nombre, String Apellido, String Cedula, int Curso, String Contacto){        
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.Curso = Curso;
        this.Contacto = Contacto;
    }

    public Alumno(int Id_Alumno, String Nombre, String Apellido,String Cedula, int Curso, String Contacto){
        this.Id_Alumno = Id_Alumno;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Cedula = Cedula;
        this.Curso = Curso;
        this.Contacto = Contacto;
    }

    public int getId_Alumno() {
        return Id_Alumno;
    }

    public void setId_Alumno(int Id_Alumno) {
        this.Id_Alumno = Id_Alumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }
    public int getCurso() {
        return Curso;
    }

    public void setCurso(int Curso) {
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
        return "Alumno{" +
                "Id_Alumno=" + Id_Alumno +
                ", nombre='" + Nombre + '\'' +
                ", apellido='" + Apellido + '\'' +
                ", cedula='" + Cedula + '\'' +
                ", Curso='" + Curso + '\'' +
                ", Contacto='" + Contacto + '\'' +
                '}';
    }

}
