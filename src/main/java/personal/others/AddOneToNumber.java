package personal.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddOneToNumber {

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        while (n!=0 && A.get(0) == 0 ) {
            A.remove(0);
            n--;
        }
        ArrayList<Integer> sol = new ArrayList<>();
        if (n==0) {
            sol.add(1);
            return sol;
        }
        int sum = A.get(n-1) +1;
        sol.add(sum%10);
        int carry = sum/10;
        for(int i=n-2;i>=0;i--) {
            sum = A.get(i) + carry;
            carry = sum/10;
            sol.add(sum%10);
        }
        if (carry!=0) {
            sol.add(carry);
        }
        Collections.reverse(sol);
        return sol;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        int n = line.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i =0;i<n;i++) {
            arr.add(Integer.parseInt(line[i]));
        }
        System.out.println(plusOne(arr));
    }
}

