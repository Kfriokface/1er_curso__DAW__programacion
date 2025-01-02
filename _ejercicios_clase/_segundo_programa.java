package _ejercicios_clase;

import java.util.Locale;
import java.util.Scanner;  

public class _segundo_programa {
  public static void main(String[] args) {
    try(Scanner scn = new Scanner(System.in).useLocale(Locale.US)) {

      System.out.println("Bienvenido al Sistema de Calculadora Interactiva");
      System.out.println("1. Realizar operación matemática (+, -, *, /)");
      System.out.println("2. Calcular el IMC (Índice de Masa Corporal)");
      System.out.println("3. Calcular descuento sobre un producto");
      System.out.println("4. Verificar si un número es par o impar");
      System.out.println("5. Simulación de cajero automático");
      System.out.println("6. Salir");
      System.out.print("Elige una opción: ");
      int option = scn.nextInt();

      switch (option) {
        case 1 -> {
          System.out.println("Elije una operación matemática: (+, -, *, /)");
          char operator = scn.next().charAt(0);
          System.out.println("Introduce un número");
          float num1 = scn.nextFloat();
          System.out.println("Introduce otro número");
          float num2 = scn.nextFloat();

          float resultado = 0;
          boolean operacionValida = true;

          switch (operator) {
            case '+' -> resultado = num1 + num2;
            case '-' -> resultado = num1 - num2;
            case '*' -> resultado = num1 * num2;
            case '/' -> {
              if (num2 != 0) {
                resultado = num1 / num2;
              } else {
                System.out.println("Error: No se puede dividir entre cero.");
                operacionValida = false;
              } 
            }
            default -> {
              System.out.println("Operación no válida.");
                operacionValida = false;
            }
          }
          if (operacionValida) {
            System.out.println("El resultado es: " + resultado);
          }
        }
        case 2 -> {
          System.out.print("Introduce tu peso en kg: ");
          double peso = scn.nextDouble();
  
          System.out.print("Introduce tu altura en metros: ");
          double altura = scn.nextDouble();
  
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
        }
        case 3 -> {
          System.out.print("Introduce el precio original: ");
          double precioOriginal = scn.nextDouble();
  
          System.out.print("Introduce el porcentaje de descuento: ");
          double descuento = scn.nextDouble();
  
          if (descuento >= 0 && descuento <= 100) {
              double precioFinal = precioOriginal - (precioOriginal * descuento / 100);
              System.out.println("El precio con descuento es: " + precioFinal);
          } else {
              System.out.println("Porcentaje de descuento no válido.");
          }
        }
        case 4 -> {
          System.out.println("Introduce un número:");
          int num3 = scn.nextInt();

          if (num3 % 2 == 0) {
            System.out.println("El número " + num3 + " es un número par.");
          } else {
            System.out.println("El número " + num3 + " es un número impar.");
          }
        }
        case 5 -> {
          double saldo = 500.0; // Saldo inicial

          System.out.println("Bienvenido al cajero automático.");
          System.out.println("1. Consultar saldo");
          System.out.println("2. Depositar dinero");
          System.out.println("3. Retirar dinero");
          System.out.print("Selecciona una opción: ");
          int opcion = scn.nextInt();
  
          // Ejecutar la opción seleccionada
          switch (opcion) {
            case 1 -> System.out.println("Tu saldo actual es: " + saldo);
            case 2 -> {
              System.out.print("Introduce la cantidad a depositar: ");
              double deposito = scn.nextDouble();
              saldo += deposito;
              System.out.println("Has depositado " + deposito + ". Tu nuevo saldo es: " + saldo);
            }
            case 3 -> {
              System.out.print("Introduce la cantidad a retirar: ");
              double retiro = scn.nextDouble();
              if (retiro <= saldo) {
                  saldo -= retiro;
                  System.out.println("Has retirado " + retiro + ". Tu nuevo saldo es: " + saldo);
              } else {
                  System.out.println("Fondos insuficientes.");
              }
            }
            default -> System.out.println("Opción no válida.");
          }
        }
        case 6 -> System.out.println("¡Hasta luego Lucas!.");
        default -> throw new AssertionError("Por favor, elije una opción válida");
      }

      scn.close();
    }
  }
}
