/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.util.ArrayList;

/**
 *
 * @author Marcos
 */

public class Alumno { 
    
    // » ATRIBUTOS
    
    private int legajo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private ArrayList <Float> notas; 
    
    // » CONSTRUCTORES

    public Alumno() { // CONSTRUCTOR GÉNERAL.
        
    }
                      // CONSTRUCTOR C/TODO MENOS NOTAS.
    public Alumno(int legajo, String nombre, String apellido, String telefono, String email) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.notas = null;
    }
    
    // » GETTERS & SETTERS (De carácter simple)

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Float> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Float> notas) {
        this.notas = notas;
    }
    
    // » TO STRING ()

    @Override
    public String toString() {
        return ("Legajo: " + legajo + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nTelefono: " + telefono + "\nEmail: " + email + "\nNotas: " + notas);
    }
   
}
