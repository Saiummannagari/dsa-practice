package dsa.Arrays;

/*
Given an array of integer, write an efficient algorithm to find majority number in that array in Time Complexity O(n) and Space Complexity O(1)

Example:

[Majority Number : The only number in the integer array which appears more than n/2 times if the length of the array is n]
Input : [1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 ]
Output: 2 ( 2 appears in this integer array more than 5 times]
[Hint: Think of using the hint, element appears more than half
 */
public class MajorityElement
{
    // Function to return majority element present in given array
    public static int majorityElement(int[] array)
    {
        // majority stores majority element if present
        int majority = array[0];

        // initialize counter i with 0
        int count = 1;

        // do for each element array[j] of the array
        for (int j = 1; j < array.length; j++)
        {
            // increment the counter if array[j] is current candidate
            if (majority == array[j]) {
                count++;
            }
            // else decrement the counter if array[j] is not current candidate
            else {
                count--;
            }

            // if the counter count becomes 0
            if (count == 0)
            {
                // set the current candidate to array[j]
                majority = array[j];

                // reset the counter to 1
                count = 1;
            }
        }

        return majority;
    }

    public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int[] array = { 3, 8, 3, 4, 3, 2, 2, 2, 2, 2, 2 };

        System.out.println("Majority element is " + majorityElement(array));
    }


    /*
    public class Main {
    public static void main(String[] args) {
        int [] arr = {1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2};
        System.out.println("Majority Element is :: " + majorityElement(arr));
    }

    static int majorityElement(int[] arr) {
     int count=1;
     int majorityElement=arr[0];
     for(int i=1;i<arr.length;i++) {
         if(majorityElement == arr[i]) {
             count++;
         }
         else {
             count--;
         }
         if(count==0) {
             majorityElement = arr[i];
             count=1;
         }
     }
     return majorityElement;
    }
}
     */
}