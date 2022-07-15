/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */

public class ManejoAgenda {
    
    ///////////////////// CARGAR /////////////////////
    public static void cargarAgenda (ArrayList<Contacto> contactos, String rutaAgenda) throws IOException {
        
        // CREAMOS UN 'OIS' P/ "RECONSTRUIR" (DESEREALIZAR) OBJETOS.
        ObjectInputStream ois = null;
        // CREAMOS UN FLUJO DE ENTRADA ('FIS') P/ LEER LOS BYTES DEL ARCHIVO.
        FileInputStream fis = null;
    
        try { // INTENTAMOS
            
            fis = new FileInputStream (rutaAgenda); // ASOCIAMOS RUTA AL 'FIS'.
            ois = new ObjectInputStream(fis);       // ASOCIAMOS 'FIS' AL 'OIS'.
            
            while(true){ // LEEMOS LOS CONTACTOS + LOS CARGAMOS EN MEMORIA.
                Contacto contacto_aux = (Contacto) ois.readObject();
                contactos.add(contacto_aux);
            }   

        // PARA CUALQUIER PROBLEMA DE E/S.  
        } catch (IOException ioe) { 
            System.out.println("ERROR E/S: " + ioe);
            /* De hecho, la forma en la que estructuramos el while, arrojará
            una excepción cuando llegue a FIN DE ARCHIVO. El catch nos salvó */
            
        // PARA PROBLEMAS DE NO-RECONOCIMIENTO DE CLASES  .  
        } catch (ClassNotFoundException cne) {
            System.out.println("ERROR DE CLASE NO ENCONTRADA: " + cne);
        }
        
        // FINALMENTE, CERRAMOS LOS FLUJOS A FIN DE LIBERAR RECURSOS.
        finally {
            if (ois != null){
                ois.close(); 
            }
            if (fis != null){
                fis.close();
            }
            /* Nota: Como esto puede potencialmente arrojar Excepciones tipo IO,
            además de haber quedado fuera del 'catch' anterior, la firma del
            método añadirá un 'throws IO Exception' que quedará "protegido"
            por un 'catch' que ya teníamos en el MAIN. */
        }
    }
    
    ///////////////////// ALTA /////////////////////
    public static void altaContacto (ArrayList <Contacto> contactos){
        
        Scanner lecturaNumeros = new Scanner(System.in);
        Scanner lecturaLetras = new Scanner (System.in);
        
        // PIDO LOS DATOS DEL CONTACTO
        System.out.println("Ingrese NOMBRE del contacto");   
        String nombreAux = lecturaLetras.nextLine();      // "AHORRANDO" LÍNEAS.
        System.out.println("Ingrese APELLIDO del contacto");
        String apellidoAux = lecturaLetras.nextLine();                  // ÍDEM.
        System.out.println("Ingrese TELÉFONO DE LÍNEA del contacto");
        String telefonoAux = lecturaLetras.nextLine();                  // ÍDEM.
        System.out.println("Ingrese TELÉFONO MÓVIL del contacto");
        String telMovilAux = lecturaLetras.nextLine();                  // ÍDEM.
        System.out.println("Ingrese TELÉFONO DEL TRABAJO del contacto");
        String telTrabajoAux = lecturaLetras.nextLine();                // ÍDEM.
        System.out.println("Ingrese EMAIL del contacto");
        String emailAux = lecturaLetras.nextLine();                     // ÍDEM.
        System.out.println("¿DE DÓNDE CONOCE ESTE CONTACTO? 1 - Familia || "
                + "2 - Universidad || 3 - Trabajo || 4 - Club || 5 - Otros");
        int vinculoAux = lecturaNumeros.nextInt();                      // ÍDEM.

        // CREO UN CONTACTO CON LOS DATOS OBTENIDOS Y LO AGREGO.
        Contacto contactoAux = new Contacto(nombreAux, apellidoAux, telefonoAux,
                telMovilAux, telTrabajoAux, emailAux, vinculoAux);
        contactos.add(contactoAux);
        System.out.println("-- CONTACTO AGREGADO EXITOSAMENTE --");
        
    }
    
