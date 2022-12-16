package dsa.DynamicProgramming;

/*
Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
class MinimumEditDistance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println("minimum edit distance :: "+minimumEditDistance(word1, word2));

        String word3 = "horse";
        String word4 = "ros";
        System.out.println("minimum edit distance :: "+minimumEditDistance(word3, word4));
    }

    private static int minimumEditDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++) {
            for(int j=0;j<word2.length()+1;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = Math.max(i, j);
                } else if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    min = Math.min(min, dp[i-1][j-1]);
                    dp[i][j] = min+1;
                } else {
                    int min = Math.min(dp[i-1][j], dp[i][j-1]);
                    min = Math.min(min, dp[i-1][j-1]);
                    dp[i][j] = min;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}