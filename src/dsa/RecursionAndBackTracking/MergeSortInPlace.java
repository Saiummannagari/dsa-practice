package dsa.RecursionAndBackTracking;

import java.util.Arrays;

public class QuickSortInPlace {
    public static void main(String[] args) {
        int[] arr3= {56, 2, 45};
        mergeSortInPlace(arr3,0,arr3.length-1);
        System.out.println(Arrays.toString(arr3));
       int[] arr = {6,5,4,3,2,1};
       mergeSortInPlace(arr,0,arr.length-1);
       System.out.println(Arrays.toString(arr));
        int[] arr2 = {2,3,4,1};
        mergeSortInPlace(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(arr2));
        int[] arr4 = {10, 7, 11, 14, 28, 16, 30};
        mergeSortInPlace(arr4,0,arr4.length-1);
        System.out.println(Arrays.toString(arr4));

    }

    static void mergeSortInPlace(int[] arr, int start, int end) {
        if(start == end) {
            return;
        }

        //int mid = (start)+(start-end)/2;
        int mid = (start+end)/2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid+1, end);

        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {
       int start2 = mid+1;
        if (arr[mid] <= arr[start2]) {
            return;
        }
       while(start<=mid && start2<=end) {
           if(arr[start] < arr[start2]) {
               start++;
           } else {
               int temp=arr[start2];
               int index=start2;
               while(index!=start) {
                   arr[index] = arr[index-1];
                   index--;
               }
               arr[start] = temp;
               start2++;
               start++;
           }

       }
    }
}