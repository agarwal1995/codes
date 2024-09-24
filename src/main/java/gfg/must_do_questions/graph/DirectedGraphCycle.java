package gfg.must_do_questions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author raag
 */
public class DirectedGraphCycle {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
//        arrayLists.add(new ArrayList<>(Arrays.asList(1,2)));
//        arrayLists.add(new ArrayList<>(Arrays.asList(2)));
//        arrayLists.add(new ArrayList<>(Arrays.asList(3,0)));
//        arrayLists.add(new ArrayList<>(Arrays.asList()));

        arrayLists.add(new ArrayList<>(Arrays.asList(1)));
        arrayLists.add(new ArrayList<>(Arrays.asList(2)));
        arrayLists.add(new ArrayList<>(Arrays.asList(3)));
        arrayLists.add(new ArrayList<>(Arrays.asList(3)));
        System.out.println(new DirectedGraphCycle().isCyclic(4, arrayLists));
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                boolean isCycle = dfs(i, adj, visited, new HashSet<>());
                if (isCycle) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Set<Integer> paths) {
        visited[node] = true;
        paths.add(node);
        for (int neighbour: adj.get(node)) {
            if (!visited[neighbour]) {
                boolean res = dfs(neighbour, adj, visited, paths);
                if (res) {
                    return true;
                }
            } else {
                if (paths.contains(neighbour)) {
                    return true;
                }
            }
        }
        paths.remove(node);
        return false;
    }
}
