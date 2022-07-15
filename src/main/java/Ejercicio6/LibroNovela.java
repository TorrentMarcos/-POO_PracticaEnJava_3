/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author Marcos
 */

public class LibroNovela extends Libro {

    /* Posiblemente ni hacía falta implementar 'Herencia', dado lo poco que se está
    guardando por cada sub-clase particular, pero aprovechemos para jugar un poco y
    sacarnos el gustito de aplicarla al menos una vez */
    
   // » ATRIBUTOS
    
    private int tipoNovela; // 1 - FICCIÓN, 2 - ROMANCE, 3 - MISTERIO, 4 - JUVENILES, 5 - POLICIALES.
    
    // » CONSTRUCTORES
   
    public LibroNovela(){
    }
  
    public LibroNovela(long isbn, String titulo, int anio, String autores,
            Editorial editorial, int formato, double precio, int stock, int tipoNovela) {
        
        super(isbn, titulo, anio, autores, editorial, formato, precio, stock);
        this.tipoNovela = tipoNovela;

    }
    
    // » GETTERS & SETTERS (En su expresión más simple)

    public int getTipoNovela() {
        return tipoNovela;
    }

    public void setTipoNovela(int tipoNovela) {
        this.tipoNovela = tipoNovela;
    }
    
    // » TO STRING ()

    @Override
    public String toString() {
        
        String genero = "";
        
        switch (tipoNovela){
            case 1 -> genero = "Ciencia Ficción";
            case 2 -> genero = "Romance";
            case 3 -> genero = "Misterio";
            case 4 -> genero = "Juvenil";
            case 5 -> genero = "Policial";
            default -> genero = "Otro";
        }
        
        return super.toString() + "\n» Género: " + genero;
    }

}