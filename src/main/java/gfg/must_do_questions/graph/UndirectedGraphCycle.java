package gfg.must_do_questions.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class UndirectedGraphCycle {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1)));
        adj.add(new ArrayList<>(Arrays.asList(0,2,4)));
        adj.add(new ArrayList<>(Arrays.asList(1,3)));
        adj.add(new ArrayList<>(Arrays.asList(2,4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
//        adj.add(new ArrayList<>(Arrays.asList(0,4)));
//        adj.add(new ArrayList<>(Arrays.asList(0,5)));
//        adj.add(new ArrayList<>(Arrays.asList(0,6)));
//        adj.add(new ArrayList<>(Arrays.asList(0,7)));
//        adj.add(new ArrayList<>(Arrays.asList(1,2)));
//        adj.add(new ArrayList<>(Arrays.asList(1,4)));
//        adj.add(new ArrayList<>(Arrays.asList(2,3)));
//        adj.add(new ArrayList<>(Arrays.asList(2,6)));
//        adj.add(new ArrayList<>(Arrays.asList(2,7)));
//        adj.add(new ArrayList<>(Arrays.asList(3,4)));
//        adj.add(new ArrayList<>(Arrays.asList(3,5)));
//        adj.add(new ArrayList<>(Arrays.asList(3,7)));
//        adj.add(new ArrayList<>(Arrays.asList(4,5)));
//        adj.add(new ArrayList<>(Arrays.asList(6,7)));
        System.out.println(new UndirectedGraphCycle().isCycle(5, adj));
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                boolean isCycle = dfs(i, adj, visited, -1);
                if (isCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[node] = true;
        for (int neighbour:adj.get(node)) {
            if (!visited[neighbour]) {
                boolean res = dfs(neighbour, adj, visited, node);
                if (res) {
                    return true;
                }
            } else if (visited[neighbour] && parent!=-1 && neighbour!=parent) {
                return true;
            }
        }
        return false;
    }
}
