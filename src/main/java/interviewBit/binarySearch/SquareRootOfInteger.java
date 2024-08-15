package interviewBit.binarySearch;

/**
 * @author raag
 */
public class SquareRootOfInteger {

    public int sqrt(int A) {
        long l = 1;
        long r = A;
        long res = 0;
        if (A==0 || A == 1)  {
            return A;
        }
        while (l<=r) {
            long mid = (l+r)/2;
            long mult = ((long) mid *mid);
            if((long) A == mult) {
                return  (int)mid;
            }
            if(mult>A) {
                r = mid-1;
            } else {
                res = mid;
                l = mid+1;
            }
        }
        return (int)res;
    }
}
