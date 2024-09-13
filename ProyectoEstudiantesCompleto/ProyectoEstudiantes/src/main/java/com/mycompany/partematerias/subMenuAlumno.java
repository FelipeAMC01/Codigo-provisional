/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.partematerias;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author FelixDDP
 */

public class subMenuAlumno {
    
    public void subMenuAlumno(){
        Scanner consola = new Scanner(System.in);
        var salir = false;
        var alumnoDAO = new AlumnoDAO();

        // MUESTRA MENU
        while (!salir){
            try{
                muestramenu();
                salir = ejecutarOpciones(consola, alumnoDAO);
            }
            catch (Exception e){
                System.out.println();
                System.out.println("Error en ejecución: " + e.getMessage());
                System.out.println();
            }
        }
    }

    private static void muestramenu(){
        System.out.println();
        System.out.println("""
                ***** SISTEMA DE ALUMNOS *****
                1. Listar
                2. Buscar alumno por Id_Alumno
                3. Buscar alumno por cedula           
                4. Agregar 
                5. Actualizar 
                6. Eliminar por Id_Alumno
                7. Eliminar alumno por cedula
                8. Salir
                """);
        System.out.print("Por favor, ingrese una opción: ");
        System.out.println();
    }

    private static boolean ejecutarOpciones(Scanner consola, AlumnoDAO alumnoDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        System.out.println();
        boolean salir = false;

        switch (opcion){
            case 1 -> { // Listar alumnos
                System.out.println();
                System.out.println(".:: Lista de alumnos ::.");
                var alumnos = alumnoDAO.listarAlumnos();
                alumnos.forEach(System.out::println);
            }
            case 2 -> { // Buscar por ID
                System.out.println("Ingrese ID de alumno a buscar: ");
                var idAlumno = Integer.parseInt(consola.nextLine());
                var alumno = new Alumno(idAlumno);
                var existeAlumno = alumnoDAO.findById(alumno);
                if(existeAlumno)
                    System.out.println("Alumno encontrado: " + alumno);
                else
                    System.out.println("No se encontró alumno con ID: " + alumno.getId_Alumno());
            }
            case 3 -> { // Buscar por cédula
                System.out.println("Ingrese cédula de alumno a buscar: ");
                var cedula = consola.nextLine();
                var alumno = new Alumno(cedula);
                var existeAlumno = alumnoDAO.findByCedula(alumno);
                if(existeAlumno)
                    System.out.println("Alumno encontrado: " + alumno);
                else
                    System.out.println("No se encontró alumno con cédula: " + alumno.getCedula());
            }
            case 4 -> { // Agregar alumno
                Scanner scanner = new Scanner(System.in);
                String nombre1 = null;
                String apellido1 = null;
                String cedula1 = null;
                String contacto1 = null;
                int curso1 = 0;

                System.out.println(".:: Agregar Alumno ::.");

                // Validar nombre
                do {                  
                    System.out.print("Nombre: ");
                    nombre1 = scanner.nextLine();
                    Pattern pattern = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");
                    Matcher matcher = pattern.matcher(nombre1);
                    if (matcher.matches()) {
                        break;
                    } else {
                        System.out.println("El nombre no es válido");
                    }
                } while (true);

                // Validar apellido
                do {                  
                    System.out.print("Apellido: ");
                    apellido1 = scanner.nextLine();
                    Pattern pattern = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");
                    Matcher matcher = pattern.matcher(apellido1);
                    if (matcher.matches()) {
                        break;
                    } else {
                        System.out.println("El apellido no es válido");
                    }
                } while (true);

                // Validar cédula
                do {
                    System.out.print("Cédula: ");
                    cedula1 = scanner.nextLine();
                    if (validarCedula(cedula1)) {
                        break;
                    } else {
                        System.out.println("La cédula no es válida");
                    }
                } while (true);

                // Validar curso
                do {                  
                    System.out.print("Curso (1-3): ");
                    if (scanner.hasNextInt()) {
                        curso1 = scanner.nextInt();
                        if (curso1 >= 1 && curso1 <= 3) {
                            break;
                        } else {
                            System.out.println("El curso debe estar entre 1 y 3.");
                        }
                    } else {
                        System.out.println("El curso no es válido. Introduzca un número entero entre 1 y 3.");
                        scanner.next(); // Limpiar la entrada inválida
                    }
                } while (true);

                // Validar contacto
                do {                  
                    System.out.print("Contacto: ");
                    contacto1 = scanner.next();
                    Pattern pattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
                    Matcher matcher = pattern.matcher(contacto1);
                    if (matcher.matches()) {
                        break;
                    } else {
                        System.out.println("El contacto no es válido");
                    }
                } while (true);

                var nuevoAlumno = new Alumno(nombre1, apellido1, cedula1, curso1, contacto1);
                var agregaalumno = alumnoDAO.agregarAlumno(nuevoAlumno);

                if(agregaalumno)
                    System.out.println("Alumno agregado exitosamente: " + nuevoAlumno);
                else
                    System.out.println("No se pudo agregar alumno: " + nuevoAlumno);
            }
            case 5 -> { // Actualizar alumno
                System.out.println(".:: Actualizar Alumno ::.");
                System.out.print("Ingrese ID de alumno a actualizar: ");
                var idAlumno = Integer.parseInt(consola.nextLine());

                Scanner scanner = new Scanner(System.in);
                String nombre1, apellido1, cedula1, contacto1;
                int curso1;

                // Validar y actualizar nombre, apellido, cedula, curso y contacto
                System.out.println("Actualice los siguientes datos:");

                do {                  
                    System.out.print("Nombre: ");
                    nombre1 = scanner.nextLine();
                    Pattern pattern = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");
                    Matcher matcher = pattern.matcher(nombre1);
                    if (matcher.matches()) {
                        break;
                    } else {
                        System.out.println("El nombre no es válido");
                    }
                } while (true);

                do {                  
                    System.out.print("Apellido: ");
                    apellido1 = scanner.nextLine();
                    Pattern pattern = Pattern.compile("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");
                    Matcher matcher = pattern.matcher(apellido1);
                    if (matcher.matches()) {
                        break;
                    } else {
                        System.out.println("El apellido no es válido");
                    }
                } while (true);

                do {                  
                    System.out.print("Cédula: ");
                    cedula1 = scanner.nextLine();
                    if (validarCedula(cedula1)) {
                        break;
                    } else {
                        System.out.println("La cédula no es válida");
                    }
                } while (true);

                do {                  
                    System.out.print("Curso (1-3): ");
                    if (scanner.hasNextInt()) {
                        curso1 = scanner.nextInt();
                        if (curso1 >= 1 && curso1 <= 3) {
                            break;
                        } else {
                            System.out.println("El curso debe estar entre 1 y 3.");
                        }
                    } else {
                        System.out.println("El curso no es válido. Introduzca un número entero entre 1 y 3.");
                        scanner.next(); // Limpiar la entrada inválida
                    }
                } while (true);

                do {                  
                    System.out.print("Contacto: ");
                    contacto1 = scanner.next();
                    Pattern pattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
                    Matcher matcher = pattern.matcher(contacto1);
                    if (matcher.matches()) {
                        break;
                    } else {
                        System.out.println("El contacto no es válido");
                    }
                } while (true);

                var editaAlumno = new Alumno(idAlumno, nombre1, apellido1, cedula1, curso1, contacto1);
                var actualizado = alumnoDAO.actualizarAlumno(editaAlumno);

                if(actualizado)
                    System.out.println("Alumno actualizado exitosamente: " + editaAlumno);
                else
                    System.out.println("No se pudo actualizar alumno: " + editaAlumno);
            }
            case 6 -> { // Eliminar alumno por ID
    System.out.println(".:: Eliminar Alumno ::.");
    System.out.print("Ingrese ID de alumno a eliminar: ");
    var idAlumno = Integer.parseInt(consola.nextLine());
    boolean eliminado = alumnoDAO.eliminarAlumnoPorId(idAlumno);
    if (eliminado)
        System.out.println("Alumno eliminado exitosamente con ID: " + idAlumno);
    else
        System.out.println("No se pudo eliminar alumno con ID: " + idAlumno);
}
case 7 -> { // Eliminar alumno por cédula
    System.out.println(".:: Eliminar Alumno ::.");
    System.out.print("Ingrese cédula de alumno a eliminar: ");
    var cedula = consola.nextLine();
    boolean eliminado = alumnoDAO.eliminarAlumnoPorCedula(cedula);
    if (eliminado)
        System.out.println("Alumno eliminado exitosamente con cédula: " + cedula);
    else
        System.out.println("No se pudo eliminar alumno con cédula: " + cedula);
}
            case 8 -> {
                System.out.println("Saliendo del sistema...");
                salir = true;
            }
            default -> System.out.println("Opción no válida.");
        }

        return salir;
    }

    private static boolean validarCedula(String cedula){
        // Lógica simplificada para validar cédula
        if(cedula.length() != 10) return false;
        try {
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito >= 6) return false;
            int[] coefValCedula = {2,1,2,1,2,1,2,1,2};
            int verificador = Integer.parseInt(cedula.substring(9,10));
            int suma = 0;
            int digito = 0;
            for(int i = 0; i < (cedula.length() - 1); i++){
                digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                suma += ((digito % 10) + (digito / 10));
            }
            if ((suma % 10 == 0) && (suma % 10 == verificador)) return true;
            if ((10 - (suma % 10)) == verificador) return true;
            return false;
        } catch (NumberFormatException nfe) {
            return false;
        } catch (Exception err) {
            return false;
        }
    }
}