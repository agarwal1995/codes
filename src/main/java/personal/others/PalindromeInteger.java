package personal.others;

public class PalindromeInteger {

    public int isPalindrome(int A) {
        if (A<0) {
            return 0;
        }
        int x = 0;

        int newNumber = 0;
        int temp = A;
        while (temp!=0) {
            int val = temp %10;
            newNumber = newNumber * (int) Math.pow(10, 1) + val;
            temp = temp/10;
            x++;
        }
        if (newNumber == A) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        PalindromeInteger palindromeInteger = new PalindromeInteger();
        System.out.println(palindromeInteger.isPalindrome(12121));
    }
}
