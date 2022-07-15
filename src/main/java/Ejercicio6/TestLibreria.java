/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */

public class TestLibreria {
    
    public static void main(String[] args) {
        
        Scanner lecturaNumeros = new Scanner(System.in);
        Scanner lecturaLetras = new Scanner(System.in);
        
        String nombreAux = "";
        Libro libroAux = null;

        boolean menuActivo = true;
        boolean buscarLibro = true;
        boolean hayCompra = false;
        boolean hayPedido = false;
        int opcionMenu = -1;
        int opcionCompra = -1;
        int opcionLibro = -1;
        int opcionPedido = -1;
        int cantidad = 0;
        
         // COMENZAREMOS CARGANDO ALGUNOS DATOS A FIN DE PODER TESTEAR OPTIMAMENTE
         
         // ----- PROVEEDORES -----
         Proveedor prov1 = new Proveedor ("Libros 'EL MAGO'", "11111", "Av. Córdoba 123", "elmago@libros.com");
         Proveedor prov2 = new Proveedor ("La gran bibilioteca", "2222", "Av. Callao 456", "granbiblio@libros.com");
         Proveedor prov3 = new Proveedor ("Alejandría", "3333", "Ayacucho 789", "alejandría@books.com");
        
         ArrayList <Proveedor> provTest = new ArrayList();
         ArrayList <Proveedor> provTest2 = new ArrayList();
         
         // PROVTEST 1 (LISTA)
         provTest.add(prov1);
         provTest.add(prov2);
         
         // PROVTEST 2 (LISTA)
         provTest2.add(prov1);
         provTest2.add(prov3);
         
         // ----- EDITORIALES -----
         
         Editorial edi1 = new Editorial("Planeta", provTest);
         Editorial edi2 = new Editorial("Mandragora", provTest2);
         Editorial edi3 = new Editorial("Mortífago", provTest);
         
         // ----- LIBROS (UNO DE CADA TIPO Y GÉNERO) -----
         
         // NOVELAS
         LibroNovela novela1 = new LibroNovela(1, "Harry Potter", 1999, "J. K. Rowling", edi1, 1, 1000, 10, 1);
         LibroNovela novela2 = new LibroNovela(2, "Crepúsculo", 2005, "Stephenie Meyer", edi1, 1, 800, 2, 4);
         LibroNovela novela3 = new LibroNovela(3, "Sherlock Holmes", 2003, "Arthur C. Doyle", edi2, 2, 1200, 0, 5);
         LibroNovela novela4 = new LibroNovela(4, "Bajo la misma estrella", 2005, "John Green", edi3, 2, 800, 1, 2);
         LibroNovela novela5 = new LibroNovela(5, "El experimento", 2007, "Sebastian Fitzek", edi1, 1, 900, 8, 3);
         GestionLibreria.libros.add(novela1);
         GestionLibreria.libros.add(novela2);
         GestionLibreria.libros.add(novela3);
         GestionLibreria.libros.add(novela4);
         GestionLibreria.libros.add(novela5);
         
         // TÉCNICOS
         LibroTecnico tec1 = new LibroTecnico(6, "Matemática, ¿Estás ahí?", 2008, "A. Paenza", edi2, 2, 1000, 0, 1);
         LibroTecnico tec2 = new LibroTecnico(7, "Árboles nativos de ARG", 2015, "Karlin", edi3, 1, 750, 10, 2);
         LibroTecnico tec3 = new LibroTecnico(8, "Manual de derecho laboral", 2004, "Grisolia", edi2, 1, 600, 2, 3);
         GestionLibreria.libros.add(tec1);
         GestionLibreria.libros.add(tec2);
         GestionLibreria.libros.add(tec3);
         
         // AHORA SÍ. PASEMOS AL MENÚ.
         while (menuActivo == true){ // SIMPLIFICARÉ LAS FUNCIONALIDADES JUNTO CON LA PROFUNDIDAD DE LAS MISMAS.
             
            ArrayList <ItemFactura> itemsFactura = new ArrayList();
            ArrayList <ItemFactura> itemsPedido = new ArrayList();
             
             System.out.println("\n***** LIBRERIA 'EL ALEPH' *****");
             System.out.println("« Ingrese la opción que desea ejecutar »");
             System.out.println("1 - BUSCAR LIBRO (CONTIENE COMPRAS Y PEDIDOS)");
             System.out.println("2 - VER PEDIDOS EMITIDOS");
             System.out.println("3 - VER FACTURAS EMITIDAS");
             System.out.println("0 - SALIR");
             
             opcionMenu = lecturaNumeros.nextInt();
             
             switch(opcionMenu){
                
                ////////////////// SALIR (Todo esto debería estar en métodos aparte).
                case 0:
                    menuActivo = false;
                break;
                /////////////////
                    
                ///////////////// BUSCAR LIBRO (CON COMPRAS Y PEDIDOS IMPLÍCITAS/OS).
                case 1:
                    
                    buscarLibro = true;
                    
                    while (buscarLibro == true){ // MIENTRAS QUERRAMOS BUSCAR LIBROS...
                        
                        // PEDIMOS EL TÍTULO A BUSCAR Y BUSCAMOS.
                        System.out.println("» Ingrese el nombre del libro a buscar: ");
                        nombreAux = lecturaLetras.nextLine();
                        libroAux = GestionLibreria.buscarLibro(nombreAux);
                        
                        // ¿ENCONTRAMOS ALGO? 
                        if (libroAux != null){ // SÍ. LO MOSTRAMOS.
                            System.out.println("------------------");
                            System.out.println(libroAux);
                            System.out.println("------------------");
                        
                            // ADEMÁS, SI HAY STOCK DEL LIBRO EN ESE MOMENTO, PREGUNTAMOS SI QUIERE COMPRARLO.
                            if (libroAux.getStock() > 0){
                            
                                System.out.println("¿AÑADIR LIBRO AL CARRITO? 1 - SÍ | 2 - NO");
                                opcionCompra = lecturaNumeros.nextInt();
                            
                                if (opcionCompra == 1){ // QUIERE COMPRARLO. ¿CUÁNTOS EJEMPLARES?
                                    
                                    System.out.println("¿Cantidad?: " + "MÁX: " + libroAux.getStock());
                                    cantidad = lecturaNumeros.nextInt();
                                    
                                    // CREAMOS EL ITEM DE LA FUTURA FACTURA.
                                    itemsFactura.add(new ItemFactura(libroAux, cantidad));
                                    
                                    // DESCONTAMOS EL STOCK
                                    libroAux.descontarStock(cantidad);
                                    System.out.println(" -- LIBRO AÑADIDO AL CARRITO --");
                                    // DEJAMOS INFORMADO QUE VA A HABER UNA FACTURA.
                                    hayCompra = true;
                                }
                            
                            } else { // NO HAY STOCK. PREGUNTAMOS SI EL LIBRO SE QUIERE ENCARGAR...
                                System.out.println("SIN STOCK. ¿DESEA ENCARGAR EL LIBRO? 1 - SÍ | 2 - NO");
                                opcionPedido = lecturaNumeros.nextInt();
                                
                                if (opcionPedido == 1){ // SÍ. SE QUIERE ENCARGAR
                                    System.out.println("¿Cantidad?: ");
                                    cantidad = lecturaNumeros.nextInt();
                                    
                                    // CREAMOS EL ITEM E INFORMAMOS QUE VA A HABER PEDIDO.
                                    itemsPedido.add(new ItemFactura(libroAux, cantidad));
                                    hayPedido = true;
                                }
                                
                            }
                        } else{         
                            System.out.println(" -- LIBRO NO ENCONTRADO --\n");
                        }
                        
                        // PREGUNTAMOS SI SE QUIERE BUSCAR OTRO LIBRO.
                        System.out.println("¿DESEA BUSCAR OTRO LIBRO? 1 - SÍ | 2 - NO");
                        opcionLibro = lecturaNumeros.nextInt();
                        
                        if (opcionLibro == 2){ // SI NO SE QUIERE... 
                            
                            // CREAMOS LA FACTURA SI HABÍA COMPRA.
                            if (hayCompra == true){
                                System.out.println("\n*** REALIZACIÓN DE FACTURA ***");
                                System.out.println("» Ingrese nombre del cliente: ");
                                nombreAux = lecturaLetras.nextLine();
                                
                                GregorianCalendar fecha = new GregorianCalendar();
                                Factura f1 = new Factura(nombreAux, fecha, itemsFactura); 
                                GestionLibreria.getFacturas().add(f1);
                                System.out.println("-- FACTURA REALIZADA --");
                                 
                            }
                            
                            // CREAMOS EL PEDIDO SI HABÍA PEDIDO.
                            if (hayPedido == true){
                                System.out.println("\n*** REALIZACIÓN DE PEDIDO ***");
                                System.out.println("» Ingrese nombre del cliente: ");
                                nombreAux = lecturaLetras.nextLine();
                                
                                GregorianCalendar fecha = new GregorianCalendar();
                                Pedido p1 = new Pedido(nombreAux, fecha, itemsPedido); 
                                GestionLibreria.getPedidos().add(p1);
                                System.out.println("-- PEDIDO GUARDADO --");
                            }
                            
                            // REINICIO TODO

                            hayCompra = false;
                            hayPedido = false;
                            buscarLibro = false;

                        } 
                    }

                break;
                
                case 2: ///////////////// MOSTRAR TODOS LOS PEDIDOS EMITIDOS.
                    
                    System.out.println("\n« *** PEDIDOS EMITIDOS *** »");
                    for (Pedido p : GestionLibreria.getPedidos()){
                        System.out.println("-------");
                        System.out.println(p);
                        System.out.println("-------");
                    } 
                break;
                
                case 3: ///////////////// MOSTRAR TODAS LAS FACTURAS EMITIDAS.
                    
                    System.out.println("\n« *** FACTURAS EMITIDAS *** »"); 
                    for (Factura f : GestionLibreria.getFacturas()){
                        System.out.println("-------");
                        System.out.println(f);
                        System.out.println("-------");
                    } 
                    
                break;
                
                default:
                    System.out.println("• OPCIÓN INVÁLIDA •");
                
            } // CIERRA SWITCH
             
        } // CIERRA MENU ACTIVO
       
    } // CIERRA MAIN
    
}