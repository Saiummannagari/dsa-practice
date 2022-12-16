package dsa.DynamicProgramming;

/*
Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 */
class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcade";
        String text2 = "ace";
        System.out.println("Length :: "+longestCommonSubsequence(text1, text2));

        String text3 = "abc";
        String text4 = "abc";
        System.out.println("Length :: "+longestCommonSubsequence(text3, text4));

        String text5 = "abc";
        String text6 = "def";
        System.out.println("Length :: "+longestCommonSubsequence(text5, text6));

        String text7 = "abcdgh";
        String text8 = "aedfhr";
        System.out.println("Length :: "+longestCommonSubsequence(text7, text8));

    }

    static int longestCommonSubsequence(String string1, String string2) {
       char[] arr = string1.toCharArray();
       char[] arr1 = string2.toCharArray();
       int [][] dp = new int[string1.length()+1][string2.length()+1];
       for(int i=0;i<string1.length()+1;i++) {
           for(int j=0;j<string2.length()+1;j++) {
               if(i==0 || j==0) {
                   dp[i][j]=0;
               }
               else if(arr[i-1] == arr1[j-1]) {
                   dp[i][j] = 1+dp[i-1][j-1];
               } else {
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
               }
           }
       }
       longestCommonSubsequenceString(dp, string1);
       return dp[string1.length()][string2.length()];
    }

    static void longestCommonSubsequenceString(int[][] dp, String c1) {
        StringBuilder sb = new StringBuilder();
        int i=dp.length-1;
        int j=dp[0].length-1;

        while(i>0 && j>0) {
            if(dp[i][j]==dp[i][j-1]) {
                --j;
            }
            else if(dp[i][j]>dp[i-1][j-1] && dp[i][j]!=dp[i-1][j]) {
                sb.append(c1.charAt(i-1));
                --i;
                --j;
            } else {
                --i;
            }
        }
        System.out.println("String :: "+sb.reverse());
    }
}