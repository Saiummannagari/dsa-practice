package dsa.Hashing;/*
Given an array of integers, print longest subsequence such that elements of the subsequence are consecutive integers, although they can be in any order.

Let’s see some examples to understand the problem better:

Suppose we are having an array of integers given below:

1	9	3	10	4	20	2

o/p: 1,3,4,2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubSequence {


    //brute force
    //space complexity -->O(n)
    //time complexity -->O(nlogn)
    static int[] longestConsecutiveUsingBruteForce(int[] arr) {
        int length = arr.length;
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length - 1; i++) {
            if (arr[i + 1]  == arr[i] +1) {
                if (set.contains(arr[i] - 1)) {
                    set.add(arr[i]);
                    set.add(arr[i + 1]);
                }
                if (set.isEmpty()) {
                    set.add(arr[i]);
                    set.add(arr[i + 1]);
                }
            }
        }
        return set.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {

        int arr[] = {1,9,3,10,4,20,2};
        System.out.println("Consecutive subarray :: "+ Arrays.toString(longestConsecutiveUsingBruteForce(arr)));
    }
}