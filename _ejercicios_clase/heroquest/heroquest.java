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
            El objetivo de este juego es avanzar por las distintas mazmorras hasta llegar a la mazmorra 3 con el máximo número de puntos de vida. 
            Al avanzar por las salas se desencadenarán distintos eventos, tanto positivos como negativos que pondrán en peligro tu misión.
            ¡Buena suerte!
            """);
        
        boolean playGame = true;
        byte startingDungeon = settings.STARTING_DUNGEON, initialEnergy = settings.INITIAL_ENERGY, initialTurn = 1, playerOption = -1;
        byte[] currentValues = {startingDungeon, initialEnergy, initialTurn, playerOption};
        byte[] dungeonEnergy = getDungeonEnergy();

        while (playGame) {
            if (currentValues[1] <= 0) {
                System.out.println("Vaya... te has quedado más tieso que la mojama. Inténtalo de nuevo");
                playGame = false;
            }
            else {
                if (currentValues[0] == settings.FINAL_DUNGEON) {
                    System.out.println("Enhorabuena aventurero, has llegado al final de tu aventura.");
                    playGame = false;
                }
                else if (currentValues[3] == 4) {
                    System.out.println("Gracias por jugar a Heroquest, aventurero. Vuelve siempre que quieras.");
                    playGame = false;
                }
                else {
                    playerOptions(currentValues, dungeonEnergy);
                }
            }
        }
        
    }

    public static byte[] playerOptions(byte[] currentValues, byte[] dungeonEnergy) {
        System.out.printf("TURNO %d: \n", currentValues[2]);
        System.out.printf("Estas en la mazmorra %s y tu energía actual es de %d puntos. \n", currentValues[0], currentValues[1]);
        System.out.println("""
            Por favor elije una de las siguientes opciones:
            
            1. Entra en una mazmorra.
            2. Explora la mazmorra.
            3. Inspeccionar la energía de las mazmorras.
            4. Abandona el juego.""");
            
        byte option = validateOption((byte) 1, (byte) 4);

        switch (option) {
            case 1:
                chooseDungeon(currentValues, dungeonEnergy);
                break;
            case 2:
                System.out.println("Cuidadín!");
                break;
            case 3:
                System.out.println("Estos son los valores de energía de cada Mazmorra:");
                for (int i = 0; i < dungeonEnergy.length; i++) {
                    System.out.printf("Mazmorra %d: %d puntos de energía\n", i+1, dungeonEnergy[i]); 
                }
                break;
            case 4:
                break;
        }

        currentValues[2]++;
        currentValues[3] = option;

        return currentValues;
    }

    /* Muestra los posibles destinos en funcón de la sala actual recibida por parámetro y actualiza los valores del juego en función de la elección.
     * @return array
     */
    private static byte[] chooseDungeon(byte[] currentValues, byte[] dungeonEnergy) {

        byte currentDungeon = currentValues[0];

        System.err.println("Elije la mazmorra a la que quieres entrar: ");

        switch (currentDungeon) {
            case 1:
                System.out.println("""
                    1. Mazmorra 2.
                    2. Mazmorra 3.""");
                break;
            case 2:
                System.out.println("""
                    1. Mazmorra 1.
                    2. Mazmorra 4.""");
                break;
            case 3:
                System.out.println("""
                    Estas en la Mazmorra final.""");
                break;
            case 4:
                System.out.println("""
                    1. Mazmorra 1.
                    2. Mazmorra 2.""");
                break;
        }

        byte option = validateOption((byte) 1, (byte) 2);

        if (option != 3) {

          currentValues[0] = settings.DUNGEON_PATHS[currentDungeon - 1][option - 1]; // Se modifica el valor de la sala actual
          byte energyModifier = dungeonEnergy[currentValues[0] -1];
  
          if (energyModifier > 0) {
              System.err.printf("Estás de suerte aventurero, acabas de ganar %d puntos de energía.\n", energyModifier );
          }
          else if (energyModifier < 0) {
              System.err.printf("Lo siento aventurero, acabas de perder %d puntos de energía.\n", energyModifier );
          }
  
          currentValues[1] = (byte) (currentValues[1] + energyModifier); // Se modifica el valor actual de la energía
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
            if (settings.KEYBOARD.hasNextByte()) {
                value = settings.KEYBOARD.nextByte();
                if (value >= min && value <= max) {
                    entradaValida = true;  // Entrada válida
                } else {
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre las anteriores.");
                }
            } else {
                System.out.println("Entrada no válida. Debe ingresar un número entero.");
                settings.KEYBOARD.next();
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


