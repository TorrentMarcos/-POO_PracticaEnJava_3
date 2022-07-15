/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public class TestReserva {
    
    public static void main(String[] args) {
        
        Scanner lecturaNumeros = new Scanner(System.in);
        ArrayList <Auto> autosHarry = new ArrayList();
        ArrayList <Auto> autosHermione = new ArrayList();
        ArrayList <Auto> autosRon = new ArrayList();
        ArrayList <Auto> seleccionAutos = new ArrayList();
        boolean opcionMenu = true;
        boolean menuAutos = true;
        int opcAuto = -1;
        int opcMenuAuto = -1;
        int opcReserva = -1;
        int i = 0;
        
        // - VAMOS A INTENTAR CREAR AGLUNAS RESERVAS.
        
        // Cargo y agrego algunos autos para que podamos elegir.
        Auto auto1 = new Auto ("A3-123", "Ford", "Fiesta", "Negro", 5, 3000);
        Auto auto2 = new Auto("A3-456", "Mitsubishi", "Eclipse", "Blanco", 5, 5000);
        Auto auto3 = new Auto("A3-789", "Jeep", "Wrangler", "Rojo", 6, 8000);
        Auto auto4 = new Auto("A4-000", "Suzuki", "Fun", "Gris", 4, 2500);
        Auto auto5 = new Auto("A4-001", "Chevrolet", "Onix", "Verde", 5, 4500);
        ManejoReserva.getAutos().add(auto1);
        ManejoReserva.getAutos().add(auto2);
        ManejoReserva.getAutos().add(auto3);
        ManejoReserva.getAutos().add(auto4);
        ManejoReserva.getAutos().add(auto5);
        
        /* Cargo también algunas reservas (válidas) para ver si, cuando creemos una, nos ofrecen
        sólo los autos disponibles p/esas fechas. */
        Cliente cli1 = new Cliente (1, "Harry", "Potter", "11111", "Hogwarts 123", "131313131");
        Cliente cli2 = new Cliente (2, "Hermione", "Granger", "22222", "Hogwarts 234", "24242424");
        Cliente cli3 = new Cliente (3, "Ron", "Weasley", "33333", "Hogwarts 345", "35353535");
        //--
        GregorianCalendar fecha1 = new GregorianCalendar (2022, 6, 6); // Los meses se cuentan desde 0. 6 = Julio.
        GregorianCalendar fecha2 = new GregorianCalendar (2022, 6, 10);
        GregorianCalendar fecha3 = new GregorianCalendar (2022, 6, 13);
        //--
        autosHarry.add(auto1); // AUTO(S) HARRY.
        autosHarry.add(auto2);
        autosHermione.add(auto3); // AUTO(S) HERMIONE.
        autosRon.add(auto4); // AUTO(S) RON.
        //-- 
        Reserva res1 = new Reserva (cli1, fecha1, fecha2, autosHarry); 
        Reserva res2 = new Reserva (cli2, fecha2, fecha3, autosHermione); 
        Reserva res3 = new Reserva (cli3, fecha1, fecha3, autosRon);
        ManejoReserva.getReservas().add(res1);
        ManejoReserva.getReservas().add(res2);  
        ManejoReserva.getReservas().add(res3);
        
        // -- SIMULO UN MENÚ SÚPER-BÁSICO COMO SI YO YA ESTUVIESE LOGEADO COMO UN CLIENTE.
        // LO QUE ME IMPORTA NO ES TESTEAR LA CARGA DE AUTOS NI CLIENTES, SINO LA CORRECTA GESTIÓN DE RESERVAS.
            // Es importante probar tanto la superposición de fechas y la no-supersoción para
            // ver si, efectivamente, nos ofrecen los autos correctos (dado que algunos estarán alquilados).
        
        while (opcionMenu == true){ // Voy a hacer de cuenta que estoy logueado como el Cliente1 (Harry Potter)
            
            System.out.println("** BIENVENIDO/A AL MENÚ DE RESERVAS, ESTIMADO/A CLIENTE **");
            System.out.println("« Ingrese la fecha de 'CHECK IN' »"); // PEDIMOS FECHA DE 'CHECK-IN'
            System.out.println("---- Día (número) (ej. 6): ");
            int dia = lecturaNumeros.nextInt();
            System.out.println("---- Mes (número) (ej. 4): ");
            int mes = lecturaNumeros.nextInt();
            System.out.println("---- Año (número) (ej. 2022): ");
            int anio = lecturaNumeros.nextInt();
            GregorianCalendar fecha = new GregorianCalendar(anio, mes-1, dia);
            System.out.println("\n» AUTOS DISPONIBLES PARA ESA FECHA: "); // MOSTRAMOS LOS AUTOS DISPONIBLES.
            for (Auto auto: ManejoReserva.AutosDisponiblesEnFecha(fecha)){
                System.out.println("--------------");
                System.out.println(auto);
                System.out.println("\t• Puede seleccionar este auto con el número: " + (i+1));
                System.out.println("--------------");
                i++;
            }
            while (menuAutos == true){ // SELECCIÓN ENTRE AUTOS DISPONIBLES (en su expresión más simple)
                System.out.println("Elija su auto (número): ");
                opcAuto = lecturaNumeros.nextInt();
                seleccionAutos.add(ManejoReserva.AutosDisponiblesEnFecha(fecha).get(opcAuto-1));
                System.out.println("« Auto N°" + opcAuto + " seleccionado. »");
                System.out.println("\n¿DESEA AGREGAR OTRO AUTO? 1 - SÍ | 2 - NO | 3 - LIMPIAR SELECCIÓN");
                opcMenuAuto = lecturaNumeros.nextInt();
                if (opcMenuAuto == 2){
                    menuAutos = false;
                }
                if (opcMenuAuto == 3){
                    seleccionAutos.clear();
                    System.out.println("-- LISTA DE AUTOS VACIADA --");
                }
            }
            System.out.println("\n« Ingrese la fecha de 'CHECK OUT' »"); // PEDIMOS FECHA DE 'CHECK OUT'.
            System.out.println("---- Día (número) (ej. 8): ");           // (Qué también podría pedirla antes).
            int diaF = lecturaNumeros.nextInt();
            System.out.println("---- Mes (número) (ej. 10): ");
            int mesF = lecturaNumeros.nextInt();
            System.out.println("---- Año (número) (ej. 2022): ");
            int anioF = lecturaNumeros.nextInt();
            GregorianCalendar fechaF = new GregorianCalendar(anioF, mesF-1, diaF);
            
            // MUESTRO UN PRELIMINAR DE LA RESERVA (CON EL COSTO TOTAL INCLUIDO Y DEMÁS).
            System.out.println("\n** VISTA PRELIMINAR DE SU RESERVA **");
            Reserva reservaAux = new Reserva(cli1, fecha, fechaF, seleccionAutos);
            reservaAux.setActiva(false);
            System.out.println("--------------");
            System.out.println(reservaAux);
            System.out.println("--------------");
            // ¿SE CONFIRMA LA RESERVA?
            System.out.println("¿Se confirma la reserva? 1 - SÍ | 2 - NO. CREAR UNA NUEVA | 0 - SALIR ");
            opcReserva = lecturaNumeros.nextInt();
            
            if (opcReserva == 1){        // SE CONFIRMA. LA GUARDO.
                reservaAux.setActiva(true);
                ManejoReserva.getReservas().add(reservaAux);
                System.out.println(" -- RESERVA GUARDADA EXITOSAMENTE --");
                opcionMenu = false;
            }
            else if (opcReserva == 2){  // NO SE CONFIRMA, PERO SE QUIERE HACER UNA RESERVA NUEVA.
                seleccionAutos.clear(); // Borro la lista de los autos que se habían elegido.
            }
            else {
                opcionMenu = false;    // NO SE CONFIRMA + SE QUIERE SALIR DEL PROGRAMA.
            }
            
            i = 0;
        }
        
        // APROVECHO PARA TESTEAR MI LISTA DE RESERVAS CREADAS.
        System.out.println("\n ********** LISTA DE RESERVAS ********** ");
        for (Reserva res : ManejoReserva.getReservas()){
            System.out.println("---------------------------------------");
            System.out.println(res);
            System.out.println("---------------------------------------");
        }

    }
     
}
