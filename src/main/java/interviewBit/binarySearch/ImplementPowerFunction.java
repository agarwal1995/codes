package interviewBit.binarySearch;

/**
 * @author raag
 */
public class ImplementPowerFunction {
    public static void main(String[] args) {
        System.out.println(new ImplementPowerFunction().pow(5, 3));
        System.out.println(new ImplementPowerFunction().pow(2, 3));
        System.out.println(new ImplementPowerFunction().pow(5, 2));
        System.out.println(new ImplementPowerFunction().pow(8, 1));
        System.out.println(new ImplementPowerFunction().pow(2, 9));
    }

    private int pow(int x,int r) {

        if(r==0) {
            return 1;
        }
        if(x == 1) {
            return x;
        }
        if(r==1) {
            return x;
        }
        if(r%2!=0) {
            return x * (pow(x, r-1));
        }
        return pow(x*x, r/2);
    }

    public int pow(int x, int n, int d) {
        long res = 1;
        long xy = (long)x;
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        while(n!=0) {
            if(n%2!=0){
                res = (res * xy);
            }
            xy = (xy * xy)%d ;
            n=n/2;
            if(res>d) {
                res = res % d;
            }
        }

        // res = (res * x)%d;
        if(res<0){
            res = res + d;
        }
        return (int)res;
    }
}


