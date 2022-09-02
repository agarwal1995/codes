package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumNumberOfVerticesToReachAllNodes {

    // Simple Solution Find Indegree with 1 only
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for(int i=0;i<edges.size();i++) {
            indegree[edges.get(i).get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) {
                result.add(i);
            }
        }
        return result;
    }

    // Initial Solution Proposed By Me
    public List<Integer> findSmallestSetOfVerticesLongWay(int n, List<List<Integer>> edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++) {
            indegree[edges.get(i).get(1)]++;
            adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        List<Integer> topologicalOrder = getTopologicalOrder(n, adjList, indegree);

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<topologicalOrder.size();i++) {
            if(!visited[topologicalOrder.get(i)]) {
                result.add(topologicalOrder.get(i));
                dfs(adjList, topologicalOrder.get(i), visited);
            }
        }
        return result;
    }

    public List<Integer> getTopologicalOrder(int n, List<List<Integer>> adjList, int[] indegree) {

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) {
                queue.add(i);
            }
        }

        List<Integer> orderedSet = new ArrayList<>();
        while(!queue.isEmpty()) {
            int polledElement = queue.poll();
            orderedSet.add(polledElement);
            for(int x:adjList.get(polledElement)) {
                indegree[x]--;
                if(indegree[x]==0) {
                    queue.add(x);
                }
            }
        }
        return orderedSet;
    }

    public void dfs(List<List<Integer>> adjList, int idx, boolean[] visited) {
        visited[idx] = true;

        for(int x:adjList.get(idx)) {
            if(!visited[x]) {
                dfs(adjList, x, visited);
            }
        }
    }
}
