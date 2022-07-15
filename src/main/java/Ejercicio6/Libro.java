/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author Marcos
 */

public abstract class Libro {
    
    // » ATRIBUTOS
    
    private long isbn;      // También podría ser un String.
    private String titulo;
    private int anio;
    private String autores; // También podría ser un ArrayList de una clase 'Autor'.
    private Editorial editorial;
    private int formato;    // 1 - TAPA DURA || 2 - EDICIÓN ECONÓMICA.
    private double precio;  // El ejercicio no lo pide pero, si voy a vender, lo considero necesario.
    private int stock; 
    
    // » CONSTRUCTORES
    
    public Libro() {
    }

    public Libro(long isbn, String titulo, int anio, String autores, 
            Editorial editorial, int formato, double precio, int stock) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.autores = autores;
        this.editorial = editorial;
        this.formato = formato;
        this.precio = precio;
        this.stock = stock;
    }
    
    // » GETTERS & SETTERS (En su expresión más simple)

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public int getFormato() {
        return formato;
    }

    public void setFormato(int formato) {
        this.formato = formato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    // TO STRING ()

    @Override
    public String toString() {
        
        String formatoAux = "";
        
        if (formato == 1){
            formatoAux = "Tapa dura";
        }
        if (formato == 2){
            formatoAux = "Versión económica";
        }
        
        return ("» ISBN: " + isbn + "\n» Título: " + titulo + "\n» Año: " + anio + "\n» Autor(es): "
                + autores + "\n» Editorial: " + editorial.getNombre() + "\n» Formato: " + formatoAux +
                "\n» Precio: $" + precio + "\n» Stock: " + stock);
    }
    
    public String toStringSinStock(){
        
        String formatoAux = "";
        
        if (formato == 1){
            formatoAux = "Tapa dura";
        }
        if (formato == 2){
            formatoAux = "Versión económica";
        }
        
        return ("» ISBN: " + isbn + "\n» Título: " + titulo + "\n» Año: " + anio + "\n» Autor(es):"
                + autores + "\n» Editorial: " + editorial + "\n» Formato:" + formatoAux +
                "\n» Precio: $" + precio);
    }
    
    // OTROS MÉTODOS Y/O FUNCIONES DEFINIDOS/AS POR EL DESARROLLADOR
    public void descontarStock(int cantidad){
        
        if (cantidad <= stock){
            stock = stock - cantidad;
        }
    }
       
}
