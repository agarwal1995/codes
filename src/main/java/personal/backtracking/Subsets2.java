package personal.backtracking;

import java.util.*;

public class Subsets2 {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        Collections.sort(A);
        Set<String> set = new HashSet<>();
        subsetsUtil(0,A.size(),A,new ArrayList<>(),sol, set);
        return sol;
    }

    public void subsetsUtil(int s,int n,ArrayList<Integer> A, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> sol, Set<String> set) {
        if(s>n) {
            return;
        }
        String str = convert(temp);
        if(!set.contains(str)) {
            sol.add(new ArrayList<>(temp));
            set.add(str);
        }
        for(int i=s;i<n;i++) {
            temp.add(A.get(i));
            subsetsUtil(i+1,n,A,temp, sol, set);
            temp.remove(temp.size()-1);
//            if (i+1<n && temp.size()>0 && temp.get(temp.size()-1).compareTo(A.get(i+1)) == 0) {
//                i++;
//                continue;
//            }
//            if(temp.size()==0 && i+1<n && A.get(i).compareTo(A.get(i+1))==0) {
//                i++;
//                continue;
//            }
//            if(temp.size()==0 && i>0 && A.get(i-1).compareTo(A.get(i))==0) {
//                i++;
//            }
        }
    }

    public String convert(ArrayList<Integer> list) {
        StringBuilder sbr = new StringBuilder();
        for(int x : list) {
            sbr.append(x);
        }
        return sbr.toString();
    }

    public static void main(String[] args) {
        Subsets2 subsets2 = new Subsets2();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        System.out.println(subsets2.subsetsWithDup(A));
    }
}
