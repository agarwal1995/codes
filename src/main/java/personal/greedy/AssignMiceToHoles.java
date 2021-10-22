package personal.greedy;
import java.util.*;

public class AssignMiceToHoles {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int maxMinute = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++) {
            maxMinute = Math.max(maxMinute, Math.abs(A.get(i) - B.get(i)));
        }
        return maxMinute;
    }

    public static void main(String[] args) {

    }
}
