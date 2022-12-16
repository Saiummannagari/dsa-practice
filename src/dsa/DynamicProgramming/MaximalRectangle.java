package dsa.DynamicProgramming;

import java.util.Stack;

/*
Maximal Rectangle

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = [["0"]]
Output: 0
Example 3:

Example 3:
Input: matrix = [["1"]]
Output: 1
 */
class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        System.out.println("Maximal Rectangular area :: "+ maximalRectangle(matrix));

        char[][] matrix1 = {{'0'}};
        System.out.println("Maximal Rectangular area :: "+ maximalRectangle(matrix1));

        char[][] matrix2 = {{'1'}};
        System.out.println("Maximal Rectangular area :: "+ maximalRectangle(matrix2));
    }

    private static int maximalRectangle(char[][] matrix) {
        int[][] histogram = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<histogram.length;i++) {
            for(int j=0;j< histogram[0].length;j++) {
                if(i==0 || j==0) {
                    histogram[i][j] = 0;
                } else if(matrix[i-1][j-1] == '1'){
                    histogram[i][j] = histogram[i-1][j] + ((int)matrix[i-1][j-1]-48);
                } else {
                    histogram[i][j] = 0;
                }
            }
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i=1;i< histogram.length;i++) {
            int max = largestRectangularAreaUsingStack(histogram[i]);
            maxArea = Math.max(max, maxArea);
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