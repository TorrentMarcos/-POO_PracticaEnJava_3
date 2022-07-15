/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */

public class PruebaABM {
    
    public static void main(String[] args) {
        
        // ------- DECLARACIÓN INICIAL DE VARIABLES
        
        Scanner lecturaNumeros = new Scanner(System.in);

        ArrayList <Integer> enteros = new ArrayList<Integer>();
        ArrayList <Alumno> alumnos = new ArrayList<Alumno>();
        
        boolean menuPrincipal = true;
        boolean menuEnteros = false;
        boolean menuAlumnos = false;
        int opcionMenu = -1;
        int opcionSubMenu = -1;
        
        // ---------------------------------------
        
        while (menuPrincipal == true) { // MENÚ PRINCIPAL
            
            System.out.println("*** MENÚ PRINCIPAL ***");
            System.out.println("\tIngrese la opción que desea ejecutar");
            System.out.println("\t1 - TRABAJAR CON NÚMEROS ENTEROS (ABM / CRUD)");
            System.out.println("\t2 - TRABAJAR CON ALUMNOS (ABM / CRUD)");
            System.out.println("\n\t0 - SALIR");
            
            opcionMenu = lecturaNumeros.nextInt();
            
            if (opcionMenu == 1){       
            
                menuEnteros = true;
                
                while (menuEnteros == true){ // SUB-MENÚ NÚMEROS ENTEROS
                    
                    System.out.println(" *** SUB-MENÚ DE NÚMEROS ENTEROS (ABM / CRUD) *** ");
                    System.out.println("\tIngrese la opción que desea ejecutar");
                    System.out.println("\t 1 - ALTA");
                    System.out.println("\t 2 - BAJA");
                    System.out.println("\t 3 - MODIFICACIÓN");
                    System.out.println("\t 4 - BÚSQUEDA");
                    System.out.println("\t 5 - IMPRESIÓN (LISTA ENTERA)");
                    System.out.println("\n\t 0 - Volver al Menú Principal");
                    
                    opcionSubMenu = lecturaNumeros.nextInt();
                    
                    switch (opcionSubMenu){
                        
                    // TRABAJO CON MÉTODOS PARA QUE QUEDE MÁS "PROLIJO" EL MAIN
                        
                        case 0: 
                            menuEnteros = false; // "CORTO" EL SUB-MENÚ.
                        break;
                        
                        case 1: // ALTA
                            altaEntero(enteros); 
                        break;
                        
                        case 2: // BAJA
                            bajaEntero(enteros);
                        break;
                        
                        case 3: // MODIFICACIÓN
                            modificacionEntero(enteros);
                        break;
                        
                        case 4: // BÚSQUEDA
                            busquedaEntero(enteros);
                        break;
                        
                        case 5: // IMPRESIÓN
                            impresionEnteros(enteros);
                        break;
                       
                        default:
                            System.out.println("Opción inválida");
  
                    } // CIERRA SWITCH (OPCIÓN SUB-MENÚ)

                } // CIERRA WHILE (SUB-MENÚ ENTEROS)
                
            } // CIERRA IF (OPCIÓN MENÚ)
            
            else if (opcionMenu == 2){ // SUB-MENÚ ALUMNOS
                
                menuAlumnos = true;
                
                while (menuAlumnos == true){
                    
                    System.out.println(" *** SUB-MENÚ DE ALUMNOS (ABM / CRUD) *** ");
                    System.out.println("\tIngrese la opción que desea ejecutar");
                    System.out.println("\t 1 - ALTA");
                    System.out.println("\t 2 - BAJA");
                    System.out.println("\t 3 - MODIFICACIÓN");
                    System.out.println("\t 4 - BÚSQUEDA");
                    System.out.println("\t 5 - IMPRESIÓN (LISTA ENTERA)");
                    System.out.println("\n\t 0 - Volver al Menú Principal");
                    
                    opcionSubMenu = lecturaNumeros.nextInt();
                    
                    switch (opcionSubMenu){
                        
                    // NUEVAMENTE, TRABAJO TODO CON MÉTODOS.
                        
                        case 0: 
                            menuAlumnos = false; // "CORTO" EL SUB-MENÚ.
                        break;
                        
                        case 1: // ALTA
                            altaAlumno(alumnos); 
                        break;
                        
                        case 2: // BAJA
                            bajaAlumno(alumnos);
                        break;
                        
                        case 3: // MODIFICACIÓN
                            modificacionAlumno(alumnos);
                        break;
                        
                        case 4: // BÚSQUEDA
                            busquedaAlumno(alumnos);
                        break;
                        
                        case 5: // IMPRESIÓN
                            impresionAlumnos(alumnos);
                        break;
                       
                        default:
                            System.out.println("Opción inválida"); 
                            
                    } // CIERRA SWITCH (OPCIÓN SUB-MENÚ)

                } // CIERRA WHILE (SUB-MENÚ ALUMNOS)
                
            } // CIERRA ELSE IF (OPCIÓN MENÚ)
            
            else {
                
                if (opcionMenu == 0){
                    menuPrincipal = false; // CORTO EL MENÚ PRINCIPAL
                }
                else {
                    System.out.println("Opción inválida");
                }
                
            } // CIERRA ELSE (OPCIÓN MENÚ)
            
        } // CIERRA WHILE (MENÚ PRINCIPAL)
        
    } // CIERRA MAIN
    
