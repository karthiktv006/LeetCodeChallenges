package Helper;

import DataStructures.ListNode;

public class L143 {
    public static ListNode tc1() {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;

        return n0;
    }
}