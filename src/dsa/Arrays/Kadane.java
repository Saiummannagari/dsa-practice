package dsa.Arrays;/*Find the contiguous subarray within an array[] of length N which has the
largest sum in Time Complexity O(n) and Space Complexity O(1) - Kadane Algorithm

 Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
[Hint : Look for all positive contiguous segments of the array and also keep track of the maximum sum contiguous segment until the end]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6
 */

public class Kadane
{
    public static void main (String[] args)
    {
        int [] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

    static int maxSubArraySum(int array[])
    {
        //Write your code here 
        int result_sum=Integer.MIN_VALUE;
        int intermediate_sum=0;
        for(int i=0;i<array.length;i++) {
            intermediate_sum +=array[i];

            if(intermediate_sum<0) {
                intermediate_sum=0;
            }

            if(intermediate_sum< array[i]) {
                intermediate_sum = array[i];
            }
            if(result_sum < intermediate_sum) {
                result_sum = intermediate_sum;
            }
        }
        return result_sum;
    }
} 
/* Try more Inputs

case1:
actual = maxSubArraySum([-2,1,-3,4,-1,2,1,-5,4],9)
expected = 6

case2:
actual = maxSubArraySum([1],1)
expected = 1

case3:
actual = maxSubArraySum([-4, 2, -5, 1, 2, 3, 6, -5, 1],9)
expected = 12

case4:
actual = maxSubArraySum([-5, 6, -7, 1, 4, -8, 16],7)
expected = 16

*/