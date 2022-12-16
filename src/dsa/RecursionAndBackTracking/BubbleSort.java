package dsa.RecursionAndBackTracking;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {8, 7, 9, 0, 9};
        bubbleSort(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr, int row, int col) {
        if(row==-1) {
            return;
        }
        if(col<row) {
            if(arr[col] > arr[col+1]) {
                int temp = arr[col+1];
                arr[col+1] = arr[col];
                arr[col] = temp;
            }
            bubbleSort(arr, row, col+1);
        } else {
            bubbleSort(arr, row-1, 0);
        }
    }
}