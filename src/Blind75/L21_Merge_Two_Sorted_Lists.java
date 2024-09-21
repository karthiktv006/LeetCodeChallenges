package Blind75;

import Common.LinkedListHelper;
import DataStructures.ListNode;
import Helper.L21;

import java.util.ArrayList;

public class L21_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        ArrayList<ListNode> list = L21.tc1();
        ListNode list1 = list.get(0);
        ListNode list2 = list.get(1);
        LinkedListHelper.printNodes(merge(list1, list2));
    }

    // taking care of edge cases with multiple checks in the beginning
    public static ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode mergedList = null, mergedListHead = null;

        if (list1.val < list2.val) {
            mergedListHead = list1;
            list1 = list1.next;
        } else {
            mergedListHead = list2;
            list2 = list2.next;
        }
        mergedList = mergedListHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;

            }
            mergedList = mergedList.next;
        }
        if (list1 == null) mergedList.next = list2;
        if (list2 == null) mergedList.next = list1;

        return mergedListHead;
    }

    // using dummy node to ignore edge cases
    public static ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;

            }
            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}
