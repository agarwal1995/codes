package interviewBit.bitManipulation;

/**
 * @author raag
 */
public class BitFlipping {

    public static void main(String[] args) {
        new BitFlipping().solve(5);
    }

    public int solve(int A) {
        String binaryString = Integer.toBinaryString(A);
        System.out.println(binaryString);
        StringBuilder sbr = new StringBuilder();
        for (int i=0;i<binaryString.length();i++) {
            sbr.append(binaryString.charAt(i)=='1'?0:1);
        }
        return Integer.parseInt(sbr.toString(), 2);
    }
}
