package dsa.DynamicProgramming;

import java.util.Stack;

/*
Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units

Example2:
Input: heights = [2,4]
Output: 4
 */
class LargestRectangle {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println("Largest area rectangular area :: "+ largestRectangularArea(heights));

        int[] heights2 = {2,1,5,6,2,3};
        System.out.println("Largest area rectangular area :: "+ largestRectangularAreaUsingStack(heights2));

        int[] heights3 = {2,4};
        System.out.println("Largest area rectangular area :: "+ largestRectangularArea(heights3));

        int[] heights4 = {2,4};
        System.out.println("Largest area rectangular area :: "+ largestRectangularAreaUsingStack(heights4));
    }

    private static int largestRectangularArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        right[heights.length-1] = heights.length-1;
        for(int i=heights.length-2;i>=0;i--) {
            right[i] = i;
            for(int j=i+1;j<=heights.length-1;j++) {
                if(heights[j]<heights[i]) {
                    right[i] = j-1;
                    break;
                }
                if(heights[j]>heights[i] && j == heights.length-1) {
                    right[i]=j;
                }
            }
        }

        left[0] = 0;
        for(int i=1;i<heights.length;i++) {
            left[i] = i;
            for(int j=i-1; j>=0; j--) {
                if(heights[j]<heights[i]) {
                    left[i] = j+1;
                    break;
                }
                if(heights[j]>heights[i] && j == 0) {
                    left[i]=j;
                }
            }
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++) {
            maxArea = Math.max(maxArea, (right[i]-left[i]+1)*heights[i]);
        }
       return maxArea;
    }

    private static int largestRectangularAreaUsingStack(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=heights.length-1;i>=0;i--) {
            if(stack.isEmpty()) {
                right[i] = heights.length-1;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? heights.length - 1 : stack.peek() - 1;
            }
           stack.push(i);
        }
        stack.clear();
        for(int i=0;i<heights.length;i++) {
            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                left[i] = stack.empty() ? 0 : stack.peek() + 1;
            }
            stack.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++) {
            maxArea = Math.max(maxArea, (right[i]-left[i]+1)*heights[i]);
        }
        return maxArea;
    }
}