    ///////////////////// ALTAS /////////////////////
    
    // ENTEROS
    public static void altaEntero (ArrayList <Integer> enteros){ 
        
        int numeroAux = 0;
        Scanner lecturaNumeros = new Scanner(System.in);

        System.out.println("Ingrese nuevo número entero");
        numeroAux = lecturaNumeros.nextInt();
        
        enteros.add(numeroAux);

    }
    
    // ALUMNOS
    public static void altaAlumno (ArrayList <Alumno> alumnos){
        
        Scanner lecturaNumeros = new Scanner(System.in);
        Scanner lecturaLetras = new Scanner (System.in);
        
        // PIDO LOS DATOS DEL ALUMNO/A
        System.out.println("Ingrese LEGAJO del alumno/a");
        int legajoAux = lecturaNumeros.nextInt();         // "AHORRANDO" LÍNEAS.
        System.out.println("Ingrese NOMBRE del alumno/a");
        String nombreAux = lecturaLetras.nextLine();                    // ÍDEM.
        System.out.println("Ingrese APELLIDO del alumno/a");
        String apellidoAux = lecturaLetras.nextLine();                  // ÍDEM.
        System.out.println("Ingrese TELÉFONO del alumno/a");
        String telefonoAux = lecturaLetras.nextLine();                  // ÍDEM.
        System.out.println("Ingrese EMAIL del alumno/a");
        String emailAux = lecturaLetras.nextLine();                     // ÍDEM.
        
        // CREO UN ALUMNO CON LOS DATOS OBTENIDOS Y, POSTERIORMENTE, LO AGREGO.
        Alumno alumnoAux = new Alumno(legajoAux, nombreAux, apellidoAux, telefonoAux, emailAux);
        alumnos.add(alumnoAux);
        
    }
    
    ///////////////////// BAJAS /////////////////////
    
    // ENTEROS
    public static void bajaEntero (ArrayList <Integer> enteros){
        
        int numeroAux = 0;
        int numeroIterator = 0;
        Scanner lecturaNumeros = new Scanner(System.in);
        
        /* Creo un ITERATOR que me sirva para recorrer una colección de
        enteros "<Integer>" y le asocio una copia de mi propia lista.
        Sobre esta copia, igualmente, voy a poder trabajar sobre la lista real.
        La utilidad está en que, al tener una "copia", evito recorrer + operar
        sobre una misma colección simultáneamente. Diversifico operaciones */
        
        Iterator<Integer> itEnteros = enteros.iterator();

        System.out.println("Ingrese el número entero que desea eliminar");
        numeroAux = lecturaNumeros.nextInt();
                            
        while (itEnteros.hasNext()){ // Mientras haya algo que recorrer...
                                
            // Rescato el siguiente elemento de la iteración.
            numeroIterator = itEnteros.next();
            
            // ¿Dicho elemento es igual al que yo estaba buscando?
            if (numeroIterator == numeroAux){
                itEnteros.remove();       // Sí. Lo borro.
            }
            
            /* Dado que no estamos "cortando" la iteración en el momento 
            preciso donde se encuentra al primer número idéntico, el 'while'
            va a recorrer toda la colección borrando todos y cada uno de
            los números iguales al que yo dije que quería eliminar */   
        }
    }
    
