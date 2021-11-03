package personal.linked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateLinkedList {

    public Node rotate(Node head, int k) {
        int x = 0;
        Node curr = head;
        while (curr!=null) {
            x++;
            if (x == k) {
                break;
            }
            curr = curr.next;
        }
        if(curr==null || curr.next==null) {
            return head;
        }
        Node secondHead = curr.next;
        curr.next = null;
        curr = secondHead;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = head;
        return secondHead;
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
        new RotateLinkedList().rotate(fHead, 3);
    }
}
