/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.partematerias;

/**
 *
 * @author FelixDDP
 */
public class Materia {
    private int id;
    private String alumno;
    private String materia;
    private int numeroHoras;
    
    public Materia(){}
    public Materia(int id){
        this.id = id;
    }
    
    public  Materia(int num, String alum, String mat, int numH){
        this.id=num;
        this.alumno=alum;
        this.materia=mat;
        this.numeroHoras=numH;
    }
    
    public  Materia(int num, String mat, int numH){
        this.id=num;
        this.materia=mat;
        this.numeroHoras=numH;
    }
    
    public  Materia(String mat, int numH){
        this.materia=mat;
        this.numeroHoras=numH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", alumno=" + alumno + ", materia=" + materia + ", numeroHoras=" + numeroHoras + '}';
    }   
}
