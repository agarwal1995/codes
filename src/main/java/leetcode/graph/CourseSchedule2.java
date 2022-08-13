package leetcode.graph;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseSchedule2().findOrder(4,
                new int[][]{ {1,0},{2,0},{3,1},{3,2} })));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[0], prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++) {
            if(inDegree[i]==0) {
                queue.add(i);
            }
        }
        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> adjMat = graph.adjMat;


        int count = 0;
        int idx = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int x = queue.poll();
            visited[x] = true;
            count++;
            order[idx++] = x;
            for(Integer adj : adjMat.get(x)) {
                if(!visited[adj]) {
                    inDegree[adj]--;
                    if(inDegree[adj]==0) {
                        queue.add(adj);
                    }
                }
            }
        }
        for(int i=0,j=order.length-1;i<j;i++) {
            int tmp = order[i];
            order[i] = order[j];
            order[j] = tmp;
            j--;
        }
        return count==numCourses? order : new int[]{};
    }

    class Graph {
        public List<List<Integer>> adjMat;

        Graph(int v) {
            adjMat = new ArrayList<>();
            for(int i=0;i<v;i++) {
                adjMat.add(new ArrayList<>());
            }
        }

        public void addEdge(int a, int b) {
            adjMat.get(a).add(b);
        }
    }
}



