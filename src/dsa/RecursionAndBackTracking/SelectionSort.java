package dsa.RecursionAndBackTracking;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
       int arr[] = {5, 8, 1, 4, 6, 7, 9};
       selectionSort(arr, arr.length-1, 0, 0);
        System.out.println(Arrays.toString(arr));
        int arr2[] = {9, 10, 12, 7, 6, 5};
        selectionSort(arr2, arr2.length-1, 0, 0);
        System.out.println(Arrays.toString(arr2));
    }

    static void selectionSort(int[] arr, int row, int col, int max) {
        if(row==-1) {
            return;
        } if(col <= row) {
            if(arr[col] > arr[max]) {
                selectionSort(arr, row, col+1, col);
            } else {
                selectionSort(arr, row, col+1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[row];
            arr[row] = temp;
            selectionSort(arr, row-1, 0, 0);
        }
    }
}