package _ejercicios_clase;

import java.util.Scanner;

public class _primer_programa {
  public static void main(String[] args) {
      //Primer punto
    try (Scanner scanner = new Scanner(System.in)) {
      //Primer punto
      System.out.println("Por favor intruduce un número entero:");
      int num = scanner.nextInt();
      
      byte num_byte = (byte)num;
      short num_short = (short)num;
      long num_long = (long)num;
      
      System.out.println("El numero introducido en formato byte es: "  + num_byte);
      System.out.println("El numero introducido en formato short es: "  + num_short);
      System.out.println("El numero introducido en formato int es: "  + num);
      System.out.println("El numero introducido en formato long es: "  + num_long);
      
      //Segundo punto
      System.out.println("Por favor introduce un número decimal:");
      float decimal_1 = scanner.nextFloat();
      System.out.println("Por favor introduce otro número decimal:");
      float decimal_2 = scanner.nextFloat();
      
      if (decimal_1 == decimal_2) {
          System.out.println("Los dos números son iguales");
      } else {
          if (decimal_1 > decimal_2) {
              System.out.println(decimal_1 + " es mayor que " + decimal_2);
          } else {
              System.out.println(decimal_2 + " es mayor que " + decimal_1);
          }
      }
      
      //Tercer punto
      System.out.println("Por favor introduce un número entero:");
      int num1 = scanner.nextInt();
      System.out.println("Por favor introduce otro número entero:");
      int num2 = scanner.nextInt();
      
      boolean esMayor = num1 > num2;
      
      if (esMayor) {
          System.out.println("El número " + num1 + " es mayor que el " + num2);
      } else {
          System.out.println("El número " + num1 + " no es mayor que el " + num2);
      }
      
      //Cuarto punto
      final String STRING = "Esta variable es una constante";
      System.out.println(STRING);
      
      //Quinto punto
      System.out.println("Por favor introduce una nota del 0 al 10 (puedes usar decimales6):");
      float nota = scanner.nextFloat();
      
      if (nota < 5) {
          System.out.println("Insuficiente");
      } else if (nota >= 5 && nota < 6) {
          System.out.println("Suficiente");
      } else if (nota >= 6 && nota < 7) {
          System.out.println("Bien");
      } else if (nota >= 7 && nota < 9) {
          System.out.println("Notable");
      } else if (nota >= 9 && nota < 10) {
          System.out.println("Sobresaliente");
      } else {
          System.out.println("Error: nota no válida");
      }
      
      //Sexto punto
      System.out.println("Por favor introduce un día de la semana en forma numérica");
      int dia = scanner.nextInt();
      
      switch (dia) {
          case 1 -> System.out.println("lunes");
          case 2 -> System.out.println("martes");
          case 3 -> System.out.println("miércoles");
          case 4 -> System.out.println("jueves");
          case 5 -> System.out.println("viernes");
          case 6 -> System.out.println("sábado");
          case 7 -> System.out.println("domingo");
      }
    }
  }
}
