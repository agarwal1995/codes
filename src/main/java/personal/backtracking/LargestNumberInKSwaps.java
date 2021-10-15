package personal.backtracking;

public class LargestNumberInKSwaps {

    private static String maxTillNow = "";

    public static String findMaximumNum(String str, int k) {
        maxTillNow = new String(str);
        findUtil(k, 0,0,new StringBuilder(str));
        return maxTillNow;
    }

    static void findUtil( int remainingSwap, int s, int index, StringBuilder str) {
        if(remainingSwap<=0 || index > str.length()) {
            return;
        }

        for (int i =index; i<str.length();i++) {
            for(int j=i+1;j<str.length();j++) {
                if(str.charAt(j) > str.charAt(i)) {
                    swap(str, i, j);
                    if (str.toString().compareTo(maxTillNow) > 0) {
                        maxTillNow = new String(str);
                    }
                    findUtil( remainingSwap-1, s, index+1, new StringBuilder(str));
                    //findUtil( remainingSwap-1, s, index, new StringBuilder(str));
                    swap(str, j, i);
                }

            }
        }
    }

    private static void swap(StringBuilder sbr, int i, int j) {
        char ch = sbr.charAt(i);
        sbr.setCharAt(i, sbr.charAt(j));
        sbr.setCharAt(j, ch);
    }

    public static void main(String[] args) {
        System.out.println(findMaximumNum("999914821", 4));
    }
}
