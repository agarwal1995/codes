package discussions.mmt;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    private void palindromePartitioning(String str) {
        List<List<String>> sol = new ArrayList<>();
        pUtil(str, new ArrayList<>(), sol, 0, str.length());
        System.out.println(sol);

    }

    private void pUtil(String str, List<String> partitions, List<List<String>> sol, int i, int n) {
        if(i>=n) {
            if(partitions.size()>0) {
                partitions.remove(partitions.size()-1);
            }
            return;
        }
        if(checkForPalindromes(partitions)) {
            List<String> solList = new ArrayList<>();
            partitions.forEach(p-> {
                solList.add(new String(p));
            });
            sol.add(solList);
        }
        if(partitions.size()>0) {
            partitions.remove(partitions.size()-1);
        }
        for(int j=i;j<n;j++) {
            partitions.add(str.substring(i,j+1));
            partitions.add(str.substring(j+1,n));
            pUtil(str, partitions, sol,j+1 , n);
            partitions.remove(partitions.size()-1);
        }
    }

    private boolean checkForPalindromes(List<String> partitions) {
        for(String s : partitions) {
            int n = s.length();
            int i=0, j=n-1;
            for(i=0,j=n-1;i<j;i++,j--) {
                if(s.charAt(i)!=s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        new PalindromePartitioning().palindromePartitioning("aabac");
    }
}
