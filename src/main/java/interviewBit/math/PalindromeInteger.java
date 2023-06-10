package interviewBit.math;

public class PalindromeInteger {
    public static void main(String[] args) {
        System.out.println(new PalindromeInteger().isPalindrome(123));
    }
    public int isPalindrome(int A) {
        int k = 0;
        int num = A;
        int rev = 0;
        if(A<0) {
            return 0;
        }
        while(A!=0) {
            int r = A%10;
            rev = r + rev*10;
            k++;
            A = A/10;
        }
        return rev==num?1:0;
    }
}
