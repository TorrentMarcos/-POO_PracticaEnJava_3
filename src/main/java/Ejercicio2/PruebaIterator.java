/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */

public class PruebaIterator {
    
    /* Como en el ejercicio anterior se implementó - casualmente - un Iterator
    con ArrayList, mi idea en esta consigna es repasar la mécanica de los
    Iterator e intentar sumar algun tipo de información útil en el código
    (ej. 'excepciones'). Trabajaré, nuevamente, con un ArrayList de enteros. */
    
    public static void main(String[] args) {
        
        // DECLARACIÓN E INICIALIZACIÓN DE VARIABLES
        
        ArrayList <Integer> enteros = new ArrayList<Integer>(); 
        Scanner lecturaNumeros = new Scanner(System.in);
        boolean menuEnteros = true;
        int opcionMenu = -1;
         
        try { // INTENTO...
            
        // Creo un menú para ir probando diferentes opciones (alta, baja, etc.)    
        
            while (menuEnteros == true){ // MENÚ PRINCIPAL Y ÚNICO
                    
                System.out.println("\n*** NÚMEROS ENTEROS (ABM / CRUD) *** ");
                System.out.println("\tIngrese la opción que desea ejecutar");
                System.out.println("\t 1 - ALTA");
                System.out.println("\t 2 - BAJA");
                System.out.println("\t 3 - MODIFICACIÓN");
                System.out.println("\t 4 - BÚSQUEDA");
                System.out.println("\t 5 - IMPRESIÓN (LISTA ENTERA)");
                System.out.println("\n\t 0 - FINALIZAR PROGRAMA");
                    
                opcionMenu = lecturaNumeros.nextInt(); // Leemos la opción.
                    
                switch (opcionMenu){ /* ¿Qué opción fue escogida? 
                        
                « TRABAJO CON MÉTODOS PARA QUE QUEDE MÁS "PROLIJO" EL MAIN » 
            
                Nota: Podríamos haber importado los métodos del ejercicio
                anterior y reducir código pero, a efectos de no andar
                yendo y viniendo, preferí repetirlos y dejarlos acá */
                        
                    case 0: // CORTO EL MENÚ Y FINALIZO EL PROGRAMA.
                        menuEnteros = false; 
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
  
                    }
                }
            }
        
        // ANTE CUALQUIER POSIBLE ERROR, LO ATRAPAMOS ("CATCH").
        catch (Exception e) { 
            System.out.println(e.toString());   // Lo mostramos por pantalla.
            
            /* Nótese que no nos estamos enfocando en ningún tipo de 'error'
            particular. Simplemente estamos atrapando cualquier clase de error
            que pudiese llegar a surgir, a efectos de que el programa no
            colapse durante su ejecución. Lo ideal, al trabajar con excepciones,
            es identificar primero todos los casos particulares y luego, por
            precaución, colocar un catch "genérico" que contemple al resto. */
               
        }
        
        // INDEPENDIENTEMENTE DE SI HUBO, O NO, EXCEPCIONES...
        finally {       
            //...
        }
    }
    
    /* » MÉTODOS "FUERA" DEL MAIN:
    
         - Nota: Dado que - si llegase a surgir algún tipo de error - yo no
         estaría manejando (en este caso) las excepciones dentro de los mismos
         métodos, debo agregar un "throws Exception" al final de sus firmas.
         (Si fuese alguna excepción más específica podría poner, por ejemplo,
         'throws ProgramException' - o cualquier otra - e incluso propias) */
    
    ///////////////////// ALTA /////////////////////
    public static void altaEntero (ArrayList <Integer> enteros) throws Exception { 
        
        int numeroAux = 0;
        Scanner lecturaNumeros = new Scanner(System.in);

        System.out.println("• Ingrese nuevo número entero");
        numeroAux = lecturaNumeros.nextInt();
        
        enteros.add(numeroAux);

    }
   
    ///////////////////// BAJA /////////////////////
    public static void bajaEntero (ArrayList <Integer> enteros) throws Exception {
        
        int numeroAux = 0;
        int numeroIterator = 0;
        Scanner lecturaNumeros = new Scanner(System.in);
        
        /* Creo un ITERATOR que me sirva para recorrer una colección de
        enteros "<Integer>" y le asocio una copia de mi propia lista.
        Sobre esta copia, igualmente, voy a poder trabajar sobre la lista real.
        La utilidad está en que, al tener una "copia", evito recorrer + operar
        sobre una misma colección simultáneamente. Diversifico operaciones */
        
        Iterator<Integer> itEnteros = enteros.iterator();

        System.out.println("• Ingrese el número entero que desea eliminar");
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
    
    ///////////////////// MODIFICACIÓN /////////////////////
    public static void modificacionEntero(ArrayList <Integer> enteros) throws Exception {
        
        Scanner lecturaNumeros = new Scanner(System.in);
        int numeroAux = 0;
        int numeroIterator = 0;
        int numeroModificar = 0;
        int i = 0;
        Iterator<Integer> itEnteros = enteros.iterator();
        
        // NÚMERO QUE SE VA A CAMBIAR (OSEA, EL "VIEJO" VALOR).       
        System.out.println("• Ingrese el número entero que desea modificar");
        numeroAux = lecturaNumeros.nextInt();
                            
        // NUEVO VALOR.
        System.out.println("• Ingrese el nuevo valor que reemplazará a ese número");
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
    
    ///////////////////// BÚSQUEDA /////////////////////
    public static void busquedaEntero(ArrayList <Integer> enteros) throws Exception {
        
        Scanner lecturaNumeros = new Scanner(System.in);
        Iterator<Integer> itEnteros = enteros.iterator();
        int numeroIterator = 0;
        boolean numEncontrado = false;
        int i = 0;
        int numeroAux = 0;
                            
        System.out.println("• Ingrese el número entero que desea buscar");
        numeroAux = lecturaNumeros.nextInt();
                            
        while ((itEnteros.hasNext()) && (numEncontrado == false)){
                                
            numeroIterator = itEnteros.next();
            
            if (numeroIterator == numeroAux){
                System.out.println("» Número encontrado en la posición: " + i);
                numEncontrado = true;
                
                /* Acá si estoy cortando la búsqueda al momento de
                encontrarse el primer ejemplar con dicho valor. También
                uno podría quitar la segunda condición del 'while' haciendo
                que el método devuelva entonces todos los índices ('i') en
                los cuales se encuentre dicho número */
            }                      
            
            i++;
        }
        
        if (numEncontrado == false){
            System.out.println("» El número buscado no está en lista");
        }
    }
    
    ///////////////////// IMPRESIÓN /////////////////////
    public static void impresionEnteros(ArrayList <Integer> enteros) throws Exception {
        
        int i = 0;
                            
        System.out.println("\n» LISTA DE ENTEROS:\n");                        
        for (i = 0; i < enteros.size(); i++){
            System.out.println(enteros.get(i));
        }
    }
    
}