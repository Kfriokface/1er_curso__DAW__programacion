
import java.util.Scanner;

public class factorial {

    public static int resultado;
    public static int contador;

    public static void main(String[] args) {
        int n;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca un número: ");
        n = teclado.nextInt();

        // Si if/else solo contienen una instrucción se pueden declarar sin llaves {}.5
        if (n > 0)
         System.out.printf("%d! = %d", n, calcFactorial(n)); 
        else
         System.out.printf("ERROR: El número debe ser mayor que cero.");
        
        teclado.close();
    }

    private static int calcFactorial(int numero) {
        resultado = numero;
        while (numero > 2) {
            numero -= 1;
            resultado *= numero;
        }

        return resultado;
    }

    private static int calcFactorialRecursivo(int numero) {
        System.out.println(resultado);
        if (numero != 1)
          resultado = calcFactorialRecursivo(numero - 1) * numero; 
        else
          resultado = 1;

        return resultado;
    }
}
