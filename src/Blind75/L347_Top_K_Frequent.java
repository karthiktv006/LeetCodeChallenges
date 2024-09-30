package Blind75;

import Common.Array;
import Helper.L347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class L347_Top_K_Frequent {
    public static void main(String[] args) {
        int[] nums = L347.tc1();
        int k = 2;

        new Array().print1DArrayInteger(topKFrequent2(nums, k));


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

    // Time: O(n + n) => O(n)
    public static int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        System.out.println(freqMap);

        ArrayList[] freqBucket = new ArrayList[nums.length + 1];
        freqMap.forEach((key, value) -> {
            if (freqBucket[value] == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(key);
                freqBucket[value] = list;
            } else {
                freqBucket[value].add(key);
            }
        });

        int[] res = new int[k];
        for (int i = nums.length; i > 0; i--) {
            if (freqBucket[i] != null) {
                for (Object n : freqBucket[i]) {
                    res[k - 1] = (int) n;
                    k--;
                    if (k < 1) return res;
                }
            }
        }

        return null;
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
