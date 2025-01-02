package _mis_pruebas;

import java.util.Scanner;

public class _rombos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la altura del rombo (número impar): ");
        int altura = scanner.nextInt();

        // Validar que la altura sea impar
        if (altura % 2 == 0) {
            System.out.println("Por favor, introduce un número impar.");
            return;
        }

        int mitad = altura / 2;

        // Parte superior del rombo
        for (int i = 0; i <= mitad; i++) {
            // Imprimir espacios
            for (int j = 0; j < mitad - i; j++) {
                System.out.print(" ");
            }
            // Imprimir asteriscos
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Parte inferior del rombo
        for (int i = mitad - 1; i >= 0; i--) {
            // Imprimir espacios
            for (int j = 0; j < mitad - i; j++) {
                System.out.print(" ");
            }
            // Imprimir asteriscos
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
