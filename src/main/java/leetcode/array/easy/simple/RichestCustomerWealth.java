package leetcode.array.easy.simple;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for(int i=0;i<accounts.length;i++) {
            int curW = 0;
            for(int j=0;j<accounts[i].length;j++) {
                curW +=accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, curW);
        }
        return maxWealth;
    }
}
