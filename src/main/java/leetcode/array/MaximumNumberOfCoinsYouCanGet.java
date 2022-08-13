package leetcode.array;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int n = piles.length;

        int sum = 0;

        int turns = n/3;

        int x = n-2;
        for(int i = 0;i<turns;i++) {
            sum = sum + piles[x];
            x = x - 2;
        }
        return sum;
    }
}
