/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import static Ejercicio4.ManejoAgenda.altaContacto;
import static Ejercicio4.ManejoAgenda.bajaContacto;
import static Ejercicio4.ManejoAgenda.busquedaContacto;
import static Ejercicio4.ManejoAgenda.cargarAgenda;
import static Ejercicio4.ManejoAgenda.cerrarAgenda;
import static Ejercicio4.ManejoAgenda.impresionContactos;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */

public class TestAgenda {
    
    public static void main(String[] args) {
        
        Scanner lecturaNumeros = new Scanner(System.in);
        String rutaAgenda = "Ejercicio4.dat";
        File archivoAgenda = null;
        ArrayList<Contacto> contactos = new ArrayList();
        boolean menuActivo = true;
        int opcionMenu = -1;
        
        try { // INTENTAMOS
            
            archivoAgenda = new File(rutaAgenda); // ASOCIAMOS LA RUTA
            
            if (archivoAgenda.createNewFile()){   // ¿LA AGENDA YA EXISTÍA?  
                // NO. LA CREAMOS.
                System.out.println("SE HA CREADO LA AGENDA"); 
            }
            else{
                // SÍ. LA CARGAMOS.
                System.out.println("LA AGENDA YA EXISTÍA");
                cargarAgenda(contactos, rutaAgenda);
                System.out.println("« AGENDA CARGADA EXITOSAMENTE » ");
            }
            
            while (menuActivo == true){ // MIENTRAS EL USUARIO NO QUIERA SALIR.
                
                System.out.println("\n *** AGENDA - MENÚ DE CONTACTOS *** ");
                System.out.println("\t « Ingrese la opción que desea ejecutar »\n");
                System.out.println("\t 1 - REGISTRAR NUEVO CONTACTO");
                System.out.println("\t 2 - ELIMINAR CONTACTO");
                System.out.println("\t 3 - BUSCAR CONTACTO");
                System.out.println("\t 4 - IMPRIMIR LISTA DE CONTACTOS");
                System.out.println("\n\t 0 - FINALIZAR PROGRAMA");
                    
                opcionMenu = lecturaNumeros.nextInt();
                
                switch (opcionMenu){
                    
                     case 0: // GUARDO AGENDA + CORTO EL MENÚ.
                            cerrarAgenda(contactos, rutaAgenda);
                            menuActivo = false; 
                        break;
                        
                        case 1: // ALTA CONTACTO
                            altaContacto(contactos); 
                        break;
                        
                        case 2: // BAJA CONTACTO
                            bajaContacto(contactos);
                        break;
                        
                        case 3: // BÚSQUEDA CONTACTO
                            busquedaContacto(contactos);
                        break;
                       
                        case 4: // IMPRESIÓN AGENDA
                            impresionContactos(contactos);
                        break;
                       
                        default:
                            System.out.println("Opción inválida");     
                }
            }
        }
        
        catch (IOException ioe){ // "ATRAPAMOS" E INFORMAMOS PROBLEMAS DE E/S.
            System.out.println("ERROR E/S: " + ioe);
        }
       
        catch (Exception e){ // "ATRAPAMOS" CUALQUIER OTRO TIPO DE PROBLEMAS.
            System.out.println("ERROR: " + e);
        }
        
        finally{
            
            /* Nota: A fin de "limpiar" el main, decidí llevar todos
            los métodos() de la gestión de la agenda a una clase llamada
            "ManejoAgenda". De esta forma, queda todo mucho más "prolijo". */
            
        }     
    }
}