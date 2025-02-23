package gfg.must_do_questions.stacks_queues;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    static Integer maxCapacity;
    static Deque<Pair> dNodes;
    static Map<Integer, Pair> map;

    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        maxCapacity = cap;
        dNodes = new LinkedList<>();
        map = new HashMap<>();
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Pair pair = map.get(key);
        dNodes.remove(pair);
        dNodes.addFirst(pair);
        return pair.y;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        if (map.containsKey(key)) {
            Pair pair = map.get(key);
            dNodes.remove(pair);
            pair.y = value;
            dNodes.addFirst(pair);
        } else {
            if (maxCapacity == map.size()) {
                Pair pair = dNodes.removeLast();
                map.remove(pair.x);
            }
            Pair pair = new Pair(key, value);
            dNodes.addFirst(pair);
            map.put(key, pair);
        }
    }
}
