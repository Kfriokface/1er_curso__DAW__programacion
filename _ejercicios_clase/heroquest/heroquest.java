package heroquest;

public class heroquest {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*        W E L C O M E  T O  H E R O Q U E S T      *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        System.out.println("""
            El objetivo de este juego es avanzar por las distintas mazmorras hasta llegar a la mazmorra 4 con el máximo número de puntos de vida. 
            Al avanzar por las salas se desencadenarán distintos eventos, tanto positivos como negativos que pondrán en peligro tu misión.
            ¡Buena suerte!
            """);

        int option = playerOptions();

        
        settings.KEYBOARD.close();

    }

    public static int playerOptions() {
        System.out.println("""
            Por favor elije una de las siguientes opciones:
            
            1. Entra en una mazmorra.
            2. Explora la mazmorra.
            3. Inspeccionar salas.
            4. Abandona el juego.""");
            
        byte option = validateOption();

        return option;

    }

    /* Función que valida los datos anteriores en base a un valor máximo y un valor mínimo recibidos por parámetros
     * return int
     */
    private static byte validateOption() {
        byte value = -1;  // Inicializo con un valor inválido
        boolean entradaValida = false;

        // Validar la entrada
        while (!entradaValida) {
            if (settings.KEYBOARD.hasNextByte()) {
                value = settings.KEYBOARD.nextByte();
                if (value >= 1 && value <= 4) {
                    entradaValida = true;  // Entrada válida
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre las anteriores.");
                }
            } else {
                System.out.println("Entrada no válida. Debe ingresar un número entero.");
                settings.KEYBOARD.next();
                return validateOption();
            }
        }
        return value;
    };


}


