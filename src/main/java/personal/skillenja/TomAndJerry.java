package personal.skillenja;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TomAndJerry {


    public static boolean isFriends(String tomString, String jerryString, int t, int j) {
        if (j==-1) {
            return true;
        }
        if(t<0) {
            return false;
        }
        if (tomString.charAt(t) == jerryString.charAt(j)) {
            return isFriends(tomString, jerryString, t-1, j-1);
        }
        return isFriends(tomString, jerryString, t-1, j);
    }

    public static boolean isFriends(String jerryString, String tomString) {
        int i=0, j=0;
        int m = jerryString.length();
        int n = tomString.length();
        int charFound = 0;
        while (i<m && j<n) {
            boolean flag = false;
            for(int k=j;k<n;k++) {
                if(tomString.charAt(k) == jerryString.charAt(i)) {
                    j = k+1;
                    i++;
                    charFound++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return charFound == m;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t>0) {
            String line1 = br.readLine().trim();
            String line2 = br.readLine().trim();

//            Set<Character> set = new HashSet<>();
//            for(int i=0;i<line2.length();i++) {
//                set.add(line2.charAt(i));
//            }
//            StringBuilder sbr = new StringBuilder();
//            for(int i=0;i<line1.length();i++) {
//                if (set.contains(line1.charAt(i))) {
//                    sbr.append(line1.charAt(i));
//                }
//            }
//            int j=0;
//            char prev = ']';
//            boolean flag = true;
//            line1 = sbr.toString();
//            for(int i=0;i<line2.length();i++) {
//                if(line1.charAt(j) == line2.charAt(i)) {
//                    j++;
//                    prev = line1.charAt(j-1);
//                    continue;
//                }
//                if(prev == line1.charAt(j)) {
//                    j++;
//                    i--;
//                    continue;
//                }
//                flag=false;
//                System.out.println("NO");
//                break;
//            }
//            if(flag) {
//                System.out.println("YES");
//            }

//            if(isFriends(line1, line2, line1.length()-1, line2.length()-1)) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }

            if(isFriends(line2, line1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            t--;
        }
    }
}
