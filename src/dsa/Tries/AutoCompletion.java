package dsa.Tries;/*
Auto completion

http://techieme.in/building-an-autocomplete-system-using-trie/
 */

import java.util.*;

public class AutoCompletion {

    static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean wordCount;

        TrieNode() {
            this.children = new HashMap<>();
            this.wordCount = false;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean getWordCount() {
            return wordCount;
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children;
        }

        public void setWordCount(boolean wordCount) {
            this.wordCount = wordCount;
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println(autoSuggestions(words, pref));

        String[] words2 = new String[]{"leetcode","win","loops","success"};
        String pref2 = "";
        System.out.println(autoSuggestions(words2, pref2));

        String[] words3 = new String[]{"leetcode","win","loops","success"};
        String pref3 = "l";
        System.out.println(autoSuggestions(words3, pref3));
    }

    static List<String> autoSuggestions(String[] words, String pref) {

        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode curr = root;
            for(char l: word.toCharArray()) {
                curr = curr.getChildren().computeIfAbsent(l, c->new TrieNode());
            }
            curr.setWordCount(true);
        }

        TrieNode node = root;

        for(char c: pref.toCharArray()) {
            node = node.getChildren().get(c);
            if(node == null) {
                return new ArrayList<>();
            }
            }
        ArrayList<String> list = new ArrayList<>();

        if (node.getWordCount()) {
            list.add(pref);
        }
        StringBuilder s = new StringBuilder();
        s.append(pref);
        for(char c: node.getChildren().keySet()) {
            s.append(c);
            dfs(c, node.getChildren().get(c), s, list);
            s.setLength(s.length()-1);
        }
        return list;
    }

    static void dfs(char c, TrieNode node, StringBuilder s, ArrayList<String> res) {
        if(node.getWordCount()) {
            res.add(String.valueOf(s));
            return;
        }
            for (char i : node.getChildren().keySet()) {
                s.append(i);
                dfs(i, node.getChildren().get(i), s, res);
                s.setLength(s.length() - 1);
            }


    }

}