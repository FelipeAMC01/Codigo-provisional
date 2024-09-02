/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.partematerias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FelixDDP
 */
public class submenus {
    Scanner sc = new Scanner(System.in);
    public submenus() {}

    public void submenus(int a) {
        int id;
        int cr;

        if (a == 1) {
            System.out.println("Ingrese el ID del Alumno");
            while (!sc.hasNextInt()) {
                System.out.println("Ingresar un ID");
                sc.next();
            }
            id = sc.nextInt();

            try {
                if (buscarAlumnoPorID(id)) {
                    porID(id);
                } else {
                    System.out.println("No se encontro al alumno con el ID proporcionado.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Ingrese el curso del 1 al 3");
            while (true) {
                while (!sc.hasNextInt()) {
                    System.out.println("Ingresar un curso del 1 al 3");
                    sc.next();
                }
                cr = sc.nextInt();
                if(cr>=1 && cr<=3) {
                    break; // Sale del bucle si el número está dentro del rango
                }else{
                    System.out.println("Ingresar un curso del 1 al 3");
                }
            }
            porCurso(cr);
        }   
    }
    
    private boolean buscarAlumnoPorID(int id) throws SQLException {
        Connection con = Connect.getConnection();
        String query = "SELECT COUNT(*) FROM alumnos WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            return true;
        }
        return false;
    }
    
    void porID(int a) {
        MateriaDAO materiaDAO = new MateriaDAO();
        int op = 0;
        String mat;
        int h;

        do {
            System.out.println("--Materias del Alumno--");
            System.out.println("1. Ingresar");
            System.out.println("2. Cambiar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            while (!sc.hasNextInt()) {
                System.out.println("Ingresar una opción del 1 al 5");
                sc.next();
            }
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Ingrese la nueva materia:");
                    mat = sc.nextLine();

                    System.out.println("Ingrese el número de horas a cursar:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Ingrese un número válido de horas:");
                        sc.next();
                    }
                    h = sc.nextInt();
                    materiaDAO.insertarMateria(a, mat, h);
                    break;

                case 2:
                    System.out.println("Ingrese la materia a cambiar:");
                    mat = sc.nextLine();
                    materiaDAO.eliminarMateria(a, mat);

                    System.out.println("Ingrese la nueva materia:");
                    mat = sc.nextLine();
                    System.out.println("Ingrese el número de horas a cursar:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Ingrese un número válido de horas:");
                        sc.next();
                    }
                    h = sc.nextInt();
                    materiaDAO.insertarMateria(a, mat, h);
                    break;

                case 3:
                    System.out.println("Ingrese la materia a eliminar:");
                    mat = sc.nextLine();
                    materiaDAO.eliminarMateria(a, mat);
                    break;

                case 4:
                    System.out.println("Materias del estudiante:");
                    List<Materia> materias = materiaDAO.obtenerMateriasPorAlumno(a);
                    for (Materia m : materias) {
                        System.out.println("ID alumno: "+m.getId() + "Alumno: " + m.getAlumno() + "Materia: " + m.getMateria() + ", Horas: " + m.getNumeroHoras());
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, ingrese un número del 1 al 5.");
            }
        } while (op != 5);
    }

    void porCurso(int a) {
        MateriaDAO materiaDAO = new MateriaDAO();
        int op = 0;
        String mat;
        int h;

        do {
            System.out.println("--Materia por curso--");
            System.out.println("1. Ingresar");
            System.out.println("2. Cambiar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Salir");
            while (!sc.hasNextInt()) {
                System.out.println("Ingresar una opción del 1 al 5");
                sc.next();
            }
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Ingrese la nueva materia:");
                    mat = sc.nextLine();

                    System.out.println("Ingrese el número de horas a cursar:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Ingrese un número válido de horas:");
                        sc.next();
                    }
                    h = sc.nextInt();
                    // Aquí se necesita un método para insertar materias por curso en lugar de por alumno.
                    materiaDAO.insertarMateriaPorCurso(a, mat, h);
                    break;

                case 2:
                    System.out.println("Ingrese la materia a cambiar:");
                    mat = sc.nextLine();
                    materiaDAO.eliminarMateriaPorCurso(a, mat);

                    System.out.println("Ingrese la nueva materia:");
                    mat = sc.nextLine();
                    System.out.println("Ingrese el número de horas a cursar:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Ingrese un número válido de horas:");
                        sc.next();
                    }
                    h = sc.nextInt();
                    materiaDAO.insertarMateriaPorCurso(a, mat, h);
                    break;

                case 3:
                    System.out.println("Ingrese la materia a eliminar:");
                    mat = sc.nextLine();
                    materiaDAO.eliminarMateriaPorCurso(a, mat);
                    break;

                case 4:
                    System.out.println("Materias del curso:");
                    List<Materia> materias = materiaDAO.obtenerMateriasPorCurso(a);
                    for (Materia m : materias) {
                        System.out.println("Curso: " +  m.getId() + "Materia: " + m.getMateria() + ", Horas: " + m.getNumeroHoras());
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, ingrese un número del 1 al 5.");
            }
        } while (op != 5);
    }
}
