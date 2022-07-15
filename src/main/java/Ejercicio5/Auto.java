/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author Marcos
 */

public class Auto {
    
    // » ATRIBUTOS
    
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int cant_plazas;
    
    private double precioAlquilerPorDia;
    private boolean disponibilidad;
    
    // » CONSTRUCTORES

    public Auto() {
        
    }

    public Auto(String matricula, String marca, String modelo, String color,
            int cant_plazas, double precioAlquilerPorDia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cant_plazas = cant_plazas;
        this.precioAlquilerPorDia = precioAlquilerPorDia;
        this.disponibilidad = true;
    }
    
    // » GETTERS & SETTERS (En su expresión más simple)

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCant_plazas() {
        return cant_plazas;
    }

    public void setCant_plazas(int cant_plazas) {
        this.cant_plazas = cant_plazas;
    }

    public double getPrecioAlquilerPorDia() {
        return precioAlquilerPorDia;
    }

    public void setPrecioAlquilerPorDia(double precioAlquilerPorDia) {
        this.precioAlquilerPorDia = precioAlquilerPorDia;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    // » TO STRING ()

    @Override
    public String toString() {
        return ("\n» Matrícula: " + matricula + "\n» Marca: " + marca + "\n» Modelo: " + modelo +
                "\n» Color: " + color + "\n» Cant. Plazas: " + cant_plazas + "\n» Precio alquiler (p/Día): $"
                + precioAlquilerPorDia + "\n» Disponibilidad: " + disponibilidad + "\n");
    }

}