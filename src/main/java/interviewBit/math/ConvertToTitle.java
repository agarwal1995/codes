package interviewBit.math;

/**
 * Given a positive integer A, return its corresponding column title as appear in an Excel sheet.
 * @author raag
 */
public class ConvertToTitle {

    public static void main(String[] args) {
        System.out.println(new ConvertToTitle().convertToTitle(52));
    }

    /**
     * find mod of number by incrementing power of 26 and use it to find the result
     */
    public String convertToTitle(int A) {
        StringBuilder sbr = new StringBuilder();
        int m = 1;
        while(A>0){
            int v = (int)Math.pow(26,m)+1;
            int k = A%v;
            int x = k/(int)Math.pow(26,m-1);
            System.out.println(x + "  " + k + "  " + v);
            if(x==0) {
                x=26;
            }
            char c = (char)('A' +x-1);
            sbr.append(c);
            A = A - (A%v);
            m++;
        }
        return sbr.toString();
    }
}
