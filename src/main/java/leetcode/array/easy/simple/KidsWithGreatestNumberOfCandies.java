package leetcode.array.easy.simple;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = 0;
        for(int i=0;i<candies.length;i++) {
            max = Math.max(candies[i], max);
        }

        for(int i=0;i<candies.length;i++) {
            res.add(candies[i]+extraCandies>=max? true: false);
        }
        return res;
    }
}
