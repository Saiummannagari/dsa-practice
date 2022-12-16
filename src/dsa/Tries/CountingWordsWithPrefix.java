/*
Counting Words With a Given Prefix

You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.

Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".

Example 2:

Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.
 */

import java.util.HashMap;

public class CountingWordsWithPrefix {

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        int wordCount;

        TrieNode() {
            this.children = new HashMap<>();
            this.wordCount = 0;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public int getWordCount() {
            return wordCount;
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children;
        }

        public void setWordCount(int wordCount) {
            this.wordCount = wordCount;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word){
            TrieNode curr = root;
            for(char l: word.toCharArray()) {
                curr.setWordCount(curr.getWordCount()+1);
                curr = curr.getChildren().computeIfAbsent(l, c->new TrieNode());
            }
        }

    }
    public static void main(String[] args) {
        String[] words = new String[]{"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(prefixCount(words, pref));

        String[] words2 = new String[]{"leetcode","win","loops","success"};
        String pref2 = "code";
        System.out.println(prefixCount(words2, pref2));
    }

    public static int prefixCount(String[] words, String pref) {
         TrieNode root = new TrieNode();
         for(String word: words) {
             TrieNode curr = root;
             for(char l: word.toCharArray()) {
                 curr.setWordCount(curr.getWordCount()+1);
                 curr = curr.getChildren().computeIfAbsent(l, c->new TrieNode());
             }
         }

        TrieNode node = root;
         int index=0;
         for(char c: pref.toCharArray()) {
            node = node.getChildren().get(c);
            if(node == null) {
                return 0;
            }
            index++;
             if(index==pref.length()) {
                 return node.getWordCount();
             }
         }
         return 0;
    }
}