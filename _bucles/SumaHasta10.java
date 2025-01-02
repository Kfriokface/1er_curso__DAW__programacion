package _bucles;

import java.util.Scanner;

public class SumaHasta10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;

        do {
            System.out.print("Introduce un número: ");
            int numero = scanner.nextInt();
            suma += numero;
        } while (suma < 10);

        System.out.println("La suma ha alcanzado o superado 100. Total: " + suma);
        scanner.close();
    }
}
