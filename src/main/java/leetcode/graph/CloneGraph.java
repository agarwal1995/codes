package leetcode.graph;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null) {
            return node;
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        Map<Integer, Node> map = new HashMap<>();
        map.put(1, cloneNode);
        dfs(node, 1, map);
        return cloneNode;
    }

    public void dfs(Node node, int x, Map<Integer, Node> cloneNodes) {
        for(Node nde : node.neighbors) {
            if(!cloneNodes.containsKey(nde.val)) {
                Node neighbourNode = new Node(nde.val, new ArrayList<>());

                cloneNodes.put(nde.val, neighbourNode);

                cloneNodes.get(node.val).neighbors.add(neighbourNode);
                dfs(nde, x, cloneNodes);
            } else {
                if(cloneNodes.containsKey(nde.val)) {
                    cloneNodes.get(node.val).neighbors.add(cloneNodes.get(nde.val));
                }
            }
        }
    }

    public void print(Node node, Map<Integer, Boolean> visited) {
        visited.put(node.val, true);
        System.out.println(node.val);
        for(Node x:node.neighbors) {
            System.out.println(":" + x.val);
        }
        for(Node c:node.neighbors) {
            if(!visited.containsKey(c.val)) {
                print(c, visited);
            }
        }
    }
}