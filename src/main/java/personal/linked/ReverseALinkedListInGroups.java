package personal.linked;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseALinkedListInGroups {

    public static Node reverse(Node node, int k) {
        Stack<Node> stack = new Stack<>();
        int x = 0;
        Node resultHead = null, result = null;
        while (node!=null) {
            stack.push(node);
            node = node.next;
            x++;

            if(x==k || node == null) {
                Node head = stack.pop();
                head.next = null;
                Node curr = head;
                while (!stack.empty()) {
                    Node top = stack.pop();
                    top.next = null;
                    curr.next = top;
                    curr = top;
                }

                if(resultHead == null) {
                    resultHead = head;
                    result = curr;
                } else {
                    result.next = head;
                    result = curr;
                }
                x = 0;
            }
        }
        return resultHead;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] line = br.readLine().trim().split("\\s+");

        Node first = null, fHead = null;
        for(int i=0;i<n;i++) {
            Node node = new Node(Integer.parseInt(line[i]));
            if(fHead == null) {
                fHead = node;
                first = node;
                continue;
            }
            first.next = node;
            first = first.next;
        }
        reverse(fHead, 3);
    }
}
