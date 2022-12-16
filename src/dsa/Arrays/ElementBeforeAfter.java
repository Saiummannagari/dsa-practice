package dsa.Arrays;
/*
 We have an array, we have to find an element before which all elements are less than it, and after which all are greater than it. Finally, return the index of the element, if there is no such element, then return -1: Time complexity O(n) and Space Complexity O(n)

Example:

Input: arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
Output: 4
Explanation: All elements on the left of arr[4] are smaller than it
and all elements on right are greater.

 */

class Main {
    public static void main(String[] args) {
        int arr[] = {5,1,4,3,6,8,10,7,9};
        System.out.println(findIndex(arr, arr.length));
        //Write your Code Here
    }

    static int findIndex(int[] array, int size) {
        int left[] = new int[size];


        left[0]=Integer.MIN_VALUE;
        for(int i=1;i<size;i++) {
            left[i]=Math.max(left[i-1],array[i-1]);
        }

        int right = Integer.MAX_VALUE;
        for(int i=size-1;i>=0;i--) {
            if(left[i] < array[i] && right > array[i]) {
                return i;
            }
            right = Math.min(right, array[i]);
        }
        return -1;
    }
}

/* Try more Inputs

findElement(array, length_of_array)


case1:
actual = findElement([5, 1, 4, 3, 6, 8, 10, 7, 9],9)
expected = 4

case2:
actual = findElement([6, 2, 5, 4, 7, 9, 11, 8, 10],9)
expected = 4

case3:
actual = findElement([5, 1, 4, 4],4)
expected = -1

*/