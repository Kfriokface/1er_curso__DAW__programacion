
import java.util.Scanner;

public class esNumero {
  public static void main(String[] args) {

      Scanner teclado = new Scanner(System.in);
      System.out.print("Mete un número:");
      int num = 0;
      boolean esNumero = false; // la inicializo en false... ya habrá tiempo de decidir si es un númer
      do { 
        if(teclado.hasNextInt()) {
          num = teclado.nextInt();
          esNumero = true;
        }
        else {
          teclado.next();
          System.out.print("Mete un número tolai:");
        }
          
      } while (!esNumero); // Hasta que no sea un número vas a estar aquí

      System.out.printf("El número que has metido es %d", num);

      teclado.close();
  }
}
