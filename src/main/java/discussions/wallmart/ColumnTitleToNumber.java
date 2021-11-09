package discussions.wallmart;

public class ColumnTitleToNumber {

    private static void findNumber(String str) {
        int sum = 0;

        int n = str.length();
        int powIndex = 0;
        for(int i=n-1;i>=0;i--) {
            int val = str.charAt(i) - 'A' + 1;
            sum += Math.pow(26, powIndex) * val;
            powIndex++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        findNumber("1AB");
    }

}
