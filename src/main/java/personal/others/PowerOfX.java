package personal.others;

public class PowerOfX {

    public static long recursive(int x, int y) {
        if(y == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        if (y%2==0) {
            return recursive(x*x, y/2);
        } else {
            return x * recursive(x, y-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(recursive(2,3));
    }
}
