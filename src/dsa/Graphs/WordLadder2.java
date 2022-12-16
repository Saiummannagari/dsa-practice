package dsa.Graphs;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        findLadders(beginWord, endWord, list);
        String beginWord1 = "hit";
        String endWord2 = "cog";
        List<String> list2 = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        findLadders(beginWord1, endWord2, list2);
    }

    static void findLadders(String beginWord, String endWord, List<String> wordList) {
       HashMap<String, List<String>> map = new HashMap<>();
       HashSet<String> set = new HashSet<>(wordList);
//       for(String s: set) {
//           System.out.println(s);
//       }
       HashMap<String, Integer> visited = new HashMap<>();
       for(String s: set) {
           visited.put(s, 0);
       }
       //adding depth of begin word
        visited.put(beginWord, 0);
       ArrayList<List<String>> res = new ArrayList<>();
       buildGraph(beginWord, endWord, map, set, visited);
//       for(String s:map.keySet()) {
//           System.out.print("key :: "+s+" ");
//           System.out.print("values :: ");
//           for(String l: map.get(s)) {
//               System.out.print(l+" ");
//           }
//           System.out.println();
//       }
//
//        for(String s:visited.keySet()) {
//            System.out.println("key :: "+s+" values :: "+ visited.get(s));
//        }
        List<String> path = new ArrayList<>();
        dfs(beginWord, endWord, path, map, res);

      for(List<String> r: res) {
          System.out.print("the path is :: ");
          for(String s: r) {
              System.out.print(s+" ");
          }
          System.out.println();
        }
    }

    static void buildGraph(String beginWord,
                           String endWord,
                           HashMap<String, List<String>> graph,
                           HashSet<String> dict,
                           HashMap<String, Integer> visited) {

        //we need queue to put it in a order
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean foundEnd=false;
        while(!queue.isEmpty()) {
            String curr = queue.poll();
           // char[] word = curr.toCharArray();
            String temp2;
            for (int i = 0; i < curr.length(); i++) {
                char[] temp =curr.toCharArray();
                char c = temp[i];

                for (int j = 0; j < 26; j++) {
                    if (c != (char) (j + 'a')) {
                        temp[i] = (char) (j + 'a');
                      temp2 = new String(temp);
                        if (dict.contains(temp2)) {
                            if(visited.get(temp2) == 0) {
                                visited.put(temp2, visited.get(curr) + 1);
                                queue.add(temp2);
                            }
                            if(!temp2.equals(endWord)) {
                                dict.remove(temp2);
                            }
                            if(!graph.containsKey(curr)) {
                                graph.put(curr, new ArrayList<>());
                            }
                            graph.get(curr).add(temp2);
                            if (temp2.equalsIgnoreCase(endWord)) {
//                                foundEnd= true;
//                             //   break;
                            }
                        }
                    }
                }
            }
        }
    }

    static void dfs(String currWord, String endWord, List<String> path, HashMap<String, List<String>> map, ArrayList<List<String>> res) {
        path.add(currWord);
        if(currWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        else if(map.containsKey(currWord)) {
            for(String nextWord: map.get(currWord)) {

                dfs(nextWord, endWord, path, map, res);
                path.remove(path.size()-1);
            }
        }
        //removing currently added string

    }

}