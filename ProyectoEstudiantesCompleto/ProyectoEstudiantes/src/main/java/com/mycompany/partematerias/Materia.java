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
    private String nombre;
    private int horas;

    // Constructor por defecto
    public Materia() {}

    // Constructor con todos los parámetros
    public Materia(int id, String nombre, int horas) {
        this.id = id;
        this.nombre = nombre;
        this.horas = horas;
    }

    // Constructor con nombre y horas (para coincidir con el uso en MateriaDAO)
    public Materia(String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}