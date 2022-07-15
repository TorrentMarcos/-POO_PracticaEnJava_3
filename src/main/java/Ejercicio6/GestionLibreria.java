/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */

public class GestionLibreria {
    
    // » ATRIBUTOS
    
    public static ArrayList<Libro> libros = new ArrayList();
    public static ArrayList<Pedido> pedidos = new ArrayList();
    public static ArrayList<Proveedor> proveedores = new ArrayList();
    public static ArrayList<Factura> facturas = new ArrayList();
    
    // » GETTERS & SETTERS

    public static ArrayList<Libro> getLibros() {
        return libros;
    }

    public static void setLibros(ArrayList<Libro> libros) {
        GestionLibreria.libros = libros;
    }

    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public static void setPedidos(ArrayList<Pedido> pedidos) {
        GestionLibreria.pedidos = pedidos;
    }

    public static ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public static void setProveedores(ArrayList<Proveedor> proveedores) {
        GestionLibreria.proveedores = proveedores;
    }

    public static ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public static void setFacturas(ArrayList<Factura> facturas) {
        GestionLibreria.facturas = facturas;
    }
    
    // » OTROS MÉTODOS Y/O FUNCIONES DEFINIDOS/AS POR EL DESARROLLADOR
    
    public static Libro buscarLibro(String nombre){
        
        Libro libroAux = null;
        
        for (Libro lib: libros){
            if (lib.getTitulo().equals(nombre)){
                libroAux = lib;
            }
        }
        
        return libroAux;
    }
  
}