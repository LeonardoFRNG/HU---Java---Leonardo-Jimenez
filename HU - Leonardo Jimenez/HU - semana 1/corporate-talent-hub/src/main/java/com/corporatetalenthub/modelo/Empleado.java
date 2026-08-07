/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corporatetalenthub.modelo;

/**
 * Modelo tradicional (estilo Java 8): clase con campos, constructor, getters,
 * setter y metodos explicitos.
 *
 * Analisis (Task 2): comparada con un Record, esta clase es mucho mas verbosa
 * porque cada pieza (constructor, accesores, toString) debe escribirse a mano.
 * Esa verbosidad se justifica porque empleado necesita estado MUTABLE:
 * el nombre y el bono mensual pueden cambiar despues de creado el objeto
 * (ver setNombre y actualizarBonoMensual). Un Record no permite eso porque
 * sus componentes son finales.
 */
public class Empleado {

    //  Los 8 tipos primitivos exigidos por la HU 
    private byte nivelAcceso;      // entero muy pequeno (-128 a 127)
    private short anioIngreso;     // entero de rango intermedio
    private int idEmpleado;        // entero estandar
    private long numeroDocumento;  // entero grande, requiere sufijo L en el literal
    private float puntajeTest;     // decimal de precision simple, requiere sufijo f
    private double salarioBase;    // decimal de precision doble por defecto en Java
    private char tipoContrato;     // un unico caracter, comillas simples: 'I'
    private boolean esActivo;      // true / false

    // String no es primitivo: es una clase. esta  variable guarda una
    // referencia a un objeto String en el Heap, no el texto en si.
    private String nombre;

    // Datos adicionales necesarios para las reglas de negocio (Task 3).
    private int edad;
    private int idSede;
    private double bonoMensual;

    public Empleado(
            byte nivelAcceso,
            short anioIngreso,
            int idEmpleado,
            long numeroDocumento,
            float puntajeTest,
            double salarioBase,
            char tipoContrato,
            boolean esActivo,
            String nombre,
            int edad,
            int idSede,
            double bonoMensual) {
        this.nivelAcceso = nivelAcceso;
        this.anioIngreso = anioIngreso;
        this.idEmpleado = idEmpleado;
        this.numeroDocumento = numeroDocumento;
        this.puntajeTest = puntajeTest;
        this.salarioBase = salarioBase;
        this.tipoContrato = tipoContrato;
        this.esActivo = esActivo;
        this.nombre = nombre;
        this.edad = edad;
        this.idSede = idSede;
        this.bonoMensual = bonoMensual;
    }

    /*
     * Task 3 

     */
    public double calcularSalarioFinal() {
        return (salarioBase + (bonoMensual * 1.10))
                - (salarioBase * 0.05);
    }


    public boolean tieneBonoExtra() {
        return idEmpleado % 2 == 0;
    }

 
    public boolean validarElegibilidad() {
        return (puntajeTest > 85 && edad < 30)
                || (idSede == 1 && !esActivo);
    }


    public void actualizarBonoMensual(double incremento) {
        bonoMensual += incremento;
    }

    // getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getBonoMensual() {
        return bonoMensual;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nivelAcceso=" + nivelAcceso +
                ", anioIngreso=" + anioIngreso +
                ", idEmpleado=" + idEmpleado +
                ", numeroDocumento=" + numeroDocumento +
                ", puntajeTest=" + puntajeTest +
                ", salarioBase=" + salarioBase +
                ", tipoContrato=" + tipoContrato +
                ", esActivo=" + esActivo +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", idSede=" + idSede +
                ", bonoMensual=" + bonoMensual +
                '}';
    }
}   
