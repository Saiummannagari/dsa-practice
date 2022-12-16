package dsa.Arrays;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements in O(n) Time complexity and O(1) Space complexity with single traversal allowed

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:
You must do this in-place without making a copy of the array.
Hint : Single traversal Movement
 */
public class MoveZerosToEnd
{
    static void MoveZeroToEnd(int array[], int n)
    {
        //Try yourself
        //Write your Code Here
        int count=0;
        for(int i=0;i<n;i++) {
            if(array[i] !=0) {
                array[count++] = array[i];
            }
        }

        while(count<n) {
            array[count++] = 0;
        }
    }

    public static void main (String[] args)
    {
        int array[] = {1,3,0,0,4,0,9};
        int n = array.length;
        MoveZeroToEnd(array, n);
        System.out.println("result is: ");
        for (int i=0; i<n; i++)
            System.out.print(array[i]+" ");
    }
}

/* Try more Inputs
case1:
 actual = MoveZeroToEnd([1,3,0,0,4,0,9],7)
 expected = [1,3,4,9,0,0,0]

case2:
actual = MoveZeroToEnd([0,1,0,3,12],5)
expected = [1,3,12,0,0]

case3:
actual = MoveZeroToEnd([0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9],13)
expected = [1,9,8,4,2,7,6,9,0,0,0,0,0]

*/