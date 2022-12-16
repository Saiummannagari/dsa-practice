package dsa.Hashing;/*
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: abc
Explanation: The answer is "abc", with the length of 3.

Input: s = "bbbbb"
Output: b
Explanation: The answer is "b", with the length of 1.

Input: s = "pwwkew"
Output: wke
Explanation: The answer is "wke", with the length of 3.
 */

import java.util.HashMap;

public class LongestSubStringWithoutRepeatingCharacters {

    //Using sliding window
    //space complexity O(1)
    //time complexity O(n*n)
    static String longestSubStringUsingSlidingWindow(String str) {
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for(int i=0;i<str.length();i++) {
            boolean[] visited = new boolean[256];
            for(int j=i;j<str.length();j++) {
                if(visited[str.charAt(j)] == true) {
                    break;
                } else {
                    visited[str.charAt(j)] = true;
                }
                if(maxLength < j-i+1) {
                    start = i;
                    end = j;
                    maxLength = j-i+1;
                }
            }
        }
        return str.substring(start,end+1);
    }


    //Using hashmap
    //space complexity O(n)
    //time complexity O(n)
    static String longestSubStringUsingHashMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        int start = 0;
        for(int end=0;end<str.length();end++) {
            if(map.containsKey(str.charAt(end))) {
                start = Math.max(start, map.get(str.charAt(end)) + 1);
            }
            map.put(str.charAt(end), end);
            if(maxLength<end-start+1) {
                maxLength = end-start+1;
                endIndex = end;
                startIndex = start;
            }
        }
        return str.substring(startIndex, endIndex +1);
    }

    public static void main(String[] args) {
        System.out.println("longest substring length using hashmap :: " + longestSubStringUsingHashMap("geeksforgeeks"));
        System.out.println("longest substring length using sliding window :: " + longestSubStringUsingSlidingWindow("geeksforgeeks"));
    }
}