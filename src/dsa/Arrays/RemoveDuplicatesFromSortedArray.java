package dsa.Arrays;

/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. Do not allocate extra space for another array, Time complexity O(n) and Space complexity O(1)

Example:

Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 */
public class RemoveDuplicatesFromSortedArray
{
    static int removeDuplicates(int array[], int n)
    {
        if(n==0 || n==1)
            return n;
        //Write your code Here 
        int j=0;
        for(int i=0; i<n-1; i++) {
            if(array[i] != array[i+1]) {
                array[j++] = array[i];
            }
        }

        //place the last element since we are missing the comparision
        array[j++]=array[n-1];
        return j;
    }

    public static void main (String[] args)
    {
        int array[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = array.length;

        n = removeDuplicates(array, n);
        System.out.println("size :: "+ n);

        for (int i=0; i<n; i++)
            System.out.print(array[i]+" ");
    }
} 

/* Try more Inputs

case1:
actual = removeDuplicates([1,1,2],3)
expected = 2

case2:
actual = removeDuplicates([2, 2, 2, 2, 2],5)
expected = 1

case3:
actual = removeDuplicates([1, 2, 2, 3, 4, 4, 4, 5, 5],9)
expected = 5

case4:
actual = removeDuplicates([1,2,3,4,5],5)
expected = 5

*/