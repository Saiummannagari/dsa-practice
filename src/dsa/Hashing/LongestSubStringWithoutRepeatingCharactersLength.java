package dsa.Hashing;/*
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharactersLength {

    //Using sliding window
    //space complexity O(1)
    //time complexity O(n*n)
    static int longestSubStringLengthUsingSlidingWindow(String str) {
        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<str.length();i++) {
            boolean[] visited = new boolean[256];
            for(int j=i;j<str.length();j++) {
                if(visited[str.charAt(j)] == true) {
                    break;
                } else {
                    visited[str.charAt(j)] = true;
                }
                maxLength = Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }

    //Using hashmap
    //space complexity O(n)
    //time complexity O(n)
    static int longestSubStringLengthUsingHashMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for(int end=0;end<str.length();end++) {
            if(map.containsKey(str.charAt(end))) {
                start = Math.max(start, map.get(str.charAt(end)) + 1);
            }
            map.put(str.charAt(end), end);
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("longest substring length using sliding window :: " + longestSubStringLengthUsingSlidingWindow("geeksforgeeks"));
        System.out.println("longest substring length using sliding window :: " + longestSubStringLengthUsingHashMap("geeksforgeeks"));
    }
}