package _bucles;

import java.util.Scanner;

public class CalcularPromedioCalificaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;
        int contador = 0;

        while (contador < 5) {  // Limita el bucle a 5 calificaciones
            System.out.print("Introduce una calificación (negativo para terminar): ");
            int calificacion = scanner.nextInt();
            if (calificacion < 0) {
                break;  // Termina el bucle si se ingresa un valor negativo
            }
            suma += calificacion;
            contador++;

            if (contador == 5) {
                System.out.println("Ya se han ingresado 5 calificaciones.");
            }
        }

        if (contador > 0) {
            double promedio = (double) suma / contador;
            System.out.println("El promedio es: " + promedio);
        } else {
            System.out.println("No se ingresaron calificaciones.");
        }
        scanner.close();
    }
}

