package dsa.Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    static class Graph {
        int numVertices;
        LinkedList<Integer>[] lists;
        boolean[] visited;

        public Graph(int num) {
            this.numVertices =  num;
            lists = new LinkedList[num];
            for(int i=0;i<numVertices;i++) {
                lists[i] = new LinkedList<>();
            }
            visited = new boolean[numVertices];
        }
        public void addEdge(int i, int j) {
            lists[i].add(j);
        }

        public void removeEdge(int i, int j) {
            lists[i].remove((Object)j);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<lists.length;i++) {
                sb.append(i+"->");
                lists[i].forEach(value -> {
                    sb.append(value + " ");
                });
                sb.append("\n");
            }
            return sb.toString();
        }


        void dfs(int s) {
            if(visited[s]) {
                return;
            }
            visited[s] = true;
            System.out.println(s+" ");
            Iterator<Integer> itr = lists[s].listIterator();
            while(itr.hasNext()) {
                int n = itr.next();
                if(!visited[n]) {
                    dfs(n);
                }
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(0,3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 1);
        g.addEdge(3, 2);

        System.out.println(g);
        g.dfs(2);
    }
}