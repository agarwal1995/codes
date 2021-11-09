package discussions.vymo;

public class FirstNonRepeatingString {

    private static int firstNonRepeatingCharacter(String str) {
        int[] array = new int[26];
        for(int i=0;i<26;i++) {
            array[i] = -2;
        }

        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (array[index] >=0) {
                array[index] = -1;
            }
            if(array[index] == -2) {
                array[index] = i;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<26;i++) {
            if (array[i]>=0) {
                minIndex = Math.min(minIndex, array[i]);
            }
        }
        return minIndex !=Integer.MAX_VALUE ? minIndex : -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(firstNonRepeatingCharacter("code"));
    }
}
