package personal.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBoggle {

    public String[] wordBoggle(char board[][], String[] dictionary) {
        Set<String> set = Arrays.stream(dictionary).collect(Collectors.toSet());
        Set<String> sol = new HashSet<>();
        StringBuilder sbr = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                wordBoggleUtil(board, set, sol,dictionary.length, sbr, visited,i,j, board.length, board[0].length);
            }
        }
        String[] strings = new String[sol.size()];
        int i=0;
        for(String s : sol) {
            strings[i] = s;
            i++;
        }
        return strings;
    }

    public void wordBoggleUtil(char board[][], Set<String> dictionary, Set<String> sol,Integer index, StringBuilder sbr,boolean[][] visited, int i, int j, int m, int n) {
        if (((i>=m || j>=n) || (i<0 || j<0)) || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        sbr.append(board[i][j]);
        if (dictionary.contains(sbr.toString())) {
            sol.add(sbr.toString());
            dictionary.remove(sbr.toString());
            sbr.deleteCharAt(sbr.length()-1);
            visited[i][j] = false;
            return;
        }
        wordBoggleUtil(board, dictionary, sol, index, sbr, visited, i-1, j-1, m, n);
        wordBoggleUtil(board, dictionary, sol, index, sbr, visited, i-1, j, m, n);
        wordBoggleUtil(board, dictionary, sol, index, sbr, visited, i-1, j+1, m, n);
        wordBoggleUtil(board, dictionary, sol, index, sbr, visited, i, j-1, m, n);
        wordBoggleUtil(board, dictionary, sol, index, sbr, visited, i, j+1, m, n);
        wordBoggleUtil(board, dictionary, sol, index, sbr, visited, i+1, j-1, m, n);
        wordBoggleUtil(board, dictionary, sol, index, sbr, visited, i+1, j, m, n);
        wordBoggleUtil(board, dictionary, sol, index, sbr, visited, i+1, j+1, m, n);
        sbr.deleteCharAt(sbr.length()-1);
        visited[i][j] = false;
    }

    public static void main(String[] args) throws Exception {
        WordBoggle wordBoggle = new WordBoggle();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n2 = Integer.parseInt(br.readLine().trim());
        String[] dictionary = br.readLine().trim().split("\\s+");
        String[] line1 = br.readLine().trim().split("\\s+");
        int m = Integer.parseInt(line1[0]);
        int n = Integer.parseInt(line1[1]);

        char[][] board = new char[m][n];
        for(int i=0;i<m;i++) {
            String[] line2 = br.readLine().trim().split("\\s+");
            for (int j=0;j<n;j++) {
                board[i][j] = line2[j].charAt(0);
            }
        }
        System.out.println(Arrays.toString(wordBoggle.wordBoggle(board, dictionary)));
    }
}
