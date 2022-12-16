package dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Verifying an Alien Dictionary using Topological Algorithm

You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language used by aliens. Write Algorithm to Derive the order of letters in this in Time Complexity O(edges +vertices) Asked in : Google, WalmartLabs, Adobe

Example:

Input:  array[] = {"baa", "abcd", "abca", "cab", "cad"}
Output: Order of characters is b, d, a, c
Note that words are sorted and in the given language "baa"
comes before "abcd", therefore b is before a in output.
 */
class VerifyingAlienDictionary {

    public static class Graph {
        private int numVertices;
        private ArrayList<Integer>[] list;

        public Graph(int vertices) {
            this.numVertices = vertices;
            list = new ArrayList[4];
            for(int i=0;i<vertices;i++) {
                list[i] = new ArrayList<>();
            }
        }

        public void addEdge(int i, int j) {
            list[i].add(j);
        }

    }

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        findOrderOfCharacter(words, 4);
    }

    private static void findOrderOfCharacter(String[] words, int n) {
        Graph g = new Graph(n);
        for(int i=0;i< words.length-1;i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            for(int j=0;j<Math.min(word1.length(), word2.length());j++) {
                if(word1.charAt(j)!=word2.charAt(j)) {
                    g.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
                    break;
                }
            }
        }
        topologicalSort(g, n);
    }

    private static void topologicalSort(Graph g, int n) {
        Stack<Integer> result = new Stack<>();

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(g, i, visited, result);
            }
        }

        while(!result.isEmpty()) {
            System.out.println((char)('a'+result.pop())+" ");
        }
    }

    private static void dfs(Graph g, int i, boolean[] visited, Stack<Integer> result) {
        visited[i] = true;
        for(int vertex: g.list[i]) {
            if(!visited[vertex]) {
                dfs(g, vertex, visited, result);
            }
        }

        result.push(i);
    }
}