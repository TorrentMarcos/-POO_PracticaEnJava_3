/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Marcos
 */

public class Pedido {
    
    // » ATRIBUTOS
    
    private static int contadorId = 1; 
    
    private int numPedido;
    private String cliente;                     // El 'Cliente', idealmente, debería ser una Clase.
    private GregorianCalendar fecha;            // En este caso, lo obviaré para simplificar un poco la resolución.        
    private ArrayList<ItemFactura> articulos;   // Dado que un 'Pedido' es parecido a una 'Factura', aprovecho 'Item'.
    private double total;                       // Podríamos incluso renombrar la clase a 'Item' (más genérico).
                                                // El total podríamos dejarlo o sacarlo. Dependerá del caso.
    
    // » CONSTRUCTORES
    
    public Pedido() {
    }
    
    public Pedido(String cliente, GregorianCalendar fecha, ArrayList<ItemFactura> articulos) {
        this.numPedido = contadorId++;
        this.cliente = cliente;
        this.fecha = fecha;
        this.articulos = articulos;
        this.total = obtenerMontoPedido();
    }
    
    // » GETTERS & SETTERS (En su expresión más simple)

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
    
    // » TO STRING ()

    @Override
    public String toString() {
        
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int anio = fecha.get(Calendar.YEAR);
        String fechaPedido = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf (anio);

        return ("» N°Pedido: "+ numPedido + "\n» Cliente: " + cliente + "\n» Fecha: " + fechaPedido +
                "\n» Articulos: " + articulos + "\n Total: $" + total);
    }
    
    // » OTROS MÉTODOS Y/O FUNCIONES DEFINIDOS/AS POR EL DESARROLLADOR
    
    public double obtenerMontoPedido(){ // IDÉNTICO AL DE 'FACTURA'. 
        
        total = 0;

        for (int i=0; i<articulos.size(); i++){
            total += articulos.get(i).getSubtotal();
        }
        
        return total;
    }
    
}
