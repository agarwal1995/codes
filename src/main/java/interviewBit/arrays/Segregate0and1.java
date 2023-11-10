package interviewBit.arrays;

import interviewBit.helper.Swap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Segregate0and1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s: line) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(new Segregate0and1().solve(list));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> list) {
        int i =0;
        int j = 0;

        int n = list.size();

        while (i<n && j<n) {
            if(list.get(j)==1) {
                j++;
            }
            else if(list.get(i)==1 && list.get(j)==0) {
               swap(list,i,j);
               i++;
               j++;
            } else {
                i++;j++;
            }
        }
        return list;
    }

    public <T> ArrayList<T> swap(ArrayList<T> list, int i, int j) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
        return list;
    }
}
