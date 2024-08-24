package algo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class Djisktra {

    public static void main(String[] args) {

    }

    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);


        dist[S] = 0;

        for (int i=0;i<V;i++) {
            int minVertex = getMinVertex(visited, dist);
            if (minVertex==-1) {
                break;
            }
            visited[minVertex] = true;
            for (ArrayList<Integer> neighbour:adj.get(minVertex)) {
                int v = neighbour.get(0);
                int distance = neighbour.get(1);
                if (!visited[v] && dist[v]>dist[minVertex]+distance) {
                    dist[v] = dist[minVertex] + distance;
                }
            }
        }

        return dist;
    }

    private static int getMinVertex(boolean[] visited, int[] dist) {
        int v = visited.length;
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i=0;i<v;i++) {
            if (!visited[i] && dist[i]<minValue) {
                minIndex = i;
                minValue = dist[i];
            }
        }
        return minIndex;
    }
}
