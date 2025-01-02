package _bucles;

import java.util.Locale;
import java.util.Scanner;

public class ejercicioTutoria {
  public static void main(String[] args) {

    // Settings iniciales
    int contador = 0;
    int numMaxCalificaciones = 5;
    int max = 10;
    int min = -10;
    int contadorPositivo = 0;
    int contadorNegativo = 0;
    int ceropatatero = 0;
    float suma = 0;
    float sumaPositivas = 0;
    float sumaNegativas = 0;
    float calificacionMax = 0;
    float calificacionMin = 0;

    Scanner Scn = new Scanner(System.in).useLocale(Locale.ENGLISH);
    
    while (contador < 5) {
      //Se recoge la calificación
      System.out.println("Introduce un numero entre -10 y 10:");
      float calificacion = Scn.nextFloat();

      if (contador == 0  && calificacion == min) { // si la primera calificación (contador = 0) es -10 se detiene el programa 
        break;
      }
      else { 
        if (calificacion == min ) { // si alguna de las siguientes calificaciones es -10 se detiene el programa y se muestran las calificaciones.
          System.out.println("Hasta aquí hemos llegado.... Estas son tus calificaciones.");
          break;
        }
        else if ( calificacion < min || calificacion > max ) {
          // no se evalua con un && porque se obliga al procesador a chequar ambas condiciones. Con que una de ellas no se cumpla es suficiente.
          System.out.println("Calificación fuera de rango... por favor introduce una calificación válida");
          continue;
        }
        else { // finalmente si la calificación es correcta se calculan las variables:

          // se suma el valor al total
          suma += calificacion;
          
          // se añade a las calificaciones negativas o positivas
          if (calificacion > 0) {
            sumaPositivas += calificacion; //Sumatorio de notas positivas
            contadorPositivo++; //Contador de notas positivas
          }
          else {
            if (calificacion < 0) {
              sumaNegativas += calificacion; //Sumatorio de notas negativas
              contadorNegativo++; //Contador de notas negativas
            }
            else {
              ceropatatero++; //Añado esto para llevar un recuento de las notas con valor 0 porque ni son positivas ni son negativas.
            }
          }

          // Se calcula la nota más alta y la más baja
          if (calificacion > calificacionMax) {
            calificacionMax = calificacion;
          }
          else if (calificacion < calificacionMin) {
            calificacionMin = calificacion;
          }
        }
      }

      // Se añade un contador al bucle
      contador++;
      
      if (contador == numMaxCalificaciones) {
        // Si se han introducido el número máximo permitido de calificaciones se termina el bucle
        System.out.println("Bien hecho. Ya has introducido 5 calificaciones");
        break;
      }
      
    }

    Scn.close();
    
    // Estadísticas 
    if (contador > 0) {
        System.out.println("El total de calificaciones válidas introducidas ha sido: " + contador);
        // Promedio
        float promedio = suma / contador;
        System.out.println("La media de las calificaciones es de: " + promedio + " puntos");
        // Calificación más alta y más baja
        System.out.println("La calificación más alta obtenida ha sido: " + calificacionMax);
        System.out.println("La calificación más baja obtenida ha sido: " + calificacionMin);
        if (contadorPositivo > 0) {
          //Promedio de las notas positivas
          float promedioPositivo = sumaPositivas / contadorPositivo;
          System.out.println("La media de las calificaciones positivas es de: " + promedioPositivo + " puntos");
          // Número de calificaciones positivas
          System.out.println("El número de calificaciones positivas (mayores que 0) obtenidas ha sido: " + contadorPositivo);
        }
        if (contadorNegativo > 0) {
          //Promedio de las notas negativas
          float promedioNegativo = sumaNegativas / contadorNegativo;
          System.out.println("La media de las calificaciones negativas es de: " + promedioNegativo + " puntos");
          // Número de calificaciones negativas
          System.out.println("El número de calificaciones negativas (menores que 0) obtenidas ha sido: " + contadorNegativo);
        }
        // Número de calificaciones con valor 0
        if (ceropatatero > 0) {
          System.out.println("Has sacado este número de cerapios: " + ceropatatero);
        }


    } else {
        System.out.println("Calificación no válida, inicia el programa de nuevo.");
    }
  }

}
