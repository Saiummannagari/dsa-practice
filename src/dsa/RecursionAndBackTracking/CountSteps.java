package dsa.RecursionAndBackTracking;/*
Given an integer num, return the number of steps to reduce it to zero.

In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

Input: num = 14
Output: 6
Explanation:
Step 1) 14 is even; divide by 2 and obtain 7.
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.
Step 4) 3 is odd; subtract 1 and obtain 2.
Step 5) 2 is even; divide by 2 and obtain 1.
Step 6) 1 is odd; subtract 1 and obtain 0.
 */

public class CountSteps {

    public static void main(String[] args) {
        System.out.println("number of steps:: "+ countSteps(14,0));
        System.out.println("number of steps:: "+ countSteps(8,0));
        System.out.println("number of steps:: "+ countSteps(123,0));
    }

    static int countSteps(int num, int count) {
        if(num == 0) {
            return count;
        }
        if(num%2 ==0) {
            return countSteps(num/2, count+1);
        }

            return countSteps(num-1, count+1);

    }
}