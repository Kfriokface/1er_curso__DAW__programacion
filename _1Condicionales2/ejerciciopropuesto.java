/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _1Condicionales2;

import java.util.Scanner;

public class ejerciciopropuesto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 500.0; // Saldo inicial para la simulación de cajero

        boolean continuar = true;
        while (continuar) {
            // Mostrar el menú
            System.out.println("Bienvenido al Sistema de Calculadora Interactiva");
            System.out.println("1. Realizar operación matemática (+, -, *, /)");
            System.out.println("2. Calcular el IMC (Índice de Masa Corporal)");
            System.out.println("3. Calcular descuento sobre un producto");
            System.out.println("4. Verificar si un número es par o impar");
            System.out.println("5. Simulación de cajero automático");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Operación matemática básica
                    System.out.print("Introduce el primer número: ");
                    double numero1 = scanner.nextDouble();
                    System.out.print("Introduce el segundo número: ");
                    double numero2 = scanner.nextDouble();
                    System.out.print("Introduce la operación (+, -, *, /): ");
                    char operacion = scanner.next().charAt(0);
                    double resultado = 0;
                    boolean operacionValida = true;

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

                    if (operacionValida) {
                        System.out.println("El resultado es: " + resultado);
                    }
                    break;

                case 2:
                    // Cálculo del IMC
                    System.out.print("Introduce tu peso en kg: ");
                    double peso = scanner.nextDouble();
                    System.out.print("Introduce tu altura en metros: ");
                    double altura = scanner.nextDouble();
                    double imc = peso / (altura * altura);
                    System.out.println("Tu índice de masa corporal es: " + imc);

                    if (imc < 18.5) {
                        System.out.println("Estás en la categoría de bajo peso.");
                    } else if (imc >= 18.5 && imc < 24.9) {
                        System.out.println("Estás en la categoría de peso normal.");
                    } else if (imc >= 25 && imc < 29.9) {
                        System.out.println("Estás en la categoría de sobrepeso.");
                    } else {
                        System.out.println("Estás en la categoría de obesidad.");
                    }
                    break;

                case 3:
                    // Cálculo de descuentos
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
                    break;

                case 4:
                    // Verificación de número par o impar
                    System.out.print("Introduce un número entero: ");
                    int numero = scanner.nextInt();
                    if (numero % 2 == 0) {
                        System.out.println(numero + " es un número par.");
                    } else {
                        System.out.println(numero + " es un número impar.");
                    }
                    break;

                case 5:
                    // Simulación de cajero automático
                    System.out.println("1. Consultar saldo");
                    System.out.println("2. Depositar dinero");
                    System.out.println("3. Retirar dinero");
                    System.out.print("Elige una opción: ");
                    int opcionCajero = scanner.nextInt();

                    if (opcionCajero == 1) {
                        System.out.println("Tu saldo actual es: " + saldo);
                    } else if (opcionCajero == 2) {
                        System.out.print("Introduce la cantidad a depositar: ");
                        double deposito = scanner.nextDouble();
                        saldo += deposito;
                        System.out.println("Has depositado " + deposito + ". Tu nuevo saldo es: " + saldo);
                    } else if (opcionCajero == 3) {
                        System.out.print("Introduce la cantidad a retirar: ");
                        double retiro = scanner.nextDouble();
                        if (retiro <= saldo) {
                            saldo -= retiro;
                            System.out.println("Has retirado " + retiro + ". Tu nuevo saldo es: " + saldo);
                        } else {
                            System.out.println("Fondos insuficientes.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 6:
                    continuar = false;
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();  // Espacio entre ejecuciones
        }

        scanner.close();
    }
}
