package interviewBit.math;

/**
 * @author raag
 */
public class StepByStep {

    public static void main(String[] args) {
        System.out.println(new StepByStep().solve(2));
        System.out.println(new StepByStep().solve(3));
    }

    public int solve(int target) {
        target = Math.abs(target);
        int sum = 0;
        int i=0;
        while (sum<target) {
            ++i;
            sum = sum + i;
        }
        if (sum==target) {
            return i;
        }

        if ((sum-target)%2==0) {
            return i;
        }
        sum = sum + i+1;
        if ((sum-target)%2==0) {
            return i+1;
        }
        return i+2;
    }

}