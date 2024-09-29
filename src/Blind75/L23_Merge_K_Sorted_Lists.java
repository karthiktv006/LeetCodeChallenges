package Blind75;

import Common.LinkedListHelper;
import DataStructures.ListNode;
import Helper.L23;

import java.util.ArrayList;
import java.util.List;

public class L23_Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        ListNode[] tc1 = L23.tc1();
        ListNode res = merge3(tc1);
        LinkedListHelper.printNodes(res);
    }

    public static ListNode merge3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int size = lists.length;

        while (size > 1) {
            List<ListNode> mergedList = new ArrayList<>();
            for (int i = 0; i < size; i += 2) {
                ListNode list1 = lists[i];
                ListNode list2;
                if (i + 1 < lists.length) {
                    list2 = lists[i + 1];
                } else {
                    list2 = null;
                }
                mergedList.add(merge2List(list1, list2));
            }
            size = (size + 1) / 2;
            lists = mergedList.toArray(lists);
        }
        return lists[0];
    }

    // Time: O(n*k)
    public static ListNode merge2(ListNode[] lists) {
        if (lists.length == 0) return null;
        for (int i = 1; i < lists.length; i++) {
            lists[0] = merge2List(lists[0], lists[i]);
        }
        return lists[0];
    }

    public static ListNode merge2List(ListNode list1, ListNode list2) {
        if (list2 == null) return list1;
        if (list1 == null) return list2;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list2 != null && list1 != null) {
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
