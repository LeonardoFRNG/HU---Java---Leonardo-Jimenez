/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.corporatetalenthub;

import com.corporatetalenthub.modelo.Empleado;
import com.corporatetalenthub.modelo.EmpresaRecord;

public class App {

    public static void main(String[] args) {
        // Task 2 - Presentacion con Text Block (Java 15+). Permite escribir
        // texto multilinea sin concatenar con "+" ni escribir \n manualmente.
        String encabezado = """
                =====================================
                     CORPORATE TALENT HUB
                   Gestion del talento humano
                =====================================
                """;
        System.out.println(encabezado);

        Empleado empleado = crearEmpleadoDePrueba();
        EmpresaRecord empresa = new EmpresaRecord(
                "CodeUp Solutions",
                "900123456-7",
                2015);

        System.out.println(empleado);
        System.out.println("Empresa: " + empresa.nombre());
        System.out.println("Salario final: " + empleado.calcularSalarioFinal());
        System.out.println("Bono extra (ID par): " + empleado.tieneBonoExtra());
        System.out.println("Empleado elegible: " + empleado.validarElegibilidad());

        if (empleado.tieneBonoExtra()) {
            empleado.actualizarBonoMensual(100_000.0);
            System.out.println("Bono actualizado con +=: " + empleado.getBonoMensual());
        }

        compararReferencias();
        ejecutarLaboratorioDeNulos(empleado);
    }

    private static Empleado crearEmpleadoDePrueba() {
        return new Empleado(
                (byte) 3,             // byte
                (short) 2024,         // short
                102,                  // int: ID par -> activara tieneBonoExtra()
                1_023_456_789L,       // long: sufijo L obligatorio
                92.5f,                // float: sufijo f obligatorio
                3_000_000.0,          // double
                'I',                  // char: contrato indefinido
                true,                 // boolean
                "Laura Gomez",        // String (no primitivo)
                27,
                2,
                500_000.0);
    }

    /**
     * Task 4 - Comparacion de referencias con ==.
     */
    private static void compararReferencias() {
        Empleado primero = crearEmpleadoDePrueba();
        Empleado segundo = crearEmpleadoDePrueba();     
        Empleado aliasDelPrimero = primero;              

        System.out.println("primero == segundo: " + (primero == segundo));
        System.out.println("primero == aliasDelPrimero: "
                + (primero == aliasDelPrimero));

    }

    /**
     * Task 4 - Laboratorio de nulos y Helpful NullPointerExceptions.
     */
    private static void ejecutarLaboratorioDeNulos(Empleado empleado) {
        empleado.setNombre(null);

        try {
            System.out.println(empleado.getNombre().toUpperCase());
        } catch (NullPointerException excepcion) {
            System.out.println("NPE controlada: " + excepcion.getMessage());
        }

    }
}
