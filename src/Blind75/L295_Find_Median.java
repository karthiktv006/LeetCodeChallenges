package Blind75;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // use reverseOrder for maxHeap
//        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else if (num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            int n = maxHeap.remove();
            minHeap.add(n);
        } else if (minHeap.size() - maxHeap.size() > 0) {
            int n = minHeap.remove();
            maxHeap.add(n);
        }
    }

    public double findMedian() {
        int dataStreamLength = minHeap.size() + maxHeap.size();
        double min = minHeap.isEmpty() ? 0 : minHeap.peek();
        double max = maxHeap.isEmpty() ? 0 : maxHeap.peek();
        if (dataStreamLength % 2 == 1) {
            return max;
        } else {
            return (min + max) / 2;
        }
    }
}

public class L295_Find_Median {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());


        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());


    }

}
