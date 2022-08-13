package leetcode.graph;

public class CentreOfGraph {

    class Solution {
        public int findCenter(int[][] edges) {
            int n = edges.length;
            int[] indegree = new int[n+1];
            for(int i=0;i<n;i++) {
                indegree[edges[i][0]-1]++;
                indegree[edges[i][1]-1]++;
            }

            int max = 0;
            int maxV = -1;
            for(int i=0;i<=n;i++) {
                if(max<indegree[i]) {
                    max = indegree[i];
                    maxV = i;
                }
            }
            return maxV+1;
        }
    }
}
