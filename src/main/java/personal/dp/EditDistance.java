package personal.dp;

public class EditDistance {

    // convert str1 to str2
    private void recursive(String str1, String str2) {
        System.out.println(recursiveUtil(str1, str2, str1.length(), str2.length(), 0, 0));
    }

    private int recursiveUtil(String str1, String str2, int m, int n, int i, int j) {
//        System.out.println(i +"  " + j);
        if(i>=m && j>=n) {
            return 0;
        }
        if(j==n) {
            return m-i;
        }
        if(i==m) {
            return n-j;
        }
        if(str1.charAt(i) == str2.charAt(j)) {
            return recursiveUtil(str1, str2, m, n, i+1, j+1);
        }
        return Math.min(
                Math.min(recursiveUtil(str1, str2, m, n, i+1, j)+1, recursiveUtil(str1, str2, m, n, i, j+1) + 1),
                recursiveUtil(str1, str2, m, n, i+1, j+1)+1);
    }

    public static void main(String[] args) {
        new EditDistance().recursive("geek", "gesek");
        new EditDistance().recursive("cat", "cut");
        new EditDistance().recursive("sunday", "saturday");
    }
}
