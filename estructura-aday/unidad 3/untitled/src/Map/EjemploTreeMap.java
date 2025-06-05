package Map;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class EjemploTreeMap {
    public static void main(String[] args) {
        Map<String, String> capitales = new TreeMap<>();
        capitales.put("Italia","Roma");

        capitales.put("Francia","Paris");
        capitales.put("España","Madrid");
        System.out.println(capitales);

        Map<String, String> capitales2 = new TreeMap<>(Comparator.reverseOrder());
        capitales2.put("España","Madrid");
        capitales2.put("Italia","Roma");
        capitales2.put("Francia","Paris");

        System.out.println(capitales2);
    }}
