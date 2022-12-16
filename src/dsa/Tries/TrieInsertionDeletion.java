/*
There may be cases when a trie is a binary search tree, but in general, these are different. Both binary search trees and tries are trees, but each node in binary search trees always has two children, whereas tries' nodes, on the other hand, can have more.

In a trie, every node (except the root node) stores one character or a digit. By traversing the trie down from the root node to a particular node n, a common prefix of characters or digits can be formed which is shared by other branches of the trie as well.

By traversing up the trie from a leaf node to the root node, a String or a sequence of digits can be formed.


 */
import java.util.HashMap;

public class TrieNode {

    private HashMap<Character, TrieNode> children;
    private String content;
    private boolean endOfWord;

    public TrieNode() {
        children = new HashMap<>();
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public String getContent() {
        return content;
    }

    public boolean getEndOfWord() {
        return endOfWord;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}

class Trie{
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr= root;
//        for(char l: word.toCharArray()) {
//            TrieNode node = curr.getChildren().get(l);
//            if(node == null) {
//                node = new TrieNode();
//                curr.getChildren().put(l, node);
//            }
//            curr = node;
//        }

        for(char l: word.toCharArray()) {
            curr = curr.getChildren().computeIfAbsent(l, c->new TrieNode());
        }
        curr.setEndOfWord(true);
    }

    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.getEndOfWord();
    }

    public void delete(String word){
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if(index==word.length()) {
            if(!current.getEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if(node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.getEndOfWord();
        if(shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;

    }
}

class Test{
    public static void main(String[] args) {
        Trie trie = new Trie();

        //creating trie
        trie.insert("abc");
        trie.insert("acb");
        trie.insert("bca");
        trie.insert("aba");

        //searching trie
        System.out.println(trie.find("abc"));
        System.out.println(trie.find("acb"));
        System.out.println(trie.find("bca"));
        System.out.println(trie.find("bac"));
        System.out.println(trie.find("aba"));

        //deleting
        trie.delete("abc");

        //searching
        System.out.println("trie after deleting");
        System.out.println(trie.find("abc"));
        System.out.println(trie.find("acb"));
        System.out.println(trie.find("bca"));
        System.out.println(trie.find("aba"));
    }
}