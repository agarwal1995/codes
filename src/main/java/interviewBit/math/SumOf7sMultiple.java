package interviewBit.math;

public class SumOf7sMultiple {

    public Long solve(int A, int B) {
        int f = 0;
        int x = A%7;
        f = A + (7-x)%7;

        int l = 0;
        int y = B%7;

        l = B-y;

        if(!(f<=B) || !(l>=A)) {
            // System.out.print("sda");
            return 0l;
        }
        System.out.println(l + "  " + f+ "   ");
        int n = ((l-f)/7) + 1;
        Double sum = 0d;
        sum = ((double)n/2) * (f+l);
        System.out.println((double)n/2 * (double) (f+l));

        return (long)(double)sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumOf7sMultiple().solve(1,1000000000));
    }
}

