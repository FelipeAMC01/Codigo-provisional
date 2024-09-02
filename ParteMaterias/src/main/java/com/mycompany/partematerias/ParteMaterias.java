/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.partematerias;

import java.util.Scanner;

/**
 *
 * @author FelixDDP
 */
public class ParteMaterias {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        MenuCurso menu = new MenuCurso();
        //subMenuAlum subMA = new subMenuAlum();

        int op = 0;
        do {
            System.out.println("-----Registro Colegio-----");
            System.out.println("1. Alumnos");
            System.out.println("2. Materias");
            System.out.println("3. Salir");
            op = sc.nextInt();

            if (op == 1) {
                //subMA.subMenuAlum();
            } else if (op == 2) {
                menu.MenuCurso();
            }
        } while (op != 3);
    }
}
