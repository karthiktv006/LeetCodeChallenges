package Helper;

import DataStructures.ListNode;

import java.util.ArrayList;

public class L21 {
    public static ArrayList<ListNode> tc1() {
        ArrayList<ListNode> tc1 = new ArrayList<>();
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

        tc1.add(n0);
        tc1.add(m0);

        return tc1;
    }
}
