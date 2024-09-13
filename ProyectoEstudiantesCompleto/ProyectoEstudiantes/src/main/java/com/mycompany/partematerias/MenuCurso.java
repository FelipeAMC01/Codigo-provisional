/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.partematerias;

import java.util.Scanner;

/**
 *
 * @author FelixDDP
 */
public class MenuCurso {
    Scanner sc = new Scanner(System.in);
    
    public void MenuCurso() {
        submenus sm = new submenus();
        int a = 0;

        while (a != 3) {
            System.out.println("----Menu de Materias----");
            System.out.println("1. Modificar por ID de Alumno");
            System.out.println("2. Modificar por curso");
            System.out.println("3. Salir");
            while (!sc.hasNextInt()) {
                System.out.println("Ingresar un número del 1 al 3");
                sc.next();
            }
            a = sc.nextInt();

            if (a < 1 || a > 3) {
                System.out.println("Ingrese una opcion del 1 al 3");
            } else if (a == 1 || a == 2) {
                sm.submenus(a);
            }
        }
    }
}
