package dsa.Arrays;

/*

Given an array A[] of N positive integers. The task is to find the maximum of j - i with the constraint of A[i] <= A[j]. Time Complexity : O(n) Space Complexity : O(n)

Example:

Input 34 8 10 3 2 80 30 33 1

Hint: [Think of traversing the array from the end and keep a track of the maximum number to the right of the current index]
Output 6

 */
public class Maxij
{
    static int findDiff(int arr[], int n)
    {
        // Write your Code Here
        int[] left = new int[n];
        int[] right = new int[n];
        int i=0,j=0,maxDiff=-1;

        right[n-1] = n-1;
        for(int k=n-2; k>=0; --k) {
            right[k] = arr[k] < arr[right[k+1]] ? right[k+1] : k;
        }

        left[0] = 0;
        for(int k=1; k<n ; k++) {
            left[k] = arr[k] > arr[left[k-1]] ? left[k-1] : k;
        }

        while(i<n && j<n) {
            if(arr[left[i]] < arr[right[j]]) {
                maxDiff = Math.max(maxDiff, right[j]-left[i]);
                j=j+1;
            }
            else {
                i=i+1;
            }
        }
        return maxDiff;
    }


    public static void main(String[] args)
    {
        int arr[] = {34, 9, 12, 3, 2,70,31,33,1};
        int n = arr.length;
        int maxDiff = findDiff(arr, n);
        System.out.println(maxDiff);
    }
}

/* Try more Inputs
case1:
actual = findDiff([35, 9, 12, 3, 2, 70, 31, 33, 1])
expected = 6

case2:
actual = findDiff([1, 2, 3, 4, 5, 6])
expected = 5

case3:
actual = findDiff([9, 2, 3, 4, 5, 6, 7, 8, 18, 0])
expected = 8

case4:
actual = findDiff([6, 5, 4, 3, 2, 1])
expected = -1

*/