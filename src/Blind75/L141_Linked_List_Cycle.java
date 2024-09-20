package Blind75;

import DataStructures.ListNode;
import Helper.L141;
import Helper.L206;

public class L141_Linked_List_Cycle {
    public static void main(String[] args) {
        ListNode tc1 = L141.tc1();
        ListNode tc2 = L206.tc1();
        System.out.println(checkLinkedListCycle(tc2));
    }

    public static boolean checkLinkedListCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return false;
        }

        return true;
    }
}
