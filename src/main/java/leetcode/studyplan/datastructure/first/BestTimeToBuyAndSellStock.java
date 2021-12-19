package leetcode.studyplan.datastructure.first;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int[] maxFromRight = new int[prices.length];
        int n = prices.length;
        maxFromRight[n-1] = prices[n-1];
        for(int i=n-2;i>=0;i--) {
            maxFromRight[i] = Math.max(maxFromRight[i+1], prices[i]);
        }
        int max = 0;
        for(int i=0;i<n;i++) {
            max = Math.max(max, maxFromRight[i] - prices[i]);
        }
        return max;
    }
}
