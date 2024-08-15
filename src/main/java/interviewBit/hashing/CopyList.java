//package interviewBit.hashing;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author raag
// */
//public class CopyList {
//
//    public static void main(String[] args) {
//
//    }
//
//    public RandomListNode copyRandomList(RandomListNode head) {
//        Map<RandomListNode, RandomListNode> randomPointers = new HashMap<>();
//
//        if (head==null) {
//            return null;
//        }
//
//        RandomListNode temp = head;
//
//
//        RandomListNode resultHead = new RandomListNode(head.label);
//        RandomListNode rs = resultHead;
//
//        temp = head.next;
//
//        while (temp!=null) {
//            rs.next = new RandomListNode(temp.label);
//            temp = temp.next;
//            randomPointers.put(temp, rs);
//            rs = rs.next;
//        }
//
//        temp = head'
//        while ()
//
//        return resultHead;
//    }
//}
//
//class RandomListNode {
//      int label;
//      RandomListNode next, random;
//      RandomListNode(int x) { this.label = x; }
//};