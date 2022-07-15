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

public class Proveedor {
    
    // » ATRIBUTOS
    
    private String razonSocial;
    private String telefono;
    private String direccion;
    private String email;
    private ArrayList<Editorial> editoriales; // No creo que lo usemos, pero...
                                              // Podría ser importante chusmear todas las editoriales que trabaja
                                              // un proveedor determinado.
    
    // » CONSTRUCTORES

    public Proveedor() {
    }

    public Proveedor(String razonSocial, String telefono, String direccion, String email) {
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.editoriales = new ArrayList();
    }

    public Proveedor(String razonSocial, String telefono, String direccion, String email,
            ArrayList<Editorial> editoriales) {
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.editoriales = editoriales;
    }
    
    // » GETTERS & SETTERS (En su expresión más simple)

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Editorial> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(ArrayList<Editorial> editoriales) {
        this.editoriales = editoriales;
    }
    
    // TO STRING ()

    @Override
    public String toString() {
        return ("» Razón social: " + razonSocial + "\n» Teléfono: " + telefono +
                "\n» Direccion: " + direccion + "\n» Email: " + email);
        
    }
    
    public String toStringConEditoriales(){
        return ("» Razón social: " + razonSocial + "\n» Teléfono: " + telefono +
                "\n» Direccion: " + direccion + "\n» Email: " + email
                + "\n» Editoriales: " + editoriales);
    }

}