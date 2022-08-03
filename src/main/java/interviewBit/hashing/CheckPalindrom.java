package interviewBit.hashing;

public class CheckPalindrom {
    public int solve(String A) {
        int[] chars = new int[26];
        for(int i=0;i<A.length();i++) {
            chars['a'- A.charAt(i)]++;
        }
        int odd = 0;
        for (int x: chars) {
            if(x%2==1) {
                odd++;
            }
        }
        return odd%2;
    }
}
