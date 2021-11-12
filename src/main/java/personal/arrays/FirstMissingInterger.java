package personal.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FirstMissingInterger {

    public int firstMissingPositive(ArrayList<Integer> list) {
        int n = list.size();

        for(int i=0;i<n;i++) {
            if (list.get(i) < 0 || list.get(i) >n) {
                list.set(i, 0);
            }
        }

        System.out.println(list);
        for (int i=0;i<n;i++) {
            int x = list.get(i);
            if(x==0) {
                continue;
            }
            x = Math.abs(x)-1;
            if(list.get(x) == 0 ) {
                list.set(x, -(x+1));
            } else if(list.get(x) >0) {
                list.set(x, -(list.get(x)));
            }
        }

        int minPositive = 1;
        for (int i = 0; i < n; i++) {
            if(list.get(i)>=0) {
                minPositive = i+1;
                break;
            }
        }
        System.out.println(minPositive);
        return minPositive;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        String[] line = br.readLine().trim().split("\\s+");
        for (int i = 0; i < line.length; i++) {
            list.add(Integer.parseInt(line[i]));
        }
        System.out.println(new FirstMissingInterger().firstMissingPositive(list));
    }
}
