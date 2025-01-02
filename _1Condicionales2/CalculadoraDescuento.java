/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _1Condicionales2;

import java.util.Scanner;

public class CalculadoraDescuento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el precio original: ");
        double precioOriginal = scanner.nextDouble();

        System.out.print("Introduce el porcentaje de descuento: ");
        double descuento = scanner.nextDouble();

        if (descuento >= 0 && descuento <= 100) {
            double precioFinal = precioOriginal - (precioOriginal * descuento / 100);
            System.out.println("El precio con descuento es: " + precioFinal);
        } else {
            System.out.println("Porcentaje de descuento no válido.");
        }
    }
}

