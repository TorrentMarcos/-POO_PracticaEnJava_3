/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author Marcos
 */

public class Cliente {
    
    // » ATRIBUTOS
    
    private int cod_cliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    
    // » CONSTRUCTORES

    public Cliente() {
        
    }

    public Cliente(int cod_cliente, String nombre, String apellido, String dni,
            String direccion, String telefono) {
        this.cod_cliente = cod_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    // » GETTERS & SETTERS (En su expresión más simple)

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
        
        /* Acá algo que también hubiésemos podido hacer, es configurar el
        setter como PRIVATE e invocarlo sólo desde el constructor haciendo,
        de paso, que el código se genere "automáticamente" acorde a un
        determinado patrón dentro del método (ej. DNI + PRIMEROS 3 NÚM
        TELEFONO). Se supone que, una vez creado este código, no debería
        / tendría que poder alterarse "jamás". Menos si están automatizados. */
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    // » TO STRING ()

    @Override
    public String toString() {
        return "» Cód. Cliente: " + cod_cliente + "\n» Nombre: " + nombre + "\n» Apellido: " + apellido + 
                "\n» Dni:" + dni + "\n» Direccion: " + direccion + "\n» Teléfono: " + telefono;
    }
   
}