package dsa.RecursionAndBackTracking;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {10, 80, 30, 90, 40, 50, 70};
        quickSort2(arr2, 0, arr2.length-1);
        System.out.println(Arrays.toString(arr2));

    }

    //putting pivot as middle element
    static void quickSort(int[] arr, int low, int high) {
        if(high<=low) {
            return;
        }
        int start = low;
        int end = high;
        int pivot = arr[(start+end)/2];
        while(start<=end) {
            while(arr[start] < pivot) {
                start ++;
            }
            while(arr[end] > pivot) {
                end--;
            }

            if(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    //putting pivot as last element
    static void quickSort2(int[] arr, int low, int high) {
        if(high<=low) {
            return;
        }

        int start = low;
        int end = high;
        int pivot = arr[high];
        while(start<=end) {
            while(arr[start] < pivot) {
                start++;
            }
            while(arr[end] > pivot) {
                end--;
            }
            if(start<=end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort2(arr, low, end);
        quickSort2(arr, start, high);
    }


}