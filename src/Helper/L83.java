package Helper;

import DataStructures.ListNode;

public class L83 {
    public static ListNode tc1() {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n0.next = n1;
        n1.next = n2;

        return n0;
    }

    public static ListNode tc2() {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);

        n0.next = n1;
        n1.next = n2;

        return n0;
    }
}
