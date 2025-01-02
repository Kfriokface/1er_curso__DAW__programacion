package _bucles;

import java.util.Scanner;

public class ImprimirImparesEntre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el primer número: ");
        int inicio = scanner.nextInt();
        
        System.out.print("Introduce el segundo número: ");
        int fin = scanner.nextInt();

        for (int i = inicio; i <= fin; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}
