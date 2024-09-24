package Blind75;

import Common.LinkedListHelper;
import DataStructures.ListNode;
import Helper.L19;

public class L19_Remove_Nth_Node {
    public static void main(String[] args) {
        ListNode tc1 = L19.tc1();
//        LinkedListHelper.printNodes(tc1);
//        LinkedListHelper.printNodes(removeNthNode(tc1,3 ));

        LinkedListHelper.printNodes(removeNode(tc1, 5));

    }

    public static ListNode removeNthNode(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len += 1;
            temp = temp.next;
        }
        temp = head;
        int i = 1;
        while (temp != null) {
            if (n == len) {
                return head.next;
            } else if (len - i == n) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
            i++;
        }
        System.out.println("len = " + len);
        return head;
    }

    public static ListNode removeNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right  = head;

        while (n > 0 && right != null) {
            right = right.next;
            n -= 1;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }


        left.next = left.next.next;

        return dummy.next;

    }
}
