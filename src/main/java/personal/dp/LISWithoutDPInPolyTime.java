package personal.dp;

import java.util.ArrayList;
import java.util.List;

public class LISWithoutDPInPolyTime {

    private void withoutDpSolution(int[] array) {
        int n = array.length;

        List<Integer> sol = new ArrayList<>();
        int count = 0;
        int max = -1;
        int maxValue = -1;
        for(int i=0;i<n;i++) {
            count = 0;
            maxValue = array[i];
            List<Integer> currSol = new ArrayList<>();
            currSol.add(maxValue);
            for(int j=i+1;j<n;j++) {
                if(array[j] > maxValue) {
                    maxValue = array[j];
                    currSol.add(maxValue);
                    count++;
                }
            }
            if(count>max) {
                max = count;
                sol = currSol;
            }
        }

        System.out.println(max);
        System.out.println(sol);
    }

    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        new LISWithoutDPInPolyTime().withoutDpSolution(array);
    }
}
