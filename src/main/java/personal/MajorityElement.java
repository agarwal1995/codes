package personal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public static int majorityElement(final List<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : A) {
            map.putIfAbsent(x, 0);
            map.put(x, map.get(x) + 1);
        }
        int maxValue = -1;
        int maxKey = A.get(0);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxKey = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int n = line.length;
        //String[] line1 = br.readLine().trim().split("\\s+");
        List<Integer> arr = new ArrayList<>();
        for (int i =0;i<n;i++) {
            arr.add(Integer.parseInt(line[i]));
        }

        System.out.println(majorityElement(arr));
    }
}
