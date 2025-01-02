package gestionUrgencias;

public class app {

    public static void main(String[] args) {

        int nuss = Nuss(settings.INTENTOS_MAX); // Se obtiene el nuss pasándole el número de intentos máximos
        if (nuss == -1) {
            return; // Si el valor de nuss no es válido se acaba el programa
        }
        byte sintoma = Sintoma(); //Se obtiene el síntoma
        byte exploracion = Exploracion(sintoma); //Se obtiene la exploracion, pasándole el síntoma
        byte prioridad = Prioridad();
        byte temperatura = Temperatura();

        printResults(nuss, sintoma, exploracion, prioridad, temperatura); //Se imprimen los resultados finales

        settings.SC.close(); //Cierro el escaner
    }

    /* Función que calcula el Nuss en base a un número de intentos recibido por parámetro
     * return int
     */
    private static int Nuss(byte intentos) {
        int nuss = -1; // Inicializo con un valor inválido

        // Compruebo que queden intentos.
        if (intentos == 0) {
            System.err.println("Ha intentado introducir el número sin éxito en varias ocasiones.\nPor favor revise su documentación e inténtelo más tarde.");
            return nuss;
        }

        System.out.println("Por favor introduzca su número de la Seguridad Social.\nEl número debe estar comprendido entre 100000 y 999999:");
        if (settings.SC.hasNextInt()) {
            int value = settings.SC.nextInt();
            if ((value < settings.NUSS_MIN) || (value > settings.NUSS_MAX)) {
                System.err.println("Lo sentimos, el número introducido no es válido. Inténtelo de nuevo.\n");
                return Nuss(--intentos);  //Llamo recursivamente a la función Nuss restando un intento del valor total.
            } else {
                nuss = value;
            }
        } else {
            System.err.println("Debe introducir un número. Inténtelo de nuevo. \n");
            settings.SC.next(); //Vacío el buffer
            return Nuss(--intentos);
        }
        return nuss;
    }

    /* Función que calcula el síntoma
     * return int
     */
    private static byte Sintoma() {
        // Se muestran las opciones de los síntomas
        System.out.println("Seleccione el síntoma que presenta:");
        System.out.println("0. " + settings.SINTOMAS[0]);
        System.out.println("1. " + settings.SINTOMAS[1]);
        System.out.println("2. " + settings.SINTOMAS[2]);
        System.out.println("3. " + settings.SINTOMAS[3]);

        byte sintoma = Validar(settings.ANSWER_VALUE_MIN, settings.ANSWER_VALUE_MAX);
        return sintoma;
    }

    /* Función que calcula la exploración
     * return int
     */
    private static byte Exploracion(byte sintoma) {
        System.out.println("¿Podría detallar su síntoma de forma mas concreta?:");
        System.out.println("0. " + settings.EXPLORACION.get(sintoma).get(0));
        System.out.println("1. " + settings.EXPLORACION.get(sintoma).get(1));
        System.out.println("2. " + settings.EXPLORACION.get(sintoma).get(2));
        System.out.println("3. " + settings.EXPLORACION.get(sintoma).get(3));

        byte exploracion = Validar(settings.ANSWER_VALUE_MIN, settings.ANSWER_VALUE_MAX);
        return exploracion;
    }

    /* Función que calcula la prioridad
     * return int
     */
    private static byte Prioridad() {
        System.out.println("Por favor indique la prioridad, entre 0 y 5, que tiene su caso\nsiendo 0 una prioridad baja y 5 una prioridad muy alta:");
        byte prioridad = Validar(settings.PRIORIDAD_MIN, settings.PRIORIDAD_MAX);
        return prioridad;
    }

    /* Función que calcula temperatura
     * return int
     */
    private static byte Temperatura() {
        System.out.println("Por favor indique su temperatura actual:");
        byte temperatura = Validar(settings.TEMPERATURA_MIN, settings.TEMPERATURA_MAX);
        return temperatura;
    }

    /* Función que valida los datos anteriores en base a un valor máximo y un valor mínimo recibidos por parámetros
     * return int
     */
    private static byte Validar(int min, int max) {
        byte value = -1;  // Inicializo con un valor inválido
        boolean entradaValida = false;

        // Validar la entrada
        while (!entradaValida) {
            if (settings.SC.hasNextByte()) {
                value = settings.SC.nextByte();
                if (value >= min && value <= max) {
                    entradaValida = true;  // Entrada válida
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre " + min + " y " + max + ":");
                }
            } else {
                System.out.println("Entrada no válida. Debe ingresar un número entero.");
                settings.SC.next();
                return Validar(min, max);
            }
        }
        return value;
    }

    /* Función que imprime los resultados en base a los valores calculados anteriormente recibidos por parámetros
     * return void
     */
    private static void printResults(int nuss, byte sintoma, byte exploracion, byte prioridad, byte temperatura) {
        short longitudSintoma = (byte) settings.SINTOMAS[sintoma].length();
        short longitudExploracion = (byte) settings.EXPLORACION.get(sintoma).get(exploracion).length();
        short dashNumber = (longitudSintoma >= longitudExploracion) ? longitudSintoma : longitudExploracion;

        System.out.println("-".repeat(dashNumber + 23));
        System.out.printf("%-30s %s%n", settings.ANSI_BOLD + "NUSS:" + settings.ANSI_RESET, nuss); // %-10s: columna de 10 caracteres alineada a la izquierda
        System.out.printf("%-30s %s%n", settings.ANSI_BOLD + "Síntoma:" + settings.ANSI_RESET, settings.SINTOMAS[sintoma]);
        System.out.printf("%-30s %s%n", settings.ANSI_BOLD + "Exploración:" + settings.ANSI_RESET, settings.EXPLORACION.get(sintoma).get(exploracion));
        System.out.printf("%-30s %s%n", settings.ANSI_BOLD + "Nivel de prioridad:" + settings.ANSI_RESET, prioridad);
        System.out.printf("%-30s %s%n", settings.ANSI_BOLD + "Temperatura actual:" + settings.ANSI_RESET, temperatura);
    }

}
