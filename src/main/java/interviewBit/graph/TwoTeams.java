package interviewBit.graph;

import java.util.*;

/**
 * @author raag
 */
public class TwoTeams {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1,2)));
        list.add(new ArrayList<>(Arrays.asList(2,3)));
        list.add(new ArrayList<>(Arrays.asList(1,5)));
        list.add(new ArrayList<>(Arrays.asList(2,4)));

        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        list2.add(new ArrayList<>(Arrays.asList(1,4)));
        list2.add(new ArrayList<>(Arrays.asList(1,3)));
        list2.add(new ArrayList<>(Arrays.asList(4,3)));
        list2.add(new ArrayList<>(Arrays.asList(2,1)));


        ArrayList<ArrayList<Integer>> list3 = new ArrayList<>();
        list3.add(new ArrayList<>(Arrays.asList(8,7)));
        list3.add(new ArrayList<>(Arrays.asList(8,6)));
        list3.add(new ArrayList<>(Arrays.asList(8,2)));
        list3.add(new ArrayList<>(Arrays.asList(4,9)));
        list3.add(new ArrayList<>(Arrays.asList(11,10)));
        list3.add(new ArrayList<>(Arrays.asList(5,10)));
        list3.add(new ArrayList<>(Arrays.asList(1,10)));
        list3.add(new ArrayList<>(Arrays.asList(3,7)));
        list3.add(new ArrayList<>(Arrays.asList(3,6)));
        list3.add(new ArrayList<>(Arrays.asList(11,7)));
        list3.add(new ArrayList<>(Arrays.asList(5,7)));
        list3.add(new ArrayList<>(Arrays.asList(1,6)));
        list3.add(new ArrayList<>(Arrays.asList(3,2)));
        list3.add(new ArrayList<>(Arrays.asList(8,9)));
        list3.add(new ArrayList<>(Arrays.asList(4,10)));
        list3.add(new ArrayList<>(Arrays.asList(5,6)));
        list3.add(new ArrayList<>(Arrays.asList(4,7)));
        list3.add(new ArrayList<>(Arrays.asList(4,6)));

//        System.out.println(new TwoTeams().solve(5, list));
//        System.out.println(new TwoTeams().solve(4, list2));
        System.out.println(new TwoTeams().solve(11, list3));
    }

//    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
//        List<List<Integer>> adjList = new ArrayList<>();
//        for (int i=0;i<=A;i++) {
//            adjList.add(new ArrayList<>());
//        }
//
//        // form the adjacency matrix
//        for (int i=0;i<B.size();i++) {
//            adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
//            adjList.get(B.get(i).get(1)).add(B.get(i).get(0));
//        }
//
//        // find cycle
//
//        boolean[] visited = new boolean[A+1];
//
//        for (int i=0;i<A;i++) {
//            if (visited[i+1]) {
//                continue;
//            }
//            Queue<Integer> queue = new LinkedList<>();
//            queue.add(i+1);
//
//            while (!queue.isEmpty()) {
//                int x = queue.poll();
//
//                if (visited[x]) {
//                    return 0;
//                }
//
//                visited[x] = true;
//                for (int y:adjList.get(x)) {
//                    if (!visited[y]) {
//                        queue.add(y);
//                    }
//                }
//            }
//        }
//        return 1;
//    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<=A;i++) {
            adjList.add(new ArrayList<>());
        }

        // form the adjacency matrix
        for (int i=0;i<B.size();i++) {
            adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
            adjList.get(B.get(i).get(1)).add(B.get(i).get(0));
        }

        int[] colour = new int[A+1];
        Arrays.fill(colour, -1);

        int x = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1;i<=A;i++) {
            if (colour[i]!=-1) {
                continue;
            }

            colour[i] = 0;
            queue.add(i);
            while (!queue.isEmpty()) {
//                x = x == 0 ? 1 : 0;
                int node = queue.poll();
                for (int adj: adjList.get(node)) {
                    if (colour[adj]==-1) {
                        colour[adj] = colour[node]^1;
                        queue.add(adj);
                    } else if (colour[node]==colour[adj]) {
                        return 0;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(colour));
        return 1;
    }
}
