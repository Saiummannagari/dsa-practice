import java.util.HashMap;

public class LongestCommonPrefix {

    static class TrieNode {
        boolean isWordPresent;
        HashMap<Character, TrieNode> children= new HashMap<>();

        public boolean isWordPresent() {
            return isWordPresent;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setWordPresent(boolean wordPresent) {
            isWordPresent = wordPresent;
        }

        public void setChildren(HashMap<Character, TrieNode> children) {
            this.children = children;
        }
    }

    static TrieNode root = new TrieNode();
    public static void main(String[] args) {
        String[] words={"leetcode","leetcode", "leetcode"};
        for(String word: words) {
            insert(word);
        }
        System.out.println(longestCommonPrefix());
    }


    static String longestCommonPrefix() {
        StringBuilder sb= new StringBuilder();
        TrieNode curr = root;
        if(curr.getChildren().size()>1) {
            return "";
        } else {
            for(char c: curr.getChildren().keySet()) {
            sb.append(c);
            dfs(c,curr.getChildren().get(c), sb);
            }
        }
        return String.valueOf(sb);
    }

    static void dfs(char c, TrieNode curr, StringBuilder sb) {
        if (curr.getChildren().size() > 1 || curr.getChildren().size() == 0) {
            return;
        } else {
            for (char i : curr.getChildren().keySet()) {
                sb.append(i);
                dfs(i, curr.getChildren().get(i), sb);
            }
        }
    }

    static void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            curr = curr.getChildren().computeIfAbsent(c, l-> new TrieNode());
        }
        curr.setWordPresent(true);
    }
}