package concepts;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    Map<Integer, Integer> disjointSet = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public void makeSet(Integer node) {
        disjointSet.put(node, node);
        rank.put(node, 0);
    }

    public void union(Integer x, Integer y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot) {
            return;
        }

        if(rank.get(xRoot) < rank.get(yRoot)) {
            disjointSet.put(xRoot, yRoot);
        } else if (rank.get(xRoot) > rank.get(yRoot)) {
            disjointSet.put(xRoot, yRoot);
        } else {
            disjointSet.put(xRoot, yRoot);
            rank.put(yRoot, rank.get(yRoot) + 1);
        }
    }

    public Integer find(int element) {
        if(disjointSet.get(element).compareTo(element) == 0) {
            return element;
        }
        disjointSet.put(element, find(disjointSet.get(element)));
        return disjointSet.get(element);
    }

    public static void printSets(int[] universe, DisjointSet ds)
    {
        for (int i: universe) {
            System.out.print(i + ":" + ds.find(i) + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        // universe of items
        int[] universe = { 1, 2, 3, 4, 5 };

        // initialize `DisjointSet` class
        DisjointSet ds = new DisjointSet();

        // create a singleton set for each element of the universe
        Arrays.stream(universe).forEach(ds::makeSet);
        printSets(universe, ds);

        ds.union(4, 3);        // 4 and 3 are in the same set
        printSets(universe, ds);

        ds.union(2, 1);        // 1 and 2 are in the same set
        printSets(universe, ds);

        ds.union(1, 3);        // 1, 2, 3, 4 are in the same set
        printSets(universe, ds);
    }

}

