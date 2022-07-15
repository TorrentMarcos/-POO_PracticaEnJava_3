/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author Marcos
 */

public class ItemFactura {
    
    // » ATRIBUTOS 
    
    private Libro articulo;
    private int cantidad;
    private double subtotal;
    
    // » CONSTRUCTORES
    
    public ItemFactura(){  
    }

    public ItemFactura(Libro articulo, int cantidad) {
        
        this.articulo = articulo;
        setCantidad(cantidad);
        this.subtotal = (articulo.getPrecio() * this.cantidad);
    }
    
    // » GETTERS & SETTERS

    public Libro getArticulo() {
        return articulo;
    }

    public void setArticulo(Libro articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        
        if (cantidad > 0){
            this.cantidad = cantidad;
        }
        else {
            System.out.println("Cantidad menor o igual a '0'. En caso de haberse introducido"
                              + " un valor negativo, la cantidad quedará auto-seteada en '0'");
            this.cantidad = 0;
        }
        
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    // »  TO STRING ()

    @Override
    public String toString() {
        return "\n\t" + articulo.getTitulo() + " || Cantidad: " + cantidad + " || Subtotal: " + subtotal;
    }

}
