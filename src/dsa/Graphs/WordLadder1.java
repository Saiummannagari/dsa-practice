package dsa.Graphs;

import java.util.*;

class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength(beginWord, endWord, list));
        String beginWord1 = "hit";
        String endWord2 = "cog";
        List<String> list2 = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(ladderLength(beginWord1, endWord2, list2));
    }

    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) {
            System.out.println("end word does not exist");
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int depth =0;
        while(!queue.isEmpty()) {
            depth = depth+1;
            int lsize = queue.size();
            while(lsize-->0) {
                String curr = queue.poll();
                String temp2;
                for (int i = 0; i < curr.length(); i++) {
                    char[] temp = curr.toCharArray();
                    char c = temp[i];

                    for (int j = 0; j < 26; j++) {
                        if (c != (char) (j + 'a')) {
                            temp[i] = (char) (j + 'a');
                            temp2 = new String(temp);
                            if (set.contains(temp2)) {
                                queue.add(temp2);
                                set.remove(temp2);
                                if (temp2.equalsIgnoreCase(endWord)) {
                                    return depth + 1;
                                }
                            }
                        }

                    }
                }
            }
                }
        return 0;
            }
}