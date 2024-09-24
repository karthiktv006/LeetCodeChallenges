package Helper;

import DataStructures.ListNode;

import java.util.ArrayList;

public class L23 {
    public static ListNode[] tc1() {
        ListNode[] tc1 = new ListNode[3];
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode m0 = new ListNode(1);
        ListNode m1 = new ListNode(3);
        ListNode m2 = new ListNode(4);
        ListNode m3 = new ListNode(8);
        m0.next = m1;
        m1.next = m2;
        m2.next = m3;

        ListNode p0 = new ListNode(2);
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(9);
        p0.next = p1;
        p1.next = p2;
        p2.next = p3;

        tc1[0] = n0;
        tc1[1] = m0;
        tc1[2] = p0;

        return tc1;
    }
}
