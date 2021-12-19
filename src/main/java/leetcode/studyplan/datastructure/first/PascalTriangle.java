package leetcode.studyplan.datastructure.first;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        if(numRows>0) {
            row.add(1);
            sol.add(row);
        }
        if(numRows>1) {
            row = new ArrayList<>();
            row.add(1);
            row.add(1);
            sol.add(row);
        }

        for(int i=1;i<numRows-1;i++) {
            List<Integer> previousRow = sol.get(sol.size()-1);
            row = new ArrayList<>();
            row.add(1);
            for(int j=0;j<previousRow.size()-1;j++) {
                row.add(previousRow.get(j) + previousRow.get(j+1));
            }
            row.add(1);
            sol.add(row);
        }
        return sol;
    }
}
