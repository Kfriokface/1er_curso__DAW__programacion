package _bucles;

public class Suma1a100 {
    public static void main(String[] args) {
        int suma = 0;
        int i = 1;
        while (i <= 100) {
            suma += i;
            i++;
        }
        System.out.println("La suma es: " + suma);
    }
}
