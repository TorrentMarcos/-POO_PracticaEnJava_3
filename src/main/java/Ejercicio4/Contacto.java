/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.io.Serializable;

/**
 *
 * @author Marcos
 */

public class Contacto implements Serializable { // IMPLEMENTO UNA INTERFACE PARA SERIALIZAR.
    
    /* Mediante el uso de esta interface, voy a poder convertir y guardar mis
    objetos en modo de una 'secuencia de bytes', que posteriormente podrá ser 
    reconstruida y así restaurar el objeto original. */
    
    // » ATRIBUTOS
    
    private String nombre;
    private String apellido;
    private String tel_linea;
    private String tel_movil;
    private String tel_trabajo;
    private String email;
    private int conozcoDe;
    // 'ConozcoDe' -> 1. FAMILIA, 2. UNIV, 3. TRAB, 4. CLUB, 5. Otro.
    
    // » CONSTRUCTORES

    public Contacto() { // CONSTRUCTOR GENÉRICO
        
    }
                        // CONSTRUCTOR C/ TODOS LOS PARÁMETROS.
    public Contacto(String nombre, String apellido, String tel_linea,
            String tel_movil, String tel_trabajo, String email, int conozcoDe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tel_linea = tel_linea;
        this.tel_movil = tel_movil;
        this.tel_trabajo = tel_trabajo;
        this.email = email;
        this.conozcoDe = conozcoDe;
    }
    
    // » GETTERS & SETTERS (En su expresión más simple).

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

    public String getTel_linea() {
        return tel_linea;
    }

    public void setTel_linea(String tel_linea) {
        this.tel_linea = tel_linea;
    }

    public String getTel_movil() {
        return tel_movil;
    }

    public void setTel_movil(String tel_movil) {
        this.tel_movil = tel_movil;
    }

    public String getTel_trabajo() {
        return tel_trabajo;
    }

    public void setTel_trabajo(String tel_trabajo) {
        this.tel_trabajo = tel_trabajo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getConozcoDe() {
        return conozcoDe;
    }

    public void setConozcoDe(int conozcoDe) {
        this.conozcoDe = conozcoDe;
    }
    
    // » TO STRING ()

    @Override
    public String toString() {
        
        return ("» Nombre: " + nombre + "\n» Apellido: " + apellido + "\n» (Tel.) Línea: " + tel_linea +
                "\n» (Tel.) Móvil: " + tel_movil + "\n» (Tel.) Trabajo: " + tel_trabajo +
                "\n» Email: " + email + "\n» Vínculo: " + determinarVinculo());
    }
    
    // MÉTODOS Y/O FUNCIONES "EXTRA" DEFINIDOS/AS POR EL DESARROLLADOR
    
    public String determinarVinculo(){
        
        String vinculo = "";
        
        vinculo = switch (conozcoDe) {
            case 1 -> "Familia";
            case 2 -> "Universidad";
            case 3 -> "Trabajo";
            case 4 -> "Club";
            case 5 -> "Otro";
            default -> "No específicado";
        }; 
     
    return vinculo;    
        
    }
    
}