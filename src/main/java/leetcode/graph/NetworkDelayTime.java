//package leetcode.graph;
//
//public class NetworkDelayTime {
//
//    public int networkDelayTime(int[][] times, int n, int k) {
//        return 0;
//    }
//
//    public int dj(int[][] times, int n, int k) {
//        int[] dist = new int[n];
//        int[][] adj = new int[n][n];
//
//        for (int i=0;i<times.length;i++) {
//            adj[times[i][0]-1][times[i][1]-1] = times[i][2];
//        }
//        for(int i=0;i<n;i++) {
//            dist[i] = Integer.MAX_VALUE;
//        }
//        boolean[] visited = new boolean[n];
//
//        for(int i=0;i<n;i++) {
//            visited[k-1] = true;
//
//            for(int j=0;j<n;j++) {
//                if(visited[])
//            }
//        }
//    }
//}
