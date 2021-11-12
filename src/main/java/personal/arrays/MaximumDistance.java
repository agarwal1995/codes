package personal.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MaximumDistance {

    public int maximumGap(final List<Integer> list) {
        int n = list.size();
        int[] leftToRightMax = new int[n];
        int[] rightToLeftMax = new int[n];

        leftToRightMax[0] = list.get(0);
        rightToLeftMax[n-1] = list.get(n-1);

        int j=n-2;
        for (int i = 1; i < n; i++) {
            leftToRightMax[i] = Math.max(leftToRightMax[i-1], list.get(i));
            rightToLeftMax[j] = Math.max(rightToLeftMax[j+1], list.get(j));
            j--;
        }

        int i=0;
        j=0;
        int maxValue = -1;
        while (i<n && j<n) {
            if(list.get(i) <= rightToLeftMax[j]) {
                maxValue = Math.max(maxValue, j-i);
                j++;
            } else {
                i++;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bufferedReader.readLine().trim().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            list.add(Integer.parseInt(line[i]));
        }
        System.out.println(new MaximumDistance().maximumGap(list));
    }
}
