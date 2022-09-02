package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(graph, new boolean[graph.length], 0, graph.length-1, new ArrayList<Integer>(), paths);
        return paths;
    }

    public void dfs(int[][] graph, boolean[] visited, int idx, int dest, List<Integer> currentPath, List<List<Integer>> paths) {
        currentPath.add(idx);
        if(idx == dest) {
            paths.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size()-1);
            return;
        }

        visited[idx] = true;

        for(int j=0;j<graph[idx].length;j++) {
            if(!visited[graph[idx][j]]) {
                dfs(graph, visited, graph[idx][j], dest, currentPath, paths);
            }
        }
        currentPath.remove(currentPath.size()-1);
        visited[idx] = false;

    }
}
