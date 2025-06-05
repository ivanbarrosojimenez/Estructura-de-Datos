package Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class EjemploLinkedHashMap {
    public static void main(String[] args) {
        Map<String, String> capitales = new LinkedHashMap<>();
        capitales.put("España","Madrid");
        capitales.put("Francia","Paris");
        capitales.put("Italia","Roma");
        System.out.println(capitales);
    }

}
