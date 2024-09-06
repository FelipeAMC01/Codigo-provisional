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
        // Validar opciones ingresadas
        switch (opcion){
            case 1 -> { // Listar alumno
                System.out.println();
                System.out.println(".:: Lista de alumno ::.");
                var alumnos = alumnoDAO.listarAlumnos();
                alumnos.forEach(System.out::println);
            }
            case 2 -> { // Buscar por ID
                System.out.println("Ingrese ID de alumno a buscar: ");
                var Id_Alumno = Integer.parseInt(consola.nextLine());
                var alumno = new Alumno(Id_Alumno);
                var existeAlumno = alumnoDAO.findById(alumno);
                if(existeAlumno)
                    System.out.println("Alumno encontrado: " + alumno);
                else
                    System.out.println("No se encontro alumno con ID : " + alumno.getId_Alumno());
            }
            case 3 -> { // Buscar por cedula
                System.out.println("Ingrese cedula de alumno a buscar: ");
                var cedula = consola.nextLine();
                var alumno = new Alumno(cedula);
                var existeAlumno = alumnoDAO.findByCedula(alumno);
                if(existeAlumno)
                    System.out.println("Alumno encontrado: " + alumno);
                else
                    System.out.println("No se encontro alumno con ID : " + alumno.getCedula());
            }
            
            
            case 4 -> { // Agregar alumno
                Scanner scanner =new Scanner(System.in);
                String nombre1=null;
                String apellido1=null;
                String cedula1=null;
                String contacto1=null;
                int curso1=0;
                System.out.println(".:: Agregar Alumno ::.");
                // validacion prueba
                int sw =0;
                do{                  
                    System.out.print("Nombre: ");
                    nombre1 =scanner.nextLine();
                    //var nombre1 = consola.nextLine();
                    Pattern pattern = Pattern.compile ("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");  // PARA CARACTERES A-Z  a-z
                    Matcher matcher = pattern.matcher(nombre1);
                    if (matcher.matches())
                    {
                        var nombre = nombre1;
                        sw=1;
                    }
                    else
                    {
                        System.out.println("El nombre no es valido");  
                    }
                }while(sw!=1);
                //fin validacion nombre
                
                //validar apellido
                int sw1 =0;
                do{                  
                    System.out.print("Apellido: ");
                    apellido1 =scanner.nextLine();
                    Pattern pattern = Pattern.compile ("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");  // PARA CARACTERES A-Z  a-z
                    Matcher matcher = pattern.matcher(apellido1);
                    if (matcher.matches())
                    {
                        var apellido = apellido1;
                        sw1=1;
                    }
                    else
                    {
                        System.out.println("El apellido no es valido");  
                    }
                }while(sw1!=1);
                
                //Fin valida apellido
                
                //Valida cedula
                
                int sw4=0;
                do
                {
                    int numero=0,suma=0,resultado=0, num=0;  
                    sw=0;
                    System.out.println("Ingrese la cedula del alumno");
                    cedula1=scanner.nextLine();
                    num=cedula1.length();
                    System.out.println("longitud:  "+num);
                    Pattern pattern = Pattern.compile ("^[0-9]+$");  //SOLO CARACTERES NUMEROS 
                    Matcher matcher = pattern.matcher(cedula1);
                    if (matcher.matches()&& num==10)
                    {
                        for (int i=0; i< cedula1.length();i++) 
                        {
                            numero=Integer.parseInt(String.valueOf(cedula1.charAt(i)));
                            if (i%2==0)
                            {
                                numero=numero*2;
                                if (numero>9) 
                                {
                                    numero=numero-9;
                                }
                            }
                        suma=suma+numero;
                        } 
                        if (suma%10 !=0)
                        {
                            resultado=10-(suma%10);
                            if (resultado == numero)
                            {
                                System.out.println("Su cedula  "+cedula1+"  es ecuatoriana ");
                                sw=1;
                            }
                            else 
                            {
                                System.out.println("Su cedula  "+cedula1+" no es ecuatoriana ");       
                            }
                        }
                        else
                        {
                            System.out.println("Su cedula  "+cedula1+"  es ecuatoriana ");
                            sw4=1;
                        }
                    }
              
                }while(sw4!=1); 
          
                //Fin valida cedula
                                
                //Valida Curso
               
                int sw3 =0;
                do{                  
                    System.out.print("Curso: ");
                    curso1 =scanner.nextInt();
                    Pattern pattern = Pattern.compile ("^[0-9]+$");  // Solo caracteres numeros
                
                    if (scanner.hasNextInt()) {
                        curso1 = scanner.nextInt();
                        sw3 = 1;  // Entrada válida, salir del bucle
                    } else {
                        System.out.println("El curso no es válido");
                        scanner.next();  // Limpia la entrada inválida
                    }
                }while(sw3!=1);
                               
                //fin valida curso
                
                //valida Contacto
                int sw2 =0;
                do{                  
                    System.out.print("Contacto: ");
                    contacto1 =scanner.nextLine();
                    Pattern pattern = Pattern.compile ("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");  // PARA CARACTERES A-Z  a-z
                    Matcher matcher = pattern.matcher(contacto1);
                    if (matcher.matches())
                    {
                        var contacto = contacto1;
                        sw2=1;
                    }
                    else
                    {
                        System.out.println("El contacto no es valido");  
                    }
                }while(sw2!=1);
                //fin valida contacto
                
                var nuevoAlumno = new Alumno(nombre1, apellido1,cedula1, curso1, contacto1);
                var agregaalumno = alumnoDAO.agregarAlumno(nuevoAlumno);

                if(agregaalumno)
                    System.out.println("Alumno agregado exitosamente: " + nuevoAlumno);
                else
                    System.out.println("No se pudo agregar alumno : " + nuevoAlumno);

            }

            case 5 -> { // Actualizar alumno
                System.out.println(".:: Actualizar Alumno ::.");
                System.out.println("Ingrese ID de alumno a actualizar: ");
                var idalumno = Integer.parseInt(consola.nextLine());
                
                Scanner scanner =new Scanner(System.in);
                String nombre1=null;
                String apellido1=null;
                String cedula1=null;
                String contacto1=null;
                int curso1=0;
                System.out.println(".:: Actualizar Alumno ::.");
                // validacion prueba
                int sw =0;
                do{                  
                    System.out.print("Nombre: ");
                    nombre1 =scanner.nextLine();
                    //var nombre1 = consola.nextLine();
                    Pattern pattern = Pattern.compile ("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");  // PARA CARACTERES A-Z  a-z
                    Matcher matcher = pattern.matcher(nombre1);
                    if (matcher.matches())
                    {
                        var nombre = nombre1;
                        sw=1;
                    }
                    else
                    {
                        System.out.println("El nombre no es valido");  
                    }
                }while(sw!=1);
                //fin validacion nombre
                
                //validar apellido
                int sw1 =0;
                do{                  
                    System.out.print("Apellido: ");
                    apellido1 =scanner.nextLine();
                    Pattern pattern = Pattern.compile ("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");  // PARA CARACTERES A-Z  a-z
                    Matcher matcher = pattern.matcher(apellido1);
                    if (matcher.matches())
                    {
                        var apellido = apellido1;
                        sw1=1;
                    }
                    else
                    {
                        System.out.println("El apellido no es valido");  
                    }
                }while(sw1!=1);
                
                //Fin valida apellido
                
                //Valida cedula
                
                int sw4=0;
                do
                {
                    int numero=0,suma=0,resultado=0, num=0;  
                    sw=0;
                    System.out.println("Ingrese la cedula del alumno");
                    cedula1=scanner.nextLine();
                    num=cedula1.length();
                    System.out.println("longitud:  "+num);
                    Pattern pattern = Pattern.compile ("^[0-9]+$");  //SOLO CARACTERES NUMEROS 
                    Matcher matcher = pattern.matcher(cedula1);
                    if (matcher.matches()&& num==10)
                    {
                        for (int i=0; i< cedula1.length();i++) 
                        {
                            numero=Integer.parseInt(String.valueOf(cedula1.charAt(i)));
                            if (i%2==0)
                            {
                                numero=numero*2;
                                if (numero>9) 
                                {
                                    numero=numero-9;
                                }
                            }
                            suma=suma+numero;
                        } 
                        if (suma%10 !=0)
                        {
                            resultado=10-(suma%10);
                            if (resultado == numero)
                            {
                                System.out.println("Su cedula  "+cedula1+"  es ecuatoriana ");
                                sw=1;
                            }
                            else 
                            {
                                System.out.println("Su cedula  "+cedula1+" no es ecuatoriana ");       
                            }
                        }
                        else
                        {
                            System.out.println("Su cedula  "+cedula1+"  es ecuatoriana ");
                            sw4=1;
                        }
                    }
              
                }while(sw4!=1); 
          
                //Fin valida cedula
                                
                //Valida Curso
               
                int sw3 =0;
                do{                  
                    System.out.print("Curso: ");
                    curso1 =scanner.nextInt();
                    Pattern pattern = Pattern.compile ("^[0-9]+$");  // Solo caracteres numeros
                    if (scanner.hasNextInt()) {
                        curso1 = scanner.nextInt();
                        sw3 = 1;  // Entrada válida, salir del bucle
                    } else {
                        System.out.println("El curso no es válido");
                        scanner.next();  // Limpia la entrada inválida
                    }
                }while(sw3!=1);
                               
                //fin valida curso
                
                //valida Contacto
                int sw2 =0;
                do{                  
                    System.out.print("Contacto: ");
                    contacto1 =scanner.nextLine();
                    Pattern pattern = Pattern.compile ("^[A-Za-zÀ-ÖØ-öø-ÿ'‘’“”„“”\\s-]+$");  // PARA CARACTERES A-Z  a-z
                    Matcher matcher = pattern.matcher(contacto1);
                    if (matcher.matches())
                    {
                        var contacto = contacto1;
                        sw2=1;
                    }
                    else
                    {
                        System.out.println("El contacto no es valido");  
                    }
                }while(sw2!=1);
                //fin valida contacto
            
                var editaAlumno = new Alumno(idalumno, nombre1, apellido1, cedula1,curso1, contacto1);
                var actualizado = alumnoDAO.actualizarAlumno(editaAlumno);
                if(actualizado)
                    System.out.println("Alumno actualizado exitosamente: " + editaAlumno);
                else
                    System.out.println("No se pudo actualizar alumno : " + editaAlumno);
            }
            case 6 -> { // Eliminar alumno
                System.out.println(".:: Eliminar alumno ::.");
                System.out.println("Ingrese ID de alumno a eliminar: ");
                var idAlumno = Integer.parseInt(consola.nextLine());
                var eliminaAlumno = new Alumno(idAlumno);
                var eliminado = alumnoDAO.eliminarAlumno(eliminaAlumno);
                if(eliminado)
                    System.out.println("Alumno eliminado exitosamente: " + eliminaAlumno);
                else
                    System.out.println("No se pudo eliminar alumno : " + eliminaAlumno);
            }
            
            
            case 7 -> { // Eliminar alumno por cedula
                System.out.println(".:: Eliminar alumno por cedula ::.");
                System.out.println("Ingrese cedula del alumno a eliminar: ");
                
                System.out.print("Cedula: ");
                var cedula = consola.nextLine();
                var eliminaAlumno = new Alumno(cedula);
                var eliminado = alumnoDAO.eliminarAlumnoCedula(eliminaAlumno);
                if(eliminado)
                    System.out.println("Alumno eliminado exitosamente: " + eliminaAlumno);
                else
                    System.out.println("No se pudo eliminar alumno : " + eliminaAlumno);
            }
                        
            case 8 -> { // Salir de la app
                System.out.println("Gracias, hasta pronto!!!");
                salir = true;
            }
            default -> System.out.println("Opcion ingresada no existe, por favor ingrese nuevamente.");
        }
        return salir; 
    }   
}
