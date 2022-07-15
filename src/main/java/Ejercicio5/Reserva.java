/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Marcos
 */

public class Reserva {
    
    // » ATRIBUTOS
    private static int contadorId = 1; // CONTADOR QUE COMPARTIRÁN / "REFERENCIARÁN" TODOS LOS OBJETOS
                                       // Y QUE SÓLO USARÉ PARA JUGAR UN POCO CON LOS NÚM. DE RESERVA.  
    private int numReserva;            // Si bien el ejercicio no lo pide, considero este dato importante.
    private Cliente cliente;
    private GregorianCalendar fechaInicio;
    private GregorianCalendar fechaFin;
    private ArrayList<Auto> autos;
    private double total;
    private boolean activa; // Incluso habiéndose excedido de la fecha, podría quedar activa por otro motivo.
                            // Por ejemplo, que el cliente nunca haya regresado.
    
    // » CONSTRUCTORES

    public Reserva() {
        
    }

    public Reserva(Cliente cliente, GregorianCalendar fechaInicio,
            GregorianCalendar fechaFin, ArrayList<Auto> autos) {
        
        setNumReserva();             // Lo manejo a través de un setter privado. 
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.autos = autos;
        calcularTotal();
        this.activa = true;
    }
    
    /* También podríamos tener OTRO constructor que sí tenga el 'ACTIVA'
    (boolean) como parámetro dado que, por ejemplo, podríamos estar haciendo
    la "digitalización" de una empresa, o tuvieramos que hacer un registro
    excepcional por 'x' motivo, etc. */
    
    // » GETTERS & SETTERS ()

    public int getNumReserva() {
        return numReserva;
    }

    private void setNumReserva() {
        this.numReserva = contadorId++;
        /* El control de este valor es puramente interno.
        Si estoy trabajando con auto-incrementables y, encima, 
        abro la posibilidad de que el núm de reserva pueda modificarse
        "públicamente" por parámetro, podría tener problemas. */
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public GregorianCalendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(GregorianCalendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public GregorianCalendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(GregorianCalendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public void setAutos(ArrayList<Auto> autos) {
        this.autos = autos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    // » TO STRING ()

    @Override
    public String toString() {
        //------------------- CONVIERTO MIS FECHAS A UN FORMATO LEGIBLE.
        int diaI = fechaInicio.get(Calendar.DAY_OF_MONTH);
        int mesI = fechaInicio.get(Calendar.MONTH) + 1;
        int anioI = fechaInicio.get(Calendar.YEAR);
        String fechaInicio = String.valueOf(diaI) + "/" + String.valueOf(mesI) + "/" + String.valueOf (anioI);
        //-------------------
        int diaF = fechaFin.get(Calendar.DAY_OF_MONTH);
        int mesF = fechaFin.get(Calendar.MONTH) + 1;
        int anioF = fechaFin.get(Calendar.YEAR);
        String fechaFin = String.valueOf(diaF) + "/" + String.valueOf(mesF) + "/" + String.valueOf (anioF);
        //-------------------
        return ("• N° Reserva: " + numReserva + "\n---\n• Cliente:\n" + cliente + "\n---\n• Fecha Inicio: "
                + fechaInicio + "\n• Fecha Fin: " + fechaFin + "\n---\n• Autos:\n" + autos +
                "\n---\n• Total: $" + total);
    }
    
    // » OTROS MÉTODOS Y/O FUNCIONES DEFINIDOS/AS POR EL DESARROLLADOR
    
    public void calcularTotal(){ // También hubiésemos podido crear otro setTotal() « Sobrecarga »
           
        long MILISEGS_POR_DIA = 24 * 60 * 60 * 1000; 
        long cantDiasReserva = 0;
        double totalAux = 0;
    
        /* Ahora bien, ¿De qué va a depender el TOTAL de la reserva? De la cantidad de días que el
        Cliente alquile los autos y del costo de alquiler que, a su vez, cada auto tenga p/día. */
   
        // Calculo durante cuántos días es la reserva haciendo una "diferencia" entre mis dos fechas.
        cantDiasReserva = (fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis()) / MILISEGS_POR_DIA;
        
        cantDiasReserva++; /* Sumamos una unidad más dado que, por ejemplo, si yo saco un auto hoy y lo
        entrego mañana, pese a que la diferencia arroje '1 día', en realidad el auto yo lo voy a tener
        2 días (hoy y mañana) */
        
        // Una vez obtengo la cant. de días de la reserva, calculo el costo final p/cada auto y lo sumo al total.
        for (Auto auto: autos){
            totalAux += (auto.getPrecioAlquilerPorDia() * cantDiasReserva);
            //auto.setDisponibilidad(false); // A su vez, indicamos que dicho auto ha dejado de estar disponible.
        }
        
        total = totalAux;
    }
    
    public void cerrarReserva(){ // Si todo salió bien (el cliente volvió con los autos, etc.)...
        
        activa = false; // "Finalizamos" la reserva.
        
        // "Activamos" nuevamente los autos que estaban en uso.
        for (Auto auto: autos){
            auto.setDisponibilidad(true);
        }

    }
}
