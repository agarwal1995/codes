package personal.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class TopKElementsInArray {

    public int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x:nums) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x) +1);
        }
        map = map.entrySet().stream().sorted((a, b) -> a.getValue().compareTo(b.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        int[] ar = new int[k];
        int i=0;
        for(Integer m : map.values()) {
            ar[i++] = m;
            if(i==k) {
                break;
            }
        }
        return ar;
    }

    public int[] topKK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x:nums) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x) +1);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((a, b)-> {
            if(a.getValue().compareTo(b.getValue()) == 0) {
                return b.getKey().compareTo(a.getKey());
            }
            return b.getValue().compareTo(a.getValue());
        });
        map.clear();
        int[] ar = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> x :list) {
            ar[i++] = x.getKey();
            if(i==k) {
                break;
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        int[] arr = {8, 1, 1, 2, 2, 3, 3, 3, 4};
        System.out.println(Arrays.toString(new TopKElementsInArray().topKK(arr, 3)));
    }
}
