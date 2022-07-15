/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */

public class TestArchivo {
    
    public static void main(String[] args) {
        
        // » DECLARACIÓN E INICIALIZACIÓN DE VARIABLES  
        File archivo = null;
        FileReader fr = null;
        // ---
        Scanner lecturaTexto = new Scanner(System.in);
        Scanner lecturaNumeros = new Scanner(System.in);
        // ---
        String textoAbuscar = "";
        String rutaArchivo = "";
        String datosLectura = "";
        // ---
        boolean lecturaYaHecha = false;
        // ---
        int opcion = -1;
        int controlCaracter = 0;
        // ---
        
        try { // INTENTAMOS...
            
                // Pedimos la ruta del archivo '.TXT' que se desea leer.
                System.out.println("Ingrese la ruta de su archivo de texto");
                rutaArchivo = lecturaTexto.nextLine();
                // » Nota: Hay un archivo de ejemplo llamado "Ejercicio3.txt".

                // Definimos un Archivo para esa ruta.
                archivo = new File(rutaArchivo);
                // Definimos un FileReader para ese Archivo.
                fr = new FileReader (archivo);
            
            while (opcion != 0){ // Mientras el usuario no quiera salir...
                
                // Pedimos y guardamos el texto que se desea buscar.
                System.out.println("Ingrese el carácter, la palabra o expresión que desee buscar: ");
                textoAbuscar = lecturaTexto.nextLine();
               
                // Para evitar leer el archivo de nuevo, pregunto: ¿Ya lo tengo leído?
                
                // No. Primera vez que lo leo.
                if (lecturaYaHecha == false) { 
                    // Empiezo a guardar carácter por carácter hasta EOF.
                    while ((controlCaracter = fr.read()) != -1) {
                        datosLectura = datosLectura + (char) controlCaracter;
                    }
                    // Terminé de leer.
                    fr.close(); // Cierro el flujo.
                    lecturaYaHecha = true; // Indico que ya no hace falta leer todo de nuevo.
                }
 
                // ¿El texto del archivo contiene el texto que yo busco?
                if (datosLectura.contains(textoAbuscar)){ // SÍ. Lo informo.
                    
                    System.out.println("\n** La secuencia buscada ESTÁ en el archivo");
                }
                
                else{ // NO. Lo informo.

                    System.out.println("\n** La secuencia buscada NO ESTÁ en el archivo");
                    
                }
                
                // Muestro, efectivamente, lo que busqué VS. lo que tenía (archivo).
                System.out.println("\t» Secuencia buscada: " + textoAbuscar);
                System.out.println("\t» Contenido del archivo: '" + datosLectura + "'");
                
                // Damos, nuevamente, la posibilidad de buscar otra expresión.
                System.out.println("\n-------------------");
                System.out.println("Ingrese opción: ");
                System.out.println("1 - Buscar otro carácter, palabra o expresión.");
                System.out.println("0 - Salir.");
                opcion = lecturaNumeros.nextInt();

            } // CIERRA WHILE OPCIÓN.

        } // CIERRA TRY
        
        // Para aquellos problemas asociados a la E/S del archivo:
        catch (IOException ioe){ 
            System.out.println("» ERROR (E/S): " + ioe);
        }
        
        // Para cualquier otro tipo de problema:
        catch (Exception e){
            System.out.println("» ERROR:" + e);
        }
        
        finally {
            
            /* Nótese que también hubiésemos podido abordar este ejercicio
            mediante la "dupla" FileReader + BufferedReader. Así, entre otras
            cosas, en vez de leer carácter por carácter, hubiésemos podido
            leer línea por línea. */
            
        }
    }
}
