/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corporatetalenthub.modelo;

/**
 * Analisis (Task 2): un record reduce drasticamente la verbosidad frente a
 * Empleado. En UNA linea, Java genera automaticamente:
 *   - un constructor con estos 3 parametros,
 *   - accesores nombre(), nit() y anioFundacion()  (OJO: no getNombre()),
 *   - equals() y hashCode() basados en los componentes,
 *   - toString() legible.
 *
 * Inmutabilidad: los componentes de un record son finales por diseno; una vez
 * construido el objeto, no existe forma de reasignar nombre, nit o
 * anioFundacion. Esa inmutabilidad es "superficial": si un componente fuera
 * el a su vez un objeto mutable (por ejemplo una List), el contenido de ese
 * objeto interno todavia podria modificarse; lo unico que no cambia es CUAL
 * objeto referencia el componente.
 */
public record EmpresaRecord(
        String nombre,
        String nit,
        int anioFundacion) {
}
