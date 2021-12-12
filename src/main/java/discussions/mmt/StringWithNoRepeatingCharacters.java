package discussions.mmt;

public class StringWithNoRepeatingCharacters {


    private void sol(String str) {
        int[] arr = new int[26];

        int n = str.length();
        int max = Integer.MIN_VALUE;
        int i=0,j=0;
        // abccbb
        while (j<n) {
//            if(j<i) {
//                j++;
//            }
            char ch = str.charAt(j);
            if(arr[ch-'a'] == 0) {
                max = Math.max(j-i+1, max);
                arr[ch-'a']=1;
                j++;
            } else {
                arr[str.charAt(i)-'a']--;
                i++;
            }
        }
        System.out.println(max);
    }

//    private boolean checkIfRepeating(int[] arr) {
//
//    }

    public static void main(String[] args) {
        new StringWithNoRepeatingCharacters().sol("aaaaa");
    }
}
