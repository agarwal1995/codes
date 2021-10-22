package personal.greedy;
import java.util.*;

public class HighestProduct {

    public int maxp3(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        int ans = A.get(n-1) * A.get(n-2) * A.get(n-3);
        ans = Math.max(A.get(n-1) * A.get(0) *A.get(1), ans);
        return ans;
    }


    public static void main(String[] args) {
        HighestProduct highestProduct = new HighestProduct();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        System.out.println(highestProduct.maxp3(a));
    }

}
