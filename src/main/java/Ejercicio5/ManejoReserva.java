/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Marcos
 */

public class ManejoReserva {
    
    // » ATRIBUTOS
    
    private static ArrayList <Reserva> reservas = new ArrayList<Reserva>();
    private static ArrayList <Auto> autos = new ArrayList<Auto>();
    
    // » GETTERS & SETTERS (En su expresión más simple)

    public static ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public static void setReservas(ArrayList<Reserva> reservas) {
        ManejoReserva.reservas = reservas;
    }

    public static ArrayList<Auto> getAutos() {
        return autos;
    }

    public static void setAutos(ArrayList<Auto> autos) {
        ManejoReserva.autos = autos;
    }
    
    // » OTROS MÉTODOS Y/O FUNCIONES DEFINIDOS/AS POR EL DESARROLLADOR
    
    public static ArrayList<Auto> AutosDisponiblesEnFecha (GregorianCalendar fecha){
        
        // 'CLONO' el ArrayList que contiene todos mis autos.
        ArrayList<Auto> autosDisponibles = (ArrayList<Auto>) autos.clone();
        
        /* Descarto todos los autos que estén ocupados / no disponibles
        para la fecha en que el Cliente quiere realizar el 'CHECK IN' */
        
        for (Reserva res: reservas){ // Analizo todas las reservas ACTIVAS.
            
            if (res.isActiva() == true){
                
                // ¿'CHECK IN' = Fecha de Inicio o Fin de otra reserva? 
                if (fecha.equals(res.getFechaInicio()) || fecha.equals(res.getFechaFin())){
                    // Descarto esos autos.
                    for (Auto auto: res.getAutos()){
                         autosDisponibles.remove(auto);
                    }
                }
                // ¿'CHECK IN' entre la Fecha de Inicio y Fin de otra reserva?
                if (fecha.after(res.getFechaInicio()) && fecha.before(res.getFechaFin())){
                    // Descarto esos autos.
                    for (Auto auto: res.getAutos()){
                         autosDisponibles.remove(auto);
                    }
                }
            }        
        }
        
        /* También podría pasar que haya autos que no estén ocupados pero que igualmente
        no estén disponibles por, supongamos, una avería. Los descartarmos también */
        for (Auto auto: autos){  
            if (auto.isDisponibilidad() == false){
                autosDisponibles.remove(auto);
            }
        }
        
    // Devolvemos sólo una lista con los autos disponibles para ese 'CHECK IN'.    
    return autosDisponibles;  
    
    }
    
    /* El siguiente método está pensando como un ideal que se ejecuta
    automáticamente todos los días donde, si la FECHA ACTUAL es igual
    al 'CHECK IN' de una reserva, automáticamente se inhabilitan todos
    los autos involucrados en dicha reserva. Luego con el método
    'CerrarReserva()', que funciona a nivel individual y está en la clase
    'Reserva', todos los autos involucrados en dicha reserva vuelven
    automáticante a la normalidad (disponibilidad = true).
    
    Podríamos también tener un método para habilitar Autos automáticamente,
    esta vez basado en el 'CHECK OUT', pero - dado que el Cliente podría 
    excederse con la entrega del auto (y necesitemos seguir cobrando)
    prefiero gestionar la baja lógica de una reserva a nivel individual 
    y no hacerlo automáticamente. Con el 'CHECK IN' no tengo drama dado
    que, el cliente venga o no, yo empiezo a cobrar a partir del CHECK IN */
    
    public void inhabilitadorAutosAutomatico(){
        
        GregorianCalendar fechaActual = new GregorianCalendar();
        
        for (Reserva res: reservas){ // RECORRO LAS RESERVAS ACTIVAS.
            if (res.isActiva() == true){
                if (fechaActual.equals(res.getFechaInicio())){ // ¿CHECK IN = FECHA ACTUAL?
                    for (Auto auto: autos){                    // SETEO LOS AUTOS COMO "OCUPADOS".
                        auto.setDisponibilidad(false);
                    } 
                }
            }
        }  
    } 
    
}