public class caraCruz {
  public static void main(String[] args) {

    int m = (int) (Math.random() * 8) + 1, p = (int) (Math.random()) * 2;
    String valor = "", posicion = "";

    switch (m) {
        case 1 -> valor = "1 céntimo";
        case 2 -> valor = "2 céntimos";
        case 3 -> valor = "5 céntimos";
        case 4 -> valor = "10 céntimos";
        case 5 -> valor = "20 céntimos";
        case 6 -> valor = "50 céntimos";
        case 7 -> valor = "1 euro";
        case 8 -> valor = "2 euros";
    }

    switch (p) {
        case 0 -> posicion = "cara";
        case 2 -> posicion = "cruz";
    }

    System.out.printf("La moneda que has lanzado es de %s, y ha caido en %s.", valor, posicion);

  }
}
