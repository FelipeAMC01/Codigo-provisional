/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package iti.proyectocolegio;
import iti.proyectocolegio.AlumnoDAO;
import iti.proyectocolegio.Alumno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RTB1
 */
public class ProyectoColegio {

    public static void main(String[] args) {
         Scanner consola = new Scanner(System.in);
        var salir = false;
        var alumnoDAO = new AlumnoDAO();

        // MOSTRAR MENU
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
                ***** PROYECTO PARA ALUMNOS *****
                1. Listar
                2. Buscar
                3. Agregar
                4. Actualizar
                5. Eliminar
                6. Salir
                """);
        System.out.print("Por favor, ingrese una opción: ");
        System.out.println();
    }

    private static boolean ejecutarOpciones(Scanner consola, AlumnoDAO alumnoDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        System.out.println();
        boolean salir = false;
        // Validar opciones ingresadas
        switch (opcion){
            case 1 -> { // Listar Alumno
                System.out.println();
                System.out.println(".:: Lista de Alumnos ::.");
                var alumno = alumnoDAO.listarAlumno();
                alumno.forEach(System.out::println);
            }
            case 2 -> { // Buscar por ID
                System.out.println("Ingrese ID de Alumno a buscar: ");
                var id_Alumno = Integer.parseInt(consola.nextLine());
                var alumno = new Alumno(id_Alumno);
                var existeAlumno = AlumnoDAO.findBy(alumno);
                if(existeAlumno)
                    System.out.println("Alumno encontrado: " + alumno);
                else
                    System.out.println("No se encontro Alumno con ID : " + Alumno.getId_Alumno());
            }
            case 3 -> { // Agregar Alumno
                System.out.println(".:: Agregar Alumno ::.");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Cedula: ");
                var cedula = consola.nextLine();
                System.out.print("Curso: ");
                var curso = consola.nextLine();
                System.out.print("Contacto: ");
                var contacto = consola.nextLine();

                var nuevoAlumno = new Alumno( nombre, apellido,cedula,curso, contacto);
                var agregaAlumno = AlumnoDAO.agregarAlumno(nuevoAlumno);

                if(agregaAlumno)
                    System.out.println("Alumno agregado exitosamente: " + nuevoAlumno);
                else
                    System.out.println("No se pudo agregar Alumno : " + nuevoAlumno);

            }

            case 4 -> { // Actualizar Alumno
                System.out.println(".:: Actualizar Alumno ::.");
                System.out.println("Ingrese ID de Alumno a actualizar: ");
                var id_Alumno = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Cedula: ");
                var cedula = consola.nextLine();
                System.out.print("Curso: ");
                var curso = consola.nextLine();
                System.out.print("Contacto: ");
                var contacto = consola.nextLine();

                var editaAlumno = new Alumno(id_Alumno,  nombre, apellido, cedula,curso, contacto);
                var actualizado = AlumnoDAO.actualizarAlumno(editaAlumno);
                if(actualizado)
                    System.out.println("Alumno actualizado exitosamente: " + editaAlumno);
                else
                    System.out.println("No se pudo actualizar estudiante : " + editaAlumno);
            }
            case 5 -> { // Eliminar Alumno
                System.out.println(".:: Eliminar Alumno ::.");
                System.out.println("Ingrese ID de Alumno a eliminar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var eliminaAlumno = new Alumno(id_Alumno);
                var eliminado = AlumnoDAO.eliminarAlumno(eliminaAlumno);
                if(eliminado)
                    System.out.println("Alumno eliminado exitosamente: " + eliminaAlumno);
                else
                    System.out.println("No se pudo eliminar Alumno : " + eliminaAlumno);
            }
            case 6 -> { // Salir de la app
                System.out.println("Gracias, hasta pronto!!!");
                salir = true;
            }
            default -> System.out.println("Opcion ingresada no existe, por favor ingrese nuevamente.");
        }
        return salir;
    }

     
        
    }
