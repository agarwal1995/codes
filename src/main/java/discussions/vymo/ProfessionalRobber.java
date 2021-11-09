package discussions.vymo;

public class ProfessionalRobber {

    private static int robAdjacentHouses(int[] array) {
        int oddSum = 0, evenSum = 0;

        evenSum = array[0];
        for (int i=1;i<array.length;i++) {
            if(i%2==0) {
                evenSum += array[i];
            } else {
                oddSum += array[i];
            }
        }
        return Math.max(evenSum, oddSum);
    }

    private static int robAdjacentHousesCircular(int[] array) {
        int oddSum = 0, evenSum = 0;

        evenSum = array[0];
        for (int i=1;i<array.length;i++) {
            if(i%2==0) {
                evenSum += array[i];
            } else {
                oddSum += array[i];
            }
        }
        if(array.length%2!=0) {
            evenSum = evenSum - Math.min(array[0], array[array.length-1]);
        }
        return Math.max(evenSum, oddSum);
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {2,7,9,3,1};
        System.out.println(robAdjacentHouses(nums));
        System.out.println(robAdjacentHousesCircular(nums));
    }
}
