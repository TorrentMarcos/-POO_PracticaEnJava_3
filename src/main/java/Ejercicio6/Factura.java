/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Marcos
 */

public class Factura {
    
    // » ATRIBUTOS
    private static int contadorId = 1; 
    
    private int numeroFactura;                // ¿Y el tipo de factura? ¡También podría estar si se quiere!
    private String razonSocial;               // Acá, incluso, podríamos tener una clase para el 'Cliente'.
    private GregorianCalendar fecha;                       // Agregamos el atributo fecha dado que se considera importante.          
    private ArrayList<ItemFactura> articulos; // Voy a trabajar la factura con un ArrayList basado en su "Detalle".
    private double total;                     // Atributo que se calculará con los subtotales de cada ItemFactura.
    
    // » CONSTRUCTORES
    
    public Factura(){
    }

    public Factura(String razonSocial, GregorianCalendar fecha,
            ArrayList<ItemFactura> articulos) {
        this.numeroFactura = contadorId++;
        this.razonSocial = razonSocial;
        this.fecha = fecha;
        this.articulos = articulos;
        this.total = obtenerMontoFactura();
    }
    
    // » GETTERS & SETTERS (En su expresión más simple)
    
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public ArrayList<ItemFactura> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<ItemFactura> articulos) {
        this.articulos = articulos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    // « OTROS MÉTODOS Y/O FUNCIONES DEFINIDOS/AS POR EL DESARROLLADOR »
    
    public double obtenerMontoFactura(){
        
        total = 0;
        
        /* Inicializo el total dado que, al aplicar el método 2 veces, se
        sumaría el total dos veces (obteniéndose un valor erróneo). A lo sumo,
        lo que podría hacer para sacar esta línea es convertir el método en
        PRIVATE y que éste sólo pueda ejecutarse internamente mediante el
        constructor. (el cual sólo lo ejecuta 1 vez) */
    
        for (int i=0; i<articulos.size(); i++){
            total += articulos.get(i).getSubtotal();
        }
        
        return total;
        
    }
    
    // » TO STRING ()

    @Override
    public String toString() {
        
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int anio = fecha.get(Calendar.YEAR);
        String fechaFactura = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf (anio);
        //-------------------
        return "» N° Factura: " + numeroFactura + "\n» Razón Social (Cliente): " + razonSocial +
                "\n» Fecha: " + fechaFactura + "\n» Articulos: " + articulos + "\n» Total: $" + total;
    }
    
}