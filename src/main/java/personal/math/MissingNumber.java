package personal.math;

public class MissingNumber {

    int missingNumber(int array[], int n) {
        int sum = 0;
        for(int i=0;i<n-1;i++) {
            sum = sum + array[i];
        }

        return ((n*(n+1))/2) - sum;
    }
}
