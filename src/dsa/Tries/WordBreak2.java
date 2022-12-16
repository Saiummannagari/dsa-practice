package dsa.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {

    static class TrieNode {
          boolean wordPresent;
          HashMap<Character, TrieNode> children = new HashMap<>();

        public boolean isWordPresent() {
            return wordPresent;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setWordPresent(boolean wordPresent) {
            this.wordPresent = wordPresent;
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children;
        }
    }

    public static void main(String[] args) {
        String[] words = {"cats", "and", "dogs", "cat", "sand"};
        String s = "catsanddogs";
        wordbreak(words, s);
    }

    static TrieNode root = new TrieNode();
    static void insert(String word) {
       TrieNode curr = root;
       for(Character l: word.toCharArray()) {
           curr = curr.getChildren().computeIfAbsent(l, c->new TrieNode());
       }
       curr.setWordPresent(true);
    }

    static void wordbreak(String[] words, String s) {
        for(String word: words) {
            insert(word);
        }


        for(int i=0;i<s.length();i++) {
            if(searchInTrie(s.substring(0,i+1))) {
                solve(s, s.substring(0, i+1), i+1);
            }
        }

        System.out.println(ans);
    }

   static boolean searchInTrie(String s) {
       TrieNode curr = root;
       for(char c: s.toCharArray()) {
           curr = curr.getChildren().get(c);
           if(curr == null) {
               return false;
           }
       }
       if(curr.isWordPresent()) {
           return true;
       }
       return false;
   }

   static List<String> ans = new ArrayList<>();
   static void solve(String s, String st, int position) {
       if(position == s.length()) {
           ans.add(st);
           return;
       }

       st += " ";
       for(int i=position;i<s.length();++i) {
           if(i+1<=s.length()) {
               if (searchInTrie(s.substring(position, i+1))) {
                   solve(s, st + s.substring(position, i + 1), i+ 1);
               }
           }
       }
   }
}