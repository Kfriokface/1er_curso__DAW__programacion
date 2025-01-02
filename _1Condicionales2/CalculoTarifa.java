/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _1Condicionales2;

import java.util.Scanner;

public class CalculoTarifa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tarifa base
        double tarifaBase = 100.0;

        // Solicitar la edad del usuario
        System.out.print("Introduce tu edad: ");
        int edad = scanner.nextInt();

        double tarifaFinal = tarifaBase;

        // Verificar condiciones de descuento
        if (edad < 12) {
            tarifaFinal = tarifaBase * 0.5; // 50% de descuento
            System.out.println("Te corresponde un 50% de descuento.");
        } else if (edad >= 65) {
            tarifaFinal = tarifaBase * 0.7; // 30% de descuento
            System.out.println("Te corresponde un 30% de descuento.");
        } else {
            System.out.println("No tienes descuento.");
        }

        System.out.println("El total a pagar es: " + tarifaFinal);
    }
}
