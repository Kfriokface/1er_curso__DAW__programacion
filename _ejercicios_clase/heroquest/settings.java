package heroquest;

import java.util.Scanner;

public class settings {

  final static Scanner KEYBOARD = new Scanner(System.in);
  final static int INITIAL_ENERGY = 100;
  final static byte FOUNDED_COINS = 10;
  final static byte TRAP_REVEALED = -15;
  final static byte STARTING_DUNGEON = 1;
  final static byte FINAL_DUNGEON = 3;

  final static byte[][] DUNGEON_PATHS = {
      {2,3},
      {1,4},
      {},
      {1,2}
  };

}
