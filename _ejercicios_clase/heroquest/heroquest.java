package heroquest;

public class heroquest {
    public static void main(String[] args) {
       
        // Variables iniciales
        boolean playGame = true;
        byte startingDungeon = constants.STARTING_DUNGEON, initialEnergy = constants.INITIAL_ENERGY, initialTurn = 1, playerOption = -1; //defino las variables iniciales
        byte[] currentValues = {startingDungeon, initialEnergy, initialTurn, playerOption}; //creo un array con las variables iniciales que se irá modificando a lo largo de la partida
        byte[] dungeonEnergy = getDungeonEnergy(); // Se obtienen los valores de energía para cada mazmorra.
        
        // Welcome message
        System.out.println("*****************************************************");
        System.out.println("*                                                   *");
        System.out.println("*        W E L C O M E  T O  H E R O Q U E S T      *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        System.out.println("""
            El objetivo del juego es avanzar por las distintas mazmorras hasta llegar a la mazmorra final con al menos 30 puntos de vida. 
            Al avanzar por las salas se desencadenarán distintos eventos, tanto positivos como negativos, que pondrán en peligro tu misión.
            ¡Buena suerte, aventurero!.
            """);

        while (playGame) {
            if (currentValues[1] <= 0) {
                System.out.println("GAME OVER... te has quedado más tieso que la mojama. Inténtalo de nuevo.\n");
                playGame = false;
            }
            else {
                if (currentValues[0] == constants.FINAL_DUNGEON && currentValues[1] >= constants.MIN_ENERGY) {
                    System.out.print("""
                    ¡¡¡Enhorabuena!!!
                    Has llegado a la mazmorra final con energía suficiente para completar la aventura.
                    Estas son tus estadísticas de juego:
                    """);
                    System.out.println("-".repeat(30));
                    System.out.printf("%-30s %s%n", constants.ANSI_BOLD + "Energía restante:" + constants.ANSI_RESET, currentValues[1]);
                    System.out.printf("%-30s %s%n", constants.ANSI_BOLD + "Turnos empleados:" + constants.ANSI_RESET, currentValues[2] - 1);
                    System.out.println("-".repeat(30));

                    playGame = false;
                }
                else if (currentValues[3] == 4) {
                    System.out.println("\nGracias por jugar a Heroquest, aventurero. Vuelve siempre que quieras.\n");
                    playGame = false;
                }
                else {
                    System.out.printf("TURNO %d: \n", currentValues[2]);
                    System.out.println("========");
                    System.out.printf("Estas en la mazmorra %s y tu energía actual es de %d puntos.\n\n", currentValues[0], currentValues[1]);
                    playerOptions(currentValues, dungeonEnergy);
                    currentValues[2]++;
                }
            }
        }
        
    }

    /* Muestra las opciones del menú principal y actualiza los valores del juego en función de la elección.
     * @return array
     */
    private static byte[] playerOptions(byte[] currentValues, byte[] dungeonEnergy) {
        System.out.println("""
            Por favor elije una de las siguientes opciones:
            
            1. Entra en una mazmorra.
            2. Explora la mazmorra.
            3. Inspeccionar la energía de las mazmorras.
            4. Abandona el juego.""");
            
        byte option = validateOption((byte) 1, (byte) 4); //Se valida la opción elegida

        switch (option) {
            case 1:
                chooseDungeon(currentValues, dungeonEnergy);
                break;
            case 2:
                //System.out.println("Cuidadín! no siempre suceden cosas buenas");
                inspectDungeon(currentValues);
                break;
            case 3:
                System.out.println("\nEstos son los valores de energía de cada Mazmorra:");
                for (int i = 0; i < dungeonEnergy.length; i++) {
                    System.out.printf("Mazmorra %d: %d puntos de energía\n", i+1, dungeonEnergy[i]); 
                }
                System.out.println("\n");
                break;
            case 4:
                break;
        }

        currentValues[3] = option;

        return currentValues;
    }

    /* Muestra los posibles destinos en funcón de la sala actual recibida por parámetro y actualiza los valores del juego en función de la elección.
     * @return array
     */
    private static byte[] chooseDungeon(byte[] currentValues, byte[] dungeonEnergy) {

        byte currentDungeon = currentValues[0];

        switch (currentDungeon) {
            case 1:
                System.err.println("\nElije la mazmorra a la que quieres entrar (introduce el valor 1 o 2 para cada caso): ");
                System.out.println("""
                    1. Mazmorra 2.
                    2. Mazmorra 3.""");
                break;
            case 2:
                System.err.println("\nElije la mazmorra a la que quieres entrar (introduce el valor 1 o 2 para cada caso): ");
                System.out.println("""
                    1. Mazmorra 1.
                    2. Mazmorra 4.""");
                break;
            case 3:
                System.out.println("""
                    \nVaya, estás en la Mazmorra final pero necesitas al menos 30 puntos de energía para terminar el juego.
                    Introduce 1 o 2 para volver a la Mazmorra inicial.""");
                break;
            case 4:
                System.err.println("\nElije la mazmorra a la que quieres entrar (introduce el valor 1 o 2 para cada caso): ");
                System.out.println("""
                    1. Mazmorra 1.
                    2. Mazmorra 2.""");
                break;
        }

        byte option = validateOption((byte) 1, (byte) 2); //Se valida la opción elegida

        if (option != 3) {

          currentValues[0] = constants.DUNGEON_PATHS[currentDungeon - 1][option - 1]; // Se modifica el valor de la sala actual
          byte energyModifier = dungeonEnergy[currentValues[0] -1];
  
          if (energyModifier > 0) {
              System.err.printf("Estás de suerte aventurero, %sacabas de ganar %d puntos de energía%s.\n\n", constants.ANSI_BOLD, energyModifier, constants.ANSI_RESET );
          }
          else if (energyModifier < 0) {
              System.err.printf("Lo siento aventurero, %sacabas de perder %d puntos de energía%s.\n\n", constants.ANSI_BOLD, energyModifier, constants.ANSI_RESET );
          }
  
          currentValues[1] = (byte) (currentValues[1] + energyModifier); // Se modifica el valor actual de la energía
        }

        return currentValues;
    }

    /* Determina el evento que sucede al inspeccionar una sala y actualiza los valores del juego en función del mismo.
     * @return array
     */
    private static byte[] inspectDungeon(byte[] currentValues) {

        byte randomEvent = (byte) ((Math.random() * 3) + 1);

        switch (randomEvent) {
            case 1:
                System.out.printf("¡Estás de enhorabuena aventurero!, %shas encontrado un puñado de monedas que te dan %d puntos de energía%s.\n\n",  constants.ANSI_BOLD, constants.FOUNDED_COINS, constants.ANSI_RESET);
                currentValues[1] = (byte) (currentValues[1] + constants.FOUNDED_COINS);
                break;
            case 2:
                System.out.printf("¡Mala suerte!, %sen tu afán de explorar has caído en una trampa que te quita %d de energía%s.\n\n", constants.ANSI_BOLD, constants.TRAP_REVEALED, constants.ANSI_RESET);
                currentValues[1] = (byte) (currentValues[1] + constants.TRAP_REVEALED);
                break;
            case 3:
                System.out.printf("Lo sentimos, en esta sala no has encontrado nada... por el momento.\n");
                break;
        }

        return currentValues;
    }

    /* Valida los datos en base a un valor máximo y un valor mínimo recibidos por parámetro
     * @return byte
     */
    private static byte validateOption(byte min, byte max) {
        byte value = -1;  // Inicializo con un valor inválido
        boolean entradaValida = false;

        // Validar la entrada
        while (!entradaValida) {
            if (constants.KEYBOARD.hasNextByte()) {
                value = constants.KEYBOARD.nextByte();
                if (value >= min && value <= max) {
                    entradaValida = true;  // Entrada válida
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre las anteriores.");
                }
            } else {
                System.out.println("Entrada no válida. Debe ingresar un número entero.");
                constants.KEYBOARD.next();
                return validateOption(min, max);
            }
        }

        return value;
    };

    /*
     * Asigna valores comprendidos entre -20 y 20 a la variable dungeonEnergy.
     * @return array
     */
     private static byte[] getDungeonEnergy() {
        byte[] dungeonEnergy = new byte[4];

        for (int i = 0; i < dungeonEnergy.length; i++) {
            dungeonEnergy[i] = (byte) ((Math.random() * 41) - 20);
        }

        return dungeonEnergy;
     }

}
