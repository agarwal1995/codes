package personal.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarrayWithBOddNumbers {

    public int solve(ArrayList<Integer> A, int B) {

        Map<Integer, Integer> countToIndexMapMin = new HashMap<>();
        Map<Integer, Integer> countToIndexMapMax = new HashMap<>();
        int odd = 0;
        int sum = 0;
        Integer prev = null;
        for (int i=0;i<A.size();i++) {
            if (A.get(i)%2 == 1) {
                odd++;
                if(!countToIndexMapMin.containsKey(odd)) {
                    countToIndexMapMin.put(odd, i);
                }
            }
            countToIndexMapMax.put(odd, i);

            if(B==0) {
                if(A.get(i)%2==0) {
                    sum = sum + 1 + i;
                    if(countToIndexMapMin.containsKey(odd)) {
                        sum = sum - countToIndexMapMin.get(odd) - 1;
                    }
                }
            } else {
                if(A.get(i)%2==0 && prev!=null) {
                    sum = sum + prev;
                } else {
                    prev = 0;
                    if(odd-B==0) {
                        int minIndexLastExclude = countToIndexMapMin.get(odd-B+1);
                        sum = sum + (minIndexLastExclude);
                        prev = minIndexLastExclude;
                    }
                    if(odd-B>=0) {
                        int minIndexLastExclude = countToIndexMapMin.get(odd-B+1);
                        sum = sum + 1;
                        prev = prev +1;
                    }
                }

            }

        }
        System.out.println(countToIndexMapMin);
        System.out.println(countToIndexMapMax);
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> array = new ArrayList<>();
        for(int i =0;i<line.length;i++) {
            array.add(Integer.parseInt(line[i]));
        }
        System.out.println(new SubarrayWithBOddNumbers().solve(array, 0));
    }
}
