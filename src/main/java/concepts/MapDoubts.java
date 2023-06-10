package concepts;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDoubts {

    public static void main(String[] args) {
    }

    public static void checkMapRemoveValue() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,34);
        map.put(2,31);

        System.out.println(map.remove(2));
    }

}
