package dsa.Hashing;/*
Find whether an array is subset of another array
Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not in sorted order. It may be assumed that elements in both arrays are distinct.

Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
Output: arr2[] is not a subset of arr1[]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class ArraySubsetOfAnotherArray {

    //Time Complexity: O(n*logn)
    //Auxiliary Space: O(n)
    static boolean isSubset(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length1 = arr1.length;
        int length2 = arr2.length;
        //arry2 should be subset of arr1
        if (length1 < length2) {
            return false;
        }

        Arrays.stream(arr1).forEach(num -> {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        });

        for(int i = 0; i < length2; i++) {
            if (!map.containsKey(arr2[i])) {
                return false;
            } else {
                map.put(arr2[i], map.get(arr2[i]) - 1);
            }
        };

        return true;
    }

    public static void main(String[] args) {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1};
        System.out.println("arr1 is subset of arr2?(yes/no) :: " + isSubset(arr1, arr2));
    }
}