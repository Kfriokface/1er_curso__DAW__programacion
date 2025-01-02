/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _1Condicionales2;

import java.util.Scanner;

public class CalculadoraConCondicionales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar números al usuario
        System.out.print("Introduce el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double numero2 = scanner.nextDouble();

        // Solicitar la operación al usuario
        System.out.print("Introduce la operación (+, -, *, /): ");
        char operacion = scanner.next().charAt(0);

        // Variables para almacenar el resultado
        double resultado = 0;
        boolean operacionValida = true;

        // Condicionales para realizar la operación correspondiente
        if (operacion == '+') {
            resultado = numero1 + numero2;
        } else if (operacion == '-') {
            resultado = numero1 - numero2;
        } else if (operacion == '*') {
            resultado = numero1 * numero2;
        } else if (operacion == '/') {
            if (numero2 != 0) {
                resultado = numero1 / numero2;
            } else {
                System.out.println("Error: No se puede dividir entre cero.");
                operacionValida = false;
            }
        } else {
            System.out.println("Operación no válida.");
            operacionValida = false;
        }

        // Mostrar el resultado si la operación fue válida
        if (operacionValida) {
            System.out.println("El resultado es: " + resultado);
        }
    }
}

