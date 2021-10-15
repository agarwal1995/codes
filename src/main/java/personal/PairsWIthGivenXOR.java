package personal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PairsWIthGivenXOR {
     public static int solve(ArrayList<Integer> a, int b) {
         int n = a.size();
         int count = 0;
         Set<String> set = new HashSet<>();
         for(int x:a) {
             String str = Integer.toBinaryString(x^b);
             if (set.contains(str)) {
                 count++;
                 set.remove(Integer.toBinaryString(x));
                 continue;
             }
             set.add(Integer.toBinaryString(x));
         }
         return count;
     }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int n = line.length;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i =0;i<n;i++) {
            arr.add(Integer.parseInt(line[i]));
        }

        int b = Integer.parseInt(br.readLine().trim());
        System.out.println(solve(arr, b));
    }

}
