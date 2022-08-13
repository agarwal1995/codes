package leetcode.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumHeightTrees {

//    class Solution {
//        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//            Graph graph = new Graph(n);
//            for(int i=0;i<edges.length;i++) {
//                graph.addEdge(edges[i][0], edges[i][1]);
//            }
//
//
//            int k=0;
//            int i=0;
//            int j=0;
//
//            int[][] distMat = new int[n][n];
//            for(i=0;i<n;i++) {
//                for (j=0;j<n;j++) {
//                    distMat[i][j] = Integer.MAX_VALUE;
//                }
//            }
//
//            for (i=0;i<n;i++) {
//                for(int x : graph.adjMat.get(i)) {
//                    distMat[i][x]=1;
//                    distMat[x][i]=1;
//                }
//            }
//
//            for(k=0;k<n;k++) {
//                for (i=0;i<n;i++) {
//                    for (j=0;j<n;j++) {
//                        if(i!=j && distMat[i][k]!=Integer.MAX_VALUE && distMat[k][j]!=Integer.MAX_VALUE && distMat[i][j]> (distMat[i][k] + distMat[k][j])) {
//                            distMat[i][j] = distMat[i][k] + distMat[k][j];
//                        }
//                    }
//                }
//            }
//
//            int[]  edgeToMaxDistance = new int[n];
//            int minOfMax = Integer.MAX_VALUE;
//            for(i=0;i<n;i++) {
//                int max = Integer.MIN_VALUE;
//                for (j=0;j<n;j++) {
//                    if(distMat[i][j]!=Integer.MAX_VALUE) {
//                        max = Math.max(max, distMat[i][j]);
//                    }
//                }
//                edgeToMaxDistance[i] = max;
//                if(max != Integer.MIN_VALUE) {
//                    minOfMax = Math.min(minOfMax, max);
//                }
//
//            }
//
//            List<Integer> result = new ArrayList<>();
//            for (int l=0;l<n;l++) {
//                if(edgeToMaxDistance[l]==minOfMax) {
//                    result.add(l);
//                }
//            }
//            System.out.println(minOfMax);
//            System.out.println(result);
////            Arrays.stream(distMat).forEach(x-> {System.out.println(Arrays.toString(x));});
//            return result;
//        }
//    }


    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Graph graph = new Graph(n);
            int[] outdegree = new int[n];
            for (int i=0;i<n-1;i++) {
                graph.addEdge(edges[i][0], edges[i][1]);
                outdegree[edges[i][0]]++;
                outdegree[edges[i][1]]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int i=0;i<n;i++) {
                if (outdegree[i]==1) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {

                int polledElement = queue.poll();
                n--;
                outdegree[polledElement]--;
                for(Integer x : graph.adjMat.get(polledElement)) {
                    outdegree[x]--;
                    if (outdegree[x]==1) {
                        queue.add(x);
                    }
                }
                if(n<=2) {
                    break;
                }
            }

            List<Integer> sol = new ArrayList<>();
            if(n==2) {
                while (!queue.isEmpty()) {
                    int r = outdegree[queue.poll()];
                    if(r!=0)
                        sol.add(r);
                }
            } else {
                sol.add(queue.poll());
            }
            return  sol;
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
            adjMat.get(b).add(a);

        }
    }


    public static void main(String[] args) throws Exception {
        MinimumHeightTrees mht = new MinimumHeightTrees();
        Solution s = mht.new Solution();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 4;
        int[][] edges = new int[n][2];



        for(int i=0;i<n-1;i++) {
            String[] s2 = br.readLine().trim().split("\\s+");
            edges[i][0] = Integer.parseInt(s2[0]);
            edges[i][1] = Integer.parseInt(s2[1]);
        }
//        Arrays.stream(edges).forEach(x-> {System.out.println(Arrays.toString(x));});
        long x = System.currentTimeMillis();
        s.findMinHeightTrees(n, edges);
//        System.out.println(System.currentTimeMillis()-x);
    }
}
