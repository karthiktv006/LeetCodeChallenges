package Easy;

import Common.LinkedListHelper;
import Common.LinkedListNode;
import DataStructures.ListNode;
import Helper.L83;

public class L83_RemoveDuplicates {
    public static void main(String[] args) {
        ListNode tc1 = L83.tc1();
        ListNode tc2 = L83.tc2();
        LinkedListHelper helper = new LinkedListHelper();
        helper.printNodes(tc1);
        deleteDuplicates(tc1);
        helper.printNodes(tc1);

        helper.printNodes(tc2);
        deleteDuplicates(tc2);
        helper.printNodes(tc2);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode res = head;
        head = head.next;
        while (head != null) {
            System.out.println(head.val);
            if (head.val == prev.val) {
                prev.next = head.next;
                //head = head.next;
            }
            prev = head;
            head = head.next;

        }

        return res;
    }
}
