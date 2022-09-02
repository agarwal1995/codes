package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if(isConnected[i][j]==1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int count = 0;
        for (int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(adjList, i, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<List<Integer>> adjList, int idx, boolean[] visited) {
        visited[idx] = true;

        for(Integer x:adjList.get(idx)) {
            if(!visited[x]) {
                dfs(adjList, x, visited);
            }
        }
    }
}
