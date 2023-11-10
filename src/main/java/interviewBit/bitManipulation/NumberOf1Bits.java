package interviewBit.bitManipulation;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().reverse(1));
    }

    public long reverse(long a) {
        long x = 0;
        int y = 63;
        long newN = 0;
        while(y>0) {

            x = a &1;
            a = a >>1;
            newN = newN | x;
            newN = newN<<(y);
            y--;
        }
        return newN;
    }

}
