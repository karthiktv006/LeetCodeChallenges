package Blind75;

import Common.LinkedListHelper;
import DataStructures.ListNode;
import Helper.L23;

import java.util.List;

public class L23_Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        ListNode[] tc1 = L23.tc1();
        merge(tc1);
    }
    public static ListNode merge(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (lists[0] != null) {
            ListNode minNode = null;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                ListNode currNode = lists[i];
                if (currNode.val < min) {
                    min = currNode.val;
                    minNode = currNode;
                }
            }
            curr.next = minNode;
            minNode = minNode.next;
            LinkedListHelper.printNodes(dummy);
        }

        return dummy.next;

    }
}
