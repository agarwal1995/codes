package personal.others;


import java.util.Arrays;

public class NextSimilarNumber {

    public String solve(String A) {
        int n = A.length();
        if(n<=1) {
            return "-1";
        }
        StringBuilder stringBuilder = new StringBuilder(A);
        int max = A.charAt(n-1);
        int index = n-1;
        for(int i=n-2;i>=0;i--) {
            if(A.charAt(i) < max) {
                int val = A.charAt(i);
                int min = max;
                for(int j=i+1;j<n;j++) {
                    if(A.charAt(j) > val && A.charAt(j) < min) {
                        min = A.charAt(j);
                        index = j;
                    }
                }

                char ch = A.charAt(i);
                stringBuilder.setCharAt(i, (char) min);
                stringBuilder.setCharAt(index, ch);

                String secondString = stringBuilder.substring(i+1, n-1);
                char[] chars = secondString.toCharArray();
                Arrays.sort(chars);

                stringBuilder.delete(i+1, n-1);
                stringBuilder.append(chars);
                return stringBuilder.toString();
            } else if (A.charAt(i) > max){
                max = A.charAt(i);
                index = i;
            }
        }
        return "-1";
    }


    public static void main(String[] args) {
        NextSimilarNumber nextSimilarNumber = new NextSimilarNumber();
        System.out.println(nextSimilarNumber.solve("255"));
    }
}
