/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author Marcos
 */
public class LibroTecnico extends Libro {
    
    // » ATRIBUTOS
    
    private int tipoTecnico; // 1 - INGENIERÍA, 2 - CS. NATURALES, 3 - CS. SOCIALES
    
    // » CONSTRUCTORES

    public LibroTecnico() {
    }

    public LibroTecnico(long isbn, String titulo, int anio, String autores,
            Editorial editorial, int formato, double precio, int stock, int tipoTecnico) {
        
        super(isbn, titulo, anio, autores, editorial, formato, precio, stock);
        this.tipoTecnico = tipoTecnico;
    }
    
    // » GETTERS & SETTERS (En su expresión más simple)

    public int getTipoTecnico() {
        return tipoTecnico;
    }

    public void setTipoTecnico(int tipoTecnico) {
        this.tipoTecnico = tipoTecnico;
    }
    
    // » TO STRING ()

    @Override
    public String toString() {
        
        String categoria = "";
        
        switch (tipoTecnico){
            case 1 -> categoria = "Ingeniería";
            case 2 -> categoria = "Ciencias Naturales";
            case 3 -> categoria = "Ciencias Sociales";
            default -> categoria = "Otra";
        }
        
        return super.toString() + "\n» Categoría: " + categoria;
    }
    
}