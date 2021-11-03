package personal.linked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntersectionPointInYShapedLinkedList {

    int intersectPoint(Node head1, Node head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);

        Node lastEqualNode = null;
        while (head1!=null && head2!=null) {
            if (head1.data == head2.data) {
                lastEqualNode = head1;
            } else {
                return lastEqualNode == null ? -1 : lastEqualNode.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }

    Node reverseList(Node head) {
        Node prev = null;
        Node curr = head, next;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());
        String[] line1 = br.readLine().trim().split("\\s+");

        int n = Integer.parseInt(br.readLine().trim());
        String[] line2 = br.readLine().trim().split("\\s+");

        Node first = null, fHead = null;
        for(int i=0;i<m;i++) {
            Node node = new Node(Integer.parseInt(line1[i]));
            if(fHead == null) {
                fHead = node;
                first = node;
                continue;
            }
            first.next = node;
            first = first.next;
        }

        Node second = null, sHead = null;
        for(int i=0;i<n;i++) {
            Node node = new Node(Integer.parseInt(line2[i]));
            if(sHead == null) {
                sHead = node;
                second = node;
                continue;
            }
            second.next = node;
            second = second.next;
        }

        System.out.println(new IntersectionPointInYShapedLinkedList().intersectPoint(fHead, sHead));
    }
}
