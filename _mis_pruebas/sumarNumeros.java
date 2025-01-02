import java.util.Scanner;

public class sumarNumeros {
    public static void main(String[] args) {
        char seguir;
        int acumulador, numero;

        Scanner teclado = new Scanner(System.in);

        acumulador = 0;
        do
        {
            System.out.printf("Introduzca un número entero: ");
            numero = teclado.nextInt();

            acumulador += numero;

            System.out.printf("¿Desea introducir otro número (s/n)?: ");
            seguir = teclado.next().charAt(0);
        }
        while(seguir!='n');

        System.out.printf("La suma de los números introducidos es: %d", acumulador);
    }
}