package gestionUrgencias;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class settings {
    final static Scanner SC = new Scanner(System.in);
    final static byte INTENTOS_MAX = 3;
    final static int NUSS_MAX = 999999;
    final static int NUSS_MIN = 100000;
    final static byte ANSWER_VALUE_MAX = 3;
    final static byte ANSWER_VALUE_MIN = 0;
    final static byte PRIORIDAD_MAX = 5;
    final static byte PRIORIDAD_MIN = 0;
    final static byte TEMPERATURA_MAX = 45;
    final static byte TEMPERATURA_MIN = 27;
    final static String[] SINTOMAS = {"Dolor", "Lesión traumática", "Fiebre alta", "Confusión o desorientación"};
    final static Map<Byte, List<String>> EXPLORACION = Collections.unmodifiableMap(
            new HashMap<Byte, List<String>>() {{
            put((byte) 0, Collections.unmodifiableList(Arrays.asList("Dolor torácico", "Dolor abdominal", "Dolor de cabeza", "Migraña")));
            put((byte) 1, Collections.unmodifiableList(Arrays.asList("Fractura ósea", "Herida de bala", "Quemadura", "Lesión cerebral traumática")));
            put((byte) 2, Collections.unmodifiableList(Arrays.asList("Neumonía", "Meningitis", "Infección viral", "Reacción alérgica")));
            put((byte) 3, Collections.unmodifiableList(Arrays.asList("Intoxicación por drogas o alcohol", "Deshidratación severa", "Accidente cerebrovascular", "Hipoglucemia severa")));
        }}
    );
    final static String ANSI_BOLD = "\033[1m";
    final static String ANSI_RESET = "\033[0m";
}
