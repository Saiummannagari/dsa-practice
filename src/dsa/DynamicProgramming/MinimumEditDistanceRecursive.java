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
        System.out.println("minimum edit distance :: "+minimumEditDistance(word1, word2, 0, 0, 0, ""));

        String word3 = "horse";
        String word4 = "ros";
        System.out.println("minimum edit distance :: "+minimumEditDistance(word3, word4, 0, 0, 0,""));
    }

    static int counter = Integer.MAX_VALUE;
    private static int minimumEditDistance(String word1, String word2, int i, int j, int count, String path) {
       if(i==word1.length() && j==word2.length()) {
//           if(counter > count) {
//               System.out.println("path :: " + path);
//               System.out.println("count :: " + count);
//           }
           return count;
       }
       else if(i==word1.length() && j<word2.length()) {
           //only removing elements
           return minimumEditDistance(word1, word2, i, j+1, count+1, path+"D");
       }
       else if(j==word2.length() && i<word1.length()) {
           //only removing elements
           return minimumEditDistance(word1, word2, i+1, j, count+1, path+"R");
       }
       else {
           if((word1.charAt(i)!=word2.charAt(j))) {
               int min = Math.min(minimumEditDistance(word1, word2, i+1, j , count + 1,path+"D"),
                       minimumEditDistance(word1, word2, i, j+1, count + 1, path+"A"));
               min = Math.min(min, minimumEditDistance(word1, word2, i+1 , j+1, count + 1, path+"Re"));
               return min;
           }
           else {
             return minimumEditDistance(word1, word2, i+1, j+1, count, path);
           }
       }
    }
}