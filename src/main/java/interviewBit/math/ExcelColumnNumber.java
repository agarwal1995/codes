package interviewBit.math;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelColumnNumber().titleToNumber("AZ"));
    }
    public int titleToNumber(String A) {
        int sum = 0;
        for(int i=0;i<A.length();i++) {
            int k = A.charAt(i) - 'A' + 1;
            sum = sum + (int)Math.pow(26, A.length()-i-1) * k;

        }
        return sum;
    }
}
