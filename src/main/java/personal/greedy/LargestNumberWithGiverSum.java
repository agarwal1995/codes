package personal.greedy;

public class LargestNumberWithGiverSum {

    static String largestNumber(int n, int sum) {
        StringBuilder password = new StringBuilder();
        while (n>0) {
            int t = Math.min(sum, 9);
            sum = Math.max((sum - 9), 0);
            password.append(t);
            n--;
        }
        if (sum>0) {
            return "-1";
        }
        return password.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(5,12));
    }
}
