/*
IMC = Peso/(altura)^2
Locale localeUS = Locale.US;       // Inglés de EE.UU.
Locale localeUK = Locale.UK;       // Inglés del Reino Unido
Locale localeFR = Locale.FRANCE;   // Francés de Francia
Locale localeES = Locale.SPAIN;    // Español de España
 */

package _1Condicionales2;

//Para evitar la excepción al poner . en double
//import java.util.Locale;  

import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {
        
        //Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        Scanner scanner = new Scanner(System.in);

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
    }
}
