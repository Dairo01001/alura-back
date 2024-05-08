package models;

import java.util.Iterator;
import java.util.Map;

public class Utils {

    public static void PaintMenu(Map<String, Double> conversionRates) {
        System.out.println(center("Bienvenido", 70 - 3, ' '));
        String line = multipli('-', 70 - 3);
        System.out.println(line);
        Iterator<String> it = conversionRates.keySet().iterator();
        String format = "|%1$-10s|%2$-10s|%3$-10s|%4$-10s|%5$-10s|%6$-10s|\n";
        while (it.hasNext()) {
            System.out.format(format, it.next(), it.next(), it.next(), it.next(), it.next(), it.next());
        }
        System.out.println(line);
        System.out.println("Type: Salir or Enter to continue.");
    }
    
    public static String multipli(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += c;
        }
        return result;
    }

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length()) {
            return s;
        }

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }
}
