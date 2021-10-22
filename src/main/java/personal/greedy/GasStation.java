package personal.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GasStation {

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int previousSum = 0;
        int index = 0;
        int sum = 0;

        int sumA = 0;
        int sumB = 0;
        for(int i=0;i<n;i++) {
            if(sum < 0) {
                sum =0;
                index = i;
            }
            sum = sum + A.get(i) - B.get(i);
            sumA = sumA + A.get(i);
            sumB = sumB + B.get(i);
        }
        if(sumA < sumB || sum<0) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        String[] line1 = br.readLine().trim().split("\\s+");
        String[] line2 = br.readLine().trim().split("\\s+");

        for(int i=0;i<line1.length;i++) {
            list1.add(Integer.parseInt(line1[i]));
            list2.add(Integer.parseInt(line2[i]));
        }

        System.out.println(new GasStation().canCompleteCircuit(list1, list2));
    }
}
