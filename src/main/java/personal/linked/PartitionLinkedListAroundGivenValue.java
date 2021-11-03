package personal.linked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PartitionLinkedListAroundGivenValue {

    public static Node partition(Node node, int x) {
        Node lessValues = null;
        Node greaterValue = null;
        Node equalValue = null;
        Node lHead = null;
        Node gHead = null;
        Node eHead = null;

        while (node!=null) {
            if(node.data < x) {
                if (lHead == null) {
                    lHead = node;
                    lessValues = node;
                } else {
                    lessValues.next = node;
                    lessValues = lessValues.next;
                }
            } else if (node.data > x) {
                if(gHead == null) {
                    gHead = node;
                    greaterValue = node;
                } else {
                    greaterValue.next = node;
                    greaterValue = greaterValue.next;
                }
            } else {
                if (equalValue == null) {
                    eHead = node;
                    equalValue = node;
                } else {
                    equalValue.next = node;
                    equalValue = equalValue.next;
                }
            }
            node = node.next;
        }
        if (lHead == null) {
            if (eHead == null) {
                return gHead;
            }
            equalValue.next = gHead;
            if (gHead != null) {
                greaterValue.next = null;
            }
            return eHead;
        }
        if (eHead == null) {
            lessValues.next = gHead;
            if (gHead!=null) {
                greaterValue.next = null;
            }
            return lHead;
        }
        lessValues.next = null;
        equalValue.next = null;
        if (gHead!=null)
        greaterValue.next = null;
        lessValues.next = eHead;
        equalValue.next = gHead;
        return lHead;
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
        partition(fHead, 3);
    }
}
