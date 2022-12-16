package dsa.RecursionAndBackTracking;

import java.util.Arrays;

public class QuickSort {

    //takes O(nlogn) time-complexity
    //takes O(n) space complexity as we are allocating additional space for the merged array
    public static void main(String[] args) {
         int[] arr = {6,5,4,3,2,1};
         int[] merge = mergeSort(arr);
         System.out.println(Arrays.toString(merge));
    }

    static int[] mergeSort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int i=0, j=0, k=0;
        int[] merge = new int[left.length + right.length];
        while(i<left.length && j<right.length) {
            if(left[i] < right[j]) {
                merge[k++] = left[i];
                i++;
            } else {
                merge[k++] = right[j];
                j++;
            }
        }
        while(j<right.length) {
            merge[k++] = right[j];
            j++;
        }

        while(i< left.length) {
            merge[k++] = left[i];
            i++;
        }

        return merge;
    }
}