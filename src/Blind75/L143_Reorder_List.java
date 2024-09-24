package Blind75;

import Common.LinkedListHelper;
import DataStructures.ListNode;
import Helper.L143;
import Helper.L19;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class L143_Reorder_List {
    public static void main(String[] args) {
        ListNode tc1 = L19.tc1();
        LinkedListHelper.printNodes(tc1);
        reorder2(tc1);
    }

    public static ListNode reorder(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        dummy.next = head;
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;
            stack.push(node);
            queue.add(node);

        }
        System.out.println("queue.size() = " + queue.size());
        System.out.println("stack.size() = " + stack.size());
        int len = queue.size(), n = 0;

        while (n < len) {
            curr.next = queue.remove();
            curr = curr.next;
            n += 1;
            if (n < len) {
                curr.next = stack.pop();
                curr = curr.next;
            }
            n += 1;
        }




        return dummy.next;
    }

    public static ListNode start(ListNode head) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        dummy.next = head;

        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;
            queue.add(node);

        }
        head = dummy;

//        reorder2(head, curr, queue);
        return head;
    }

    public static void reorder2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode firstHalf = head;

        ListNode prev = null;
        while (secondHalf != null) {
            ListNode temp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }
        ListNode reversed = prev;
        LinkedListHelper.printNodes(reversed);

        while (reversed != null) {
            ListNode temp1 = firstHalf.next, temp2 = reversed.next;
            firstHalf.next = reversed;
            reversed.next = temp1;
            firstHalf = temp1;
            reversed = temp2;
        }
        LinkedListHelper.printNodes(head);
    }
}
