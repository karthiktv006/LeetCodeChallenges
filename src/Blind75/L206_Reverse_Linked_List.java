package Blind75;

import Common.LinkedListHelper;
import Common.LinkedListNode;
import DataStructures.ListNode;
import Helper.L206;

import java.util.List;
import java.util.Stack;

public class L206_Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode tc1 = L206.tc1();
        LinkedListHelper.printNodes(tc1);
//        ListNode res = reverseList(tc1);
//        LinkedListHelper.printNodes(res);

        ListNode res2c = reverserList2(tc1);
        LinkedListHelper.printNodes(res2c);



    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode newHead;

        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        newHead = stack.peek();
        head = newHead;

        while (!stack.isEmpty()) {
            head.next = stack.pop();
            head = head.next;
        }
        head.next = null;
        return newHead;
    }

    public static ListNode reverserList2(ListNode head) {
        ListNode prev = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
