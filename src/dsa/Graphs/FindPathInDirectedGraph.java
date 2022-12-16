package dsa.Graphs;/*
Finding path in Directed Graph

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order
 */

import java.util.ArrayList;

class FindPathInDirectedGraph {

    public static class Graph {
        private int numVertices;
        private ArrayList<Integer>[] list;

        public Graph(int vertices) {
            this.numVertices = vertices;
            list = new ArrayList[vertices];
            for(int i=0;i<vertices;i++) {
                list[i] = new ArrayList<>();
            }
        }

        public void addEdge(int i, int j) {
            list[i].add(j);
        }

    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        findAllPaths(graph, 0, 5, 6);
    }

    private static void findAllPaths(Graph graph, int src, int dest, int n) {
        boolean[] visited = new boolean[n];
        visited[src] = true;
        dfs(graph, src, visited, "",dest);
    }

    private static void dfs(Graph g, int i, boolean[] visited, String path, int dest) {
        if(i == dest) {
            System.out.println(path+i);
            return;
        }
        path = path+ i;
        for(Integer l: g.list[i]) {
            if(!visited[l]) {
                visited[i] = true;
                dfs(g, l, visited, path, dest);
                visited[i] = false;
            }
        }
    }
}