    // ALUMNOS
    public static void bajaAlumno (ArrayList <Alumno> alumnos){
        
        /* Vamos a buscar por número de LEGAJO dado que éste
        sería, y lo es de hecho, una perfecta clave primaria */
        
        int legajoAux = 0;
        Scanner lecturaNumeros = new Scanner(System.in);
        Iterator <Alumno> itAlumnos = alumnos.iterator();
               
        System.out.println("Ingrese el LEGAJO del alumno/a que desea eliminar");
        legajoAux = lecturaNumeros.nextInt();
        
        while (itAlumnos.hasNext()){
            
            Alumno alumnoAux = itAlumnos.next();
            if (alumnoAux.getLegajo() == legajoAux){
                itAlumnos.remove();
                
                /* Nótese que remove() siempre elimina el elemento
                que devolvería next(). Por lo tanto, tenemos certeza
                de que estamos borrando el alumno que, efectivamente,
                deseamos eliminar */
                
            }
        }
    }
    
    ///////////////////// MODIFICACIONES /////////////////////
    
    // ENTEROS
    public static void modificacionEntero(ArrayList <Integer> enteros){
        
        Scanner lecturaNumeros = new Scanner(System.in);
        int numeroAux = 0;
        int numeroIterator = 0;
        int numeroModificar = 0;
        int i = 0;
        Iterator<Integer> itEnteros = enteros.iterator();
        
        // NÚMERO QUE SE VA A CAMBIAR (OSEA, EL "VIEJO" VALOR).       
        System.out.println("Ingrese el número entero que desea modificar");
        numeroAux = lecturaNumeros.nextInt();
                            
        // NUEVO VALOR.
        System.out.println("Ingrese el nuevo valor que reemplazará a ese número");
        numeroModificar = lecturaNumeros.nextInt();
                            
        while (itEnteros.hasNext()){
                                
            numeroIterator = itEnteros.next();
            if (numeroIterator == numeroAux){
                enteros.set(i, numeroModificar);
                
                /* Como la modificación mediante set() nos pide la posición
                del elemento a modificar (el cual, en este caso, será igual
                al n° de iteración), podemos conocer ésta tan sólo con agregar
                una variable entera auto-incremental por cada ciclo efectuado */
            }
                                
            i++;
        }
    }
    
