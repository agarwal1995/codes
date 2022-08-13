package leetcode.graph;

import java.util.*;


public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{1,0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            int x = queue.poll();
            visited[x] = true;
            count++;
            for(Integer adj : adjMat.get(x)) {
                if(!visited[adj]) {
                    inDegree[adj]--;
                    if(inDegree[adj]==0) {
                        queue.add(adj);
                    }
                }
            }
        }
        return count==numCourses;
    }

    public Graph formGraph(int[][] prerequisites, int numCourses) {
        Graph graph = new Graph(numCourses);
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[0], prerequisite[1]);
        }
        return graph;
    }
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
