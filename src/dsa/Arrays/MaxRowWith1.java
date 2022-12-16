package dsa.Arrays;

/*

A 2-D array of 1's and 0's is given. Find the row with max 1's in Time Complexity O(nlogn) and Space Complexity O(1) . The array is sorted row wise (all 0's in a row are followed by all 1's

Example:

Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0
Output: 2
[Hint : Think of using binary search across sorted rows]

 */
public class MaxRowWith1 {
    static int m = 4, n = 4;

    static int binarySearch(int array[], int low, int high)
    {
        //Write your code Here
        if(high>=low) {
            int mid = low+(high-low)/2;
            if((mid==0 || array[mid-1] ==0) && array[mid] == 1)
                return mid;
            else if(array[mid]==0)
                return binarySearch(array,mid+1,high);
            else
                return binarySearch(array,low,mid-1);
        }
        return -1;
    }

    static int findRow(int matrix[][])
    {
        //Write your Codr Here
        int max_row_index=0,max=-1;
        int index;
        for(int i=0; i<matrix.length; i++) {
            index = binarySearch(matrix[i], 0, matrix[i].length-1);
            if(index != -1 && matrix[i].length - index > max) {
                max = matrix[i].length - index;
                max_row_index = i;
            }
        }

        return max_row_index;
    }
    public static void main(String[] args)
    {
        int matrix[][] = { { 0, 1, 1, 1 },
                { 0, 0, 1, 1 },
                { 0, 0, 0, 1 },
                { 1, 1, 1, 1 } };
        System.out.println("Index of row with maximum 1s is "
                + findRow(matrix));

    }
}

/* Try more Inputs
case1:
 actual = findRow([[0, 1, 1, 1],
       [0, 0, 1, 1],
       [1, 1, 1, 1],
       [0, 0, 0, 0]])
expected = 2

case2:
actual = findRow([[1, 1, 1],
       [0, 0, 0],
       [1, 1, 0],
       [1, 0, 0]])
expected = 0

case3:
actual = findRow([[0, 0, 0, 1, 1],
       [0, 0, 1, 1, 1],
       [0, 0, 0, 0, 0],
       [0, 1, 1, 1, 1],
       [0, 0, 0, 0, 1]])
expected = 4

*/