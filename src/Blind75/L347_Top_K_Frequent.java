package Blind75;

import Common.Array;
import Helper.L347;

import java.util.HashMap;
import java.util.PriorityQueue;

public class L347_Top_K_Frequent {
    public static void main(String[] args) {
        int[] nums = L347.tc1();
        int k = 2;

        new Array().print1DArrayInteger(topKFrequent(nums, k));


        // Practice max heap in java
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        q.add(10);
//        q.add(45);
//        q.add(78);
//        q.add(10);
//        q.add(18);
//        q.add(6);
//
//        System.out.println(q);
//
//        q.remove();
//        System.out.println(q);
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//        int[] arr1 = {1, 3};
//        int[] arr2 = {2, 2};
//        int[] arr3 = {3, 6};
//        queue.add(arr3);
//        queue.add(arr2);
//        queue.add(arr1);
//
//
//        while (!queue.isEmpty()) {
//            int[] a = queue.remove();
//            System.out.println(a[0] + ":" + a[1]);
//        }
//
//        System.out.println(queue);

    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] res = new int[k];
        for (int num : nums) {
            int count = freq.getOrDefault(num, 0);
            freq.put(num, count + 1);
        }
        freq.forEach((key, value) -> {
            int[] arr = new int[2];
            arr[0] = key;
            arr[1] = value;
            queue.add(arr);
        });
        System.out.println(freq);

        while (k > 0) {
            int[] a = queue.remove();
            System.out.println(a[0] + ":" + a[1]);
            res[k - 1] = a[0];
            k -= 1;
        }
        return res;
    }
}
