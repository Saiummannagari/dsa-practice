package dsa.DynamicProgramming;

/*
Longest Repeating subsequence

ex: AABB
output: AB
 */
class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "aabb";
        System.out.println("Longest repeating subsequence :: "+ longestSubsequence(str));

        String str2 = "bb";
        System.out.println("Longest repeating subsequence :: "+ longestSubsequence(str2));

        String str3 = "letsleetcode";
        System.out.println("Longest repeating subsequence :: "+ longestSubsequence(str3));

    }

    private static String longestSubsequence(String str) {
        String dp[][] = new String[str.length()+1][str.length()+1];
        for(int i=0;i<str.length()+1;i++) {
            for(int j=0;j<str.length()+1;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = "";
                } else if(str.charAt(i-1)==str.charAt(j-1) && i!=j) {
                    dp[i][j] = dp[i-1][j-1]+str.charAt(i-1);
                } else {
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j] : dp[i][j-1];
                }
            }
        }
        return dp[str.length()][str.length()];
    }
}