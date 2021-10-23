package personal.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyPair {

    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Set<Integer> map = new HashSet<>();
        for(int val : arr) {
            if (map.contains(x-val)) {
                return true;
            }
            map.add(val);
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
