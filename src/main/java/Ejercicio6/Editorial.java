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

class Editorial {
    
    // » ATRIBUTOS
    
    private String nombre;
    private ArrayList<Proveedor> proveedores;
    
    // » CONSTRUCTORES

    public Editorial() {
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
        this.proveedores = new ArrayList();
    }

    public Editorial(String nombre, ArrayList<Proveedor> proveedores) {
        this.nombre = nombre;
        this.proveedores = proveedores;
    }
    
    // GETTERS & SETTERS ()

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    // TO STRING ()

    @Override
    public String toString() {
        return "• Nombre: " + nombre + "\n • Proveedores: " + proveedores;
    }

}
