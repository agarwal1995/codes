package personal.hashing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ColorfulNumber {

    public int colorful(int A) {
        String str = String.valueOf(A);
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<str.length();i++) {
            int p = Integer.parseInt(String.valueOf(str.charAt(i)));
            if(set.contains(p)) {
                return 0;
            }
            set.add(p);
            for(int j=i+1;j<str.length();j++) {
                int x = Integer.parseInt(String.valueOf(str.charAt(j)));
                p = p * x;
                if (set.contains(p)) {
                    return 0;
                }
                set.add(p);
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        System.out.println(new ColorfulNumber().colorful(2345));
    }
}
