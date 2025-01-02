package _bucles;

import java.util.Scanner;

public class CalcularFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();
        int factorial = 1;

        while (numero > 0) {
            factorial *= numero;
            numero--;
        }
        System.out.println("El factorial es: " + factorial);
        scanner.close();
    }
}
