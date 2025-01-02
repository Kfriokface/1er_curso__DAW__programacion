package _mis_pruebas;

public class _clases_envolventes {
  public static void main(String [] args) {


          // Tipo primitivo
          int numeroPrimitivo = 200;
  
          // Tipo no primitivo (clase envolvente Integer)
          Integer numeroNoPrimitivo = 100;
  
          // Comparación
          if (numeroPrimitivo == numeroNoPrimitivo) {
              System.out.println("Son iguales");
          } else {
              System.out.println("Son diferentes");
          }
  
          // Esto es posible porque Java realiza "autoboxing", que convierte automáticamente entre primitivos y sus clases envolventes

  }
}