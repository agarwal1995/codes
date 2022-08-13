package interviewBit.graph.helpers;

import java.util.ArrayList;
import java.util.List;

public class Graph {
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