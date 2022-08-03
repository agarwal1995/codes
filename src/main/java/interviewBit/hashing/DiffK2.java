package interviewBit.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffK2 {

    public int diffPossible(final List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.size();i++) {
            if(map.containsKey(B+A.get(i))) {
                return 1;
            }
            map.put(A.get(i), i);
        }

        map = new HashMap<>();
        for (int i=A.size()-1;i>=0;i--) {
            if(map.containsKey(B+A.get(i))) {
                return 1;
            }
            map.put(A.get(i), i);
        }
        return 0;
    }
}
