package utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<Character, Integer> dico = new HashMap<>();
    public static Map<Integer, Character> dico2 = new HashMap<>();

    // Bloc statique d'initialisation
    static {
        for (int i = 0; i < 25; i++) {
            char lettre = (char) ('A' + i);  // Lettres de 'A' à 'Y'
            dico.put(lettre, i);
        }
        for (int i = 0; i < 25; i++) {
            char lettre = (char) ('A' + i);  // Lettres de 'A' à 'Y'
            dico2.put(i, lettre);
        }
    }
}
