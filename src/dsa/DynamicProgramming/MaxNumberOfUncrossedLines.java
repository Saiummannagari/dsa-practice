package dsa.DynamicProgramming;

/*
Uncrossed Lines

You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.

We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:

nums1[i] == nums2[j], and
the line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).

Return the maximum number of connecting lines we can draw in this way.

 Example 1:


Input: nums1 = [1,4,2], nums2 = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
Example 2:

Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
Output: 2
 */
class MaxNumberOfUncrossedLines {
    public static void main(String[] args) {
        int[] nums1=new int[]{1,4,2};
        int[] nums2=new int[]{1,2,4};
        System.out.println("Max number of uncrossed lines :: "+ maxNumberOfUncrossedLines(nums1,nums2));

        int[] nums3=new int[]{2,5,1,2,5};
        int[] nums4=new int[]{10,5,2,1,5,2};
        System.out.println("Max number of uncrossed lines :: "+ maxNumberOfUncrossedLines(nums3,nums4));

        int[] nums5=new int[]{1,3,7,1,7,5};
        int[] nums6=new int[]{1,9,2,5,1};
        System.out.println("Max number of uncrossed lines :: "+ maxNumberOfUncrossedLines(nums5,nums6));

    }

    private static int maxNumberOfUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i=0;i<nums1.length+1;i++) {
            for(int j=0;j< nums2.length+1;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                } else if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}