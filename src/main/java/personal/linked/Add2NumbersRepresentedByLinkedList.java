package personal.linked;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Add2NumbersRepresentedByLinkedList {

    static Node addTwoLists(Node first, Node second){
        first = reverseList(first);
        second = reverseList(second);

        Node result = null, head = null;
        int carry = 0;
        int sum = 0;
        while(first!=null && second!=null) {
            sum = first.data + second.data + carry;
            if (sum>9) {
                carry = 1;
                sum = sum-10;
            } else {
                carry=0;
            }
            Node node = new Node(sum);
            if(result==null) {
                result = node;
                head = result;
            } else {
                result.next = node;
                result = result.next;
            }
            first = first.next;
            second = second.next;
        }
        while(first!=null) {
            sum = first.data + carry;
            if (sum>9) {
                carry = 1;
                sum = sum-10;
            } else {
                carry=0;
            }
            Node node = new Node(sum);
            if(result==null) {
                result = node;
                head = result;
            } else {
                result.next = node;
                result = result.next;
            }
            first = first.next;
        }

        while(second!=null) {
            sum = second.data + carry;
            if (sum>9) {
                carry = 1;
                sum = sum-10;
            } else {
                carry=0;
            }
            Node node = new Node(sum);
            if(result==null) {
                result = node;
                head = result;
            } else {
                result.next = node;
                result = result.next;
            }
            second = second.next;
        }
        if(carry ==1 ) {
            Node node = new Node(1);
            result.next = node;
        }
        return reverseList(head);

    }

    static Node reverseList(Node head)
    {
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
        addTwoLists(fHead, sHead);
    }
}
