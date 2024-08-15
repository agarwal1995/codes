package interviewBit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author raag
 */
public class PathWithGoodNodes {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0,1,0,1,1,1));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1,2)));
        B.add(new ArrayList<>(Arrays.asList(1,5)));
        B.add(new ArrayList<>(Arrays.asList(1,6)));
        B.add(new ArrayList<>(Arrays.asList(2,3)));
        B.add(new ArrayList<>(Arrays.asList(2,4)));

        System.out.println(new PathWithGoodNodes().solve(A, B, 1));
    }

    public int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        List<List<Integer>> adjList = convertTree(A, B);
        boolean[] visited = new boolean[A.size()+1];
        return recursive(A, adjList, C, A.get(0), 1, visited);

    }

    private int recursive(ArrayList<Integer> A, List<List<Integer>> adjList, int c, int currentCount, int x, boolean[] visited) {
        if (visited[x]) {
            return 0;
        }

        visited[x] = true;
        if (adjList.get(x).size()==1 && visited[adjList.get(x).get(0)]) {
            if (currentCount<=c) {
                return 1;
            }
            else {
                return 0;
            }
        }

//        if (adjList.get(x).isEmpty()) {
//            if (currentCount<=c) {
//                return 1;
//            }
//            else {
//                return 0;
//            }
//        }

        int goodNodes = 0;
        for (int i=0;i<adjList.get(x).size();i++) {
            currentCount = currentCount + A.get(adjList.get(x).get(i)-1);
            goodNodes += recursive(A, adjList, c, currentCount, adjList.get(x).get(i), visited);
            currentCount = currentCount - A.get(adjList.get(x).get(i)-1);
        }

        return goodNodes;
    }

    private List<List<Integer>> convertTree(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = A.size();

        for (int i=0;i<=n;i++) {
            adjList.add(new ArrayList<>());
        }
        for (ArrayList<Integer> list : B) {
            int a = list.get(0);
            int b = list.get(1);

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        return adjList;
    }


}