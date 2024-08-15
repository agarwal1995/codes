package interviewBit.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author raag
 */
public class WordSearchBoard {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(
                Arrays.asList(
                        "ABCE","SFCS","ADEE"
                )
        );
        WordSearchBoard wordSearchBoard = new WordSearchBoard();
        System.out.println(wordSearchBoard.exist(strings, "ABCCED"));
        System.out.println(wordSearchBoard.exist(strings, "SEE"));
        System.out.println(wordSearchBoard.exist(strings, "ABCB"));
        System.out.println(wordSearchBoard.exist(strings, "ABFSAB"));
        System.out.println(wordSearchBoard.exist(strings, "ABCD"));

    }

    public int exist(ArrayList<String> A, String B) {
        int n = A.size();
        int m = A.get(0).length();
        Character[][] graph = new Character[n][m];
        int x = 0;
        for (String s: A) {
            for (int i=0;i<m;i++) {
                graph[x][i] = s.charAt(i);
            }
            x++;
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (dfs(B, m,n,0, graph, i, j)) {
                    return 1;
                }
            }
        }
        return 0;

    }

    public boolean dfs(String B,int m, int n, int bIndex, Character[][] graph, int x, int y) {
        if (bIndex==B.length()) {
            return true;
        }
        if (x==n || y==m || x<0 || y<0) {
            return false;
        }
        if (graph[x][y]==B.charAt(bIndex)) {
             boolean dfsTop    = dfs(B,m,n, bIndex+1, graph, x-1, y);
             boolean dfsRight  = dfs(B, m,n,bIndex+1, graph, x, y+1);
             boolean dfsBottom = dfs(B, m,n,bIndex+1, graph, x+1, y);
             boolean dfsLeft   = dfs(B, m,n,bIndex+1, graph, x, y-1);
             return dfsTop || dfsBottom || dfsLeft ||  dfsRight;
        } else {
            return false;
        }

    }
}
