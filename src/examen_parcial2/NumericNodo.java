/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_parcial2;

/**
 *
 * @author XAVIER ALEXANDRO PADILLA ARELLANO
 */
public class NumericNodo {
    private Object valor;
    private double prioridad;
    private NumericNodo enlace;

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public double getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(double prioridad) {
        this.prioridad = prioridad;
    }

    public NumericNodo getEnlace() {
        return enlace;
    }

    public void setEnlace(NumericNodo enlace) {
        this.enlace = enlace;
    }
}