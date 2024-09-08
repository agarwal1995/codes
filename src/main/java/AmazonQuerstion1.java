import java.util.*;

/**
 * @author raag
 */
public class AmazonQuerstion1 {

    public static void main(String[] args) {
        System.out.println(getMinScore(Arrays.asList(1,2,2,2,5,2), 1,5));
        System.out.println(getMinScore(Arrays.asList(1,1,1,1,1), 1,5));
        System.out.println(getMinScore(Arrays.asList(1,3,2,1,4), 1,2));
        System.out.println(getMinScore(Arrays.asList(1,3,2,2,1,0), 1,2));
        System.out.println(getMinScore(Arrays.asList(1,3,2,2,1,0), 3,0));
        System.out.println(getMinScore(Arrays.asList(1,3,2,2,1,0), 2,2));
        System.out.println(getMinScore(Arrays.asList(), 2,2));
    }

    public static int getMinScore(List<Integer> watch_history, int series1, int series2) {
        int i=1,j=1;
        int n = watch_history.size();
        if (watch_history.isEmpty()) {
            return 0;
        }

        while (j<n) {
            if (watch_history.get(j).compareTo(watch_history.get(i-1))==0) {
                j++;
            } else {
                watch_history.set(i, watch_history.get(j));
                i++;
                j++;
            }
        }
        watch_history = watch_history.subList(0, i);


        int series1Index = -1;
        int series2Index = -1;
        int minWindow = Integer.MAX_VALUE;
        for (int k=0;k<watch_history.size();k++) {
            if (watch_history.get(k)==series1) {
                series1Index=k;
            }
            if (watch_history.get(k)==series2) {
                series2Index=k;
            }
            if (series1Index!=-1 && series2Index!=-1) {
                minWindow = Math.min(minWindow, Math.abs(series1Index-series2Index)+1);
            }
        }

        return minWindow==Integer.MAX_VALUE?0:minWindow;
    }
}
