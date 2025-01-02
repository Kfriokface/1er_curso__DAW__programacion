
import java.util.Scanner;

public class primos {

  public static void main(String[] args) {
    
    int n;
    int contadorPrimos = 0;
    Scanner sc = new Scanner(System.in);

    System.out.println("Por favor introduce un número:");
    n = sc.nextInt();

    for (int i=0; i<=n; i++) {

      boolean esPrimo = true;

      if(i < 2) {
        esPrimo = false;
      } else {
        for (int j = 2; j<i; j++) {
          if (i % j == 0) {
            esPrimo = false; 
          }
        }
      }

      if(esPrimo) {
        contadorPrimos++;
      }

    }

    System.out.println("El número " + n + " contiene " + contadorPrimos + " números primos.");

    sc.close();
  }
  
}