    ///////////////////// BAJA /////////////////////
    public static void bajaContacto (ArrayList <Contacto> contactos){
        
        /* Vamos a buscar por número de CELULAR dado que éste, si
        se quiere, podría servirnos como "clave primaria". Nota:
        Esto, en la práctica, es INADMISIBLE dado que sería
        totalmente incómodo. Lo ideal sería ir filtrando contactos
        a medida que el usuario vaya tipeando el nombre. */
        
        String celularAux = "";
        Scanner lecturaLetras = new Scanner(System.in);
        Iterator <Contacto> itContactos = contactos.iterator();
               
        System.out.println("Ingrese el TEL. MÓVIL del contacto que desea eliminar");
        celularAux = lecturaLetras.nextLine();
        
        while (itContactos.hasNext()){
            
            Contacto contactoAux = itContactos.next();
            if (contactoAux.getTel_movil().equals(celularAux)){
                itContactos.remove();
                System.out.println("-- CONTACTO BORRADO --");
                
                /* Nótese que remove() siempre elimina el elemento
                que devolvería next(). Por lo tanto, tenemos certeza
                de que estamos borrando el contacto que, efectivamente,
                deseamos eliminar */
                
            }
        }
    }
    
    ///////////////////// BÚSQUEDA /////////////////////
    public static void busquedaContacto(ArrayList <Contacto> contactos){
         
        Scanner lecturaLetras = new Scanner(System.in);
        Iterator <Contacto> itContactos = contactos.iterator();
        boolean contactoEncontrado = false;
        int i = 0;
        String celularAux = "";
        
        // AL IGUAL QUE EN LAS BAJAS, BUSCAMOS MEDIANTE EL TELÉFONO CELULAR.
        System.out.println("Ingrese el TEL. MÓVIL del contacto que desea buscar");
        celularAux = lecturaLetras.nextLine();
        
        // MIENTRAS QUEDEN CONTACTOS Y NO HAYAMOS, ADEMÁS, ENCONTRADO YA UNO...
        while ((itContactos.hasNext()) && (contactoEncontrado == false)){
            
            Contacto contactoAux = itContactos.next();   // "COPIO" EL CONTACTO.
            
            if (contactoAux.getTel_movil().equals(celularAux)){     // VERIFICO.
                System.out.println("**********");                   // IMPRIMO.
                System.out.println(contactoAux);
                System.out.println("\t• Contacto encontrado en la posición: " + i + " •");
                System.out.println("**********");
                contactoEncontrado = true;
            }
            
            i++; // VARIABLE PARA "CONTAR" EN QUÉ POSICIÓN ENCONTRÉ AL CONTACTO.
        }
        
        if (contactoEncontrado == false){   // ¿NO LO ENCONTRÉ? TAMBIÉN INFORMO.
            System.out.println(" -- CONTACTO NO ENCONTRADO/A --");
        }
        
    }
    
    ///////////////////// IMPRESIÓN /////////////////////
    public static void impresionContactos(ArrayList <Contacto> contactos){

        System.out.println("\nLISTA DE CONTACTOS:\n");   
        for (Contacto contacto : contactos){
            System.out.println("-------------------");
            System.out.println(contacto);
            System.out.println("-------------------\n");
        }
    }
    
    ///////////////////// CERRAR /////////////////////
    public static void cerrarAgenda(ArrayList <Contacto> contactos, String rutaAgenda) throws IOException{
        
        // CREAMOS UN 'OUS' PARA SEREALIZAR OBJETOS Y PODER GUARDARLOS (BYTES).
        ObjectOutputStream ous = null;
        // CREO UN FLUJO DE SALIDA ('FUS') PARA GUARDAR BYTES EN MI ARCHIVO.
        FileOutputStream fus = null;
    
        try { // INTENTO.
            
            fus = new FileOutputStream (rutaAgenda);    // ASOCIO RUTA AL 'FUS'.
            ous = new ObjectOutputStream(fus);         // ASOCIO 'FUS' AL 'OUS'.
            
            // VOY GUARDANDO, UNO POR UNO, CADA CONTACTO DE MI LISTA.
            for (int i = 0; i< contactos.size(); i++){
                ous.writeObject(contactos.get(i));
            }    
        
        // PARA CUALQUIER ERROR DE E/S.
        } catch (IOException ioe) {
            System.out.println("ERROR E/S: " + ioe);
        }
        
        // CERRAMOS LOS FLUJOS A FIN DE LIBERAR RECURSOS.
        finally {
            if (ous != null){
                ous.close();
            }
            if (fus != null){
              fus.close();  
            }
            
            /* Nota: Como esto puede potencialmente arrojar Excepciones tipo IO,
            además de haber quedado fuera del 'catch' anterior, la firma del
            método añadirá un 'throws IO Exception' que quedará "protegido"
            por un 'catch' que ya teníamos en el MAIN. */
        }

    }
    
}