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
    private String materia;
    private int numeroHoras;
    
    
    public  Materia(int num, String mat, int numH){
        this.id=num;
        this.materia=mat;
        this.numeroHoras=numH;
    }

    public int getId() {
        return id;
    }

    public String getMateria() {
        return materia;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }
    
    @Override
    public String toString() {
        return "ID: "+id+"  Materia: "+materia+"  Numero de horas: "+numeroHoras;
    } 
}
