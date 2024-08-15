package interviewBit.math;

/**
 * @author raag
 */
public class NextSimilarNumber {

    public static void main(String[] args) {
        System.out.println(new NextSimilarNumber().solve("218765"));
        System.out.println(new NextSimilarNumber().solve("4321"));
        System.out.println(new NextSimilarNumber().solve("892795"));
    }

    public String solve(String number) {
        int n = number.length();
        int prev = -1;
        int i = n-1;
        for (;i>=0;i--) {
            int x = (int) number.charAt(i) - '0';
            if (prev == -1) {
                prev = x;
                continue;
            }
            if (x<prev) {
                break;
            }
            prev = x;
        }
        if (i<0) {
            return "-1";
        }
        StringBuilder sbr = new StringBuilder(number);
        int k =-1;
        for (int j=n-1;j>i;j--) {
            if (number.charAt(j) > number.charAt(i)) {
                k = j;
                break;
            }
        }
        char ch = sbr.charAt(i);
        sbr.setCharAt(i, sbr.charAt(k));
        sbr.setCharAt(k, ch);
        StringBuilder sbr2 = new StringBuilder(sbr.substring(i+1));
        sbr2.reverse();
        return sbr.substring(0, i+1) + sbr2;
    }
}