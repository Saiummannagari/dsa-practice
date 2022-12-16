package dsa.DynamicProgramming;

/*
Shortest Common Supersequence

Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

Example 1:

Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.
Example 2:

Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"
 */
class Supersequence {
    public static void main(String[] args) {
        String str1="abac";
        String str2="cab";
        System.out.println("Common supersequence :: "+commonSupersequence(str1,str2));

        String str3="aaaaaaaa";
        String str4="aaaaaaaa";
        System.out.println("Common supersequence :: "+commonSupersequence(str3,str4));
    }

    private static String commonSupersequence(String str1, String str2) {
        String[][] dp = new String[str1.length()+1][str2.length()+1];
        for(int i=0;i<str1.length()+1;i++) {
            for(int j=0;j<str2.length()+1;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = "";
                }
                else if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+str1.charAt(i-1);
                } else {
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j] : dp[i][j-1];
                }
            }
        }
       String seq = dp[str1.length()][str2.length()];
        System.out.println(seq);
        int ptr1=0;
        int ptr2=0;
        StringBuilder ans = new StringBuilder();
        for(char c: seq.toCharArray()) {
            while(str1.charAt(ptr1)!=c) {
               ans.append(str1.charAt(ptr1));
                ++ptr1;
            }
            while(str2.charAt(ptr2)!=c) {
                ans.append(str2.charAt(ptr2));
                ++ptr2;
            }
            ans.append(c);
            ++ptr1;
            ++ptr2;
        }
        while(ptr1<str1.length()) {
            ans.append(str1.charAt(ptr1));
            ptr1++;
        }
        while(ptr2<str2.length()) {
            ans.append(str2.charAt(ptr2));
            ptr2++;
        }
        return String.valueOf(ans);
    }
}