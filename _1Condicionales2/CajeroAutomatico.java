/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _1Condicionales2;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = 500.0; // Saldo inicial

        System.out.println("Bienvenido al cajero automático.");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();

        // Ejecutar la opción seleccionada
        if (opcion == 1) {
            System.out.println("Tu saldo actual es: " + saldo);
        } else if (opcion == 2) {
            System.out.print("Introduce la cantidad a depositar: ");
            double deposito = scanner.nextDouble();
            saldo += deposito;
            System.out.println("Has depositado " + deposito + ". Tu nuevo saldo es: " + saldo);
        } else if (opcion == 3) {
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
    }
}
