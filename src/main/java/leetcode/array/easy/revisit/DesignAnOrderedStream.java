package leetcode.array.easy.revisit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignAnOrderedStream {
    class OrderedStream {

        int ptr = 1;
        Map<Integer, String> map;

        public OrderedStream(int n) {
            ptr = 1;
            map = new HashMap<>();

        }
        public List<String> insert(int idKey, String value) {
            map.put(idKey, value);
            List<String> res = new ArrayList<>();
            while(map.containsKey(ptr)) {
                res.add(map.get(ptr));
                map.remove(ptr);
                ptr++;
            }
            return res;
        }


    }
}


