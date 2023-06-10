package interviewBit.hashing;

/**
 * Given a string A consisting of lowercase characters.
 * Check if characters of the given string can be rearranged to form a palindrome.
 * Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 */
public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(new CheckPalindrome().solve("aba"));
    }

    /**
     * Maintain a char frequency array for lowercase letters
     * return 1 if freq count is odd for <=1 element else 0
     */
    public int solve(String A) {
        int[] chars = new int[26];
        for(int i=0;i<A.length();i++) {
            chars[A.charAt(i) - 97]++;
        }
        int odd = 0;
        for (int x: chars) {
            if(x%2==1) {
                odd++;
            }
        }
        return odd<=1 ? 1 : 0;
    }
}