    // ALUMNOS
    public static void modificacionAlumno(ArrayList <Alumno> alumnos){
        
        int legajoAux = 0;
        boolean alumnoEncontrado = false;
        Scanner lecturaNumeros = new Scanner(System.in);
        Scanner lecturaLetras = new Scanner(System.in);
        Iterator <Alumno> itAlumnos = alumnos.iterator();
        
        // Nuevamente, buscamos por LEGAJO (identificador CLAVE).
        
        System.out.println("Ingrese el LEGAJO del alumno/a que desea modificar");
        legajoAux = lecturaNumeros.nextInt();
        
        while (itAlumnos.hasNext()){ // Recorro mi colección...
            
            Alumno alumnoAux = itAlumnos.next(); // Copio la referencia.
            
                if (alumnoAux.getLegajo() == legajoAux){ // Comparo legajos.
                    
                    // ¡Lo encontré! Lo informo.
                    System.out.println("*** ALUMNO/A ENCONTRADO/A **");
                    alumnoEncontrado = true;
   
                    // PIDO LOS NUEVOS DATOS 
                    /* Nótese que estoy haciendo un ingreso super rústico en
                    el cual, forzosamente, el usuario va a tener que escribir
                    "TODO" de nuevo. Lo ideal sería que el operador pudiese
                    elegir qué cosas específicas quiere modificar */

                    System.out.println("Ingrese NUEVO NOMBRE");
                    String nombreAux = lecturaLetras.nextLine();
                    alumnoAux.setNombre(nombreAux); 
                    System.out.println("Ingrese NUEVO APELLIDO");
                    String apellidoAux = lecturaLetras.nextLine();
                    alumnoAux.setApellido(apellidoAux);
                    System.out.println("INGRESE NUEVO TELÉFONO");
                    String telefonoAux = lecturaLetras.nextLine();
                    alumnoAux.setTelefono(telefonoAux);
                    System.out.println("INGRESE NUEVO EMAIL");
                    String emailAux = lecturaLetras.nextLine();
                    alumnoAux.setEmail(emailAux);
            } 
        }
        
        if (alumnoEncontrado == false){ // ¿No lo encontré? Lo informo.
            System.out.println(" -- ALUMNO/A NO ENCONTRADO/A --");
        }
        
    }
    
    ///////////////////// BÚSQUEDAS /////////////////////
    
    // ENTEROS
    public static void busquedaEntero(ArrayList <Integer> enteros){
        
        Scanner lecturaNumeros = new Scanner(System.in);
        Iterator<Integer> itEnteros = enteros.iterator();
        int numeroIterator = 0;
        boolean numEncontrado = false;
        int i = 0;
        int numeroAux = 0;
                            
        System.out.println("Ingrese el número entero que desea buscar");
        numeroAux = lecturaNumeros.nextInt();
                            
        while ((itEnteros.hasNext()) && (numEncontrado == false)){
                                
            numeroIterator = itEnteros.next();
            
            if (numeroIterator == numeroAux){
                System.out.println("Número encontrado en la posición: " + i);
                numEncontrado = true;
                
                /* Acá si estoy cortando la búsqueda al momento de
                encontrarse el primer ejemplar con dicho valor. También
                uno podría quitar la segunda condición del 'while' haciendo
                que el método devuelva entonces todos los índices ('i') en
                los cuales se encuentre dicho número */
            }                      
            
            i++;
        }
    }
    
    //ALUMNOS
    public static void busquedaAlumno(ArrayList <Alumno> alumnos){
        
        // Búsqueda prácticamente idéntica al método anterior (busquedaEntero).
        
        Scanner lecturaNumeros = new Scanner(System.in);
        Iterator <Alumno> itAlumnos = alumnos.iterator();
        boolean alumnoEncontrado = false;
        int i = 0;
        int legajoAux = 0;
        
        System.out.println("Ingrese el LEGAJO del alumno/a que desea buscar");
        legajoAux = lecturaNumeros.nextInt();
        
        while ((itAlumnos.hasNext()) && (alumnoEncontrado == false)){
            
            Alumno alumnoAux = itAlumnos.next();
            
            if (alumnoAux.getLegajo() == legajoAux){
                System.out.println("Alumno/a encontrado/a en la posición: " + i);
                alumnoEncontrado = true;
            }
            
            i++;
        }
        
        if (alumnoEncontrado == false){
            System.out.println(" -- ALUMNO/A NO ENCONTRADO/A --");
        }
    }
    
    ///////////////////// IMPRESIONES /////////////////////
    
    // ENTEROS
    public static void impresionEnteros(ArrayList <Integer> enteros){
        
        int i = 0;
                            
        System.out.println("\nLISTA DE ENTEROS:\n");                        
        for (i = 0; i < enteros.size(); i++){
            System.out.println(enteros.get(i));
        }
    }
    
    // ALUMNOS
    public static void impresionAlumnos(ArrayList <Alumno> alumnos){

        System.out.println("\nLISTA DE ALUMNOS:\n");   
        for (Alumno alumno : alumnos){
            System.out.println(alumno);
        }
    }
    
}