//public class AutoCompletion2 {
//
//    public static void main(String[] args) {
//
//    }
//
//    public TrieNode getLocationOfStringInTrie(TrieNode root,
//                                              String str, int ndex){
//        if(index == str.length()) {
//            return root;
//        }
//        if(root.map.containsKey(str.charAt(index)) == true) {
//            root = root.map.get(str.charAt(index));
//            getLocationOfStringInTrie(root, str, index++);
//        }
//    }
//
//    public void suggestion(TrieNode root) {
//        if(root.isend == false) {
//            set<Character> set = root.map.keySet();
//            for(char ch:str) {
//                System.out.println(ch);
//                suggestion(root.map.get(ch));
//
//            }
//        }
//        else {
//            return;
//        }
//    }
//}