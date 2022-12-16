package dsa.Hashing;/*
In top K frequent elements we have given an array nums[], find the k most frequently occurring elements.

nums[] = {1, 1, 1, 2, 2, 3}
k = 2

o/p: 1 2
 */

import java.util.*;

public class TopKFrequentElements {
    static class Element {
        int value;
        int freq;

        public Element(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

    static void printFrequentElements(int [] arr, int k) {
        int n= arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(num ->
        {
           if(map.containsKey(num)) {
               map.put(num, map.get(num)+1);
           } else {
               map.put(num, 1);
           }
        });

        //constructing priority queue(max heap)
        PriorityQueue<Element> heap = new PriorityQueue<>(new Comparator<Element>() {

            @Override
            public int compare(Element t1, Element t2) {
                 return Integer.compare(t2.freq, t1.freq);
            }
        });

        for(Integer key: map.keySet()) {
            heap.add(new Element(key, map.get(key)));
        }

        for(int i=0;i<k;i++) {
            System.out.print(heap.poll().value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        printFrequentElements(nums, k);
        // Example 2
        nums = new int[]{1};
        k = 1;
        printFrequentElements(nums, k);
    }
}