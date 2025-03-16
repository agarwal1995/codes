package gfg.must_do_questions.stacks_queues;

public class CircularTour {

    public static void main(String[] args) {

    }

    public int startStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int currGas = 0;
        int ind = 0;

        for (int i=0;i<gas.length;i++) {
            currGas = currGas + gas[i] - cost[i];
            totalGas = totalGas + gas[i] - cost[i];

            if (currGas<0) {
                currGas = 0;
                ind = i+1;
            }
        }

        if (totalGas<0) {
            return -1;
        }
        return ind;
    }

}
