package interviewBit.graph;

import java.util.*;

public class PathInADirectedGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1,4)));
        list.add(new ArrayList<>(Arrays.asList(2,1)));
        list.add(new ArrayList<>(Arrays.asList(4,3)));
        list.add(new ArrayList<>(Arrays.asList(4,5)));
        list.add(new ArrayList<>(Arrays.asList(2,3)));
        list.add(new ArrayList<>(Arrays.asList(2,4)));
        list.add(new ArrayList<>(Arrays.asList(1,5)));
        list.add(new ArrayList<>(Arrays.asList(5,3)));
        list.add(new ArrayList<>(Arrays.asList(2,5)));
        list.add(new ArrayList<>(Arrays.asList(5,1)));
        list.add(new ArrayList<>(Arrays.asList(4,2)));
        list.add(new ArrayList<>(Arrays.asList(3,1)));
        list.add(new ArrayList<>(Arrays.asList(5,4)));
        list.add(new ArrayList<>(Arrays.asList(3,4)));
        list.add(new ArrayList<>(Arrays.asList(1,3)));
        list.add(new ArrayList<>(Arrays.asList(4,1)));
        list.add(new ArrayList<>(Arrays.asList(3,5)));
        list.add(new ArrayList<>(Arrays.asList(3,2)));
        list.add(new ArrayList<>(Arrays.asList(5,2)));


        new PathInADirectedGraph().solve(5, list);
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph graph = new Graph(A);
        for(List<Integer> lst : B) {
            graph.addEdge(lst.get(0), lst.get(1));
        }
        boolean[] visited = new boolean[A+1];
        return dfs(A, graph.adjMat, visited, 1)?1:0;
    }

    public boolean dfs(int a, List<List<Integer>> adjMat, boolean[] visited, int s) {
        if(s==a) {
            return true;
        }
        visited[s] = true;
        for (int x: adjMat.get(s)) {
            if (!visited[x]) {
                if (dfs(a, adjMat, visited, x)) {
                    return true;
                }
            }
        }
        return false;
    }

}

class Graph {
    public List<List<Integer>> adjMat;

    Graph(int v) {
        adjMat = new ArrayList<>();
        for(int i=0;i<v+1;i++) {
            adjMat.add(new ArrayList<>());
        }
    }

    public void addEdge(int a, int b) {
        adjMat.get(a).add(b);
    }
}