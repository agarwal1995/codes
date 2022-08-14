package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(list, destination, source, visited);
    }

    public boolean dfs(List<List<Integer>> adjList, int dest, int x, boolean[] visited) {
        if(x==dest) {
            return true;
        }
        visited[x] = true;
        for(int y:adjList.get(x)) {
            if(!visited[y] && dfs(adjList, dest, y, visited)) {
                return true;
            }
        }
        return false;
    }
}
