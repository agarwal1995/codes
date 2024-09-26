package interviewBit.dp;

/**
 * @author raag
 */
public class ClimbStairs {

        public int climbStairs(int A) {

            int a = 1;
            int b = 2;

            if(A==1) {
                return 1;
            }

            if(A==2) {
                return 2;
            }

            int c = 0;
            for(int i=3;i<=A;i++) {
                c = a+b;
                a=b;
                b=c;
            }
            return c;

    }
}
