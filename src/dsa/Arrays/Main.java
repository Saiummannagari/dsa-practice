package dsa.Arrays;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int arrival[] = {1:00, }
    }

    private static void findNextGreater(int[] numArr, int n) {
        int i = 0;
        for (i = 0; i < n - 1; i++) {
            if (numArr[i - i] < numArr[i]) {
                break;
            }
        }

        int element = numArr[i - 1];
        int min = i;
        for (int j = i + 1; j < n; j++) {
            if (element < numArr[j] && numArr[j] < numArr[min]) {
                min = j;
            }
        }
        swap(numArr, i - 1, min);
        Arrays.sort(numArr, i, n);
    }

    private static void swap(int[] numArr, int i, int min) {

        int temp = numArr[i];
        numArr[i] = numArr[min];
        numArr[min] = temp;
    }


}